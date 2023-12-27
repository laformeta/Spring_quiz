package com.quiz.weather_history.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.quiz.weather_history.domain.WeatherHistory;

@Repository
public interface WeatherHistoryMapper {
	
	public List<WeatherHistory> selectWeatherHistory();
	
	public void insertWeatherHistory(WeatherHistory weatherHistory);
	
	public WeatherHistory selectWeatherHistoryById(int id);
}
