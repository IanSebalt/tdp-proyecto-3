package Escenario;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Entidades.*;

public class Grilla {
	
	protected Fila matriz [];		
	
	public Grilla(int filas) {
		matriz = new Fila[filas];
		for(int i = 0; i<filas; i++)		
			this.matriz[i] = new Fila();
	}
	
	public synchronized void setZombie(Zombie z, int fil) {		
		matriz[fil].getFilaZombie().addLast(z);				
	}
	
	public synchronized void setPlanta(Planta plan, Coordenada cord) {
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]==null)
			matriz[cord.getY()].getFilaPlanta()[cord.getX()] = plan;			
	}
	
	public void setProyectil(Proyectil p, Coordenada c) {
		matriz[c.getY()].getFilaProyectil().addFirst(p);
	}
	
	public Planta getPlanta(Coordenada cord) {
		Planta toReturn = null;
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]!=null) {
			toReturn = matriz[cord.getY()].getFilaPlanta()[cord.getX()];
		}
		return toReturn;
	}	
	
	public synchronized void matarZombie(Zombie z) {
		matriz[z.getCoordenada().getY()].getFilaZombie().removeFirstOccurrence(z);	
	}
	
	public synchronized void matarPlanta(Coordenada cord) {		
		Planta planta = null;
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]!=null) {
			planta = matriz[cord.getY()].getFilaPlanta()[cord.getX()];
			matriz[cord.getY()].getFilaPlanta()[cord.getX()] = null;
		}
		if (planta!=null)
			planta.morir();
	}
	
	public void matarProyectil(Proyectil p) {
		matriz[p.getCoordenada().getY()].getFilaProyectil().removeFirstOccurrence(p);
	}
	
	public synchronized Planta getUltimaPlanta(int fila) {
		Planta toReturn = null; 
		Planta [] filaPlantas = matriz[fila].getFilaPlanta();
		boolean encontre = false;
		int i = filaPlantas.length - 1;
		while( i >= 0 && !encontre) {
			if(filaPlantas[i] != null) {
				encontre = true;
				toReturn = filaPlantas[i];
			}
			i--;
		}
		return toReturn;
	}
	
	public synchronized void moverZombies() {
		for(int i = 0; i<matriz.length; i++) {
			List<Zombie> filaZombie = Collections.synchronizedList(matriz[i].getFilaZombie());
			Iterator<Zombie> it = filaZombie.iterator();
			while(it.hasNext()) {
				Planta ultimaPlanta = getUltimaPlanta(i);
				Proyectil ultimoProyectil = null;
				Zombie zom = it.next();
				
				if(!matriz[i].getFilaProyectil().isEmpty()) {
					ultimoProyectil = matriz[i].getFilaProyectil().getLast();
				}		
				if(ultimoProyectil != null) {
					if(zom.getRectangulo().intersects(ultimoProyectil.getRectangulo())){
						zom.visit(ultimoProyectil);
					}
				}
				
				if( ultimaPlanta == null ) {
					zom.mover();
				}else {
					if(zom.getRectangulo().intersects(ultimaPlanta.getRectangulo())) {
						zom.visit(ultimaPlanta);
					}else {
						zom.mover();
					}
				}
			}
		}
	}

	public synchronized void actuarPlantas() {
		for(int i = 0; i<matriz.length; i++)
			for(Planta p : matriz[i].getFilaPlanta().clone())
				if(p != null) {
					p.actuar();
				}
	}

	public synchronized void moverProyectiles() {
		for(int i = 0; i<matriz.length; i++)
			for(Proyectil p : matriz[i].getFilaProyectil())
				if(p != null) {
					p.mover();		
				}
	}	
	
	public synchronized boolean hayZombies() {
		boolean toReturn = false;
		for(int i = 0; i<matriz.length; i++) {
			for(Zombie z : matriz[i].getFilaZombie()) {
				if(z != null) {
					toReturn = true;
				}
			}
		}
		return toReturn;
	}
	
	public synchronized boolean hayZombiesFila(Coordenada c) {
		boolean toReturn = false;
		LinkedList<Zombie> filaZombie = (LinkedList<Zombie>) matriz[c.getY()].getFilaZombie().clone();
		Iterator<Zombie> it = filaZombie.iterator();
		while(it.hasNext() && !toReturn) {
			Zombie aux = it.next();
			if( (int)(aux.getRectangulo().getX() / 100) >= c.getX()) {
				
				toReturn = true;
			}
		}
		return toReturn;
	}
	
}
