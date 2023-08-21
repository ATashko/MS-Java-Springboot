package com.dh.catalogservice.repository;

import com.dh.catalogservice.config.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@LoadBalancerClient(name = "movie-service", configuration = CustomLoadBalancerConfiguration.class)
@FeignClient (name = "movie-service")
public interface IMovieFeignRepository {

    @GetMapping("/api/v1/movies/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre (@PathVariable String genre);
}
