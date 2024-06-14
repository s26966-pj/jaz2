package pl.pjatk.RentalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id){
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @GetMapping("/return/{id}")
    public ResponseEntity<Movie> setAvailable(@PathVariable int id) {
        rentalService.returnMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rent/{id}")
    public ResponseEntity<Movie> setUnavailable(@PathVariable int id) {
        rentalService.rentMovie(id);
        return ResponseEntity.noContent().build();
    }
}
