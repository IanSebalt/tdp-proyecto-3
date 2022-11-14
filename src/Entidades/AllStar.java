package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class AllStar extends ZombieEspecial{
	public AllStar() {
		vida = 150;
		velocidad = 2;//falta ver velocidad, este es mas rapido que los demas
		dmg = 2; 
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/allstar.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectanguloZombie, altoRectanguloZombie);
	}	
}
