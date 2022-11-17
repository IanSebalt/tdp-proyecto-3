package Hilos;

import Juego.Juego;

/**
 * Clase ControlPlanta que extiende Control para el manejo del hilo dedicado a la actualización de las Plantas.
 *
 */
public class ControlPlanta extends Control{
	
	/**
	 * El constructor de la clase recibe por parámetro el juego y lo inicializa para el uso dentro del hilo.
	 * @param mj - juego a utilizar.
	 */
	public ControlPlanta(Juego mj) {
		super(mj);
	}
	
	/**
	 * Método run que duerme el hilo 500 ms y ejecuta el método actuarPlantas() de juego.
	 */
	public void run() {
		while(continuar){
			try {
				Thread.sleep(500);
				miJuego.actuarPlantas();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}		
	}
	
	
}
