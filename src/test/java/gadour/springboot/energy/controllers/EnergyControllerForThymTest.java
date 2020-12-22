package gadour.springboot.energy.controllers;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.domain.Energy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class EnergyControllerForThymTest {

    @Mock
    EnergyService service;

    @Mock
    Model model;

    EnergyControllerForThym controller;

    @Before
    void setUp() throws Exception{

        MockitoAnnotations.openMocks(this);

        controller = new EnergyControllerForThym(service);

    }


    @Test
    void listEnergy() {
        //given

        Set<Energy> data = new HashSet<>();
        data.add(new Energy());

        Energy energy = new Energy();

        energy.setId(1);

        data.add(energy);

        when(service.findAll()).thenReturn(data);

        ArgumentCaptor<Set<Energy>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String viewName = controller.listEnergy(model);
        //then

        assertEquals("index", viewName);
        verify(service, times(1)).findAll();
        verify(model,times(1)).addAttribute(eq("data"),argumentCaptor.capture());
        Set<Energy> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());

    }

}