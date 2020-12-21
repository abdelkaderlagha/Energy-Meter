package gadour.springboot.energy.controllers;

import gadour.springboot.energy.Services.EnergyService;
import org.springframework.stereotype.Controller;

@Controller
public class EnergyController {

    private final EnergyService energyService;

    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }


}
