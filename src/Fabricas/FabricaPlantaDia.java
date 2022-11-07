package Fabricas;

import Entidades.*;

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
