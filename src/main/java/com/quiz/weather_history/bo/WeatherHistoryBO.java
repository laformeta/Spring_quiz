package com.quiz.weather_history.bo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	public void addWeatherHistory(Date date, String weather, double temperatures, double precipitation,
			String microDust, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
	
}
