package cineflex;

import cineflex.manager.Profile;
import cineflex.manager.Start;
import cineflex.movies.Generate;
import cineflex.movies.Movies;

public class CineFlex {
    
    public static void main(String[] args) {
        Movies[] movie = Generate.generateMovie();
        Profile[] p = new Profile[20];
        Start.start(movie, p, 0);
    }
}
