package gadour.springboot.energy.Services.springDataJPA;

import gadour.springboot.energy.domain.Energy;
import gadour.springboot.energy.repositories.EnergyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnergyJpaServiceTest {

    EnergyJpaService service;

    @Mock
    EnergyRepository repository;



    @BeforeEach
    void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        service = new EnergyJpaService(repository);
    }

    @Test
    void findAll() throws Exception{

        Energy energy = new Energy();
        HashSet data = new HashSet();
        data.add(energy);

        when(service.findAll()).thenReturn(data);

        assertEquals(data.size(),1);

    }
}