package gadour.springboot.energy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyTest {

    Energy energy;

    @BeforeEach
    void setUp() {
        energy = new Energy();

    }

    @Test
    void getDeviceSn() {
        String sn = "#1";
        energy.setDeviceSn(sn);
        assertEquals(sn,energy.getDeviceSn());
    }
}