package Entidades;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class LanzaGuisantes extends PlantaDisparadora{
	public LanzaGuisantes(Coordenada c) {
		segundos = 1;
		dmg = 10;
		vida = 100;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/lanzaguisantes.gif"));
		miSprite = new Sprite(img);
		costo = 100;
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
