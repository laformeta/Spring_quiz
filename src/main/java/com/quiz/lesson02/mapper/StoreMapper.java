package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

@Mapper
public interface StoreMapper {

	// input : X (BO로부터 받아오는 것) 			output : (Service한테 주는 것) List<Store>
	public List<Store> selectStoreList();
}
