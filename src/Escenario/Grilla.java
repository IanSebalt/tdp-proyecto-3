package Escenario;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Entidades.*;
import Juego.Juego;

/**
 * Clase Grilla para el manejo de entidades en el juego.
 *
 */
public class Grilla {
	
	protected Fila matriz [];		
	
	/**
	 * El constructor de Grilla inicializa la matriz y crea una fila por cada posición de la matriz.
	 * @param filas - cantidad de filas de la matriz.
	 */
	public Grilla(int filas) {
		matriz = new Fila[filas];
		for(int i = 0; i<filas; i++)		
			this.matriz[i] = new Fila();
	}
	
	/**
	 * Método para insertar el zombie recibido por parámetro en la lista de zombies en una fila recibida por parámetro.
	 * @param z - zombie a insertar.
	 * @param fil - fila donde insertar el zombie.
	 */
	public synchronized void setZombie(Zombie z, int fil) {		
		matriz[fil].getFilaZombie().addLast(z);				
	}
	
	/**
	 * Método que inserta una planta recibida por parámetro en el arreglo de plantas
	 * en la coordenada recibida por parámetro.
	 * @param plan - planta a insertar.
	 * @param cord - coordenada donde insertar la planta.
	 */
	public synchronized void setPlanta(Planta plan, Coordenada cord) {
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]==null)
			matriz[cord.getY()].getFilaPlanta()[cord.getX()] = plan;			
	}
	
	/**
	 * Método que inserta un proyectil en la listas de proyectiles en la coordenada
	 * pasada por parámetro.
	 * @param p - proyectil a insertar.
	 * @param c - coordenada donde insertar el proyectil.
	 */
	public synchronized void setProyectil(Proyectil p, Coordenada c) {
		matriz[c.getY()].getFilaProyectil().addFirst(p);
	}
	
	/**
	 * Método que retorna la planta en la coordenada recibida como parámetro, en caso
	 * de que no exista una planta se retorna nulo.
	 * @param cord - coordenada a checkear si existe la planta.
	 * @return una planta en caso que exista, sino nulo.
	 */
	public Planta getPlanta(Coordenada cord) {
		Planta toReturn = null;
		if(matriz[cord.getY()].getFilaPlanta()[cord.getX()]!=null) {
			toReturn = matriz[cord.getY()].getFilaPlanta()[cord.getX()];
		}
		return toReturn;
	}	
	
	/**
	 * Método que remueve al zombie recibido como parámetro de la lista de zombies.
	 * @param z -  zombie a remover.
	 */
	public synchronized void matarZombie(Zombie z) {
		matriz[z.getCoordenada().getY()].getFilaZombie().removeFirstOccurrence(z);	
	}
	
	/**
	 * Método que remueve la planta recibida como parámetro del arreglo de plantas.
	 * @param p - planta a remover.
	 */
	public synchronized void matarPlanta(Planta p) {		
		matriz[p.getCoordenada().getY()].getFilaPlanta()[p.getCoordenada().getX()] = null;		
	}
	
	/**
	 * Método que remueve el proyectil recibido como parámetro de la lista de proyectiles.
	 * @param p - proyectil a remover.
	 */
	public synchronized void matarProyectil(Proyectil p) {
		matriz[p.getCoordenada().getY()].getFilaProyectil().removeFirstOccurrence(p);
	}
	
	/**
	 * Método que retorna la ultima planta colocada en la fila recibida como parámetro de derecha a izquierda en el escenario.
	 * En caso de que la fila no tenga plantas retorna nulo.
	 * @param fila - fila a checkear última planta.
	 * @return la última planta si existe, nulo en caso contrario.
	 */
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
	
	/**
	 * Método que mueve todos los zombies colocados en el escenario clonando la lista de zombies. Tambien
	 * realiza el chequeo de coliciónes para el caso de que haya una entidad proyectil o planta en frente.
	 */
	public synchronized void moverZombies() {
		for(int i = 0; i<matriz.length; i++) {
			@SuppressWarnings("unchecked")
			List<Zombie> filaZombie = Collections.synchronizedList((List<Zombie>) matriz[i].getFilaZombie().clone());
			Iterator<Zombie> it = filaZombie.iterator();
			while(it.hasNext()) {
				Planta ultimaPlanta = getUltimaPlanta(i);
				Proyectil ultimoProyectil = null;
				Zombie zom = it.next();
				
				if( zom.getRectangulo().getX() < 0 ) {
					Juego miJuego = Juego.obtenerInstancia(null);
					miJuego.finJuego();
				}
				
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
	
	/**
	 * Método que clona los arreglos de las plantas y los recorre para ejecutar su método
	 * actuar que dependiendo del tipo de planta ejecuta distinta acción.
	 */
	public synchronized void actuarPlantas() {
		for(int i = 0; i<matriz.length; i++)
			for(Planta p : matriz[i].getFilaPlanta().clone())
				if(p != null) {
					p.actuar();
				}
	}
	
	/**
	 * Método que clona la lista actual de los proyectiles para no tener
	 * problemas con la sincronización y la recorre para moverlos uno por uno.
	 */
	@SuppressWarnings("unchecked")
	public synchronized void moverProyectiles() {
		for(int i = 0; i<matriz.length; i++)
			for(Proyectil p : (LinkedList<Proyectil>) matriz[i].getFilaProyectil().clone())
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
	
	/**
	 * Método que retorna verdadero si hay algún zombie en la fila de la coordenada pasada por parámetro,
	 * falso en caso contrario.
	 * @param c - coordenada a checkear la fila.
	 * @return verdadero si hay zombies en la fila, falso en caso contrario.
	 */
	public synchronized boolean hayZombiesFila(Coordenada c) {
		boolean toReturn = false;
		@SuppressWarnings("unchecked")
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
