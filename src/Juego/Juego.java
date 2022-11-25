package Juego;


import Escenario.Coordenada;
import Entidades.Planta;
import Entidades.Proyectil;
import Entidades.Zombie;
import Escenario.Grilla;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaZombie;
import GUI.Sprite;
import GUI.Ventana;
import Hilos.Control;
import Hilos.ControlPlanta;
import Hilos.ControlProyectil;
import Hilos.ControlZombie;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Juego para el manejo general del mismo y responsable de la generación del juego y 
 * la comunicación entre las distintas clases.
 *
 */
public class Juego {
	
	private ModoDeJuego miModo;
	
	protected int puntosSoles;
	
	protected int zombiesBasicos, zombiesRobustos, zombiesEspeciales;
	
	protected boolean lapidasGeneradas;
	
	protected int oleadaActual;
	
	protected int oleadasTotal;
	
	protected int nivelActual;
	
	protected static Juego instance;
	
	protected Ventana miVentana;
	
	protected Control miControl;
	
	protected Grilla miGrilla;
	
	protected ManejoNivel miManejo;
	
	protected Coordenada lapidas [];
	
	protected Control controlJuego;
	
	protected Control controlZombie;
	
	protected Control controlProyectil;
	
	protected Control controlPlanta;
	
	
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
		this.lapidas = new Coordenada[3];
		this.lapidasGeneradas = false;
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
	 * Método que retorna la cantidad de zombies a generar.
	 * @return cantidad de zombies a generar.
	 */
	public int cantidadZombiesParaGenerarEnOleada() {
		return zombiesBasicos + zombiesEspeciales + zombiesRobustos;
	}
	
