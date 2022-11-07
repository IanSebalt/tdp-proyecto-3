package Entidades;

import Escenario.Coordenada;
import GUI.Sprite;

public abstract class Entidad {
	protected Sprite miSprite;
	protected int vida;
	protected Coordenada cord;
	
	public abstract void morir();
	
	public void recibirDmg(int d) {
		vida -= d;
		if(vida <= 0) {
			morir();
		}
	}
	
	public Coordenada getCoordenada() {
		return cord;
	}
	
	public void setCoordenada(int x, int y) {
		cord = new Coordenada(x, y);
	}

	public Sprite getSprite() {
		return miSprite;
	}
}
