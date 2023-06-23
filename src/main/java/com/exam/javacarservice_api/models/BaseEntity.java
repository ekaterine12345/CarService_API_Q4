package com.exam.javacarservice_api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
@ToString
@EntityListeners(AuditingEntityListener.class)
public  abstract class BaseEntity <ID extends Serializable> {
    @CreatedDate
    @Column(name="CREATED_AT", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @LastModifiedDate
    @Column(name="UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;
    @Enumerated(EnumType.STRING)
    @Column(name="RECORD_STATE")
    protected RecordState recordState;
}
