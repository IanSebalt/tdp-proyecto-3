package Entidades;

public interface VisitorZombie {
	public void visit(Planta p);
	public void visit(ProyectilRalentizador p);
	public void visit(ProyectilNormal p);
}
