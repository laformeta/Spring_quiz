package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	
// input : id		output :
	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
		
	// myBatis 문법에서 parameter는 단 한개만 xml로 보낼 수 있다.
	// parameter들을 하나의 map에 담아서 보낸다.
	// map으로 만들어주는 어노테이션이 @Param이다.
	public List<RealEstate> selectRealEstateListByAreaPrice(@Param("area")int area, @Param("price")int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	public int deleteRealEstateById(int id);
}
