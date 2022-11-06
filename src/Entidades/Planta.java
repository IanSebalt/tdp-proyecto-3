package Entidades;

public abstract class Planta extends Entidad{
	protected int segundos;
	
	/* public void accept(VisitorZombie v) {
		v.visit(this);
	}*/
	
	public abstract void actuar();
}
