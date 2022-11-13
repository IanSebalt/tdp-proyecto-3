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
				Thread.sleep(1000);
				miJuego.accionModo(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void finish() {
		continuar = false;
	}

}
