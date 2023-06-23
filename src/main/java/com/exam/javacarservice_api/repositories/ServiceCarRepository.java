package com.exam.javacarservice_api.repositories;

import com.exam.javacarservice_api.models.ServiceCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCarRepository extends JpaRepository<ServiceCar, Long> {
}
