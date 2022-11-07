package Fabricas;

<<<<<<< HEAD
import Entidades.*;
=======
import Entidades.Girasol;
import Entidades.LanzaGuisantes;
import Entidades.Nuez;
import Entidades.PlantaDisparadora;
import Entidades.PlantaGeneradora;
import Entidades.PlantaRobusta;
>>>>>>> 585ad22b68b45bd67e888da5bba95b88d7092293

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
