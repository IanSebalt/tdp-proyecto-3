package Entidades;

import Juego.Juego;

public abstract class Zombie extends Entidad implements VisitorZombie{
	protected int dmg;
	protected int velocidad;
	protected int anchoRectanguloZombie = 100;
	protected int altoRectanguloZombie = 100;
	
	public void mover() {
		miSprite.mover(miSprite.getX() - velocidad, miSprite.getY());
		miRectangulo.setLocation(miSprite.getX() - velocidad, miSprite.getY());
	}
	
	public void visit(Planta p) {
		p.recibirDmg(dmg);		
	}
	
	public void morir() {
		Juego j = Juego.obtenerInstancia(null);
		j.matarZombie(this);
	}
	
	public void visit(Proyectil p) {
		p.recibirDmg(1);
		recibirDmg(p.obtenerDmg());
		System.out.println(vida);
		if(vida <= 0) {
			morir();
		}
	}
	

}
