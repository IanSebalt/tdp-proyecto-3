package Juego;


import java.util.concurrent.ThreadLocalRandom;

import Escenario.Coordenada;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaPlantaDia;
import Fabricas.FabricaZombie;
import Fabricas.FabricaZombieDia;

/**
 * Clase SupervicenciaDia que extiende ModoDeJuego para el modo de juego dia.
 *
 */
public class SupervivenciaDia extends ModoDeJuego{
	
	protected int cronometro;
	
	/**
	 * Constructor que recibe por parámetro el juego para enviar los respectivos mensajes.
	 * @param j - juego a utilizar.
	 */
	public SupervivenciaDia(Juego j) {
		super.miJuego = j;
		super.fabricaPlan = new FabricaPlantaDia();
		super.fabricaZom = new FabricaZombieDia();
		this.cronometro = 0;
	}
	
	/**
	 * Método que genera soles de manera aleatoria y le manda un mensaje al juego para poder generarlos.
	 * Estos soles se generan cada 10 segundos.
	 * @param - segundos a sumar hasta que se generen los soles.
	 */
	public void accionModo(int seg) {
		if (cronometro == 10000) {
			int randomX = ThreadLocalRandom.current().nextInt(0, 10);
			int randomY = ThreadLocalRandom.current().nextInt(0, 7);			
			miJuego.generarSol(new Coordenada(randomX, randomY));
			cronometro = 0;
		}
		cronometro += seg;
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
