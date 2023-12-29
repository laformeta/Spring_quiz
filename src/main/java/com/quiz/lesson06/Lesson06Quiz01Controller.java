package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson06.bo.BookmarkBO;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;

	// 즐겨찾기 추가 화면
	// url : http://localhost/lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		
		return "lesson06/addBookmark";
	}
	
	// 회원가입 진행(insert) => AJAX 요청
	// AJAX가 요청하는 응답값은 반드시 String이다.
	
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		bookmarkBO.addBookmark(name, url);
		
		return "추가 완료";
	}
	
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView() {
		
		return "lesson06/afterAddBookmark";
	}
}
