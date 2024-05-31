package pl.pjatk.MovieService.movieService.repository;

import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pjatk.MovieService.movie.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Modifying
    @Query(value="update Movie set is_available = true where id = :id")
    void setAsAvailable(@Param("id") int id);


}
