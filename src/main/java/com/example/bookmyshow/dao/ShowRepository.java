package com.example.bookmyshow.dao;

import com.example.bookmyshow.entity.Movie;
import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    List<Show> findAllByMovie(Movie movie);

    List<Show> findAllByTheatre(Theatre theatre);

    List<Show> findByMovieAndTheatre(Movie movie, Theatre theatre);

    List<Show> findByTheatre(Theatre theatre);
}
