package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import GUI.Sprite;

public class Comun extends ZombieBasico{
	public Comun() {
		vida = 80;
		velocidad = 1;
		dmg = 1;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/zombie.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectanguloZombie, altoRectanguloZombie);
		ralentizado = false;
	}
	
}
