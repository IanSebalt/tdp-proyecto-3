package Juego;

import java.util.concurrent.ThreadLocalRandom;

import Escenario.Coordenada;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaPlantaNoche;
import Fabricas.FabricaZombie;
import Fabricas.FabricaZombieNoche;


/**
 * Clase SupervicenciaNoche que extiende ModoDeJuego para el modo de juego noche.
 *
 */
public class SupervivenciaNoche extends ModoDeJuego{
	
	protected int cronometro;
	
	protected Coordenada lapidas []; 
		
	protected int cantLapidas;
	
	/**
	 * Constructor que recibe por parámetro el juego para enviar los respectivos mensajes.
	 * @param j - juego a utilizar.
	 */
	public SupervivenciaNoche(Juego j) {
		super.miJuego = j;
		super.fabricaPlan = new FabricaPlantaNoche();
		super.fabricaZom = new FabricaZombieNoche();
		this.cronometro = 0;
		lapidas = new Coordenada [3];
		cantLapidas = 0;
	}
	
	/**
	 * Metodo que genera lápidas de forma aleatoria en el mapa y luego comienza a generar zombies en el lugar de las lápidas.
	 * @param seg - segundos a aumentar para ir generando lápidas y zombies.
	 */
	public void accionModo(int seg) {
		cronometro += seg;
		while(cantLapidas<3) {
			int randomX = ThreadLocalRandom.current().nextInt(5, 9);
			int randomY = ThreadLocalRandom.current().nextInt(0, 5);
			Coordenada nuevaCor = new Coordenada(randomX, randomY);
			if(cantLapidas == 0) {
				lapidas [cantLapidas] = nuevaCor;
				cantLapidas++;
				miJuego.generarLapida(nuevaCor, cantLapidas);
			}else			
				if(cantLapidas>0 && (lapidas[cantLapidas-1].getX() != randomX || lapidas[cantLapidas-1].getY() != randomY)) {
					lapidas [cantLapidas] = nuevaCor;
					cantLapidas++;
					miJuego.generarLapida(nuevaCor, cantLapidas);
				}
			cronometro = 0;
		}
		if(miJuego.seGeneraronZombiesEnLapida() == false && miJuego.cantidadZombiesParaGenerarEnOleada() > 0 && cronometro == 20000) {
			miJuego.generarOleada(2);
			cronometro = 0;
		}
		if(cronometro>=20000 || miJuego.seGeneraronZombiesEnLapida() == true)
			cronometro = 0;
		if(miJuego.getLapidas()[0]==null && miJuego.seGeneraronZombiesEnLapida() == false)
			cantLapidas = 0;
	}

	public String getFondo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCesped() {
		String[] retornar =  {"/imagenes/night-grass.png", "/imagenes/night-grass-hovered.png"};
		return retornar;
	}

	
	public String[] getPlantas() {
		String[] retornar = {"/imagenes/setasolar-precio.png", "/imagenes/cactus-precio.png", "/imagenes/setadesesporada-precio.png"};
		return retornar;
	}
	
	
	public FabricaPlanta getFabricaPlanta() {
		return fabricaPlan;
	}	
	
	public FabricaZombie getFabricaZombie() {
		return fabricaZom;
	}
}
