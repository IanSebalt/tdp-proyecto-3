package Juego;

import Fabricas.FabricaPlanta;
import Fabricas.FabricaZombie;

public abstract class ModoDeJuego {
	
	protected Juego miJuego;
	
	protected FabricaZombie fabricaZom;
	
	protected FabricaPlanta fabricaPlan;	
	
	public abstract void accionModo(int seg);	
	
	public abstract String getFondo();
	
	public abstract String[] getCesped();	
	
	public abstract String[] getPlantas();
	
	public abstract FabricaPlanta getFabricaPlanta();
	
	public abstract FabricaZombie getFabricaZombie();
	
}
