package Fabricas;

import Entidades.Girasol;
import Entidades.LanzaGuisantes;
import Entidades.Nuez;
import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;
import Escenario.Coordenada;

public class FabricaPlantaDia implements FabricaPlanta {
	public PlantaDisparadora getPlantaDisparadora(Coordenada c) {
		return new LanzaGuisantes(c);
	}
	public PlantaRobusta getPlantaRobusta(Coordenada c) {
		return new Nuez(c);
	}
	public PlantaGeneradora getPlantaGeneradora(Coordenada c) {
		return new Girasol(c);
	}
}
