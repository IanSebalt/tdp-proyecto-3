package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class SetaDesesporada extends PlantaDisparadora {
	public SetaDesesporada(Coordenada c) {
		segundos = 1;//Setear segundos;
		dmg = 15;//Setear dmg;
		vida = 60;
		costo = 0;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/setadesesporadara.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0,100,100);
	}
	
	public void actuar() {
		Proyectil p = new Proyectil(dmg, coord, miRectangulo);
		Juego j = Juego.obtenerInstancia(null);
		j.generarProyectil(coord, p);
	}
	
}
