package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public RecruitEntity quiz02_1() {
		return recruitRepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> quiz02_2(
			@RequestParam("companyId") int companyId){
		
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> quiz02_3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> quiz02_4() {
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> quiz02_5() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> quiz02_6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	public List<RecruitEntity> quiz02_7() {
		return recruitRepository.findDeadlineSalaryType("2026-04-10", 8100, "정규직");
	}
}
