package Entidades;

import Juego.Juego;

public abstract class Planta extends Entidad{
	protected int segundos;
	protected int costo;
	
	public void accept(VisitorZombie v) {
		v.visit(this);
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getCosto() {
		return costo;
	}	
	
	public void morir() {
		Juego j = Juego.obtenerInstancia(null);
		j.matarPlanta(this);
	}
	
	public abstract void actuar();
	
}
