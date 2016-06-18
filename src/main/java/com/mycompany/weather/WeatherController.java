package com.mycompany.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("cities", weatherService.getCities());
        return "weather";
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public String redirectToHome(Model model) {
        model.addAttribute("cities", weatherService.getCities());
        return "weather";
    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public String weather(@RequestParam(value = "city", required = false, defaultValue = "London") String city, Model model) {
        model.addAttribute("cities", weatherService.getCities());
        model.addAttribute("weatherDataSummary", weatherService.getWeatherData(city));
        return "weather";
    }

}
