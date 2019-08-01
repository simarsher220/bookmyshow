package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.ShowDtoRequest;
import com.example.bookmyshow.dto.ShowsDto;
import com.example.bookmyshow.dto.TheatresShowsDto;
import com.example.bookmyshow.error.exception.GenericException;
import com.example.bookmyshow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class ShowsController {

    @Autowired
    private ShowService showService;

    @PostMapping(value = "/shows/create")
    public ShowsDto addShow(@RequestBody ShowDtoRequest showDto) throws GenericException {
        return showService.addShow(showDto);
    }

    @DeleteMapping(value = "/shows/delete")
    public void deleteShow(@RequestBody ShowDtoRequest showDto) throws GenericException {
        showService.deleteShow(showDto);
    }

    @GetMapping(value = "/shows")
    public ShowsDto getShowsByMovieTheatreDate(@RequestParam("movie_id") Integer movieId, @RequestParam("theatre_id") Integer theatreId, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws GenericException {
        return showService.getShowsByMovieAndTheatreAndDate(movieId, theatreId, date);
    }

    @GetMapping(value = "/showsBy")
    public TheatresShowsDto getShowsByMovieCityDate(@RequestParam("movie_id") Integer movieId, @RequestParam("city") String city, @RequestParam("date") Date date) throws GenericException {
        return showService.getShowsByMovieAndCityAndDate(movieId, city, date);
    }
}
