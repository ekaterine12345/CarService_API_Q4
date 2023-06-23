package com.exam.javacarservice_api.services.impl;

import com.exam.javacarservice_api.apiUtils.NoSuchElementFoundException;
import com.exam.javacarservice_api.dtos.ApiResponse;
import com.exam.javacarservice_api.dtos.CarDto;
import com.exam.javacarservice_api.models.Car;
import com.exam.javacarservice_api.models.RecordState;
import com.exam.javacarservice_api.repositories.CarRepository;
import com.exam.javacarservice_api.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements ICarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public ApiResponse add(CarDto carDto) {

        if (carDto.getName() == null) {
            throw new NoSuchElementFoundException();
        }

        Car my_car = new Car(carDto);

        Car insertedCar = carRepository.save(my_car);
        return new ApiResponse("car", insertedCar);
    }

    @Override
    public ApiResponse delete(Long Id) {
        System.out.println("del id = " + Id);

        Car carToDelete = carRepository.findById(Id).orElse(null);

        if (carToDelete != null){
            carRepository.deleteById(Id);
            return new ApiResponse("deleted car", carToDelete);
        }


        return new ApiResponse().addError("denied", "Id is not valid");
    }

    @Override
    public ApiResponse deleteAll() {
        return null;
    }

    @Override
    public ApiResponse searchByName(String universityName) {
        return null;
    }

    @Override
    public ApiResponse geById(Long Id) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("cars", carRepository.findAll());
    }

    @Override
    public ApiResponse updateName(Long id, String newName) {
        return null;
    }

    @Override
    public ApiResponse update(Long id, CarDto carDto) {
        if (carDto.getName()==null) { // university.getAddress()==null &&
            throw new NoSuchElementFoundException();
        }

        Car carToUpdated = carRepository.findById(id).orElse(null);
        if (carToUpdated != null){
            carToUpdated.setName(carDto.getName());
            carToUpdated.setFirm(carDto.getFirm());

            if (carDto.getFirm() != null){
                carToUpdated.setRecordState(RecordState.ACTIVE);
            }

            Car insertedCar = carRepository.save(carToUpdated);
            return new ApiResponse("university", insertedCar);
        }

        return new ApiResponse().addError("denied", "Can not perform updated action on this record");
    }
}
