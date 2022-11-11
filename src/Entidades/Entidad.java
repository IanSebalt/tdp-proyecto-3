package Entidades;

import java.awt.Rectangle;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public abstract class Entidad {
	protected Sprite miSprite;
	protected int vida;
	protected Coordenada coord;
	protected Juego miJuego;
	protected Rectangle miRectangulo;
	
	public abstract void morir();
	
	public void recibirDmg(int d) {
		vida -= d;
		if(vida <= 0) {
			morir();
		}
	}
	
	public Coordenada getCoordenada() {
		return coord;
	}
	
	public void setCoordenada(int x, int y) {
		coord = new Coordenada(x, y);
	}

	public Sprite getSprite() {
		return miSprite;
	}
	
	public Rectangle getRectangulo(){
		return miRectangulo;
	}
}
