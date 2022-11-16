package eu.spring_project_001.demo.service.exceptions;

public class OwnerNotFoundException extends RuntimeException
{
    private static final String MESSAGE = "Owner with id %s not found.";
    private static final String MESSAGE_FOR_REPAIR = "Owner with first name %s and last name %s not exists in system.";
    public OwnerNotFoundException(Long id)
    {
        super(String.format(MESSAGE, id));
    }

    public OwnerNotFoundException(String firstName, String lastName)
    {
        super(String.format(MESSAGE_FOR_REPAIR, firstName, lastName));
    }

}
