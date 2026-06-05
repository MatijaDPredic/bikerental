package at.spengergasse.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentedBikeServiceTest {
    RentedBikeService rentedBikeService = new RentedBikeService();

    @BeforeEach
    void setUp() {
        // is now redundant but i will still leave it here
        //var rentedBikes = rentedBikeService.getRentedBikes();
        //TestDataRentedBikeService.testData(rentedBikes);
        }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        System.out.println(rentedBikeService.toString());
    }
}