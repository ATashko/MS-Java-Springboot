package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMovieByGenre ( String genre);
}
