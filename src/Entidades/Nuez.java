package Entidades;

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
		costo = 100;
		coord = c;
	}
	
	public void actuar() {
		//Falta el actuar
	}

	public void morir() {
		
	}
}
