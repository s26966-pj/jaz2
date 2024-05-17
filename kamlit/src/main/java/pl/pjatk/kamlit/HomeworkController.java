package pl.pjatk.kamlit;

import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @GetMapping({"/get/{id}", "/get"})
    public ResponseEntity<Car> getCar(@PathVariable(required = false) String id, @RequestParam(required = false) String reqParam){
        String carId = "";
        if (id != null) {
            carId = id;
        }
        if (reqParam != null) {
            carId = reqParam;
        }
        Car car = new Car(carId);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Car> putCar(@PathVariable String id, @RequestBody Car car){
        Car updatedCar = new Car(car.getId());
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Car> postCar(@RequestBody Car car){
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    @DeleteMapping({"/delete/{id}"})
    public HttpStatus deleteCar(@PathVariable String id){
        return HttpStatus.OK;
    }

}