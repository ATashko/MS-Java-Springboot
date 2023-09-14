package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.repository.IMovieFeignRepository;
import com.dh.catalogservice.repository.ISerieFeignRepository;
import com.example.serieservice.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {


    @Autowired
    private IMovieFeignRepository iCatalogClient;

    @Autowired
    private ISerieFeignRepository iSerieClient;

    public CatalogController(IMovieFeignRepository iCatalogClient, ISerieFeignRepository iSerieClient) {
        this.iCatalogClient = iCatalogClient;
        this.iSerieClient = iSerieClient;
    }

    @GetMapping("catalog/{genre}")
    public List<Movie> getPlaylistByGenre (@PathVariable String genre) {
        return iCatalogClient.getMovieByGenre(genre);
    }

    @PostMapping("catalog/create-movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return iCatalogClient.saveMovie(movie);
    }

    @GetMapping("catalog/series")
    public List<Serie> getAll(){
        return iSerieClient.getAll();
    }

    @GetMapping("catalog/series/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }

    @PostMapping("catalog/series")
    public String create(@RequestBody Serie serie) {
        return iSerieClient.create(serie);
    }
}
