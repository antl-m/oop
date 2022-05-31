package com.oop.lab2.domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class FlightInfo {

    private Long id;

    private Long from;

    private Long to;

    private long datetime;
}