package Hilos;

import Juego.Juego;

public class ControlZombie extends Control{
	
	protected int spawn = 0;

	public ControlZombie(Juego mj) {
		super(mj);
	}
	
	public void run() {
		while(continuar){
			try {
				//TODO métodos a controlar por el hilo				
				Thread.sleep(50);
				miJuego.moverZombies();
				spawn += 50;
				if(spawn==5000) {
					miJuego.generarZombie();
					spawn = 0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
