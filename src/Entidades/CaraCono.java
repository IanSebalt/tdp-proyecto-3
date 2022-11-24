package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class CaraCono extends ZombieRobusto{
	
	protected boolean cono;

	public CaraCono() {
		vida = 120;
		velocidad = 1;//Falta ver la velocidad
		dmg = 1; //Falta ver el dmg
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/caracono.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectanguloZombie, altoRectanguloZombie);
		ralentizado = false;
		cono = true;
	}
	
	public void visit(ProyectilNormal p) {
		p.recibirDmg(1);			
		recibirDmg(p.obtenerDmg());
		if(vida<= 0) {
			morir();
		} else if(vida <= 80 && cono) {
			romperCono();
		}
	}	
	
	private void romperCono() {
		cono = false;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/zombie.gif"));
		miSprite.setImg(img);
	}
	
}
