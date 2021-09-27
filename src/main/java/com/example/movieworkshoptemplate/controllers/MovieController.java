package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.ReadFile.Movie;
import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class MovieController {
    //Controller methods




    //Task 3.1:
    @GetMapping("/")
    public String index(){
        return "Hello user - Use This application to search for your movie facts";
    }

    //Task 3.2:
    @GetMapping("/getFirstMovie")
    public String getFirst() throws FileNotFoundException{
        MovieService ms1= new MovieService();
        return ms1.getFirstMovie();

    }

    //Task 3.3:
    @GetMapping("/getRandomMovie")
    public String getRandomMovie() throws FileNotFoundException{
        MovieService ms3_3 = new MovieService();
        return ms3_3.getRandomMovie();
    }

    //Task 3.5:
    @GetMapping("/howManyWonAnAward")
    public int howManyWonAnAward() throws FileNotFoundException {
        MovieService movieService = new MovieService();
        return movieService.HowManyWonAnAward();
    }


}
