package Juego;


import Entidades.*;
import Fabricas.*;
import Entidades.Planta;
import Entidades.Zombie;
import Fabricas.FabricaPlantaDia;
import Fabricas.FabricaZombieDia;

public class SupervivenciaDia extends ModoDeJuego{	
	
	public SupervivenciaDia(Juego j) {
		super.fabricaPlan = new FabricaPlantaDia();
		super.fabricaZom = new FabricaZombieDia();
	}
	
	@Override
	public void accionModo() {
		// TODO generar soles dia		
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
	
	public String getFondo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String[] getCesped() {
		String[] retornar =  {"/imagenes/grasstile.png", "/imagenes/grasstile-hovered.png"};
		return retornar;
	}

	public String[] getPlantas() {
		String[] retornar = {"/imagenes/sunflower.gif", "/imagenes/wallnut.gif", "/imagenes/lanzaguisantes.gif"};
		return retornar;
	}
}
