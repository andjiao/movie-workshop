package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.repositories.Movie;
import com.example.movieworkshoptemplate.repositories.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.HashSet;

public class MovieService {
    //Services called from controllers that returns what the client requests
    ReadFile reader = new ReadFile();
    ArrayList<Movie> moviesList = reader.fileReader();

    public MovieService() throws FileNotFoundException {
    }

    /*GetFirst, finding first movie and display title*/
    public String getFirstMovie() throws FileNotFoundException{
        ArrayList <Movie> mList = moviesList;
        return  "The first movie on the list is: " + mList.get(0).getTitle();

    }

    /*This end-point calls a service,  that finds a single random movie from the list and displays the
    title */
    public String getRandomMovie() throws FileNotFoundException{
        //pick random movie

        //Movie randomMovie = moviesList.random(0 - moviesList.size)
        Random randomizer = new Random(moviesList.size());
        Movie randomMovie = moviesList.get(randomizer.nextInt());
        return randomMovie.getTitle();
    }

    /*
    3.4 /getTenSortByPopularity - Amanda
This end-point calls a service that fetches 10 random movies, maps each result to a Movie model class, adds to a
Movie Arraylist and prints the result to the browser - sorted in ascending order by popularity
(Hint: Remember the comparable interface).
     */

    public String getTenSortByPopularity() throws FileNotFoundException{

        HashSet<Movie> tenRandomMovies = new HashSet<>();

        while(tenRandomMovies.size() < 10) {
            double currentNumber = Math.floor(Math.random()*(moviesList.size()-1)+1);
            tenRandomMovies.add(moviesList.get((int) currentNumber));
        }

        ArrayList<Movie> sortedTenMovies = new ArrayList<>();

        for(Movie movie : tenRandomMovies){
            sortedTenMovies.add(movie);
        }

        Collections.sort(sortedTenMovies);

        String result = "Movies:<br>";
        for (Movie movie: sortedTenMovies) {
            result += movie.getTitle() + ", popularity: " + movie.getPopularity() + "<br>";

        }

        return result;
    }


    /*
    3.5  /howManyWonAnAward This  end-point  prints  how  many  of
    the  movies  of  the  data-set  that  won  an award.
    */
    public int HowManyWonAnAward() throws FileNotFoundException {
        int amountOfMoviesWithAwards = 0;
        for(Movie movie : moviesList){
            if(movie.isAwards().equals("Yes")){
                amountOfMoviesWithAwards++;
            }
        }
        return amountOfMoviesWithAwards;
    }

    //3.6 (Advanced)
    // /filter?char=’x’amount=’n’This end points calls a service that prints all movies,
    // but only if they contain x character n amount of times
    public ArrayList <Movie> listOfMoviesWithXName(){
        return listOfMoviesWithXName();
    }
}
