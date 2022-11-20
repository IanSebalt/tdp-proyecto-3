package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class Portero extends ZombieRobusto{

	public Portero() {
		vida = 170;
		velocidad = 2;//Falta ver la velocidad
		dmg = 2; //Falta ver el dmg
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/portero.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectanguloZombie, altoRectanguloZombie);
		ralentizado = false;
	}
	
}

