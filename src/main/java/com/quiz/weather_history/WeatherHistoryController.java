package com.quiz.weather_history;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	// 날씨 정보 화면
	// url : http://localhost/weather_history/weather-list-view
	@GetMapping("/weather-list-view")
	public String addWeatherView(Model model) {
		
		model.addAttribute(weatherHistoryBO.getWeatherHistory());
		return "weather_history/weatherList";
	}
	
	
	
	

}
