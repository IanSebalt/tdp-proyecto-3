package Fabricas;

import Entidades.Cactus;
import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;
import Entidades.SetaDesesporada;
import Entidades.SetaSolar;

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

