package com.ssafy.ws.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Restaurant;
import com.ssafy.ws.model.dto.Review;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.service.RestaurantService;
import com.ssafy.ws.model.service.ReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/restaurantapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class MainRestController {

	@Autowired
	RestaurantService resService;

	@Autowired
	ReviewService revService;

	@PostMapping(value = "/res", consumes = "multipart/form-data")
	@ApiOperation(value = "맛집 정보를 등록한다.", response = Integer.class)
	public ResponseEntity<?> registRestaurant(Restaurant res) {
		try {
			int result = resService.insertRestaurant(res);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/res")
	@ApiOperation(value = "맛집 정보를 검색하여 그 결과를 반환한다.", response = Restaurant.class)
	public ResponseEntity<?> searchRestaurant(SearchCondition con) {
		try {
			Map<String, Object> result = resService.selectRestaurantBySearchConditionWithPaging(con);
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/res/{resId}")
	@ApiOperation(value = "맛집 정보를 반환한다.", response = Restaurant.class)
	public ResponseEntity<?> getRestaurant(@PathVariable Integer resId) {
		try {
			Restaurant res = resService.selectRestaurantById(resId);
			if (res != null) {
				return new ResponseEntity<Restaurant>(res, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@DeleteMapping("/res/{resId}")
	@ApiOperation(value = "등록된 맛집 정보를 삭제합니다.", response = Integer.class)
	public ResponseEntity<?> deleteRestaurant(@PathVariable Integer resId) {
		try {
			Integer result = resService.deleteRestaurant(resId);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/res")
	@ApiOperation(value = "등록된 맛집 정보를 수정합니다.", response = Integer.class)
	public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant res) {
		try {
			Integer result = resService.updateRestaurant(res);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PostMapping("/review")
	@ApiOperation(value = "맛집에 대해 리뷰를 작성합니다.", response = Integer.class)
	public ResponseEntity<?> registReview(@RequestBody Review review) {
		try {
			Integer result = revService.insertReview(review);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@GetMapping("/review/{resId}")
	@ApiOperation(value = "해당 맛집의 리뷰를 모두 가져옵니다.", response = Review.class)
	public ResponseEntity<?> getReviewList(@PathVariable Integer resId) {
		try {
			List<Review> list = revService.selectAllReview(resId);
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/review/{reviewId}")
	@ApiOperation(value = "맛집에 등록된 리뷰를 삭제합니다.", response = Integer.class)
	public ResponseEntity<?> deleteReview(@PathVariable Integer reviewId) {
		try {
			Integer result = revService.deleteReview(reviewId);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> getDownLoad(String fileName) {

		String filePath = "C:\\temp\\" + fileName;

		Resource res = new FileSystemResource(filePath);

		String resourceName = res.getFilename();

		resourceName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();

		try {
			headers.add("Content-Disposition",
					"attachment; filename=" + new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(res, headers, HttpStatus.OK);
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
