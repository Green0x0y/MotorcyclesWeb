package mt.motorcycles.service;

import lombok.AllArgsConstructor;
import mt.motorcycles.exception.VehicleNotFoundException;
import mt.motorcycles.model.Motorcycle;
import mt.motorcycles.repo.MotorcycleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class MotorcycleService {
    private final MotorcycleRepo motorcycleRepo;

    public Motorcycle addMotorcycle(Motorcycle motorcycle){
        motorcycle.setName("Honda CBR 125");
        return motorcycleRepo.save(motorcycle);
    }

    public List<Motorcycle> findAllMotorcycles(){
        return motorcycleRepo.findAll();
    }

    public Motorcycle updateMotorcycle(Motorcycle motorcycle){
        return motorcycleRepo.save(motorcycle);
    }

    public Motorcycle findMotorcycleById(Long id){
        return motorcycleRepo.findMotorcycleById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Motorcycle not found by id " + id));
    }

    public void deleteMotorcycle(Long id){
        motorcycleRepo.deleteMotorcycleById(id);
    }
}
