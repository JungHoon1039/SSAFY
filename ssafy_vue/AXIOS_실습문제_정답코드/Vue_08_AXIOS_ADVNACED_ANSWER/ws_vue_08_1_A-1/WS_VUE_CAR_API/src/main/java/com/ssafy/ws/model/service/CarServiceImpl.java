package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.CarDao;
import com.ssafy.ws.model.dto.Car;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;

	@Override
	public List<Car> list() {
		return carDao.list();
	}

	@Override
	public Car search(String vin) {
		return carDao.search(vin);
	}

	@Override
	public boolean create(Car car) {
		return carDao.create(car) == 1;
	}

}
