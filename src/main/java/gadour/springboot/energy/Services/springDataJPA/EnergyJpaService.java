package gadour.springboot.energy.Services.springDataJPA;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.domain.Energy;
import org.springframework.stereotype.Service;
import gadour.springboot.energy.repositories.EnergyRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @Override
    public Double calculAVGEnegry() {

        Set<Energy>data = new HashSet<>();
        energyRepository.findAll().forEach(data::add);

        List<Double> energyData = new ArrayList<>();

        data.forEach(energy -> {
            energyData.add(energy.getEnergy());
        });

        Double average = energyData.stream().mapToDouble(val -> val).average().orElse(0.0);

        return average ;
    }
}
