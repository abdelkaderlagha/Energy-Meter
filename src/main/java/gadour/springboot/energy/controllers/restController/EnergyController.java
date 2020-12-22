package gadour.springboot.energy.controllers.restController;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.domain.Energy;
import javax.validation.Valid;

import gadour.springboot.energy.repositories.EnergyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestController
@Api(description = "Energy management:")
@RequestMapping(value = "/api/energy")
public class EnergyController {

    private final EnergyService energyService;

    @Autowired
    private KafkaTemplate<String , Energy> kafkaTemplate;

    private static final String Topic = "Energy_Readings";

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

    @ApiOperation("Stream datapoints from the server")
    @GetMapping(value="/publish")
    public String post(){

        Set<Energy> data = new HashSet<>();

        energyService.findAll().forEach(data::add);

        data.forEach(energy -> { kafkaTemplate.send( Topic, energy ); });

        return "Published successfully";
    }




}
