package eu.spring_project_001.demo.service;

class CarNotFoundException extends  RuntimeException
{
    private static final String MESSAGE = "Car with id %s not found";
    CarNotFoundException(long id)
    {
        super(String.format(MESSAGE, id));
    }
}
