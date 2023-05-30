package mt.motorcycles;

import lombok.AllArgsConstructor;
import mt.motorcycles.model.Motorcycle;
import mt.motorcycles.service.MotorcycleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
@AllArgsConstructor
public class MotorcycleResource {
    private final MotorcycleService motorcycleService;

    @GetMapping("/all")
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles(){
        List<Motorcycle> motorcycles = motorcycleService.findAllMotorcycles();
        return new ResponseEntity<>(motorcycles, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable("id") Long id){
        Motorcycle motorcycle = motorcycleService.findMotorcycleById(id);
        return new ResponseEntity<>(motorcycle, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Motorcycle> addMotorcycle(@RequestBody Motorcycle motorcycle){
        Motorcycle newMotorcycle = motorcycleService.addMotorcycle(motorcycle);
        return new ResponseEntity<>(newMotorcycle, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Motorcycle> updateMotorcycle(@RequestBody Motorcycle motorcycle){
        Motorcycle updateMotorcycle = motorcycleService.addMotorcycle(motorcycle);
        return new ResponseEntity<>(updateMotorcycle, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMotorcycleById(@PathVariable("id") Long id){
        motorcycleService.deleteMotorcycle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
