package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Restaurant;
import com.ssafy.ws.model.dto.SearchCondition;

public interface RestaurantDao {

	int insertRestaurant(Restaurant restaurant);

	int deleteRestaurant(int resId);

	int updateRestaurant(Restaurant restaurant);

	Restaurant selectRestaurantById(int resId);

	List<Restaurant> selectByCondition(SearchCondition con);

	int getTotalCount(SearchCondition con);

}
