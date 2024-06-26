package pl.pjatk.MovieService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pjatk.MovieService.movie.enums.Category;
import pl.pjatk.MovieService.movie.model.Movie;
import pl.pjatk.MovieService.movieService.service.MovieService;

import java.util.List;

@SpringBootApplication
public class MovieServiceApplication {
	private final MovieService movieService;
	public MovieServiceApplication(MovieService movieService) {
		this.movieService = movieService;
		execProcess();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	private void execProcess() {

	}
}
