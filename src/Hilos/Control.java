package Hilos;

import Juego.Juego;

/**
 * Clase Control que implementa la interfaz Runnable de java para el manejo del hilo dedicado a la actualización del juego.
 *
 */
public class Control implements Runnable{
	
	protected boolean continuar;
	
	protected Juego miJuego;
	
	/**
	 * Método que recibo por parámetor el juego a utilizar.
	 * @param mj - juego a utilizar.
	 */
	public Control(Juego mj) {
		this.miJuego = mj;
		continuar = true;
	}
	
	/**
	 * Método run que duerme el hilo 1s para ejecutar el metodo accionModo() de juego.
	 */
	public void run() {
		while(continuar){
			try {
				Thread.sleep(1000);
				miJuego.accionModo(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Método que detiene el ciclo del hilo.
	 */
	public void finish() {
		continuar = false;
	}

}
