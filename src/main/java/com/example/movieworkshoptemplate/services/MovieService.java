package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.ReadFile.Movie;
import com.example.movieworkshoptemplate.ReadFile.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class MovieService {
    //Services called from controllers that returns what the client requests

    /*GetFirst, finding first movie and display title*/
    public String getFirstMovie() throws FileNotFoundException{
        ArrayList <Movie> mList = new ArrayList<>();

        return mList.get(1).getTitle();

    }

    /*This end-point calls a service,  that finds a single random movie from the list and displays the
    title */
    public String getRandomMovie() throws FileNotFoundException{
        //pick random movie
        ReadFile reader = new ReadFile();
        ArrayList<Movie> moviesList = reader.fileReader();
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

    public void getTenSortByPopularity() throws FileNotFoundException{
        //Først findes ti tilfældige film

        ReadFile reader = new ReadFile();
        ArrayList<Movie> moviesList = reader.fileReader();
        HashSet<Movie> tenRandomMovies = new HashSet<>();

        while(tenRandomMovies.size() < 10) {
            int currentNumber = Integer.parseInt(String.valueOf(Math.floor(Math.random()*(moviesList.size()-1)+1)));
            tenRandomMovies.add(moviesList.get(currentNumber));
        }

    }


    /*
    3.5  /howManyWonAnAward This  end-point  prints  how  many  of
    the  movies  of  the  data-set  that  won  an award.
    */
    public int HowManyWonAnAward() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        int amountOfMoviesWithAwards = 0;
        for(Movie movie : readFile.fileReader()){
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
