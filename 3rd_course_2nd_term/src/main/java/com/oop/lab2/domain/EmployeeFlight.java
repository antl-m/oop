package com.oop.lab2.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
@IdClass(EmployeeFlight.class)
public class EmployeeFlight implements Serializable {
    @Id
    public Long employeeId;

    @Id
    public Long flightId;
}
