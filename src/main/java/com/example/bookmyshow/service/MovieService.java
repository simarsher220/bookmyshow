package com.example.bookmyshow.service;

import com.example.bookmyshow.dao.MovieRepository;
import com.example.bookmyshow.dao.ShowRepository;
import com.example.bookmyshow.dao.TheatreRepository;
import com.example.bookmyshow.entity.Movie;
import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.entity.Theatre;
import com.example.bookmyshow.mapper.MovieMapper;
import com.example.bookmyshow.dto.MovieDto;
import com.example.bookmyshow.dto.MoviesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ShowRepository showRepository;

    public MoviesDto getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDto> movieDtos = MovieMapper.getMovieDtosFromMovies(movies);
        MoviesDto moviesDto = new MoviesDto();
        moviesDto.setMovies(movieDtos);
        return moviesDto;
    }

    public MovieDto getMovieById(Integer movieId) {
        Movie movie = movieRepository.findMovieById(movieId);
        if (movie == null) {
            // error handling
        }
        return MovieMapper.getMovieDtoFromMovie(movie);
    }

    public Movie addMovie(MovieDto movieDto) {
        Movie movie = MovieMapper.getMovieFromMovieDto(movieDto);
        movie = movieRepository.saveAndFlush(movie);
        return movie;
    }

    public void removeMovie(Integer movieId) {
        movieRepository.deleteById(movieId);
    }

    public MoviesDto getMoviesByTheatre(Integer theatreId) {
        Theatre theatre = theatreRepository.findTheatreById(theatreId);
        List<Show> shows = showRepository.findAllByTheatre(theatre);
        List<Movie> movies = new ArrayList<>();
        if (shows == null) {

        }
        for (Show show : shows) {
            if (!movies.contains(show.getMovie())) {
                movies.add(show.getMovie());
            }
        }
        MoviesDto moviesDto = new MoviesDto();
        moviesDto.setMovies(MovieMapper.getMovieDtosFromMovies(movies));
        return moviesDto;
    }

    public MoviesDto getMoviesByCity(String city) {
        List<Theatre> theatres = theatreRepository.findAllByCity(city);
        List<Movie> movies = new ArrayList<>();
        for (Theatre theatre : theatres) {
            List<Show> shows = showRepository.findAllByTheatre(theatre);
            for (Show show : shows) {
                if (!movies.contains(show.getMovie())) {
                    movies.add(show.getMovie());
                }
            }
        }
        MoviesDto moviesDto = new MoviesDto();
        moviesDto.setMovies(MovieMapper.getMovieDtosFromMovies(movies));
        return moviesDto;
    }
}
