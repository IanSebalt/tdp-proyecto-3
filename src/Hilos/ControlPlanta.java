package Hilos;

import Juego.Juego;

public class ControlPlanta extends Control{

	public ControlPlanta(Juego mj) {
		super(mj);
	}
	
	public void run() {
		while(continuar){
			try {
				Thread.sleep(2500);
				miJuego.actuarPlantas();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}		
	}
	
	
}
