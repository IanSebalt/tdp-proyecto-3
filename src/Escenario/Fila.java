package Escenario;

import java.util.LinkedList;
import Entidades.Planta;
import Entidades.Proyectil;
import Entidades.Zombie;

/**
 * Clase Fila para el manejo de las distintas listas de entidades.
 *
 */
public class Fila {
	
	protected LinkedList<Zombie> filaZombie;
	
	protected Planta filaPlanta [];
	
	protected LinkedList<Proyectil> filaProyectil;
	
	/**
	 * El constructor Fila inicicaliza 2 listas de proyectil y zombie
	 * y un arreglo de plantas.
	 */
	public Fila() {
		filaZombie = new LinkedList<Zombie>();
		filaPlanta = new Planta[9];
		filaProyectil = new LinkedList<Proyectil>();
	}
	
	/**
	 * Método que retorna la lista de zombies.
	 * @return la lista de zombies.
	 */
	public LinkedList<Zombie> getFilaZombie(){
		return filaZombie;
	}
	
	/**
	 * Método que retorna el arreglo de Plantas.
	 * @return un arreglo de plantas.
	 */
	public Planta [] getFilaPlanta(){
		return filaPlanta;
	}
	
	/**
	 * Método que retorna la lista de proyectiles.
	 * @return una lista de proyectiles.
	 */
	public LinkedList<Proyectil> getFilaProyectil(){
		return filaProyectil;
	}
	
}
