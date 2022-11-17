package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

/**
 * Clase ControlZombie que extiende Control para el manejo del hilo dedicado a la actualización de los Zombies.
 *
 */
public class Proyectil extends Entidad{
	protected int dmg;
	protected int velocidad = 7;
	protected int anchoRectangulo = 50;
	
	public Proyectil(int d, Coordenada c, Rectangle rec) {
		vida = 1;
		dmg = d;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/projectile.png"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectangulo, (int)rec.getHeight());
		miRectangulo.setLocation((c.getX()*100) + 50, c.getY()*100);
	}
	
	public void morir() {
		Juego j = Juego.obtenerInstancia(null);
		j.matarProyectil(this);
	}
	
	public void mover() {
		if(miSprite.getX()>=900)
			morir();
		miSprite.mover(miSprite.getX() + velocidad, miSprite.getY());
		miRectangulo.setLocation(miSprite.getX() + velocidad, miSprite.getY());
	}
	
	public void accept(VisitorZombie v){
	 	v.visit(this);
	 }
	
	public int obtenerDmg() {
		return dmg;
	}
	
	
}
