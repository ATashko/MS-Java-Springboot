package com.dh.catalogservice.queue;


import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.MovieService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {

    private final MovieService iMovieService;

    public MovieListener(MovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload Movie movie){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        iMovieService.saveMovie(movie);
    }
}