package com.exam.javacarservice_api.models;


import com.exam.javacarservice_api.dtos.CarServiceDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="services_car")
public class ServiceCar extends BaseEntity<Long>{
    @jakarta.persistence.Id
    @Column(name = "ID")
    @SequenceGenerator(name = "serviceCarIdSeq", sequenceName = "SERVICE_CAR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviceCarIdSeq")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    private Car car;

    public ServiceCar(CarServiceDto carServiceDto) {
        this.name = carServiceDto.getName();
       // this.car = carServiceDto.ge
    }
}
