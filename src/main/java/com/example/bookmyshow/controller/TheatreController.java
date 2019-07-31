package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.TheatreDto;
import com.example.bookmyshow.dto.TheatresDto;
import com.example.bookmyshow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping(value = "/theatres/")
    public TheatresDto getAllTheatresInCity(@RequestParam("city") String city) {
        return theatreService.getAllTheatresInCity(city);
    }

    @GetMapping(value = "/theatres/{movieId}")
    public void getTheatreByMovieId(@PathVariable("movieId") Integer movieId) {
        theatreService.getTheatresByMovieId(movieId);
    }

    @PostMapping(value = "/theatres/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TheatreDto addNewTheatre(@RequestBody TheatreDto theatreDto) {
        return theatreService.addTheatre(theatreDto);
    }

    @DeleteMapping(value = "/theatres/{theatreId}/delete")
    public void deleteTheatre(@PathVariable("theatreId") Integer theatreId) {
        theatreService.removeTheatre(theatreId);
    }

}
