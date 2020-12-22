package gadour.springboot.energy.controllers;

import gadour.springboot.energy.Services.EnergyService;
import gadour.springboot.energy.controllers.thymeleaf.EnergyControllerForThym;
import gadour.springboot.energy.domain.Energy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class EnergyControllerForThymTest {

    @Mock
    EnergyService service;

    @Mock
    Model model;

    EnergyControllerForThym controller;

    @Before
    public void setUp() throws Exception{

        MockitoAnnotations.openMocks(this);

        controller = new EnergyControllerForThym(service);



    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }


    @Test
    public void listEnergy() {
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