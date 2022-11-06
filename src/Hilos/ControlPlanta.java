package Hilos;

import Juego.Juego;

public class ControlPlanta extends Control{

	public ControlPlanta(Juego mj) {
		super(mj);
	}
	
	public void run() {
		while(continuar){
			try {
				//TODO métodos a controlar por el hilo				
				Thread.sleep(1000);				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}		
	}
	
	
}
