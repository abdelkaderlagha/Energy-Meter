package gadour.springboot.energy.controllers.restController;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.domain.Energy;
import javax.validation.Valid;

import gadour.springboot.energy.repositories.EnergyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;



import java.util.Set;

@RestController
@Api(description = "Energy management:")
@RequestMapping(value = "/api/energy")
public class EnergyController {

    private final EnergyService energyService;

    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }

    @ApiOperation("Get all data")
    @GetMapping(value = "/")
    public Set<Energy> allEnergy(){
        return  energyService.findAll();
    }

    @ApiOperation("Post data")
    @PostMapping(value = "/")
    public Energy addEnergy(@Valid @RequestBody Energy e){
        return energyService.save(e);
    }

    @ApiOperation("Get data by SN")
    @GetMapping(value="/{id}")
    public Energy getData(@PathVariable String id) throws Exception{
        return energyService.findBydeviceSn(id);
    }

    @ApiOperation("Get averge")
    @GetMapping(value="/avg")
    public Double getAvg() throws Exception{
        return energyService.avg();
    }



}
