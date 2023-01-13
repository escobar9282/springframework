package eu.spring_project_001.demo.service.enums;


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
        try
        {
            PremiumCar.valueOf(name.toUpperCase());
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
}
