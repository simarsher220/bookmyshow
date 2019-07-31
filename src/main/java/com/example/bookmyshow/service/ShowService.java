package com.example.bookmyshow.service;

import com.example.bookmyshow.dao.MovieRepository;
import com.example.bookmyshow.dao.ShowRepository;
import com.example.bookmyshow.dao.TheatreRepository;
import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.entity.Movie;
import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.entity.Theatre;
import com.example.bookmyshow.mapper.MovieMapper;
import com.example.bookmyshow.mapper.ShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheatreRepository theatreRepository;

    public ShowsDto addShow(ShowDtoRequest showDto) {
        Movie movie = movieRepository.findMovieById(showDto.getMovieId());
        Theatre theatre = theatreRepository.findTheatreById(showDto.getTheatreId());
        List<Show> shows = showRepository.findByTheatre(theatre);
        if (shows != null && shows.size() > 0) {
            for (Show show : shows) {
                LocalTime time = showDto.getTime().toLocalTime();
                LocalTime compTime = show.getId().getTime().toLocalTime();
                if (MINUTES.between(time, compTime) == 0) {
                    throw new RuntimeException();
                }
                if (MINUTES.between(time, compTime) < 0 && Math.abs(MINUTES.between(time, compTime)) - show.getMovie().getLength() < 0) {
                    throw new RuntimeException();
                }    // -ve
                if(MINUTES.between(time, compTime) > 0 && Math.abs(MINUTES.between(time, compTime)) - movie.getLength() < 0) {
                    throw new RuntimeException();
                }
            }
        }
        Show show = ShowMapper.getShowFromShowDtoRequest(movie, theatre, showDto.getDate(), showDto.getTime());
        show = showRepository.saveAndFlush(show);
        if (show == null) {
            // error handling
        }
        ShowsDto showsDto = new ShowsDto();
        showsDto.setMovie(show.getMovie());
        showsDto.setTheatre(show.getTheatre());
        showsDto.setShowDtos(ShowMapper.getShowsDtoFromShows(Collections.singletonList(show)));
        return showsDto;
    }

    public void deleteShow(ShowDtoRequest showDto) {
        Movie movie = movieRepository.findMovieById(showDto.getMovieId());
        Theatre theatre = theatreRepository.findTheatreById(showDto.getTheatreId());
        Show show = ShowMapper.getShowFromShowDtoRequest(movie, theatre, showDto.getDate(), showDto.getTime());
        showRepository.delete(show);
    }

    private List<ShowDto> getShowListByMovieAndTheatreAndDate(Integer movieId, Integer theatreId, Date date) {
        Movie movie = movieRepository.findMovieById(movieId);
        Theatre theatre = theatreRepository.findTheatreById(theatreId);
        List<Show> shows = showRepository.findByMovieAndTheatre(movie, theatre);
        List<Show> showFilter = new ArrayList<>();
        date = ShowMapper.getZeroTimeDate(date);
        for (Show show : shows) {
            Date compDate = ShowMapper.getZeroTimeDate(show.getId().getDate());
            if (compDate.equals(date)) {
                showFilter.add(show);
            }
        }
        return ShowMapper.getShowsDtoFromShows(showFilter);
    }

    public ShowsDto getShowsByMovieAndTheatreAndDate(Integer movieId, Integer theatreId, Date date) {
        ShowsDto showsDto = new ShowsDto();
        Movie movie = movieRepository.findMovieById(movieId);
        Theatre theatre = theatreRepository.findTheatreById(theatreId);
        showsDto.setMovie(movie);
        showsDto.setTheatre(theatre);
        showsDto.setShowDtos(getShowListByMovieAndTheatreAndDate(movieId, theatreId, date));
        return showsDto;
    }

    public TheatresShowsDto getShowsByMovieAndCityAndDate(Integer movieId, String city, Date date) {
        List<Theatre> theatres = theatreRepository.findAllByCity(city);
        TheatresShowsDto theatresShowsDto = new TheatresShowsDto();
        List<TheatreShowsDto> theatreShowsDtos = new ArrayList<>();
        for (Theatre theatre : theatres) {
            TheatreShowsDto theatreShowsDto = new TheatreShowsDto();
            theatreShowsDto.setTheatreId(theatre.getTheatreId());
            theatreShowsDto.setTheatreLocation(theatre.getTheatreLocation());
            theatreShowsDto.setTheatreName(theatre.getTheatreName());
            theatreShowsDto.setCity(theatre.getCity());
            theatreShowsDto.setPincode(theatre.getPincode());
            theatreShowsDto.setShowDtos(getShowListByMovieAndTheatreAndDate(movieId, theatre.getTheatreId(), date));
            theatreShowsDtos.add(theatreShowsDto);
        }
        Movie movie = movieRepository.findMovieById(movieId);
        theatresShowsDto.setMovie(MovieMapper.getMovieDtoFromMovie(movie));
        theatresShowsDto.setTheatreShowsDtos(theatreShowsDtos);
        return theatresShowsDto;
    }
}
