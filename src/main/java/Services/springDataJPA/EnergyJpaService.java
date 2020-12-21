package Services.springDataJPA;

import Services.EnergyService;
import domain.Energy;
import org.springframework.stereotype.Service;
import repositories.EnergyRepository;

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
    public Energy findById(String s) {
        return energyRepository.findById(s).orElse(null);
    }

    @Override
    public Energy save(Energy object) {
        return energyRepository.save(object);
    }

    @Override
    public void delete(Energy object) {
        energyRepository.delete(object);
    }

    @Override
    public void deleteById(String s) {
        energyRepository.deleteById(s);

    }
}
