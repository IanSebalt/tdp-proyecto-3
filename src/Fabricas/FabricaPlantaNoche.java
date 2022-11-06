package Fabricas;


public class FabricaPlantaNoche implements FabricaPlanta{
	public PlantaDisparadora getPlantaDisparadora() {
		return new Seta_Desesporadora();
	}
	public PlantaRobusta getPlantaRobusta() {
		return new Cactus();
	}
	public PlantaGeneradora getPlantaGeneradora() {
		return new Seta_Solar();
	}
}

