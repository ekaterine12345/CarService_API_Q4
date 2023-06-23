package com.exam.javacarservice_api.models;


import com.exam.javacarservice_api.dtos.CarDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="cars")
public class Car extends BaseEntity<Long>{

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "carIdSeq", sequenceName = "CAR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carIdSeq")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @Column(name="FIRM")
    private String firm;

    public Car(CarDto carDto) {
        this.name = carDto.getName();
        this.firm = carDto.getFirm();
        this.recordState = RecordState.ACTIVE;
    }
}
