package Escenario;

import java.util.LinkedList;
import java.util.List;

public class Fila {
	
	protected List<Zombie> filaZombie;
	
	protected Planta filaPlanta [];
	
	protected List<Proyectil> filaProyectil;
	
	public Fila() {
		filaZombie = new LinkedList<Zombie>();
		filaPlanta = new Planta[9];
		filaProyectil = new LinkedList<Proyectil>();
	}
	
	public List<Zombie> getFilaZombie(){
		return filaZombie;
	}
	
	public Planta [] getFilaPlanta(){
		return filaPlanta;
	}
	
	public List<Proyectil> getFilaProyectil(){
		return filaProyectil;
	}
	
}
