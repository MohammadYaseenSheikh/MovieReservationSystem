package book.my.film.code.bookmyfilm.Repo;

import book.my.film.code.bookmyfilm.Models.DTO.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
}
