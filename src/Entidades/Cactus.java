package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class Cactus extends PlantaRobusta{

	public Cactus(Coordenada c) {
		segundos = 0;//Setear segundos;
		dmg = 5;//Setear dmg;
		vida = 150;
		costo = 125;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/cactus.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0,100,100);
	}
	
	public void actuar() {
		Juego j = Juego.obtenerInstancia(null);
		segundos += 500;
		if(j.hayZombieFila(coord) && segundos == 1500) {
			Proyectil p = new ProyectilNormal(dmg, coord, miRectangulo);		
			j.generarProyectil(coord, p);
		}
		if(segundos>=1500)
			segundos = 0;
	}	
}

