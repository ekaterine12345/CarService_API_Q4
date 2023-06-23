package com.exam.javacarservice_api.dtos;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String name;
    private String firm;
}
