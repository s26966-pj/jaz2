package pl.pjatk.RentalService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Operation(summary = "Returns specific movie")
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id){
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @Operation(summary = "Sets movie as available")
    @PatchMapping("/return/{id}")
    public ResponseEntity<Movie> setAvailable(@PathVariable int id) {
        rentalService.returnMovie(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Sets movie as unavailable")
    @PatchMapping("/rent/{id}")
    public ResponseEntity<Movie> setUnavailable(@PathVariable int id) {
        rentalService.rentMovie(id);
        return ResponseEntity.noContent().build();
    }
}
