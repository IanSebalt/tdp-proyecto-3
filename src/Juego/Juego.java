package Juego;

import Escenario.Coordenada;
import Escenario.Grilla;
import GUI.Ventana;
import Hilos.Control;
import Hilos.ControlZombie;

import java.util.concurrent.ThreadLocalRandom;

import Entidades.*;

public class Juego {
	
	private ModoDeJuego miModo;
	
	protected int puntosSoles;
	
	protected static Juego instance;
	
	protected Ventana miVentana;
	
	protected Control miControl;
	
	protected Grilla miGrilla;
	
	
	/**
	 * Constructor privado para el uso del patrón singleton, en donde recibe una ventana
	 * como parámetro e inicializa alguno de sus atributos.
	 * @param v - Ventana a utilizar.
	 */
	private Juego(Ventana v) {
		this.miVentana = v;
		this.puntosSoles = 0;
		this.miControl = new Control(this);		
		this.miModo = null;
	}
	
	/**
	 * Uso de patrón Singleton
	 * Método que retorna el juego si ya fue creado, y si no, crea uno nuevo y lo retorna.
	 * Se le pasa por parámetro la ventana para crear el juego.
	 * @param v - ventana a utilizar.
	 * @return el juego.
	 */
	public static Juego obtenerInstancia(Ventana v) {
		if(instance == null)
			instance = new Juego(v);
		return instance;
	}
	
	/**
	 * Método que suma una cantidad 's' de soles al total. 
	 * @param s - cantidad de soles a sumar.
	 */
	public void sumarSoles(int s) {
		this.puntosSoles += s;
	}
	
	/**
	 * Método que resta una cantidad 's' de soles al total.
	 * @param s - cantidad de soles a restar.
	 */
	public void restarSoles(int s) {
		this.puntosSoles -= s;
	}
	
	/**
	 * Uso de Patrón State
	 * Método que modifica el estado del modo de juego dependiendo de lo que el jugador
	 * decida.
	 * @param m - nuevo estado de modo de juego.
	 */
	public void setModo(ModoDeJuego m) {
		this.miModo = m;
	}
	
	public ModoDeJuego getModo() {
		return miModo;
	}
	
	public Planta generarPlanta(int i, int x, int y) {
		Planta retornar = null;
		if(miGrilla.getPlanta(new Coordenada(x, y)) == null) {
			retornar = miModo.generarPlanta(i);
			miGrilla.setPlanta(retornar, new Coordenada(x, y));
		}
		return retornar;
	}
	
	public void generarZombie() {
		int randomY = ThreadLocalRandom.current().nextInt(1, 5);
		Zombie z = miModo.generarZombie('a');
		miGrilla.setZombie(z, randomY);
		z.setCoordenada(0, randomY);
		miVentana.crearZombie(z);
	}
	
	public void moverZombies() {
		miGrilla.moverZombies();
	}
	
	public void matarPlanta(Planta p) {
		miGrilla.matarPlanta(p.getCoordenada());
	}
	public void matarZombie(Zombie z) {
		miGrilla.matarZombie(z);
	}
	public void matarProyectil(Proyectil p) {
		miGrilla.matarProyectil(p);
	}
	
	public void empezarJuego() {
		miGrilla = new Grilla(6, 9);
		ControlZombie cz = new ControlZombie(this);
		Thread t1 = new Thread(cz);
		t1.start();
	}
}
