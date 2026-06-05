package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "rentedBikeId", callSuper = false)


@Entity
public class RentedBike {
    @Id
    private Long      rentedBikeId;
    private LocalDate rentedAtDate;
    private String    bikeCategory;
    private String    costumerName;
    private Double    price;
    private Integer   daysRented;
    private Boolean   isInLoyaltyProgram;

    private static final AtomicLong sequence = new AtomicLong(1000);
    private static final String[] bikeCategories = {"City Bike", "Trekking Bike","Mountain Bike","E-Bike"};

    public RentedBike() {
//        setRentedBikeId();
//        setRentedAtDate(LocalDate.now());
//        setBikeCategory("City Bike");
//        setCostumerName("Unknown");
//        setPrice(8.0);
//        setDaysRented(1);
//        setIsInLoyaltyProgram(false);
    }

    public RentedBike(LocalDate rentedAtDate, String bikeCategory, String costumerName, Double price, Integer daysRented, Boolean isInLoyaltyProgram) {
        setRentedBikeId();
        setRentedAtDate(rentedAtDate);
        setBikeCategory(bikeCategory);
        setCostumerName(costumerName);
        setPrice(price);
        setDaysRented(daysRented);
        setIsInLoyaltyProgram(isInLoyaltyProgram);
    }

    public RentedBike(Long rentedBikeId, LocalDate rentedAtDate, String bikeCategory, String costumerName, Double price, Integer daysRented, Boolean isInLoyaltyProgram) {
        setRentedBikeId(rentedBikeId);
        setRentedAtDate(rentedAtDate);
        setBikeCategory(bikeCategory);
        setCostumerName(costumerName);
        setPrice(price);
        setDaysRented(daysRented);
        setIsInLoyaltyProgram(isInLoyaltyProgram);
    }

    public void setRentedBikeId(){
        rentedBikeId = sequence.getAndIncrement();
    }

    public void setPrice(Double price){
        if (price < 8)
            throw new RentedBikeException("price is too low!");
        if (price > 112)
            throw new RentedBikeException("price is too high!");
        this.price = price;
    }

    public void setBikeCategory(String bikeCategory){
        if (!Arrays.asList(bikeCategories).contains(bikeCategory))
            throw new RentedBikeException("Unknown bike category!");
        this.bikeCategory = bikeCategory;
    }

    //TODO: don't have time to look into it rn but i should check why the IDE expects a super call to the clone method
    @Override
    public RentedBike clone(){
        return new RentedBike(rentedBikeId, rentedAtDate, bikeCategory, costumerName, price, daysRented, isInLoyaltyProgram);
    }
}
