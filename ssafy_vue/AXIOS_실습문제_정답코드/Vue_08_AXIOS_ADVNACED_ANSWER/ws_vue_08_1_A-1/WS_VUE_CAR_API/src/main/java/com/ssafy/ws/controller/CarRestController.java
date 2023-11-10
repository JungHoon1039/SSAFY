package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Car;
import com.ssafy.ws.model.service.CarService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/car")
public class CarRestController {

	private static final Logger logger = LoggerFactory.getLogger(CarRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	CarService carService;

	@ApiOperation(value = "모든 자동차의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Car>> listCar() {
		logger.debug("listCar - 호출");
		return new ResponseEntity<>(carService.list(), HttpStatus.OK);
	}

	@ApiOperation(value = "vin에 해당하는 자동차의 정보를 반환한다.", response = Car.class)
	@GetMapping("/{vin}")
	public ResponseEntity<Car> searchCar(@PathVariable String vin) {
		logger.debug("searchCar - 호출");
		return new ResponseEntity<>(carService.search(vin), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 자동차 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createCar(@RequestBody Car carDto) {
		logger.debug("insertCar - 호출");
		if (carService.create(carDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
