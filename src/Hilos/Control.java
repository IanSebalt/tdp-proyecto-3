package Hilos;

import Juego.Juego;

public class Control implements Runnable{
	
	protected boolean continuar;
	
	protected Juego miJuego;
	
	public Control(Juego mj) {
		this.miJuego = mj;
		continuar = true;
	}

	public void run() {
		while(continuar){
			try {
				//TODO métodos a controlar por el hilo
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void finish() {
		continuar = false;
	}

}
