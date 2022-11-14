package Juego;

import java.util.concurrent.ThreadLocalRandom;

import Escenario.Coordenada;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaPlantaNoche;
import Fabricas.FabricaZombie;
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
		}
		cronometro += seg;
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

	public FabricaPlanta getFabricaPlanta() {
		return fabricaPlan;
	}

	public FabricaZombie getFabricaZombie() {
		return fabricaZom;
	}
}
