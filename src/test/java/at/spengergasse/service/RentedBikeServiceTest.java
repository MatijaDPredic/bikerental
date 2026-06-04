package at.spengergasse.service;

import at.spengergasse.domain.RentedBike;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RentedBikeServiceTest {
    RentedBikeService rentedBikeService = new RentedBikeService();

    @BeforeEach
    void setUp() {
        var rentedBikes = rentedBikeService.getRentedBikes();

        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 4), "City Bike", "Anna Müller", 12.0, 2, true));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 5), "Mountain Bike", "Peter Schmidt", 18.0, 3, false));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 1), "Trekking Bike", "Lisa Wagner", 10.0, 7, true));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 4), "E-Bike", "Max Mustermann", 25.0, 1, false));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 3), "City Bike", "Emma Gruber", 8.0, 1, false));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 4), "E-Bike", "Felix Berger", 30.0, 2, true));
        rentedBikes.add(new RentedBike());
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 2), "City Bike", "Sophie Kern", 11.0, 4, false));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 3), "Mountain Bike", "Lukas Berger", 20.0, 2, true));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 4), "Trekking Bike", "Julia Hofmann", 14.0, 5, false));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 1), "E-Bike", "Thomas Neumann", 28.0, 3, true));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 5), "City Bike", "Maria Schwarz", 9.0, 1, false));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 4), "Mountain Bike", "Daniel Wolf", 19.0, 2, true));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 2), "Trekking Bike", "Sarah Klein", 13.0, 6, false));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 3), "E-Bike", "Michael Roth", 26.0, 1, true));
        rentedBikes.add(new RentedBike(LocalDate.of(2026, 6, 4), "City Bike", "Laura Becker", 10.0, 3, false));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        System.out.println(rentedBikeService.toString());
    }
}