package Entidades;

import Escenario.Coordenada;
import Juego.Juego;

public class Proyectil extends Entidad{
	protected int dmg;
	
	public Proyectil(int d, Coordenada c) {
		dmg = d;
		coord = c;
	}
	
	public void morir() {
		Juego j = Juego.obtenerInstancia(null);
		j.matarProyectil(this);
	}
	
	public void mover() {
		miSprite.mover(miSprite.getX() - 1, miSprite.getY());
		miRectangulo.setLocation(miSprite.getX() - 1, miSprite.getY());
	}
	
	public void accept(VisitorZombie v){
	 	v.visit(this);
	 }
	
	public int obtenerDmg() {
		return dmg;
	}
	
	
}
