package Fabricas;

import Entidades.Cactus;
import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;
import Entidades.SetaDesesporada;
import Entidades.SetaSolar;
import Escenario.Coordenada;

public class FabricaPlantaNoche implements FabricaPlanta{
	public PlantaDisparadora getPlantaDisparadora(Coordenada c) {
		return new SetaDesesporada(c);
	}
	public PlantaRobusta getPlantaRobusta(Coordenada c) {
		return new Cactus(c);
	}
	public PlantaGeneradora getPlantaGeneradora(Coordenada c) {
		return new SetaSolar(c);
	}
}

