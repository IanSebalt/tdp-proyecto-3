package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;

public class Nuez extends PlantaRobusta {
	public Nuez(Coordenada c) {
		segundos = 0;//Setear segundos;
		dmg = 0;
		vida = 200;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/wallnut.gif"));
		miSprite = new Sprite(img);
		costo = 50;
		coord = c;
		miRectangulo = new Rectangle(0,0,100,100);
	}

	public void actuar() {
		//No realiza ninguna acción.
	}	

}
