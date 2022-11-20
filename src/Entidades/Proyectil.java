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
public abstract class Proyectil extends Entidad{
	protected int dmg;
	protected int velocidad = 5;
	protected int anchoRectangulo = 50;	

	
	public void mover() {
		if(miSprite.getX()>=900)
			morir();
		miSprite.mover(miSprite.getX() + velocidad, miSprite.getY());
		miRectangulo.setLocation(miSprite.getX() + velocidad, miSprite.getY());
	}
	
	public void morir() {
		Juego j = Juego.obtenerInstancia(null);
		j.matarProyectil(this);
	}
	
	public abstract void accept(VisitorZombie z);

	public int obtenerDmg() {
		return dmg;
	}
}
