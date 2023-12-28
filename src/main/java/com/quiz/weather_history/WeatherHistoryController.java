package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String weatherListView(Model model) {
		
		List<WeatherHistory> weatherList = weatherHistoryBO.getWeatherHistoryList();
		
		model.addAttribute("weatherList", weatherList);
		return "weather_history/weatherList";
	}
	
	// url : http://localhost/weather_history/add-weather-view

	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 수행 >> 날씨 목록 화면으로 리디렉션
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures")  double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed
			) {
		
		weatherHistoryBO.addWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		
		return "redirect:/weather_history/weather-list-view";
	}

}
