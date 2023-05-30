package mt.motorcycles.repo;

import mt.motorcycles.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotorcycleRepo extends JpaRepository<Motorcycle, Long> {

    void deleteMotorcycleById(Long id);

    Optional<Motorcycle> findMotorcycleById(Long id);
}
