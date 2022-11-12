package eu.spring_project_001.demo.service.exceptions;

public class OwnerNotFoundException extends RuntimeException
{
    private static final String MESSAGE = "Owner with id %s not found.";
    public OwnerNotFoundException(Long id)
    {
        super(String.format(MESSAGE, id));
    }
}
