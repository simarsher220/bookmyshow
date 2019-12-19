package com.example.bookmyshow.controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmyshow.dto.TheatreDto;
import com.example.bookmyshow.dto.TheatresDto;
import com.example.bookmyshow.error.exception.GenericException;
import com.example.bookmyshow.service.TheatreService;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

//    @GetMapping(value = "/theatres/")
//    public TheatresDto getAllTheatresInCity(@RequestParam("city") String city) throws GenericException {
//        return theatreService.getAllTheatresInCity(city);
//    }
//
//    @GetMapping(value = "/theatres/{movieId}")
//    public List<TheatreDto> getTheatreByMovieId(@PathVariable("movieId") Integer movieId) throws GenericException {
//        return theatreService.getTheatresByMovieId(movieId);
//    }

    @PostMapping(value = "/theatres/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Collaborate a theatre with our platform")
    public TheatreDto addNewTheatre(@RequestBody TheatreDto theatreDto) throws GenericException {
		return theatreService.addTheatre(theatreDto);
    }

//    @DeleteMapping(value = "/theatres/{theatreId}/delete")
//    public void deleteTheatre(@PathVariable("theatreId") Integer theatreId) throws GenericException {
//        theatreService.removeTheatre(theatreId);
//    }

}
