package Juego;

import Fabricas.*;
import Entidades.*;
import Entidades.Planta;
import Entidades.Zombie;
import Fabricas.FabricaPlantaNoche;
import Fabricas.FabricaZombieNoche;

public class SupervivenciaNoche extends ModoDeJuego{
	
	
	public SupervivenciaNoche(Juego j) {
		super.fabricaPlan = new FabricaPlantaNoche();
		super.fabricaZom = new FabricaZombieNoche();
	}

	@Override
	public void accionModo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Planta generarPlanta(int c) {
		Planta nuevaPlanta = null;
		if(c == 1)
			nuevaPlanta = fabricaPlan.getPlantaGeneradora();
		else
			if(c == 2)
				nuevaPlanta = fabricaPlan.getPlantaRobusta();
			else
				if(c == 3)
					nuevaPlanta = fabricaPlan.getPlantaDisparadora();
		return nuevaPlanta;		
	}

	@Override
	public Zombie generarZombie(char c) {
		Zombie nuevoZombie = null;
		if(c == 'a')
			nuevoZombie = fabricaZom.getZombieBasico();
		else
			if(c == 'b')
				nuevoZombie = fabricaZom.getZombieEspecial();
			else
				if(c == 'c')
					nuevoZombie = fabricaZom.getZombieRobusto();
		return nuevoZombie;		
	}

	@Override
	public String getFondo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getCesped() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPlantas() {
		return null;
	}
}
