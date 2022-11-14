package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class CaraCono extends ZombieRobusto{

	public CaraCono() {
		vida = 120;
		velocidad = 2;//Falta ver la velocidad
		dmg = 2; //Falta ver el dmg
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/caracono.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectanguloZombie, altoRectanguloZombie);
	}	
	
}
