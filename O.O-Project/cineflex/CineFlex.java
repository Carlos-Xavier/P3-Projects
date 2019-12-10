package cineflex;

import cineflex.manager.Profile;
import cineflex.manager.Start;
import cineflex.movies.Movies;

public class CineFlex {
    
    public static void main(String[] args) {
        Movies movie = new Movies();
        movie.generateMovies();
        Profile[] p = new Profile[20];
        Start.start(movie, p, 0);
    }
}
