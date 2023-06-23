package com.exam.javacarservice_api.controllers;

import com.exam.javacarservice_api.dtos.ApiResponse;
import com.exam.javacarservice_api.dtos.CarDto;
import com.exam.javacarservice_api.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final ICarService carService1;

    @Autowired
    public CarController(ICarService carService1) {
        this.carService1 = carService1;
    }

 //   @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ApiResponse geCars(){
   //     System.out.println("hiiiiiiiiiiii");
        return this.carService1.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ApiResponse addUniversity(@RequestBody CarDto carDto) throws RuntimeException {
        return this.carService1.add(carDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{Id}")
    public ApiResponse updateUniversity(@PathVariable("Id") Long Id, @RequestBody CarDto carDto) throws RuntimeException {
        System.out.println("updated ID "+ Id);
        return this.carService1.update(Id, carDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{Id}")
    public ApiResponse deleteUniversity(@PathVariable("Id") Long Id){
        return this.carService1.delete(Id);
    }
}
