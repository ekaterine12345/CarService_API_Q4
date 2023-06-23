package com.exam.javacarservice_api.services.impl;

import com.exam.javacarservice_api.apiUtils.NoSuchElementFoundException;
import com.exam.javacarservice_api.dtos.ApiResponse;
import com.exam.javacarservice_api.dtos.CarServiceDto;
import com.exam.javacarservice_api.models.RecordState;
import com.exam.javacarservice_api.models.ServiceCar;
import com.exam.javacarservice_api.repositories.ServiceCarRepository;
import com.exam.javacarservice_api.services.IServiceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCarServiceImpl implements IServiceCarService {

    private final ServiceCarRepository carServiceRepository;

    @Autowired
    public ServiceCarServiceImpl(ServiceCarRepository carServiceRepository) {
        this.carServiceRepository = carServiceRepository;
    }

    @Override
    public ApiResponse add(CarServiceDto carServiceDto) {
        if (carServiceDto.getName() == null) {
            throw new NoSuchElementFoundException();
        }

        ServiceCar my_car = new ServiceCar(carServiceDto);

        ServiceCar insertedCarSer = carServiceRepository.save(my_car);
        return new ApiResponse("car_service", insertedCarSer);
    }

    @Override
    public ApiResponse delete(Long Id) {
        ServiceCar serviceCarToDelete = carServiceRepository.findById(Id).orElse(null);

        if (serviceCarToDelete != null){

            carServiceRepository.deleteById(Id);
            return new ApiResponse("car", serviceCarToDelete);
        }


        return new ApiResponse().addError("denied", "Id is not valid");
    }

    @Override
    public ApiResponse deleteAll() {
        return null;
    }

    @Override
    public ApiResponse geById(Long Id) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return null;
    }

    @Override
    public ApiResponse updateName(Long id, String newName) {
        return null;
    }

    @Override
    public ApiResponse update(Long id, CarServiceDto carServiceDto) {
        if (carServiceDto.getName()==null) { // university.getAddress()==null &&
            throw new NoSuchElementFoundException();
        }

        // University universityToUpdated = universityRepository.getOne(id);
        ServiceCar carServiceToUpdated = carServiceRepository.findById(id).orElse(null);
        if (carServiceToUpdated != null){
            carServiceToUpdated.setName(carServiceDto.getName());
            //carServiceToUpdated.se(carDto.getFirm());
                carServiceToUpdated.setRecordState(RecordState.ACTIVE);

            ServiceCar insertedCar = carServiceRepository.save(carServiceToUpdated);
            return new ApiResponse("carservice", insertedCar);
        }

        return new ApiResponse("denied", "Can not perform updated action on this record");
    }
}
