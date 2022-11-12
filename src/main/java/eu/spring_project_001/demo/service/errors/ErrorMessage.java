package eu.spring_project_001.demo.service.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class ErrorMessage
{
    private int statusCode;
    private LocalDate localDate;
    private  String message;
    private  String description;
}
