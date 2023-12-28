package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RequestMapping("/store")
@Controller
public class StoreController {

	@Autowired
	private StoreBO storeBO;
	
	// url : http://localhost/store/store-list-view
	@GetMapping("/store-list-view")
	public String storeListView(Model model) {
		
		List<Store> storeList = storeBO.getStoreList();
		
		model.addAttribute("storeList", storeList);
		
		return "store/storeList";
	}
	
	// url : http://localhost/store/store-review-view
	@GetMapping("/store-review-view")
	public String storeReviewView() {
		
		return "store/storeReview";
	}
}
