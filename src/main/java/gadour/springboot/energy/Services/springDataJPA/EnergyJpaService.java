package gadour.springboot.energy.Services.springDataJPA;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.domain.Energy;
import org.springframework.stereotype.Service;
import gadour.springboot.energy.repositories.EnergyRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class EnergyJpaService implements EnergyService {

    private final EnergyRepository energyRepository;

    public EnergyJpaService(EnergyRepository energyRepository) {
        this.energyRepository = energyRepository;
    }

    @Override
    public Set<Energy> findAll() {
        Set<Energy>data = new HashSet<>();
        energyRepository.findAll().forEach(data::add);
        return data;
    }

    @Override
    public Energy save(Energy object) {
        return energyRepository.save(object);
    }


    @Override
    public Energy findBydeviceSn(String device_sn) {
        return energyRepository.findBydeviceSn(device_sn);
    }
}
