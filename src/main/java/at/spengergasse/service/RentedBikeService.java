package at.spengergasse.service;

import at.spengergasse.domain.RentedBike;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service

public class RentedBikeService {

    @Getter
    private ArrayList<RentedBike> rentedBikes;

    public RentedBikeService(){
        rentedBikes = new ArrayList<>(1000);
        TestDataRentedBikeService.fillTestData(rentedBikes,10);
    }

    public ArrayList<RentedBike> findAll(){
        return new ArrayList<>(rentedBikes);
    }

    public void removeAllRenters() {
        rentedBikes.clear();
    }

    public void add10Renters() {
        TestDataRentedBikeService.fillTestData(rentedBikes,10);
    }

    public void add1ToPrice() {
        for (RentedBike rentedBike : rentedBikes) {
            rentedBike.setPrice(rentedBike.getPrice() + 1.0);
        }
    }

    public void removeLoyalCostumers() {
        rentedBikes.removeIf(RentedBike::getIsInLoyaltyProgram);
    }

    @Override
    public String toString(){
        return rentedBikes.stream()
                .map(RentedBike::toString)
                .collect(Collectors.joining("\n"));
    }



}
