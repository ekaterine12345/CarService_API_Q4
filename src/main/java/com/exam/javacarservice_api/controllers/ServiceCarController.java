package com.exam.javacarservice_api.controllers;

import com.exam.javacarservice_api.dtos.ApiResponse;
import com.exam.javacarservice_api.dtos.CarServiceDto;
import com.exam.javacarservice_api.services.IServiceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars_services")
public class ServiceCarController {
    private final IServiceCarService carSerService;


    @Autowired
    public ServiceCarController(IServiceCarService carSerService) {
        this.carSerService = carSerService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ApiResponse geCars(){
        System.out.println("hiiiiiiiiiiii");
        return this.carSerService.getAll();
    }

    @PostMapping("/add")
    public ApiResponse addUniversity(@RequestBody CarServiceDto carServiceDto) throws RuntimeException {
        return this.carSerService.add(carServiceDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{Id}")
    public ApiResponse updateUniversity(@PathVariable("Id") Long Id, @RequestBody CarServiceDto carServiceDto) throws RuntimeException {
        System.out.println("updated ID "+ Id);
        return this.carSerService.update(Id, carServiceDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{Id}")
    public ApiResponse deleteUniversity(@PathVariable("Id") Long Id){
        return this.carSerService.delete(Id);
    }
}

