package Entidades;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class LanzaGuisantes extends PlantaDisparadora{
	public LanzaGuisantes() {
		segundos = 1;
		dmg = 10;
		vida = 100;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/lanzaguisantes.gif"));
		miSprite = new Sprite(img);
		costo = 100;
	}
	
	public void actuar() {
		new Proyectil(dmg);
	}

	public void morir() {
		//Falta ver como muere
	}
	
}
