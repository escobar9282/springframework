package eu.spring_project_001.demo.service;

public class InvalidTypeOfEngineException extends RuntimeException
{
    private static final String MESSAGE = "The specified type does not exist. Please provide one of the types listed: electric, petrol, mixed, double_electric";

    protected InvalidTypeOfEngineException()
    {
        super(MESSAGE);
    }
}
