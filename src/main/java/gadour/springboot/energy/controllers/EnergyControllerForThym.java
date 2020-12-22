package gadour.springboot.energy.controllers;

import gadour.springboot.energy.Services.EnergyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnergyControllerForThym {


    private final EnergyService energyService;


    public EnergyControllerForThym(EnergyService energyService) {
        this.energyService = energyService;
    }


    @RequestMapping(value={"/",""})
    public String listEnergy(Model model){
        model.addAttribute("data",energyService.findAll());
        model.addAttribute("avg",energyService.avg());
        return "index";
    }

}
