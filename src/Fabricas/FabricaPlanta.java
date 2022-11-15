package Fabricas;

import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;
import Escenario.Coordenada;

public interface FabricaPlanta {
	public PlantaDisparadora getPlantaDisparadora(Coordenada c);
	public PlantaRobusta getPlantaRobusta(Coordenada c);
	public PlantaGeneradora getPlantaGeneradora(Coordenada c);
}
