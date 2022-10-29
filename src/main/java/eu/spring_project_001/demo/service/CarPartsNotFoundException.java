package eu.spring_project_001.demo.service;

public class CarPartsNotFoundException extends RuntimeException
{
    private static final String MESSAGE = "Car parts with id %s not found";
    CarPartsNotFoundException(long id)
    {
        super(String.format(MESSAGE, id));
    }
}
