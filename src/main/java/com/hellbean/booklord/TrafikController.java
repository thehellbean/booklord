package com.hellbean.booklord;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TrafikController {

    @Value("${sl.api.key}")
    private String apiKey;

	@GetMapping("/trafik")
	public String trafik(RestTemplate restTemplate) {
        String formattedURL = String.format("https://api.sl.se/api2/realtimedeparturesV4.json?key=%s&siteid=9117&timewindow=60", apiKey);
        TimeTableResponse apiResponse = restTemplate.getForObject(formattedURL, TimeTableResponse.class);
		return apiResponse.getResponseData().getMetros().get(0).getDestination();
	}
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
