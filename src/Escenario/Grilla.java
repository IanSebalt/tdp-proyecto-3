package Escenario;

import java.util.LinkedList;

public class Grilla {
	
	protected Fila matriz [];		
	
	public Grilla(int filas, int col) {
		for(int i = 0; i<filas; i++)			
			this.matriz[i] = new Fila();
	}
	
	public void setZombie(Zombie z, int fil) {		
		matriz[fil].getFilaZombie().addLast(z);				
	}
	
	public void setPlanta(Planta plan, Coordenada cord) {
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]==null)
			matriz[cord.getY()].getFilaPlanta()[cord.getX()].addLast(plan);			
	}
	
	public Planta getPlanta(Coordenada cord) {
		Planta toReturn = null;
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]!=null) {
			toReturn = matriz[cord.getY()].getFilaPlanta()[cord.getX()];
		}
		return toReturn;
	}	
	
	public void matarZombie(Zombie z) {
		matriz[z.getCoordenada().getY()].getFilaProyectil().removeFirstOccurrence(z);	
	}
	
	public void matarPlanta(Coordenada cord) {		
		Planta planta = null;
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]!=null) {
			planta = matriz[cord.getY()].getFilaPlanta()[cord.getX()];
			matriz[cord.getY()].getFilaPlanta()[cord.getX()] = null;
		}
		if (planta!=null)
			planta.morir();
	}
	
	public void moverZombies() {
		for(int i = 0; i<matriz.length; i++)
			for(Zombie zom : matriz[i].getFilaZombie())
				zom.mover();
	}
	
}
