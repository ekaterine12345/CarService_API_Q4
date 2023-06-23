package com.exam.javacarservice_api.repositories;

import com.exam.javacarservice_api.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
//    List<University> getByAddressAndName(String address, String name);
//    List<University> getByIdAndCreatedAt(Long Id, Date CreatedAt);
//    Optional<University> findById(Long Id);
}
