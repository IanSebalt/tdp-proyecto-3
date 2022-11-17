package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class Girasol extends PlantaGeneradora{
	
	
	public Girasol(Coordenada c) {
		segundos = 0;//Setear segundos;
		soles = 1;//Setear soles;
		vida = 100;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/sunflower.gif"));
		miSprite = new Sprite(img);
		costo = 50;
		coord = c;
		miRectangulo = new Rectangle(0,0,100,100);
	}
	
	public void actuar() {
		segundos += 1000;
		if(segundos==25000) {
			Juego j = Juego.obtenerInstancia(null);
			j.generarSol( coord );
			segundos = 0;
		}
	}

}
