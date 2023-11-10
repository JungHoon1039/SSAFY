package com.ssafy.ws.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarDto : 자동차 한 대의 정보", description = "자동차의 상세 정보를 나타낸다.")
public class Car {

	@ApiModelProperty(value = "차량번호", example = "KMHXX00XXXX000001")
	private String vin;
	@ApiModelProperty(value = "모델명")
	private String modelName;
	@ApiModelProperty(value = "색상")
	private String color;
	@ApiModelProperty(value = "주행거리")
	private int mileage;
 

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "CarDto [vin=" + vin + ", modelName=" + modelName + ", color=" + color + ", mileage=" + mileage + "]";
	}


	
    
	
	
}

