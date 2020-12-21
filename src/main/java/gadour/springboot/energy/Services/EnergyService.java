package gadour.springboot.energy.Services;

import gadour.springboot.energy.domain.Energy;

public interface EnergyService extends CrudService <Energy , String>{
    Double  calculAVGEnegry();
}

