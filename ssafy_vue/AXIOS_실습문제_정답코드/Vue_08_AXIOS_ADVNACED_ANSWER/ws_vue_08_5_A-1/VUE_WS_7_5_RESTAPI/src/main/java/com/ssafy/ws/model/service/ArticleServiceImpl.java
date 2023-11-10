package com.ssafy.ws.model.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.Article;
import com.ssafy.ws.model.FileDto;
import com.ssafy.ws.model.mapper.ArticleDao;
import com.ssafy.ws.model.mapper.FileDao;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private FileDao fileDao;

	
	@Override
	public List<Map<String, Object>> getArticles(Map<String, Object> params) {
		return articleDao.selectArticles(params);
	}
	
	
	@Override
	public Map<String, Object> getArticle(Map<String,Object> params) {
		System.out.println("getArticle :: " + params);
		return articleDao.selectArticle(params);
	}
	
	@Override
	@Transactional
	public boolean insertArticle(Map<String, Object> article) {
		System.out.println("article :: " + article);
		try {
			int boardId = Integer.parseInt((String)article.get(Article.BOARD_ID.getField()));
			int maxRgt = articleDao.selectMaxRgt(boardId);
			article.put(Article.MAX_RGT.getField(), maxRgt);
			articleDao.insertArticle(article);
			System.out.println("article map:");
			System.out.println(article);
			
			if(article.containsKey("fileInfos")) {
				// 기존의 MultipartFile[] 배열을 가져옵니다.
				MultipartFile[] fileArray = (MultipartFile[]) article.get("fileInfos");
				
				// 변환된 Map을 담을 리스트를 생성합니다.
				List<Map<String, Object>> fileInfos = new ArrayList<>();
				
				// 배열을 반복하면서 Map<String, Object>로 변환 후 리스트에 추가합니다.
				for (MultipartFile file : fileArray) {
					Map<String, Object> fileInfo = new HashMap<>();
					fileInfo.put("fileName", file.getOriginalFilename());
					fileInfo.put("fileSize", file.getSize());
					// 다른 필드도 추가 가능
					
					// articleId를 추가합니다.
					fileInfo.put("articleId", article.get("articleId"));
					
					// 변환된 Map을 리스트에 추가합니다.
					fileInfos.add(fileInfo);
					
					// 데이터베이스에 파일 정보를 추가합니다.
					fileDao.insertFile(fileInfo);
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateArticle(Map<String, Object> article) {
		try {
			articleDao.updateArticle(article);
//			articleDao.saveFile();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteArticle(int articleId) {
		int result = articleDao.deleteArticle(articleId);
		if (result > 0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean increaseViewCnt(int articleId) {
		int result = articleDao.increaseViewCnt(articleId);
		if( result > 0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean likeArticle(Map<String, Object> article) {
		return articleDao.likeArticle(article) == 1;
	}


	@Override
	public boolean dislikeArticle(Map<String, Object> article) {
		return articleDao.dislikeArticle(article) == 1;
	}


	@Override
	@Transactional
	public boolean replyArticle(Map<String, Object> article) {
		articleDao.updateLft(article);
		articleDao.updateRgt(article);
		int depth = articleDao.getParentDepth(article);
		article.put("depth", depth+1);
		System.out.println("reply Article!!!!");
		System.out.println(article);
		articleDao.replyArticle(article);
		List<Map<String,Object>> fileInfos = (List<Map<String, Object>>) article.get("fileInfos");
		for(Map<String, Object> fileInfo : fileInfos) {
			fileInfo.put("articleId", article.get("articleId"));
			fileDao.insertFile(fileInfo);
		}
		return true;
	}
		
	
}
