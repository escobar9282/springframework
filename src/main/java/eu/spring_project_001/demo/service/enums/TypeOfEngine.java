package eu.spring_project_001.demo.service.enums;

import eu.spring_project_001.demo.service.exceptions.InvalidTypeOfEngineException;

public enum TypeOfEngine
{
    ELECTRIC, PETROL, MIXED, DOUBLE_ELECTRIC;

    public static TypeOfEngine validatedTypeOfEngine(String type)
    {
        if (ELECTRIC.name().equals(type.toUpperCase()))
        {
            return ELECTRIC;
        } else if (PETROL.name().equals(type.toUpperCase()))
        {
            return PETROL;
        } else if (MIXED.name().equals(type.toUpperCase()))
        {
            return MIXED;
        } else if (DOUBLE_ELECTRIC.name().equals(type.toUpperCase()))
        {
            return DOUBLE_ELECTRIC;
        }
        else
        {
            throw new InvalidTypeOfEngineException();
        }
    }
}
