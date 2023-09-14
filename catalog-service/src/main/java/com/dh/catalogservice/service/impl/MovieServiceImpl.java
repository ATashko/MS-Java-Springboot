package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.repository.IMovieFeignRepository;
import com.dh.catalogservice.service.MovieService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    private IMovieFeignRepository movieFeignRepository;

    private CircuitBreakerRegistry circuitBreakerRegistry;

    @CircuitBreaker(name= "movies", fallbackMethod = "getMovieByGenreEmptyFallback")
    @Retry(name = "movies")
    @Override
    public List<Movie> getMovieByGenre(String genre) {
        log.info("obtaining genre");
        return movieFeignRepository.getMovieByGenre(genre);
    }

    private List<Movie> getMovieByGenreEmptyFallback(CallNotPermittedException exception) {
        return new ArrayList<>();
    }
}
