package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;

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
		//Hacer metodo daño.		
	}	
}
