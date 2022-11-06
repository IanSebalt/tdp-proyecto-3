package Fabricas;

public class FabricaPlantaDia implements FabricaPlanta {
	public PlantaDisparadora getPlantaDisparadora() {
		return new Lanzaguisantes();
	}
	public PlantaRobusta getPlantaRobusta() {
		return new Nuez();
	}
	public PlantaGeneradora getPlantaGeneradora() {
		return new Girasol();
	}
}
