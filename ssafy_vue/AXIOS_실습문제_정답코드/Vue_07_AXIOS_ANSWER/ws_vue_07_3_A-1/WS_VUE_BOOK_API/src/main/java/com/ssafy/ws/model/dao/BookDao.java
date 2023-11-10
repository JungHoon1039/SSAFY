package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Book;

public interface BookDao {

	List<Book> list();

	Book search(String isbn);

	int create(Book book);

	int modify(Book book);

	int delete(String isbn);
	
}
