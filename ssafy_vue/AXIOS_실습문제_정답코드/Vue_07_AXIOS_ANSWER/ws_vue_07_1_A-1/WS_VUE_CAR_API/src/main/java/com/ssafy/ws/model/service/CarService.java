package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarService {

	List<Car> list();

	Car search(String vin);

	boolean create(Car carDto);

}
