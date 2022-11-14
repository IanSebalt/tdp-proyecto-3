package Juego;


import Escenario.Coordenada;
import Entidades.Planta;
import Entidades.Proyectil;
import Entidades.Zombie;
import Escenario.Grilla;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaZombie;
import GUI.Ventana;
import Hilos.Control;
import Hilos.ControlPlanta;
import Hilos.ControlProyectil;
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
	
	public int cantidadZombiesParaGenerarEnOleada() {
		return zombiesBasicos + zombiesEspeciales + zombiesRobustos;
	}
	
	
	public boolean hayZombiesEnGrilla() {
		return miGrilla.hayZombies();
	}
	
	/**
	 * Uso de Patrón State
	 * Método que modifica el estado del modo de juego dependiendo de lo que el jugador
	 * decida.
	 * @param m - nuevo estado de modo de juego.
	 */
	public void setModo(int m) {
		if (m==1)
			this.miModo = new SupervivenciaDia(this);
		else
			if(m==2)
				this.miModo = new SupervivenciaNoche(this);
	}
	
	public ModoDeJuego getModo() {
		return miModo;
	}
	
	public void generarNivel(int nivel,int oleada) {
		nivelActual = nivel;
		oleadaActual = oleada;
		zombiesBasicos = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieBasico");
		zombiesEspeciales = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieEspecial");
		zombiesRobustos = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieRobusto");
		puntosSoles = miManejo.getInformacion("Nivel"+ nivel + "Soles");
		oleadasTotal = miManejo.getInformacion("OleadasNivel" + nivel);
	}
	
	public void manejoOleada() {
		if(oleadaActual < oleadasTotal ) {
			oleadaActual++;
			generarNivel(nivelActual, oleadaActual);
		}else{ //Es la ultima oleada
			if( hayZombiesEnGrilla() == false ) {
				if( nivelActual < 2 ) {
					//miVentana.finNivel();
					siguienteNivel(); //Este metodo lo llamaria miVentana si clickean en seguiente nivel;
				}else { //Es el ultimo nivel
					//miVentana.finJuego();
				}
				
			}
		}
	}
	
	public void siguienteNivel() {
		nivelActual++;
		oleadaActual = 1;
		generarNivel(nivelActual, oleadaActual);
	}
	
	public Planta generarPlanta(int c, int x, int y) {
		Planta retornar = null;
		FabricaPlanta fabricaPlan = miModo.getFabricaPlanta();
		Coordenada coord = new Coordenada(x,y);
		if(miGrilla.getPlanta(coord) == null) {
			if(c == 1) 
				retornar = fabricaPlan.getPlantaGeneradora(coord);			
			else
				if(c == 2)
					retornar = fabricaPlan.getPlantaRobusta(coord);
				else
					if(c == 3)
						retornar = fabricaPlan.getPlantaDisparadora(coord);
			retornar.getRectangulo().setLocation(x*100, y*100);
			miGrilla.setPlanta(retornar, coord);
		}
		return retornar;
	}
	
	public void generarZombie(int c) {
		int randomY = ThreadLocalRandom.current().nextInt(0, 6);
		FabricaZombie fabricaZom = miModo.getFabricaZombie();		
		Zombie nuevoZombie = null;
		if(c == 1)
			nuevoZombie = fabricaZom.getZombieBasico();
		else
			if(c == 2)
				nuevoZombie = fabricaZom.getZombieEspecial();
			else
				if(c == 3)
					nuevoZombie = fabricaZom.getZombieRobusto();
		nuevoZombie.setCoordenada(0, randomY);
		nuevoZombie.getRectangulo().setLocation(1000, randomY * 100);
		miGrilla.setZombie(nuevoZombie, randomY);
		miVentana.crearEntidad(nuevoZombie);
	}
	
	public void generarOleada() {
		while(zombiesRobustos>0 || zombiesEspeciales>0 || zombiesBasicos>0) {
			if(zombiesRobustos>0) {
				generarZombie(3);
				zombiesRobustos--;
			}
			if(zombiesBasicos>0) {
				generarZombie(1);
				zombiesBasicos--;
			}
			if(zombiesEspeciales>0) {
				generarZombie(2);
				zombiesEspeciales--;
			}
		}
	}
	
	public void generarProyectil(Coordenada c, Proyectil p) {
		miGrilla.setProyectil(p, c);
		miVentana.crearEntidad(p);
		p.getSprite().mover(c.getX()*100+50, c.getY() * 100);
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
		miVentana.eliminarEntidad(z);
	}
	public void matarProyectil(Proyectil p) {
		miGrilla.matarProyectil(p);
		miVentana.eliminarEntidad(p);
	}
	
	public void accionModo(int seg) {
		miModo.accionModo(seg);
	}
	
	public void generarLapida(Coordenada cor) {
		//miVentana.generarLapida(cor);
	}
	
	public void generarSol(Coordenada cor) {
		//miVentana.generarSol(cor);
	}
	
	public void moverProyectiles() {
		miGrilla.moverProyectiles();
	}
	
	public void actuarPlantas() {
		miGrilla.actuarPlantas();
	}
	
	public boolean hayZombieFila(int fila) {
		return miGrilla.hayZombiesFila(fila);
	}
	
	public void empezarJuego() {
		nivelActual = 1;
		oleadaActual = 1;
		generarNivel(nivelActual, oleadaActual);
		miGrilla = new Grilla(6);
		ControlZombie cz = new ControlZombie(this);
		Thread hiloZombie = new Thread(cz);
		hiloZombie.start();
		ControlPlanta cPlanta = new ControlPlanta(this);
		Thread hiloPlanta = new Thread(cPlanta);
		hiloPlanta.start();
		ControlProyectil cProyectil = new ControlProyectil(this);
		Thread hiloProyectil = new Thread(cProyectil);
		hiloProyectil.start();
	}
}
