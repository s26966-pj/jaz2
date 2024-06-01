package pl.pjatk.RentalService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Movie getMovie(int id) {
        return restTemplate.getForObject("http://localhost:8080/movies/" + id, Movie.class);
    }
}
