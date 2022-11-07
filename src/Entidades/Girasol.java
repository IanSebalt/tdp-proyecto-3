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
	}
	
	public void actuar() {
		//Falta el actuar
	}

	public void morir() {
		//Falta ver como muere
	}
}
