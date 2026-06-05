package at.spengergasse.service;

import at.spengergasse.domain.RentedBike;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestDataRentedBikeService {


    public static void fillTestData(ArrayList<RentedBike> arrayList, int times){
        Faker faker = new Faker();

        String[] bikeCategories = {"City Bike", "Trekking Bike","Mountain Bike","E-Bike"};
        String[] costumerNames = {"Susi", "Thomas", "Ivan", "Jordje"};
        Double[] prices =  {8.0, 16.0, 34.0, 12.0};



        for (int i = 0; i < times; i++) {
            RentedBike rentedBike = new RentedBike();
            rentedBike.setRentedBikeId();
            rentedBike.setRentedAtDate(LocalDate.now().minusDays(faker.number().numberBetween(0, 30)));
            rentedBike.setBikeCategory(bikeCategories[faker.number().numberBetween(0, bikeCategories.length)]);
            rentedBike.setCostumerName(costumerNames[faker.number().numberBetween(0, costumerNames.length)]);
            rentedBike.setPrice(prices[faker.number().numberBetween(0, prices.length)]);
            rentedBike.setDaysRented(faker.number().numberBetween(1, 4));
            rentedBike.setIsInLoyaltyProgram(faker.bool().bool());

            arrayList.add(rentedBike);
        }
    }

    public static void testData(ArrayList<RentedBike> arrayList){
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 4), "City Bike", "Anna Müller", 12.0, 2, true));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 5), "Mountain Bike", "Peter Schmidt", 18.0, 3, false));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 1), "Trekking Bike", "Lisa Wagner", 10.0, 7, true));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 4), "E-Bike", "Max Mustermann", 25.0, 1, false));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 3), "City Bike", "Emma Gruber", 8.0, 1, false));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 4), "E-Bike", "Felix Berger", 30.0, 2, true));
        arrayList.add(new RentedBike());
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 2), "City Bike", "Sophie Kern", 11.0, 4, false));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 3), "Mountain Bike", "Lukas Berger", 20.0, 2, true));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 4), "Trekking Bike", "Julia Hofmann", 14.0, 5, false));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 1), "E-Bike", "Thomas Neumann", 28.0, 3, true));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 5), "City Bike", "Maria Schwarz", 9.0, 1, false));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 4), "Mountain Bike", "Daniel Wolf", 19.0, 2, true));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 2), "Trekking Bike", "Sarah Klein", 13.0, 6, false));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 3), "E-Bike", "Michael Roth", 26.0, 1, true));
        arrayList.add(new RentedBike(LocalDate.of(2026, 6, 4), "City Bike", "Laura Becker", 10.0, 3, false));
    }
}
