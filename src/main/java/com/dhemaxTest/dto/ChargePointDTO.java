package com.dhemaxTest.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChargePointDTO {

    public String status;

    public String operator;

    public int connections;

    public String latitude;

    public String longitude;

    public String country;

    public int power;
}
