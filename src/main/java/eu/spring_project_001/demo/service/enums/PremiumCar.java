package eu.spring_project_001.demo.service.enums;

import java.util.Arrays;
import java.util.List;

public enum PremiumCar
{
    BENTLEY("Bentley"), CADILLAC("Cadillac"), CHRYSLER("Chrysler"),
    FERRARI("Ferrari"), INFINITY("Infinity"), JAGUAR("Jaguar"),
    LAMBORGHINI("Lamborghini"), LAND_ROVER("Land Rover"), LEXUS("Lexus"),
    LINCOLN("Lincoln"), MASERATI("Maserati"), MERCEDES_BENZ("Mercedes Benz"),
    PORSCHE("Porsche"), ROVER("Rover"), SAAB("Saab");

    private final String name;

    PremiumCar(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public static boolean isCarPremium(String name)
    {
        List<PremiumCar> listOfCars = Arrays.asList(PremiumCar.values());
        try
        {
            return listOfCars.contains(PremiumCar.valueOf(name));
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
}
