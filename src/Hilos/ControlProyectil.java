package Hilos;

import Juego.Juego;

public class ControlProyectil extends Control{

	public ControlProyectil(Juego mj) {
		super(mj);
	}
	
	public void run() {
		while(continuar){
			try {
				Thread.sleep(45);
				miJuego.moverProyectiles();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
