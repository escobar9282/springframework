package eu.spring_project_001.demo.service.exceptions;

public class InvalidUserDataException extends RuntimeException
{
    public InvalidUserDataException()
    {
        super("Given data is incorrect");
    }
}
