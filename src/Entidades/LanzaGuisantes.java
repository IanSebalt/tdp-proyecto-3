package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class LanzaGuisantes extends PlantaDisparadora{
	public LanzaGuisantes(Coordenada c) {
		segundos = 0;
		dmg = 20;
		vida = 100;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/lanzaguisantes.gif"));
		miSprite = new Sprite(img);
		costo = 100;
		coord = c;
		miRectangulo = new Rectangle(0,0,100,100);
	}
	
	public synchronized void actuar() {
		Juego j = Juego.obtenerInstancia(null);
		segundos += 500;
		if(j.hayZombieFila(coord) && segundos == 3000) {
			Proyectil p = new ProyectilNormal(dmg, coord, miRectangulo);		
			j.generarProyectil(coord, p);
		}
		if(segundos>=3000)
			segundos = 0;
	}
}
