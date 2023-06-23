package com.exam.javacarservice_api.services;

import com.exam.javacarservice_api.dtos.ApiResponse;
import com.exam.javacarservice_api.dtos.CarServiceDto;

public interface IServiceCarService {
    ApiResponse add(CarServiceDto carServiceDto);
    ApiResponse delete(Long Id);
    ApiResponse deleteAll();

    ApiResponse geById(Long Id);

    ApiResponse getAll();

    ApiResponse updateName(Long id, String newName);

    ApiResponse update(Long id, CarServiceDto carServiceDto);
}
