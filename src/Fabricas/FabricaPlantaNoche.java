package Fabricas;

import Entidades.*;

public class FabricaPlantaNoche implements FabricaPlanta{
	public PlantaDisparadora getPlantaDisparadora() {
		return new SetaDesesporada();
	}
	public PlantaRobusta getPlantaRobusta() {
		return new Cactus();
	}
	public PlantaGeneradora getPlantaGeneradora() {
		return new SetaSolar();
	}
}

