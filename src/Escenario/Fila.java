package Escenario;

import java.util.LinkedList;
import Entidades.*;

public class Fila {
	
	protected LinkedList<Zombie> filaZombie;
	
	protected Planta filaPlanta [];
	
	protected LinkedList<Proyectil> filaProyectil;
	
	public Fila() {
		filaZombie = new LinkedList<Zombie>();
		filaPlanta = new Planta[9];
		filaProyectil = new LinkedList<Proyectil>();
	}
	
	public LinkedList<Zombie> getFilaZombie(){
		return filaZombie;
	}
	
	public Planta [] getFilaPlanta(){
		return filaPlanta;
	}
	
	public LinkedList<Proyectil> getFilaProyectil(){
		return filaProyectil;
	}
	
}
