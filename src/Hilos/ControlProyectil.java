package Hilos;

import Juego.Juego;

/**
 * Clase ControlProyectil que extiende Control para el manejo del hilo dedicado a la actualización de los proyectiles.
 *
 */
public class ControlProyectil extends Control{
	
	/**
	 * El constructor de la clase recibe por parámetro el juego y lo inicializa para el uso dentro del hilo.
	 * @param mj - juego a utilizar.
	 */
	public ControlProyectil(Juego mj) {
		super(mj);
	}
	/**
	 * Método run que duerme el hilo 100 ms y ejecuta el método moverProyectiles() de juego.
	 */
	public void run() {
		while(continuar){
			try {
				Thread.sleep(50);
				miJuego.moverProyectiles();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
