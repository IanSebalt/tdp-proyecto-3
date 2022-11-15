package Hilos;

import Juego.Juego;

public class ControlZombie extends Control{
	
	protected int spawn = 0;

	public ControlZombie(Juego mj) {
		super(mj);
	}
	
	public void run() {
		boolean inicioOleada = true;
		while(continuar){
			try {
				if(inicioOleada) {
					Thread.sleep(3000);
				}
				else
					Thread.sleep(50);
				miJuego.moverZombies();
				if( miJuego.cantidadZombiesParaGenerarEnOleada() > 0 ) {
					spawn += 50;
					if(spawn == 800 ) {
						inicioOleada = false;
						miJuego.generarOleada();
						spawn = 0;
					}
				}
				else
					if(miJuego.hayZombiesEnGrilla() == false){	
						inicioOleada = true;
						miJuego.manejoOleada();
						
					/*
					 *  Si se puede generar una oleada, genero
					 *  Pero quiero cambiar de nivel solo cuando no haya mas zombies en pantalla
					 */
				}
				if(spawn>800)
					spawn = 0;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}