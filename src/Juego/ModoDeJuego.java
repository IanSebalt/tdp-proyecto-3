package Juego;

import Fabricas.FabricaPlanta;
import Fabricas.FabricaZombie;

/**
 * Clase abstracta Modo de Juego para el manejo de los distintos modos de juego.
 *
 */
public abstract class ModoDeJuego {
	
	protected Juego miJuego;
	
	protected FabricaZombie fabricaZom;
	
	protected FabricaPlanta fabricaPlan;	
	
	/**
	 * Método que realiza una accion dependiendo del modo de juego iniciado.
	 * @param seg - segundos para ejecutar una acción.
	 */
	public abstract void accionModo(int seg);	
	
	/**
	 * Método que retorna la imágen del fondo del modo de juego.
	 * @return imagen del fondo del modo de juego.
	 */
	public abstract String getFondo();
	
	/**
	 * Método que retorna un arreglo con las imagenes del cesped del modo de juego.
	 * @return arreglo con las imagenes del cesped.
	 */
	public abstract String[] getCesped();	
	
	/**
	 * Método que retorna un arreglo con las imagenes de las plantas.
	 * @return arreglo con las imagenes de las plantas.
	 */
	public abstract String[] getPlantas();
	
	/**
	 * Método que retorna la fabrica de plantas inicializada por el modo de juego noche
	 * @return una fabrica de plantas.
	 */
	public abstract FabricaPlanta getFabricaPlanta();
	
	/**
	 * Método que retorna la fabrica de zombies inicializada por el modo de juego noche
	 * @return una fabrica de zombies.
	 */
	public abstract FabricaZombie getFabricaZombie();
	
}
