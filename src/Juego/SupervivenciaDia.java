package Juego;


import java.util.concurrent.ThreadLocalRandom;

import Escenario.Coordenada;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaPlantaDia;
import Fabricas.FabricaZombie;
import Fabricas.FabricaZombieDia;

public class SupervivenciaDia extends ModoDeJuego{
	
	protected int cronometro;
	
	public SupervivenciaDia(Juego j) {
		super.miJuego = j;
		super.fabricaPlan = new FabricaPlantaDia();
		super.fabricaZom = new FabricaZombieDia();
		this.cronometro = 0;
	}
	
	public void accionModo(int seg) {
		if (cronometro == 10000) {
			int randomX = ThreadLocalRandom.current().nextInt(0, 10);
			int randomY = ThreadLocalRandom.current().nextInt(0, 7);			
			miJuego.generarSol(new Coordenada(randomX, randomY));
			cronometro = 0;
		}
		cronometro += seg;
	}

	
	public String getFondo() {
		return null;
	}
	
	public String[] getCesped() {
		String[] retornar =  {"/imagenes/grasstile.png", "/imagenes/grasstile-hovered.png"};
		return retornar;
	}

	public String[] getPlantas() {
		String[] retornar = {"/imagenes/girasol-precio.png", "/imagenes/nuez-precio.png", "/imagenes/lanzaguisantes-precio.png"};
		return retornar;
	}
	
	public FabricaPlanta getFabricaPlanta() {
		return fabricaPlan;
	}
	
	public FabricaZombie getFabricaZombie() {
		return fabricaZom;
	}
}
