package com.dhemaxTest.controller;

import com.dhemaxTest.dto.BestChargingOptionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.dhemaxTest.dao.ChargePointsDAO;
import com.dhemaxTest.dto.ChargePointDTO;
import com.dhemaxTest.model.ChargePoint;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class ChargePointsController {
    
    @Autowired
    private ChargePointsDAO chargePointsDAO;

    @GetMapping("/chargePoints")
    public List<ChargePoint> getchargePoints() {
        return (List<ChargePoint>) chargePointsDAO.findAll();
    }
    
    @GetMapping("/chargePoints/{chargePointId}")
    public ChargePoint getchargePoint(@PathVariable Long chargePointId) throws ResponseStatusException {
        return chargePointsDAO.findById(chargePointId).orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{\"mensaje\": \"chargePoint not found\"}"); } );
    }

    @GetMapping("/bestChargingOption")
    public BestChargingOptionDTO getchargePoint(@RequestParam String latitude, @RequestParam String longitude) throws ResponseStatusException {
        float requestLatitude = Float.parseFloat(latitude);
        float requestLongitude = Float.parseFloat(longitude);
        List<ChargePoint> chargePoints = (List<ChargePoint>) chargePointsDAO.findAll();
        double currentDistance = 1000000;
        double currentPower = 0;
        ChargePoint chargePointBestDistance = new ChargePoint();
        ChargePoint chargePointBestPower = new ChargePoint();
        for (ChargePoint chargePoint : chargePoints) {
            float chargePointLatitude = Float.parseFloat(chargePoint.getLatitude());
            float chargePointLongitude = Float.parseFloat(chargePoint.getLongitude());
            double distance = Math.sqrt(Math.pow(requestLatitude - chargePointLatitude,2) + Math.pow(requestLongitude - chargePointLongitude,2));
            double power = chargePoint.getPower();
            if (distance < currentDistance) {
                chargePointBestDistance = chargePoint;
                currentDistance = distance;
            }
            if (power > currentPower) {
                chargePointBestPower = chargePoint;
                currentPower = power;
            }
        }
        BestChargingOptionDTO bestChargingOptionDTO = new BestChargingOptionDTO();
        bestChargingOptionDTO.setChargePointBestDistance(chargePointBestDistance);
        bestChargingOptionDTO.setChargePointBestPower(chargePointBestPower);
        return bestChargingOptionDTO;
    }

    @PostMapping("/chargePoints")
    public ChargePoint addchargePoint(@RequestBody ChargePointDTO chargePointDTO) throws JsonProcessingException {
        if (Objects.isNull(chargePointDTO.getStatus()) || chargePointDTO.getStatus().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Status requerido\"}");
        }
        if (Objects.isNull(chargePointDTO.getOperator()) || chargePointDTO.getOperator().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Operator requerido\"}");
        }
        if (Objects.isNull(chargePointDTO.getConnections()) || chargePointDTO.getConnections() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Connections requerido\"}");
        }
        if (Objects.isNull(chargePointDTO.getLatitude()) || chargePointDTO.getLatitude().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Latitud requerida\"}");
        }
        if (Objects.isNull(chargePointDTO.getLongitude()) || chargePointDTO.getLongitude().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Longitud requerida\"}");
        }
        if (Objects.isNull(chargePointDTO.getCountry()) || chargePointDTO.getCountry().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"País requerido\"}");
        }
        if (Objects.isNull(chargePointDTO.getPower()) || chargePointDTO.getPower() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Power requerido\"}");
        }
        ChargePoint chargePoint = new ChargePoint();
        chargePoint.setStatus(chargePointDTO.getStatus());
        chargePoint.setOperator(chargePointDTO.getOperator());
        chargePoint.setConnections(chargePointDTO.getConnections());
        chargePoint.setLatitude(chargePointDTO.getLatitude());
        chargePoint.setLongitude(chargePointDTO.getLongitude());
        chargePoint.setCountry(chargePointDTO.getCountry());
        chargePoint.setPower(chargePointDTO.getPower());
        chargePointsDAO.save(chargePoint);
        return chargePoint;
    }
    
    @PutMapping("/chargePoints/{chargePointId}")
    public ChargePoint putchargePoint(@RequestBody ChargePointDTO chargePointDTO, @PathVariable Long chargePointId) throws JsonProcessingException, ResponseStatusException {
        Optional<ChargePoint> dbchargePoint = chargePointsDAO.findById(chargePointId);
        if (dbchargePoint.isPresent())
        {
            if (Objects.isNull(chargePointDTO.getStatus()) || chargePointDTO.getStatus().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Status requerido\"}");
            }
            if (Objects.isNull(chargePointDTO.getOperator()) || chargePointDTO.getOperator().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Operator requerido\"}");
            }
            if (Objects.isNull(chargePointDTO.getConnections()) || chargePointDTO.getConnections() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Connections requerido\"}");
            }
            if (Objects.isNull(chargePointDTO.getLatitude()) || chargePointDTO.getLatitude().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Latitud requerida\"}");
            }
            if (Objects.isNull(chargePointDTO.getLongitude()) || chargePointDTO.getLongitude().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Longitud requerida\"}");
            }
            if (Objects.isNull(chargePointDTO.getCountry()) || chargePointDTO.getCountry().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"País requerido\"}");
            }
            if (Objects.isNull(chargePointDTO.getPower()) || chargePointDTO.getPower() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\": \"Power requerido\"}");
            }
            ChargePoint chargePoint = new ChargePoint();
            chargePoint.setStatus(chargePointDTO.getStatus());
            chargePoint.setOperator(chargePointDTO.getOperator());
            chargePoint.setConnections(chargePointDTO.getConnections());
            chargePoint.setLatitude(chargePointDTO.getLatitude());
            chargePoint.setLongitude(chargePointDTO.getLongitude());
            chargePoint.setCountry(chargePointDTO.getCountry());
            chargePoint.setPower(chargePointDTO.getPower());
            chargePointsDAO.save(chargePoint);
            return chargePoint;
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{\"mensaje\": \"chargePoint not found\"}");
        }
    }
    
    @DeleteMapping("/chargePoints/{chargePointId}")
    void deletechargePoint(@PathVariable Long chargePointId) throws ResponseStatusException {
        Optional<ChargePoint> dbchargePoint = chargePointsDAO.findById(chargePointId);
        if (dbchargePoint.isPresent())
        {
            chargePointsDAO.deleteById(chargePointId);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{\"mensaje\": \"chargePoint not found\"}");
        }
    }
}
