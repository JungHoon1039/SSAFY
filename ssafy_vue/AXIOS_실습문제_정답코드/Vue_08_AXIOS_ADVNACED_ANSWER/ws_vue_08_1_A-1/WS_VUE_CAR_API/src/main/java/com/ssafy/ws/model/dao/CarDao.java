package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarDao {
	List<Car> list();

	Car search(String vin);

	int create(Car car);
}
