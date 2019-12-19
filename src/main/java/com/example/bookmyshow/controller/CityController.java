package com.example.bookmyshow.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmyshow.error.exception.GenericException;
import com.example.bookmyshow.service.CityService;

@RestController
public class CityController {
	
	@Autowired
    private CityService cityService;

    @GetMapping(value = "/cities/")
    @ApiOperation("Get all cities")
    public String[] getAllCities() throws GenericException {
        return cityService.getAllCities();
    }

}
