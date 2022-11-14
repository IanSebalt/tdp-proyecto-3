package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class Abanderado extends ZombieBasico{
	public Abanderado() {
		vida = 120;
		velocidad = 2;
		dmg = 10;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/abanderado.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectanguloZombie, altoRectanguloZombie);
	}	

}