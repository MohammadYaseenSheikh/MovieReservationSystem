package book.my.film.code.bookmyfilm.Controller;

import book.my.film.code.bookmyfilm.Models.DTO.Movie;
import book.my.film.code.bookmyfilm.Models.MovieRequest;
import book.my.film.code.bookmyfilm.Service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    final
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping("/movies")
    public ResponseEntity<Void> addMovie(@RequestBody List<Movie> movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/updateMovie")
    public ResponseEntity<Movie> updateMovie(@RequestBody MovieRequest movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/deleteMovie")
    public void deleteMovie(@RequestParam Long id) {
        movieService.deleteMovie(id);
    }

}
