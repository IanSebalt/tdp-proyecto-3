package Entidades;

public class Proyectil extends Entidad{
	protected int dmg;
	
	public Proyectil(int d) {
		dmg = d;
	}
	
	public void morir() {
		//Falta ver como muere		
	}
	
	/*public void accept(VisitorZombie v){
	 * 	v.visit(this);
	 * }
	 */
	
	
}
