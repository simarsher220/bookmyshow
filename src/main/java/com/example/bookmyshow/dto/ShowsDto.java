package com.example.bookmyshow.dto;

import com.example.bookmyshow.entity.Movie;
import com.example.bookmyshow.entity.Theatre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowsDto {

    private Movie movie;
    private Theatre theatre;
    private List<ShowDto> showDtos;

    @JsonProperty("movie")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @JsonProperty("theatre")
    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @JsonProperty("shows")
    public List<ShowDto> getShowDtos() {
        return showDtos;
    }

    public void setShowDtos(List<ShowDto> showDtos) {
        this.showDtos = showDtos;
    }
}
