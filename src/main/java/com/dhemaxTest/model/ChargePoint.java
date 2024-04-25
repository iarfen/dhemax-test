package com.dhemaxTest.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "charge_points")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChargePoint {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    @Column
    @NotNull
    @NotEmpty
    public String status;

    @Column
    @NotNull
    @NotEmpty
    public String operator;

    @Column
    @NotNull
    @NotEmpty
    public int connections;

    @Column
    @NotNull
    @NotEmpty
    public String latitude;

    @Column
    @NotNull
    @NotEmpty
    public String longitude;

    @Column
    @NotNull
    @NotEmpty
    public String country;

    @Column
    @NotNull
    @NotEmpty
    public int power;
}
