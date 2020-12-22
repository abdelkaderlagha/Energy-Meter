package gadour.springboot.energy.controllers;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.repositories.EnergyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnergyControllerForThym {

    private final EnergyRepository energyRepository;
    private final EnergyService energyService;


    public EnergyControllerForThym(EnergyRepository energyRepository, EnergyService energyService) {
        this.energyRepository = energyRepository;
        this.energyService = energyService;
    }


    @RequestMapping(value={"/",""})
    public String listEnergy(Model model){
        model.addAttribute("data",energyService.findAll());
        model.addAttribute("avg",energyRepository.avg());
        return "index";
    }

}