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
				if( miJuego.cantidadZombiesParaGenerarEnOleada() > 0 ) {
					spawn += 50;
					if(spawn==5000) {
						miJuego.generarOleada();
						spawn = 0;
					}
				}else {					
					Thread.sleep(1000);
					miJuego.manejoOleada();
					
					/*
					 *  Si se puede generar una oleada, genero
					 *  Pero quiero cambiar de nivel solo cuando no haya mas zombies en pantalla
					 */
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}