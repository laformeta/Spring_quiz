package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	// 날씨 정보 화면
	// url : http://localhost/weather_history/weather-list-view
	@GetMapping("/weather-list-view")
	public String addWeatherView(Model model) {
		
		List<WeatherHistory> weatherList = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherList", weatherList);
		return "weather_history/weatherList";
	}
	
	// url : http://localhost/weather_history/add-weather-view

	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add-weather")
	public String addWeather(
			@ModelAttribute WeatherHistory weatherHistory,
			Model model) {
		
		weatherHistoryBO.addWeatherHistory(weatherHistory);
		
		WeatherHistory latestAddedWeatherHistory = weatherHistoryBO.getWeatherHistoryById(weatherHistory.getId());
		
		model.addAttribute("weatherList", latestAddedWeatherHistory);
		
		return "redirect:http://localhost/weather_history/weather-list-view";
	}

}
