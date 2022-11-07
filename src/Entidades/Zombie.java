package Entidades;

public abstract class Zombie extends Entidad{
	protected int dmg;
	protected int velocidad;
	
	public void mover() {
		miSprite.mover(miSprite.getX() - velocidad, miSprite.getY());
	}
}
