package Entidades;

import Escenario.Coordenada;
import Juego.Juego;

public class SetaDesesporada extends PlantaDisparadora {
	public SetaDesesporada(Coordenada c) {
		segundos = 1;//Setear segundos;
		dmg = 15;//Setear dmg;
		vida = 60;
		costo = 0;
		coord = c;
	}
	
	public void actuar() {
		Proyectil p = new Proyectil(dmg, coord);
		Juego j = Juego.obtenerInstancia(null);
		j.generarProyectil(coord, p);
	}

	public void morir() {
		//Falta ver como muere
	}
	
}
