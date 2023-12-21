package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// url : http://localhost/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
				
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
			return "lesson04/afterAddSeller";
				
			}
	
	// 최근 가입자 한명
	
	// url : http://localhost/lesson04/quiz01/seller-info-view
	
	// url : http://localhost/lesson04/quiz01/seller-info-view?id=1
	
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		// db select
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getRecentSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		// model에 담기
		model.addAttribute("seller", seller);
		model.addAttribute("title", "최근 판매자 정보");
		// 응답
		return "lesson04/sellerInfo";
		
	}
	
}
