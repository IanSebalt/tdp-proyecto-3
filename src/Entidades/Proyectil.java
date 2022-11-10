package Entidades;

import Juego.Juego;

public class Proyectil extends Entidad{
	protected int dmg;
	
	public Proyectil(int d) {
		dmg = d;
	}
	
	public void morir() {
		Juego j = Juego.obtenerInstancia(null);
		j.matarProyectil(this);
	}
	
	public void accept(VisitorZombie v){
	 	v.visit(this);
	 }
	
	public int obtenerDmg() {
		return dmg;
	}
	
	
}
