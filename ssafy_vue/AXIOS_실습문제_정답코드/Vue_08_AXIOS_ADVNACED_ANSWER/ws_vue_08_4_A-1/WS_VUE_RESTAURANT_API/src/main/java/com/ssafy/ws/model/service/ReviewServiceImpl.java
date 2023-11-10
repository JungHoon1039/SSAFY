package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.ReviewDao;
import com.ssafy.ws.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao rDao;

	@Override
	public int insertReview(Review rev) {
		return rDao.insertReview(rev);
	}

	@Override
	public int deleteReview(int revId) {
		return rDao.deleteReview(revId);
	}

	@Override
	public List<Review> selectAllReview(int resId) {
		return rDao.selectAllReview(resId);
	}

}
