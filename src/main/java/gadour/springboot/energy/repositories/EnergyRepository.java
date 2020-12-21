package gadour.springboot.energy.repositories;

import gadour.springboot.energy.domain.Energy;
import org.springframework.data.repository.CrudRepository;

public interface EnergyRepository extends CrudRepository<Energy , String> {
    Double calculAVGEnegry();
}
