package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class MovieController{
    //Controller methods
    MovieService movieService = new MovieService();
    public MovieController() throws FileNotFoundException {
    }

    //Task 3.1:
    @GetMapping("/")
    public String index(){
        return "Hello user - Use This application to search for your movie facts";
    }

    //Task 3.2:
    @GetMapping("/getFirstMovie")
    public String getFirst(){
        return movieService.getFirstMovie();
    }

    //Task 3.3:
    @GetMapping("/getRandomMovie")
    public String getRandomMovie() throws FileNotFoundException{
        MovieService ms3_3 = new MovieService();
        return ms3_3.getRandomMovie();
    }

    //Task 3.5:
    @GetMapping("/howManyWonAnAward")
    public int howManyWonAnAward(){
        return movieService.HowManyWonAnAward();
    }

}
