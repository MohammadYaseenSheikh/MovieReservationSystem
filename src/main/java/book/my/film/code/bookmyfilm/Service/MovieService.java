package book.my.film.code.bookmyfilm.Service;

import book.my.film.code.bookmyfilm.Models.DTO.Movie;
import book.my.film.code.bookmyfilm.Models.MovieRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    ResponseEntity<List<Movie>> getMovies();
    ResponseEntity<Void> addMovie(List<Movie> movie);
    ResponseEntity<Movie> updateMovie(MovieRequest movie);
    void deleteMovie(Long id);

}
