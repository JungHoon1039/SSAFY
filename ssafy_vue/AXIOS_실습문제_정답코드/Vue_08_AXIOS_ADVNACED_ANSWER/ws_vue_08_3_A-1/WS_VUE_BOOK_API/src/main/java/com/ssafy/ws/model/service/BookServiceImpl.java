package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> list() {
		return bookDao.list();
	}

	@Override
	public Book search(String isbn) {
		return bookDao.search(isbn);
	}

	@Override
	public boolean create(Book book) {
		return bookDao.create(book) == 1;
	}

	@Override
	public boolean modify(Book book) {
		return bookDao.modify(book) == 1;
	}

	@Override
	public boolean delete(String isbn) {
		return bookDao.delete(isbn) == 1;
	}

}
