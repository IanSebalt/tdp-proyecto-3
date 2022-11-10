package Entidades;

import javax.swing.ImageIcon;

import GUI.Sprite;
import Juego.Juego;

public class Nuez extends PlantaRobusta {
	public Nuez() {
		segundos = 0;//Setear segundos;
		dmg = 0;
		vida = 200;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/wallnut.gif"));
		miSprite = new Sprite(img);
		costo = 100;
	}
	
	public void actuar() {
		//Falta el actuar
	}

	public void morir() {
		
	}
}
