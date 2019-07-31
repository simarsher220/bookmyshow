package com.example.bookmyshow.service;

import com.example.bookmyshow.dao.MovieRepository;
import com.example.bookmyshow.dao.SeatRepository;
import com.example.bookmyshow.dao.ShowRepository;
import com.example.bookmyshow.dao.TheatreRepository;
import com.example.bookmyshow.dto.TheatresDto;
import com.example.bookmyshow.entity.Movie;
import com.example.bookmyshow.entity.Seat;
import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.entity.Theatre;
import com.example.bookmyshow.mapper.TheatreMapper;
import com.example.bookmyshow.dto.TheatreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;

    public TheatresDto getAllTheatresInCity(String city) {
        List<Theatre> theatres = theatreRepository.findAllByCity(city);
        if (theatres == null) {

        }
        TheatresDto theatresDto = new TheatresDto();
        theatresDto.setTheatreDtos(TheatreMapper.getTheatreDtosFromTheatres(theatres));
        return theatresDto;
    }

    public void removeTheatre(Integer theatreId) {
        theatreRepository.deleteById(theatreId);
    }

    public TheatreDto addTheatre(TheatreDto theatreDto) {
        Theatre theatre = TheatreMapper.getTheatreFromTheatreDto(theatreDto);
        theatre = theatreRepository.saveAndFlush(theatre);
        if (theatre == null) {

        }
        Set<Seat> seats = new HashSet<>();
        for (int c=65; c<=74; c++) {
            for (int s=1; s<=10; s++) {
                Seat seat = new Seat(theatre, (char) c, s, false);
                seat = seatRepository.saveAndFlush(seat);
                seats.add(seat);
            }
        }
        theatre.setSeats(seats);
        theatre = theatreRepository.saveAndFlush(theatre);
        return TheatreMapper.getTheatreDtoFromTheatre(theatre);
    }

    public List<TheatreDto> getTheatresByMovieId(Integer movieId) {
        Movie movie = movieRepository.findMovieById(movieId);
        List<Show> shows = showRepository.findAllByMovie(movie);
        List<Theatre> theatres = new ArrayList<>();
        if (shows == null) {

        }
        for (Show show : shows) {
            if (!theatres.contains(show.getTheatre())) {
                theatres.add(show.getTheatre());
            }
        }

        return TheatreMapper.getTheatreDtosFromTheatres(theatres);
    }
}
