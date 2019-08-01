package com.example.bookmyshow.service;

import com.example.bookmyshow.dao.MovieRepository;
//import com.example.bookmyshow.dao.SeatRepository;
import com.example.bookmyshow.dao.ShowRepository;
import com.example.bookmyshow.dao.TheatreRepository;
import com.example.bookmyshow.dto.TheatresDto;
import com.example.bookmyshow.entity.Movie;
//import com.example.bookmyshow.entity.Seat;
import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.entity.Theatre;
import com.example.bookmyshow.error.exception.GenericException;
import com.example.bookmyshow.mapper.TheatreMapper;
import com.example.bookmyshow.dto.TheatreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
//    @Autowired
//    private SeatRepository seatRepository;

    public TheatresDto getAllTheatresInCity(String city) throws GenericException {
        List<Theatre> theatres = null;
        try {
            theatres = theatreRepository.findAllByCity(city);
            if (theatres == null) {
                throw new Exception("Theatres not found!!");
            }
        }
        catch (Exception e) {
            throw new GenericException(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        TheatresDto theatresDto = new TheatresDto();
        theatresDto.setTheatreDtos(TheatreMapper.getTheatreDtosFromTheatres(theatres));
        return theatresDto;
    }

    public void removeTheatre(Integer theatreId) throws GenericException {
        try {
            theatreRepository.deleteById(theatreId);
        }
        catch (Exception e) {
            throw new GenericException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public TheatreDto addTheatre(TheatreDto theatreDto) throws GenericException {
        Theatre theatre = TheatreMapper.getTheatreFromTheatreDto(theatreDto);
        try {
            if (!(theatre.getCity().equals("Bengaluru") || theatre.getCity().equals("Lucknow") || theatre.getCity().equals("Mumbai") || theatre.getCity().equals("Delhi"))) {
                throw new Exception("Invalid City!!");
            }
            theatre = theatreRepository.saveAndFlush(theatre);
            if (theatre == null) {
                throw new Exception("Couldn't insert theatre!!");
            }
        }
        catch (Exception e) {
            throw new GenericException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
//        Set<Seat> seats = new HashSet<>();
//        for (int c=65; c<=74; c++) {
//            for (int s=1; s<=10; s++) {
//                Seat seat = new Seat(theatre, (char) c, s, false);
//                seat = seatRepository.saveAndFlush(seat);
//                seats.add(seat);
//            }
//        }
//        theatre.setSeats(seats);
//        theatre = theatreRepository.saveAndFlush(theatre);
        return TheatreMapper.getTheatreDtoFromTheatre(theatre);
    }

    public List<TheatreDto> getTheatresByMovieId(Integer movieId) throws GenericException {
        List<Theatre> theatres = new ArrayList<>();
        try {
            Movie movie = movieRepository.findMovieById(movieId);
            if (movie == null) {
                throw new Exception("Movie not found!!");
            }
            List<Show> shows = showRepository.findAllByMovie(movie);
            if (shows == null) {
                throw new Exception("Shows not found!!");
            }
            for (Show show : shows) {
                if (!theatres.contains(show.getTheatre())) {
                    theatres.add(show.getTheatre());
                }
            }
        }
        catch (Exception e) {
            throw new GenericException(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return TheatreMapper.getTheatreDtosFromTheatres(theatres);
    }
}
