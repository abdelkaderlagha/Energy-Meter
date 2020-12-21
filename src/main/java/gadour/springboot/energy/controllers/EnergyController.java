package gadour.springboot.energy.controllers;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.domain.Energy;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/energy")
public class EnergyController {

    private final EnergyService energyService;

    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }

    @GetMapping(value = "/")
    public Set<Energy> allEnergy(){
        return  energyService.findAll();
    }

    @PostMapping(value = "/")
    public Energy addEnergy(@Valid @RequestBody Energy e){
        return energyService.save(e);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Energy> getData(@PathVariable Integer id) throws Exception{
        Energy e = energyService.findById(id);
        return ResponseEntity.ok().body(e);
    }

    @DeleteMapping(value="/{id}" )
    public Map<String,Boolean> deleteData(@PathVariable Integer id) throws Exception {
        energyService.deleteById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted!",Boolean.TRUE);
        return response;
    }

}
