package com.oop.lab2.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "\"from\"", nullable = false)
    private Airport from;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "\"to\"", nullable = false)
    private Airport to;

    private LocalDateTime departure;
    
    public Flight(Airport from, Airport to, LocalDateTime dateTime) {
        this.from = from;
        this.to = to;
        this.departure = dateTime;
    }
}
