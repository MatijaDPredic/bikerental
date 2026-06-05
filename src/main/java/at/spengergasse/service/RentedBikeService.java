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
        TestDataRentedBikeService.testData(rentedBikes);
    }

    public ArrayList<RentedBike> findAll(){
        return new ArrayList<>(rentedBikes);
    }

    @Override
    public String toString(){
        return rentedBikes.stream()
                .map(RentedBike::toString)
                .collect(Collectors.joining("\n"));
    }

}
