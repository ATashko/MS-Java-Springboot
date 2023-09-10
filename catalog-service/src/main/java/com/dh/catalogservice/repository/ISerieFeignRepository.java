package com.dh.catalogservice.repository;

import com.example.serieservice.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "serie-service")
public interface ISerieFeignRepository {
    @GetMapping("/api/v1/series")
    List<Serie> getAll();

    @GetMapping("/{genre}")
    List<Serie> getSerieByGenre(@PathVariable String genre);

    @PostMapping("/api/v1/series")
    String create(@RequestBody Serie serie);

}
