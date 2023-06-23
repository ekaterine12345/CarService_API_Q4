package com.exam.javacarservice_api.services;

import com.exam.javacarservice_api.dtos.ApiResponse;
import com.exam.javacarservice_api.dtos.CarDto;

public interface ICarService {
    ApiResponse add(CarDto carDto);
    ApiResponse delete(Long Id);
    ApiResponse deleteAll();
    ApiResponse searchByName(String universityName);
    ApiResponse geById(Long Id);

    ApiResponse getAll();

    ApiResponse updateName(Long id, String newName);

    ApiResponse update(Long id, CarDto university);
}
