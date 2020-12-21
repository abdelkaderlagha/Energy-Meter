package repositories;

import domain.Energy;
import org.springframework.data.repository.CrudRepository;

public interface EnergyRepository extends CrudRepository<Energy , String> {
}
