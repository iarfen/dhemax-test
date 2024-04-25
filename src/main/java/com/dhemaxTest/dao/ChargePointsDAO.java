package com.dhemaxTest.dao;

import org.springframework.stereotype.Repository;

import com.dhemaxTest.model.ChargePoint;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;

@Repository
@Configurable
public interface ChargePointsDAO extends CrudRepository<ChargePoint, Long>{}

