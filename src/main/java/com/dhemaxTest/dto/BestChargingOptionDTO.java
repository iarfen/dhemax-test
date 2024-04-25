package com.dhemaxTest.dto;

import com.dhemaxTest.model.ChargePoint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BestChargingOptionDTO {

    public ChargePoint chargePointBestDistance;

    public ChargePoint chargePointBestPower;

}