	/**
	 * Método que retorna verdadero si hay zombies en la grilla y falso en caso contrario.
	 * @return verdadero si hay zombies en la grilla, falso en caso contrario.
	 */
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
		else if(m==2) {
			this.miModo = new SupervivenciaNoche(this);
		}
				
				
	}
	
	/**
	 * Método que retorna el estado del modo de juego.
	 * @return el modo de juego.
	 */
	public ModoDeJuego getModo() {
		return miModo;
	}
	
	/**
	 * Carga del archivo Niveles.properties la cantidad de zombies a generar en el nivel y oleada recibida por parámetro.
	 * @param nivel - nivel a cargar.
	 * @param oleada - oleada a cargar.
	 */
	public void generarNivel(int nivel,int oleada) {
		nivelActual = nivel;
		oleadaActual = oleada;
		zombiesBasicos = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieBasico");
		zombiesEspeciales = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieEspecial");
		zombiesRobustos = miManejo.getInformacion("Nivel"+ nivel + "_Oleada" + oleada + "ZombieRobusto");
		puntosSoles = miManejo.getInformacion("Nivel"+ nivel + "Soles");
		oleadasTotal = miManejo.getInformacion("OleadasNivel" + nivel);
	}
	
	/**
	 * Método que chequea si hay oleadas en el nivel. Si es verdadero entonces avanza a la siguiente oleada,
	 * sino avanza al siguiente nivel.
	 */
	public void manejoOleada() {
		if(oleadaActual < oleadasTotal ) {
			oleadaActual++;
			generarNivel(nivelActual, oleadaActual);
			lapidasGeneradas = false;
			miVentana.mostrarCambioOleada();
		}else{ //Es la ultima oleada
			if( hayZombiesEnGrilla() == false ) {
				if( nivelActual < 5 ) {
					boolean resultadoVentana = miVentana.pedirVolver();
					if( resultadoVentana == false ) { //Quiere seguir de nivel
						siguienteNivel();
					} else { //Quiere volver al menu
						finJuego();
					}
				}else { //Es el ultimo nivel
					finJuego();
				}
				
			}
		}
	}
	
	
	/**
	 * Método que detiene todos los hilos iniciados para el comienzo del juego y termina la partida
	 * mandandole el mensaje a la ventana.
	 */
	public void finJuego() {
		miVentana.terminarPartida();
		controlJuego.finish();
		controlZombie.finish();
		controlPlanta.finish();
		controlProyectil.finish();
	}
	
	/**
	 * Método para avanzar al siguiente nivel iniciando desde la primera oleada y llamando al metodo generarNivel para
	 * volver a cargar los zombies a generar.
	 */
	public synchronized void siguienteNivel() {
		nivelActual++;
		oleadaActual = 1;
		generarNivel(nivelActual, oleadaActual);
		miGrilla = new Grilla(6);
		miVentana.siguienteNivel();
		lapidasGeneradas = false;
		lapidas = new Coordenada[3];
	}
	
	/**
	 * Método que genera una planta en la posición (x,y) recibida por parámetro y el tipo de planta se define con el entero 'c'.
	 * Luego la retorna.
	 * @param c - tipo de planta a generar.
	 * @param x - posición x en el escenario.
	 * @param y - posición y en el escenario.
	 * @return el sprite de la planta generada.
	 */
	public Sprite generarPlanta(int c, int x, int y) {
		Planta retornar = null;
		Sprite retornarS = null;
		FabricaPlanta fabricaPlan = miModo.getFabricaPlanta();
		Coordenada coord = new Coordenada(x,y);
		if(miGrilla.getPlanta(coord) == null) {
			switch(c) {
				case 1 : 					
					retornar = fabricaPlan.getPlantaGeneradora(coord);
					break;
				case 2 :
					retornar = fabricaPlan.getPlantaRobusta(coord);
					break;
				case 3 :
					retornar = fabricaPlan.getPlantaDisparadora(coord);
					break;
			}			
			if( puedoComprar(retornar.getCosto()) ) {
				retornar.getRectangulo().setLocation(x*100, y*100);
				miGrilla.setPlanta(retornar, coord);
				retornarS = retornar.getSprite();
				restarSoles(retornar.getCosto());
			}else { //Si no tengo soles para comprar la planta retorno null
				retornar = null;
			}
			
		}
		return retornarS;
	}
	
	public boolean chequearLapida(int x, int y) {
		boolean retornar = false;
		Coordenada [] laps = getLapidas();
		for(int i = 0; i < laps.length && !retornar; i++) {
			if( laps[i] != null)
				retornar = laps[i].getX() == x && laps[i].getY() == y;	
		}
		return retornar;
	}
	
	/**
	 * Método que retorna verdadero si hay la cantidad necesaria de soles para comprar una planta, falso en caso contrario
	 * @param costoPlanta - coste de la planta a comprar.
	 * @return verdadero si se puede comprar la planta, falso caso contrario.
	 */
	public boolean puedoComprar( int costoPlanta ) {
		boolean toReturn = false;
		if(puntosSoles >= costoPlanta) {
			toReturn = true;
		} 
		return toReturn;
	}
	
	/**
	 * Método que retorna la cantidad de soles generados.
	 * @return cantida de soles.
	 */
	public int getSoles() {
		return puntosSoles;
	}
	
	/**
	 * Método que genera un zombie en una fila de forma aleatoria. El tipo de zombie es definido por el entero recibido por parámetro.
	 * @param c - tipo de zombie a generar.
	 */
	public void generarZombie(int c) {
		int randomY = ThreadLocalRandom.current().nextInt(0, 6);
		FabricaZombie fabricaZom = miModo.getFabricaZombie();		
		Zombie nuevoZombie = null;
		switch(c) {
			case 1 :
				nuevoZombie = fabricaZom.getZombieBasico();
				break;
			case 2 :
				nuevoZombie = fabricaZom.getZombieEspecial();
				break;
			case 3 :
				nuevoZombie = fabricaZom.getZombieRobusto();
				break;
		}
		nuevoZombie.setCoordenada(9, randomY);
		nuevoZombie.getRectangulo().setLocation(900, randomY * 100);
		miGrilla.setZombie(nuevoZombie, randomY);
		miVentana.crearEntidad(nuevoZombie);
	}
	
	/**
	 * Método que genera un zombie en una lapida de forma aleatoria. El tipo de zombie es definido de forma aleatoria.
	 * @param cord - coordenada de la lápida donde generar el zombie.
	 */
	public void generarZombieEnLapida(int c, int lapida) {
		FabricaZombie fabricaZom = miModo.getFabricaZombie();	
		Zombie nuevoZombie = null;
		switch(c) {
			case 1 :
				nuevoZombie = fabricaZom.getZombieBasico();
				break;
			case 2 :
				nuevoZombie = fabricaZom.getZombieEspecial();
				break;
			case 3 :
				nuevoZombie = fabricaZom.getZombieRobusto();
				break;
		}
		nuevoZombie.setCoordenada(lapidas[lapida].getX(), lapidas[lapida].getY());
		nuevoZombie.getRectangulo().setLocation(lapidas[lapida].getX() * 100, lapidas[lapida].getY() * 100);
		miGrilla.setZombie(nuevoZombie, lapidas[lapida].getY());
		miVentana.crearEntidad(nuevoZombie);
	}
	
	/**
	 * Método que genera la oleada de zombies de forma aleatoria en donde hay un 50% de generar zombies basicos y para el 
	 * resto hay un 25% de que se generen.
	 * El entero recibido por parámetro define como se generan las oleadas siendo el valor 1 para la generación normal de los zombies
	 * en el caso de que el entero sea 2 se generarán zombies encima de las lápidas, esta opción solamente se habilita para el modo noche.
	 * @param n - forma de generar zombies.
	 */
	public void generarOleada(int n) {
		int num = ThreadLocalRandom.current().nextInt(1, 5);
		int generado = 0;
		if(zombiesRobustos>0 && (num == 3) && n == 1) {
			generarZombie(3);
			zombiesRobustos--;
		}
		if(zombiesBasicos>0 && (num == 1 || num == 4  && n == 1) ) {
			generarZombie(1);
			zombiesBasicos--;
		}
		if(zombiesEspeciales>0 && num ==2  && n == 1) {
			generarZombie(2);
			zombiesEspeciales--;
		}
		while(generado<3 && lapidasGeneradas == false && n == 2) {
			num = ThreadLocalRandom.current().nextInt(1, 5);
			if(zombiesRobustos>0 && (num == 3)) {
				generarZombieEnLapida(3, generado);
				zombiesRobustos--;
				generado++;
			}
			if(zombiesBasicos>0 && (num == 1 || num == 4)) {
				generarZombieEnLapida(1, generado);
				zombiesBasicos--;
				generado++;
			}
			if(zombiesEspeciales>0 && num == 2) {
				generarZombieEnLapida(2, generado);
				zombiesEspeciales--;
				generado++;
			}
		}
		if(generado==3)
			lapidasGeneradas = true;
	}	
	
	/**
	 * Método que genera proyectiles en la coordenada recibida por parámetro y le manda el mensaje a ventana para generarlo
	 * gráficamente.
	 * @param c - coordenada a generar el proyectil.
	 * @param p - proyectil a generar en la ventana.
	 */
	public void generarProyectil(Coordenada c, Proyectil p) {
		miGrilla.setProyectil(p, c);
		miVentana.crearEntidad(p);
		p.getSprite().mover(c.getX()*100+50, c.getY() * 100);
	}
	
	/**
	 * Método que le manda el mensaje a la grilla para mover todos los zombies de la misma.
	 */
	public void moverZombies() {
		miGrilla.moverZombies();
	}	
	 /**
	  * Método que elimina de la gráfica la planta recibida por parámetro y le manda el mensaje a la grilla para que la
	  * elimine de la misma.
	  * @param p - planta a eliminar.
	  */
	public void matarPlanta(Planta p) {
		miGrilla.matarPlanta(p);
		miVentana.eliminarPlanta(p);
	}
	
	/**
	  * Método que elimina de la gráfica el zombie recibida por parámetro y le manda el mensaje a la grilla para que lo
	  * elimine de la misma.
	  * @param z - zombie a eliminar.
	  */
	public void matarZombie(Zombie z) {
		miVentana.eliminarEntidad(z);
		miGrilla.matarZombie(z);
	}
	
	/**
	  * Método que elimina de la gráfica el proyectil recibida por parámetro y le manda el mensaje a la grilla para que lo
	  * elimine de la misma.
	  * @param p - proyectil a eliminar.
	  */
	public void matarProyectil(Proyectil p) {
		miGrilla.matarProyectil(p);
		miVentana.eliminarEntidad(p);
	}
	
	/**
	 * Método que le manda un mensaje al modo de juego para que ejecute su acción cada 'seg'. En caso de que sea el modo día se generaran soles
	 * caso que sea modo noche se generarán lápidas de manera aleatoria en el escenario.
	 * @param seg - segundos para que la accionModo se ejecute.
	 */
	public void accionModo(int seg) {
		miModo.accionModo(seg);
	}
	
	/**
	 * Método que retorna el cesped del modo de juego.
	 * @return el cesped de modo de juego.
	 */
	public String[] getCesped() {
		return miModo.getCesped();
	}
 	

	/**
	 * Método generar lápida para el modo supervivencia noche, en el que las genera en la coordenada recibida parámetro.
	 * @param cor - coordenada donde generar la lápida.
	 * @param cantLapidas - cantidadLapidas generadas.
	 */
	public void generarLapida(Coordenada cor, int cantLapidas) {
		miVentana.generarLapida(cor);
		lapidas[cantLapidas-1] = cor;
	}
	
	/**
	 * Método generarSol para el modo superviencia dia y para las plantas generadoras.
	 * Genera soles en la coordenada recibida por parámetro mandandole un mensaje a la ventana para hacerlo gráfico.
	 * @param cor - coordenada donde generar el sol.
	 */
	public void generarSol(Coordenada cor) {
		miVentana.generarSol(cor);
	}
	
	/**
	 * Método que le manda un mensaje a la grilla para mover todos sus proyectiles.
	 */
	public void moverProyectiles() {
		miGrilla.moverProyectiles();
	}
	
	/**
	 * Método que le manda un mensaje a la grilla para ejecutar todas las acciones que realizan 
	 * las plantas colocadas en la grilla.
	 */
	public void actuarPlantas() {
		miGrilla.actuarPlantas();
	}
	
	/**
	 * Método que retorna verdadero si hay zombies en la fila recibida por parámetro, falso en caso contrario.
	 * @param c - Coordenada donde chequear la fila.
	 * @return verdadero si hay zombies en la fila, falso caso contrario.
	 */
	public boolean hayZombieFila(Coordenada c) {
		return miGrilla.hayZombiesFila(c);
	}
	
	/**
	 * Método que retorna verdadero si se generaron los zombies en las lápidas, falso en caso contrario.
	 * @return verdadero si se generaron zombies en las lapidas, falso en caso contrario.
	 */
	public boolean seGeneraronZombiesEnLapida() {
		return lapidasGeneradas;
	}
	
	/**
	 * Método que retorna el nivel actual que se está jugando.
	 * @return nivel actual.
	 */
	public int getNivel() {
		return nivelActual;
	}
	
	/**
	 * Método que inicia el juego en el primer nivel y primera oleada y crea los hilos para manejar cada entidad y los inicia.
	 * Tambien se crea la grilla con una cantidad de 6 filas.
	 */
	public void empezarJuego() {
		nivelActual = 1;
		oleadaActual = 1;
		generarNivel(nivelActual, oleadaActual);
		miGrilla = new Grilla(6);
		controlZombie = new ControlZombie(this);
		Thread hiloZombie = new Thread(controlZombie);
		hiloZombie.start();
		controlPlanta = new ControlPlanta(this);
		Thread hiloPlanta = new Thread(controlPlanta);
		hiloPlanta.start();
		controlProyectil = new ControlProyectil(this);
		Thread hiloProyectil = new Thread(controlProyectil);
		hiloProyectil.start();
		controlJuego = new Control(this);
		Thread hiloJuego = new Thread(controlJuego);
		hiloJuego.start();
	}
	
	/**
	 * Método que retorna el arreglo de lápidas.
	 * @return el arreglo de lapidas.
	 */
	public Coordenada [] getLapidas() {
		return lapidas;
	}
}
