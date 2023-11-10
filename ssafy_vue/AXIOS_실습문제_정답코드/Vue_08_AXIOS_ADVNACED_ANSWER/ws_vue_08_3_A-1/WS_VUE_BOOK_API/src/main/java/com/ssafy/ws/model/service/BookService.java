package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Book;

public interface BookService {

	List<Book> list();

	Book search(String isbn);

	boolean create(Book book);

	boolean modify(Book book);

	boolean delete(String isbn);

}
