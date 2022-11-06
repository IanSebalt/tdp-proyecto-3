package Entidades;

public abstract class Entidad {
	protected Sprite miSprite;
	protected int vida;
	
	public abstract void morir();
	
	public void recibirDmg(int d) {
		vida -= d;
		if(vida <= 0) {
			morir();
		}
	}

}
