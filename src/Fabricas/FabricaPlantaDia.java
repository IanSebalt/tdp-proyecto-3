package Fabricas;

import Entidades.*;
import Entidades.Girasol;
import Entidades.LanzaGuisantes;
import Entidades.Nuez;
import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;

public class FabricaPlantaDia implements FabricaPlanta {
	public PlantaDisparadora getPlantaDisparadora() {
		return new LanzaGuisantes();
	}
	public PlantaRobusta getPlantaRobusta() {
		return new Nuez();
	}
	public PlantaGeneradora getPlantaGeneradora() {
		return new Girasol();
	}
}
