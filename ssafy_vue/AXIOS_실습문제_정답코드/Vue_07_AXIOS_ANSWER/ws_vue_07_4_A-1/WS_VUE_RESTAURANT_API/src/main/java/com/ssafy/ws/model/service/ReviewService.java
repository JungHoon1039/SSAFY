package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Review;

public interface ReviewService {

	int insertReview(Review rev);

	int deleteReview(int revId);

	List<Review> selectAllReview(int resId);

}
