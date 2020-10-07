package com.moodys.qats.acceptance;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @GetMapping(value = "/healthcheck")
    public String healthcheck() { 
    	return HttpStatus.OK.toString(); 
    }
}