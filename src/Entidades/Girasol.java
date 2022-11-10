package Entidades;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class Girasol extends PlantaGeneradora{
	public Girasol() {
		segundos = 1;//Setear segundos;
		soles = 1;//Setear soles;
		vida = 100;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/sunflower.gif"));
		miSprite = new Sprite(img);
		costo = 50;
	}
	
	public void actuar() {
		//Generaria soles
	}

	public void morir() {
	}
}
