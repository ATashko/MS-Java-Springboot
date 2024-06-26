package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.repository.IMovieFeignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {


    @Autowired
    private IMovieFeignRepository iCatalogClient;

    @GetMapping("catalog/{genre}")
    public ResponseEntity<List<Movie>> getPlaylistByGenre (@PathVariable String genre) {
        return iCatalogClient.getMovieByGenre(genre);
    }
}
