package gadour.springboot.energy.Services.springDataJPA;

import gadour.springboot.energy.domain.Energy;
import gadour.springboot.energy.repositories.EnergyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnergyJpaServiceTest {


    @Mock
    EnergyRepository repository;


    @InjectMocks
    EnergyJpaService service;

    Energy returnEnergy;

    @BeforeEach
    void setUp() throws Exception {

        returnEnergy = Energy.builder().id(1).energy(10.0).device_sn("#1").timestamp(LocalDateTime.now()).build();

    }

    @Test
    void findAll() throws Exception{

        Set<Energy> returnEnergySet = new HashSet<>();
        returnEnergySet.add(Energy.builder().id(1).build());
        returnEnergySet.add(Energy.builder().id(2).build());

        when(repository.findAll()).thenReturn(returnEnergySet);

        Set<Energy> data = service.findAll();

        assertNotNull(data);
        assertEquals(2, data.size());

    }

    @Test
    void save() {
        Energy energyToSave = Energy.builder().id(1).build();

        when(repository.save(any())).thenReturn(returnEnergy);

        Energy savedEnergy = service.save(energyToSave);

        assertNotNull(savedEnergy);

        verify(repository).save(any());
    }

}