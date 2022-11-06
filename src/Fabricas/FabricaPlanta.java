package Fabricas;

import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;

public interface FabricaPlanta {
	public PlantaDisparadora getPlantaDisparadora();
	public PlantaRobusta getPlantaRobusta();
	public PlantaGeneradora getPlantaGeneradora();
}
