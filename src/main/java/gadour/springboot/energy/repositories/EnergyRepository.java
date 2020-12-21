package gadour.springboot.energy.repositories;

import gadour.springboot.energy.domain.Energy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface EnergyRepository extends CrudRepository<Energy , Integer > {

    @Query(value = "SELECT avg(energy) FROM Energy")
    public Double avg();

    Energy findBydeviceSn(String device_sn);

}
