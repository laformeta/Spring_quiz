package com.quiz.lesson06.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkMapper {

	public void insertBookmark(String name, String url);
}
