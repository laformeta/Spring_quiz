package com.quiz.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	private BookmarkMapper bookmarkMapper;

	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
}
