package eu.spring_project_001.demo.service.exceptions;

public class OwnerDoesNotHaveThatCarException extends RuntimeException
{
    private static final String MESSAGE = "There is no assigned car for the user with the first %s and last name %s . Please add it and try again!";
    public OwnerDoesNotHaveThatCarException(String firstName, String lastName)
    {
        super(String.format(MESSAGE, firstName, lastName));
    }
}
