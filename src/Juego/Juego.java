package Juego;

import Escenario.Grilla;
import Hilos.Control;

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
		this.miModo = m;
		this.puntosSoles = 0;
		this.miControl = new Control(this);		
	}
	
	/**
	 * Uso de patrón Singleton
	 * Método que retorna el juego si ya fue creado, y si no, crea uno nuevo y lo retorna.
	 * Se le pasa por parámetro la ventana para crear el juego.
	 * @param v - ventana a utilizar.
	 * @return el juego.
	 */
	public static Juego obtenerInstancia(Ventana v, ModoDeJuego m) {
		if(instance == null)
			instance = new Juego(v, m);
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
	
	public void generarPlanta(char c) {
		miModo.generarPlanta(c);
	}
	
	public void generarZombie() {
		miGrilla.generarZombie(c);
	}
	
	public void moverZombies() {
		miGrilla.moverZombies();
	}
	
	public void matarPlanta(Planta p) {
		miGrilla.matarPlanta(p);
	}
	public void matarZombie(Zombie z) {
		miGrilla.matarZombie(z);
	}
	public void matarProyectil(Proyectil p) {
		miGrilla.matarProyectil(p);
	}
	
}
