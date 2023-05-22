package com.example.demo.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyException extends RuntimeException
{
    private Integer httpStatusCode = 500;

    private String description;

    public MyException(String description)
    {
        this.description = description;
    }
}
