package com.example.bookmyshow.controller;

import com.example.bookmyshow.entity.Movie;
import com.example.bookmyshow.dto.MovieDto;
import com.example.bookmyshow.dto.MoviesDto;
import com.example.bookmyshow.error.exception.GenericException;
import com.example.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies/")
    public MoviesDto getAllMovie() throws GenericException {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/movies/{movieId}")
    public MovieDto getMovie(@PathVariable("movieId") Integer movieId) throws GenericException {
        return movieService.getMovieById(movieId);
    }

    @PostMapping(value = "/movies/create")
    public MovieDto addMovie(@RequestBody MovieDto movieDto) throws GenericException {
        return movieService.addMovie(movieDto);
    }

    @DeleteMapping(value = "/movies/{movieId}/delete")
    public void deleteMovie(@PathVariable("movieId") Integer movieId) {
        movieService.removeMovie(movieId);
    }

    @GetMapping(value = "/movies/theatre/{theatreId}")
    public MoviesDto getMoviesByTheatre(@PathVariable("theatreId") Integer theatreId) throws GenericException {
        return movieService.getMoviesByTheatre(theatreId);
    }

    @GetMapping(value = "/movies/city/{city}")
    public MoviesDto getMoviesByCity(@PathVariable("city") String city) throws GenericException {
        return movieService.getMoviesByCity(city);
    }
}
