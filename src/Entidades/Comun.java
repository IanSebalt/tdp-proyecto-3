package Entidades;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class Comun extends ZombieBasico{
	public Comun() {
		vida = 80;
		velocidad = 2;
		dmg = 0;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/zombie.gif"));
		miSprite = new Sprite(img);
	}
	
	
	public void morir() {
		//Falta ver como muere		
	}
}
