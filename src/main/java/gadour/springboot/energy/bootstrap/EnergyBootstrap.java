package gadour.springboot.energy.bootstrap;


import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.domain.Energy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Component
public class EnergyBootstrap implements CommandLineRunner {

    private final EnergyService energyService;

    public EnergyBootstrap(EnergyService energyService) {
        this.energyService = energyService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = energyService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData(){

        Energy v1 = new Energy();
        v1.setTimestamp(LocalDateTime.now());
        v1.setEnergy(100.0);
        v1.setDeviceSn("#2");

        energyService.save(v1);

        Energy v2 = new Energy();
        v2.setTimestamp(LocalDateTime.now());
        v2.setEnergy(150.0);
        v2.setDeviceSn("#1");

        energyService.save(v2);
    }

}
