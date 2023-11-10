package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.RestaurantDao;
import com.ssafy.ws.model.dto.Restaurant;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.util.PageNavigation;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao dao;

	@Override
	@Transactional
	public int insertRestaurant(Restaurant restaurant) {
		// 파일 처리를 서비스에서 처리

		MultipartFile file = restaurant.getFile();
		int result = 0;
		if (file != null) {

			String saveFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
			String uploadPath = "C:\\temp";

			File target = new File(uploadPath, saveFileName);

			if (!new File(uploadPath).exists()) {
				new File(uploadPath).mkdirs();
			}

			try {
				restaurant.setFileName(saveFileName);
				restaurant.setFileUri(target.getCanonicalPath());
				result = dao.insertRestaurant(restaurant);
				FileCopyUtils.copy(file.getBytes(), target);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	@Transactional
	public int updateRestaurant(Restaurant restaurant) {
		return dao.updateRestaurant(restaurant);
	}

	@Override
	@Transactional
	public int deleteRestaurant(int id) {
		Restaurant res = dao.selectRestaurantById(id);
		// 파일 삭제 처리
//		File file = new File(res.getFileUri());
//		if (file.exists()) {
//			file.delete();
//		}
		int result = dao.deleteRestaurant(id);
		System.out.println("result: " + result);
		return dao.deleteRestaurant(id);
	}

	@Override
	public Restaurant selectRestaurantById(int id) {
		return dao.selectRestaurantById(id);
	}

	@Override
	public Map<String, Object> selectRestaurantBySearchConditionWithPaging(SearchCondition con) {
		int totalCount = dao.getTotalCount(con);
		PageNavigation nav = new PageNavigation(con.getCurrentPage(), totalCount);

		Map<String, Object> pagingResult = new HashMap<>();

		pagingResult.put("restaurants", dao.selectByCondition(con));
		pagingResult.put("navigation", nav);

		return pagingResult;
	}

}
