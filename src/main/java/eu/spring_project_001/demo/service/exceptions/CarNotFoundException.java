package eu.spring_project_001.demo.service.exceptions;

public class CarNotFoundException extends  RuntimeException
{
    private static final String MESSAGE = "Car with id %s not found";
    public CarNotFoundException(long id)
    {
        super(String.format(MESSAGE, id));
    }
}
