package book.my.film.code.bookmyfilm.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private Long id;
    private String title;
    private String description;
    private String genre;
    private String posterUrl;
}
