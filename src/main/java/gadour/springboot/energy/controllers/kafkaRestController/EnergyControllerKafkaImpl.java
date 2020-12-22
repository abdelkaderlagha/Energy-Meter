package gadour.springboot.energy.controllers.kafkaRestController;

import gadour.springboot.energy.domain.Energy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value="/api/kafka/")
public class EnergyControllerKafkaImpl {


    @Autowired
    private KafkaTemplate<String , Energy> kafkaTemplate;

    private static final String Topic = "Energy Readings";

    @GetMapping(value="/publish/{id}/{device_sn}/{energy}/{timestamp}")
    public String post( @PathVariable("id") final int id,
                        @PathVariable("device_sn") final String device_sn,
                        @PathVariable("energy") final Double energy,
                        @PathVariable("timestamp") final LocalDateTime timestamp ){
        kafkaTemplate.send(
                Topic,
                new Energy(id, timestamp , device_sn , energy));

        return "Published successfully";
    }


}




