package Juego;

import java.util.concurrent.ThreadLocalRandom;

import Entidades.Planta;
import Entidades.Zombie;
import Escenario.Coordenada;
import Fabricas.FabricaPlantaNoche;
import Fabricas.FabricaZombieNoche;

public class SupervivenciaNoche extends ModoDeJuego{
	
	protected int cronometro;
	
	public SupervivenciaNoche(Juego j) {
		super.fabricaPlan = new FabricaPlantaNoche();
		super.fabricaZom = new FabricaZombieNoche();
		this.cronometro = 0;
	}

	public void accionModo(int seg) {
		if (cronometro == 1000) {
			int randomY = ThreadLocalRandom.current().nextInt(0, 8);
			int randomX = ThreadLocalRandom.current().nextInt(0, 5);
			miJuego.generarLapida(new Coordenada(randomX, randomY));
			cronometro = 0;
		}
		cronometro += seg;
	}

	@Override
	public Planta generarPlanta(int c, Coordenada coord) {
		Planta nuevaPlanta = null;
		if(c == 1)
			nuevaPlanta = fabricaPlan.getPlantaGeneradora(coord);
		else
			if(c == 2)
				nuevaPlanta = fabricaPlan.getPlantaRobusta(coord);
			else
				if(c == 3)
					nuevaPlanta = fabricaPlan.getPlantaDisparadora(coord);
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
