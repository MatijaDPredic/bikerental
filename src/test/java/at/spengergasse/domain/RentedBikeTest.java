package at.spengergasse.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentedBikeTest {
    RentedBike rentedBike = new RentedBike();

    @BeforeEach
    void setUp() {
        rentedBike.setRentedBikeId(1000L);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void setRentedBikeId() {
        assertEquals(1000,rentedBike.getRentedBikeId());
        rentedBike.setRentedBikeId();
        assertEquals(1001,rentedBike.getRentedBikeId());
    }

    @Test
    void setPrice_withValidPrice_updatesPrice() {
        rentedBike.setPrice(16.0);
        assertEquals(16.0, rentedBike.getPrice());
    }

    @Test
    void setPrice_withPriceTooLow_throwsException() {
        RentedBikeException exception = assertThrows(RentedBikeException.class, () -> rentedBike.setPrice(5.0));
        assertEquals("price is too low!", exception.getMessage());
    }

    @Test
    void setPrice_withPriceTooHigh_throwsException() {
        RentedBikeException exception = assertThrows(RentedBikeException.class, () -> rentedBike.setPrice(113.0));
        assertEquals("price is too high!", exception.getMessage());
    }

    @Test
    void setBikeCategory() {
    }

    @Test
    void testClone() {
        RentedBike rentedBikeClone = rentedBike.clone();
        assertEquals(rentedBike,rentedBikeClone);
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void getRentedBikeId() {
    }

    @Test
    void getRentedAtDate() {
    }

    @Test
    void getBikeCategory() {
    }

    @Test
    void getCostumerName() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void getDaysRented() {
    }

    @Test
    void getIsInLoyaltyProgram() {
    }

    @Test
    void testSetRentedBikeId() {
    }

    @Test
    void setRentedAtDate() {
    }

    @Test
    void setCostumerName() {
    }

    @Test
    void setDaysRented() {
    }

    @Test
    void setIsInLoyaltyProgram() {
    }

    @Test
    void testToString() {
        String stringRentedBike = rentedBike.toString();
        String test = "RentedBike(" +
                "rentedBikeId=1000, " +
                "rentedAtDate=2026-06-05, " +
                "bikeCategory=City Bike, " +
                "costumerName=Unknown, " +
                "price=8.0, " +
                "daysRented=1, " +
                "isInLoyaltyProgram=false)";
        assertEquals(test , stringRentedBike);
    }

}