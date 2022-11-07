package Fabricas;

<<<<<<< HEAD
import Entidades.*;
=======
import Entidades.Cactus;
import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;
import Entidades.SetaDesesporada;
import Entidades.SetaSolar;
>>>>>>> 585ad22b68b45bd67e888da5bba95b88d7092293

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

