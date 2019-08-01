package com.example.bookmyshow.mapper;

import com.example.bookmyshow.dto.ShowDto;
import com.example.bookmyshow.entity.Movie;
import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.entity.Theatre;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public class ShowMapper {

    public static Show getShowFromShowDtoRequest(Movie movie, Theatre theatre, Date date, Time time) {
        Show show = new Show(theatre, movie, date, time);
        return show;
    }

    public static ShowDto getShowDtoFromShow(Show show) {
        ShowDto showDto = new ShowDto();
        showDto.setDate(show.getId().getDate());
        showDto.setTime(show.getId().getTime());
        return showDto;
    }

    public static List<ShowDto> getShowsDtoFromShows(List<Show> shows) {
        List<ShowDto> showDtos = new ArrayList<>();
        for (Show show : shows) {
            showDtos.add(getShowDtoFromShow(show));
        }
        return showDtos;
    }

//    public static Date getZeroTimeDate(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        date = calendar.getTime();
//        return date;
//    }
}
