package book.my.film.code.bookmyfilm.Service.Impl;

import book.my.film.code.bookmyfilm.Models.DTO.Movie;
import book.my.film.code.bookmyfilm.Models.MovieRequest;
import book.my.film.code.bookmyfilm.Repo.MovieRepo;
import book.my.film.code.bookmyfilm.Service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    final
    MovieRepo repo;

    public MovieServiceImpl(MovieRepo repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<List<Movie>> getMovies() {
        try{
            List<Movie> movies = repo.findAll();
            return ResponseEntity.ok(movies);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Void> addMovie(List<Movie> movie) {
        try{
            repo.saveAll(movie);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Movie> updateMovie(MovieRequest movie) {
        return repo.findById(movie.getId())
                .map(existingMovie -> {
                    // Update only non-null fields using Optional
                    Optional.ofNullable(movie.getTitle()).ifPresent(existingMovie::setTitle);
                    Optional.ofNullable(movie.getGenre()).ifPresent(existingMovie::setGenre);
                    Optional.ofNullable(movie.getPosterUrl()).ifPresent(existingMovie::setPosterUrl);
                    Optional.ofNullable(movie.getDescription()).ifPresent(existingMovie::setDescription);
                    // Add other fields as needed...

                    Movie updated = repo.save(existingMovie);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public void deleteMovie(Long id) {
        try{
            repo.deleteById(id);
        } catch (Exception e){
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
