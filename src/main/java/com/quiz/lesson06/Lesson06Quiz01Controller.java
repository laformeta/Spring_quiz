package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Quiz01Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;

	// 즐겨찾기 추가 화면
	// url : http://localhost/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		
		return "lesson06/addBookmark";
	}
	
	// 회원가입 진행(insert) => AJAX 요청
	// AJAX가 요청하는 응답값은 반드시 String이다.
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		bookmarkBO.addBookmark(name, url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "추가 완료");
		
		return result; // map => JSON String
	}
	
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView(Model model) {
		// select db
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		// model에 담기
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
	
	// url 중복 확인 - AJAX 요청
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url){
		
		// DB select
		boolean isDuplication = bookmarkBO.isDuplicationUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result;
	}
	
	// 즐겨찾기 삭제 - AJAX 요청
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		
		// DB delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200); // 성공
			result.put("result", "성공");
		} else {
			result.put("code", 500); // 실패
			result.put("error_message", "삭제 실패");
		}
		
		return result;
	}
	
}
