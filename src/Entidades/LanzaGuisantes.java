package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class LanzaGuisantes extends PlantaDisparadora{
	public LanzaGuisantes(Coordenada c) {
		segundos = 1;
		dmg = 40;
		vida = 100;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/lanzaguisantes.gif"));
		miSprite = new Sprite(img);
		costo = 100;
		coord = c;
		miRectangulo = new Rectangle(0,0,100,100);
	}
	
	public synchronized void actuar() {
		Juego j = Juego.obtenerInstancia(null);
		if(j.hayZombieFila(coord.getX())) {
			Proyectil p = new Proyectil(dmg, coord, miRectangulo);		
			j.generarProyectil(coord, p);
		}
	}
}
