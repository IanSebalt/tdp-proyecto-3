package Entidades;

import java.awt.Rectangle;

import Escenario.Coordenada;
import GUI.Sprite;
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
	
	public void morir() {
		Juego j = Juego.obtenerInstancia(null);
		j.matarPlanta(this);
	}
	
	public abstract void actuar();
	
}
