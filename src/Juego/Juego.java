package Juego;


import Escenario.Coordenada;
import Entidades.Planta;
import Entidades.Proyectil;
import Entidades.Zombie;
import Escenario.Grilla;
import GUI.Ventana;
import Hilos.Control;
import Hilos.ControlZombie;

import java.util.concurrent.ThreadLocalRandom;

public class Juego {
	
	private ModoDeJuego miModo;
	
	protected int puntosSoles;
	
	protected int zombiesBasicos, zombiesRobustos, zombiesEspeciales;
	
	protected int oleadaActual;
	
	protected int oleadasTotal;
	
	protected int nivelActual;
	
	protected static Juego instance;
	
	protected Ventana miVentana;
	
	protected Control miControl;
	
	protected Grilla miGrilla;
	
	protected ManejoNivel miManejo;
	
	
	/**
	 * Constructor privado para el uso del patrón singleton, en donde recibe una ventana
	 * como parámetro e inicializa alguno de sus atributos.
	 * @param v - Ventana a utilizar.
	 */
	private Juego(Ventana v) {
		this.miVentana = v;
		this.puntosSoles = 0;
		this.zombiesBasicos = 0;
		this.zombiesEspeciales = 0;
		this.zombiesRobustos = 0;
		this.miManejo = new ManejoNivel();
		this.miControl = new Control(this);		
		this.miModo = null;
		miManejo.generarArchivoNivel();
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
	
	public void generarNivel(int nivel,int oleada) {
		nivelActual = nivel;
		oleadaActual = oleada;
		zombiesBasicos = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + "ZombieBasico");
		zombiesEspeciales = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieEspecial");
		zombiesRobustos = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieRobusto");
		puntosSoles = miManejo.getInformacion("Nivel"+ nivel + "Soles");
		oleadasTotal = miManejo.getInformacion("OleadasNivel" + nivel);
	}
	
	public Planta generarPlanta(int i, int x, int y) {
		Planta retornar = null;
		Coordenada c = new Coordenada(x,y);
		if(miGrilla.getPlanta(c) == null) {
			retornar = miModo.generarPlanta(i, c);
			retornar.getRectangulo().setLocation(x*100, y*100);
			miGrilla.setPlanta(retornar, c);
		}
		return retornar;
	}
	
	public void generarZombie() {
		int randomY = ThreadLocalRandom.current().nextInt(1, 5);
		Zombie z = miModo.generarZombie('a');
		miGrilla.setZombie(z, randomY);
		z.setCoordenada(0, randomY);
		z.getRectangulo().setLocation(1000, randomY * 100);
		miVentana.crearEntidad(z);
	}
	
	public void generarProyectil(Coordenada c, Proyectil p) {
		miGrilla.setProyectil(p, c);
		miVentana.crearEntidad(p);
	}
	
	public void moverZombies() {
		miGrilla.moverZombies();
	}
	
	public void matarPlanta(Planta p) {
		miGrilla.matarPlanta(p.getCoordenada());
		miVentana.eliminarPlanta(p);
	}
	public void matarZombie(Zombie z) {
		miGrilla.matarZombie(z);
		//miVentana.eliminarEntidad(z);
	}
	public void matarProyectil(Proyectil p) {
		miGrilla.matarProyectil(p);
		//miVentana.eliminarEntidad(p);
	}
	
	public void accionModo(int seg) {
		miModo.accionModo(seg);
	}
	
	public void generarLapida(Coordenada cor) {
		miVentana.generarLapida(cord);
	}
	
	public void generarSol(Coordenada cor) {
		miVentana.generarSol(cor);
	}
	
	public void moverProyectiles() {
		miGrilla.moverProyectiles();
	}
	
	public void actuarPlantas() {
		miGrilla.actuarPlantas();
	}
	
	public void empezarJuego() {
		miGrilla = new Grilla(6);
		ControlZombie cz = new ControlZombie(this);
		Thread t1 = new Thread(cz);
		t1.start();
	}
}
