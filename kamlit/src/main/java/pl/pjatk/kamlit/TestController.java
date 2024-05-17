package pl.pjatk.kamlit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getCar() {
        return ResponseEntity.ok(new Car(10));
    }

    @GetMapping("/hello/{value}")
    public ResponseEntity<String> helloValue(@PathVariable String value) {
        return ResponseEntity.ok(value);
    }

    @GetMapping("/helloparam")
    public ResponseEntity<String> helloValueReq(@RequestParam String value) {
        return ResponseEntity.ok(value);
    }

    @PostMapping("/model")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(car);
    }


}
