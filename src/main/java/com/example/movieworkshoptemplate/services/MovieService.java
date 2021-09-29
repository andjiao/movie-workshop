package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.repositories.Movie;
import com.example.movieworkshoptemplate.repositories.ReadFile;

import java.io.FileNotFoundException;
import java.util.*;

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
        Random randomizer = new Random();

        /* Vi går ind i arraylisten movieList og henter, et tilfældig indexplads, altså bare det første int,
        som randomizeren møder, hvilket vil være størrelsen på arrayet, som består af følgende
        {"year":1936,"length":84,"popularity":50,"title":"Secret Agent","subject":"Mystery"} */
        Movie randomMovie = moviesList.get(randomizer.nextInt(moviesList.size()));

        /*Dog er vi kun interesseret i titlen. randomMovie består af en hel linje fra csv-filen,
        som vi får i linjen ovenover, men vi ønsker kun titlen, derfor getTitle*/
        return randomMovie.getTitle();
    }

    /*
    3.4 /getTenSortByPopularity - Amanda
        This end-point calls a service
        that fetches 10 random movies
        maps each result to a Movie model class,
        adds to a Movie Arraylist and prints the result to the browser -
        sorted in ascending order by popularity
        (Hint: Remember the comparable interface).
     */

    public String getTenSortByPopularity() throws FileNotFoundException{

        Set<Movie> tenRandomMovies = new HashSet<>();

        while(tenRandomMovies.)

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
            result += movie.getTitle() + "; popularity: " + movie.getPopularity() + "<br>";

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

    /*
    3.6 (Advanced) /filter?char=’x’amount=’n’ - Amanda
    This end points calls a service that prints all movies, but only if they contain x character n amount of times
     */
    public String filterMovies(char c, int n){
        String result = "Movies with " + n + " instances of " + "'" + c +"' in title:<br>";
        for (Movie movie: moviesList) {
            String title = movie.getTitle();
            long count = title.chars().filter(ch -> ch == c).count();
            if (count == n){
                result += title + "<br>";
            }
        }
        return result;
    }

    /*
    3.7 (Advanced) /longest?g1=’x’g2=’y’ - Amanda
    This end-point calls a service that compares two genres and finds what genre, on average, has the longest movies.
     */

    public String compareGenreLength(String genre1, String genre2){
        int countNoMoviesG1 = 0;
        int countTotalLengthG1 = 0;
        int countNoMoviesG2 = 0;
        int countTotalLengthG2 = 0;
        for (Movie movie: moviesList) {

            if (movie.getSubject().equalsIgnoreCase(genre1)){
                countNoMoviesG1 ++;
                countTotalLengthG1 += movie.getLength();
            } else if (movie.getSubject().equalsIgnoreCase(genre2)){
                countNoMoviesG2 ++;
                countTotalLengthG2 += movie.getLength();
            }
        }
        int avLengthG1 = countTotalLengthG1/countNoMoviesG1;
        int avLengthG2 = countTotalLengthG2/countNoMoviesG2;

        if (avLengthG1 > avLengthG2){
            return "The genre " + genre1 + " has movies of an average longer length than " + genre2;
        } else if (avLengthG1 < avLengthG2) {
            return "The genre '" + genre2 + "' has movies of an average longer length than the genre '" + genre1 + "'.";
        } else {
            return genre1 + " and " + genre2 + " have movies of an equal average length.";
        }
    }


}
