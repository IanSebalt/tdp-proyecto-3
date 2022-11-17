package Hilos;

import Juego.Juego;

public class ControlZombie extends Control{
	
	protected int spawn = 0;
	
	/**
	 * El constructor de la clase recibe por parámetro el juego y lo inicializa para el uso dentro del hilo.
	 * @param mj - juego a utilizar.
	 */
	public ControlZombie(Juego mj) {
		super(mj);
	}
	
	/**
	 * Método que duerme el hilo 3s cuando es el inicio de una oleada y una vez generado el primer zombie se
	 * duerme pero 100ms para que la actualización sea mas rápida. Este método mueve constantemente los zombies 
	 * utilizando el método moverZombies() de juego y solo genera zombies si hay para generar y en caso de que
	 * el jugador pase de oleada se vuelve a dormir el hilo 3s para el inicio de una nueva oleada.
	 */
	public void run() {
		boolean inicioOleada = true;
		while(continuar){
			try {
				if(inicioOleada) {
					Thread.sleep(3000);
				}
				else
					Thread.sleep(100);
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