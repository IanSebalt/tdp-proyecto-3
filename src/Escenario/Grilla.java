package Escenario;

import java.util.Iterator;

import Entidades.*;

import Entidades.Planta;
import Entidades.Zombie;

public class Grilla {
	
	protected Fila matriz [];		
	
	public Grilla(int filas) {
		matriz = new Fila[filas];
		for(int i = 0; i<filas; i++)		
			this.matriz[i] = new Fila();
	}
	
	public void setZombie(Zombie z, int fil) {		
		matriz[fil].getFilaZombie().addLast(z);				
	}
	
	public void setPlanta(Planta plan, Coordenada cord) {
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]==null)
			matriz[cord.getY()].getFilaPlanta()[cord.getX()] = plan;			
	}
	
	public void setProyectil(Proyectil p, Coordenada c) {
		matriz[c.getY()].getFilaProyectil().addLast(p);
	}
	
	public Planta getPlanta(Coordenada cord) {
		Planta toReturn = null;
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]!=null) {
			toReturn = matriz[cord.getY()].getFilaPlanta()[cord.getX()];
		}
		return toReturn;
	}	
	
	public void matarZombie(Zombie z) {
		matriz[z.getCoordenada().getY()].getFilaZombie().removeFirstOccurrence(z);	
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
	
	public void matarProyectil(Proyectil p) {
		matriz[p.getCoordenada().getY()].getFilaProyectil().removeFirstOccurrence(p);
	}
	
	public Planta getUltimaPlanta(int fila) {
		Planta toReturn = null; 
		Planta [] filaPlantas = matriz[fila].getFilaPlanta();
		boolean encontre = false;
		int i = filaPlantas.length - 1;
		while( i > 0 && !encontre) {
			if(filaPlantas[i] != null) {
				encontre = true;
				toReturn = filaPlantas[i];
			}
			i--;
		}
		return toReturn;
	}
	
	public void moverZombies() {
		for(int i = 0; i<matriz.length; i++) {
			Iterator<Zombie> it = matriz[i].getFilaZombie().iterator();
			while(it.hasNext()) {
				Planta ultimaPlanta = getUltimaPlanta(i);
				Proyectil ultimoProyectil = null;
				if(!matriz[i].getFilaProyectil().isEmpty()) {
					ultimoProyectil = matriz[i].getFilaProyectil().getLast();
				}
				Zombie zom = it.next();
				if( ultimaPlanta == null ) {
					if(ultimoProyectil != null) {
						if(zom.getRectangulo().intersects(ultimoProyectil.getRectangulo())){
							zom.visit(ultimoProyectil);
						}
					}
					zom.mover();
				}else {
					if(zom.getRectangulo().intersects(ultimaPlanta.getRectangulo())) {
						zom.visit(ultimaPlanta);
						if(ultimoProyectil != null) {
							if(zom.getRectangulo().intersects(ultimoProyectil.getRectangulo())){
								zom.visit(ultimoProyectil);
							}
						}
					}else {
						if(ultimoProyectil != null) {
							if(zom.getRectangulo().intersects(ultimoProyectil.getRectangulo())){
								zom.visit(ultimoProyectil);
							}
						}
						zom.mover();
					}
				}
			}
		}
	}

	public void actuarPlantas() {
		for(int i = 0; i<matriz.length; i++)
			for(Planta p : matriz[i].getFilaPlanta())
				p.actuar();
	}

	public void moverProyectiles() {
		for(int i = 0; i<matriz.length; i++)
			for(Proyectil p : matriz[i].getFilaProyectil())
				p.mover();		
	}	
	
}
