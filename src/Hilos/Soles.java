package Hilos;

import Juego.SupervivenciaDia;

public class Soles implements Runnable{

	protected boolean continuar;
	
	protected SupervivenciaDia modo;
	
	public Soles(SupervivenciaDia sup) {
		this.continuar = true;
		this.modo = sup;
	}
	
	public void run() {
		while(continuar)
			try {
				Thread.sleep(10000);
				//TODO
				//modo.generarSol();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	public void finish(){
		continuar = false;
	}
}
