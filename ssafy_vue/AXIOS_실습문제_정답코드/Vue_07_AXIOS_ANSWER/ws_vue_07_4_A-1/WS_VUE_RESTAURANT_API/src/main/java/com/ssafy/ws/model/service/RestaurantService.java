package com.ssafy.ws.model.service;

import java.util.Map;

import com.ssafy.ws.model.dto.Restaurant;
import com.ssafy.ws.model.dto.SearchCondition;

public interface RestaurantService {

	int insertRestaurant(Restaurant restaurant);

	int updateRestaurant(Restaurant restaurant);

	int deleteRestaurant(int id);

	Restaurant selectRestaurantById(int id);

	Map<String, Object> selectRestaurantBySearchConditionWithPaging(SearchCondition con);

}
