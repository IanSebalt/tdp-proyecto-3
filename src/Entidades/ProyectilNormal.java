package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class ProyectilNormal  extends Proyectil{
	public ProyectilNormal(int d, Coordenada c, Rectangle rec) {
		vida = 1;
		dmg = d;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource( "/imagenes/projectile.png"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectangulo, (int)rec.getHeight());
		miRectangulo.setLocation((c.getX()*100) + 50, c.getY()*100);
	}
	
	
	
	public void accept(VisitorZombie v){
	 	v.visit(this);
	 }
	
}
