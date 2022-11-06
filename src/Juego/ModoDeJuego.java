package Juego;

import Entidades.Planta;
import Entidades.Zombie;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaZombie;

public abstract class ModoDeJuego {
	
	protected Juego miJuego;
	
	protected FabricaZombie fabricaZom;
	
	protected FabricaPlanta fabricaPlan;
	
	public ModoDeJuego(Juego j) {
		this.miJuego = j;		
	}
	
	public abstract void accionModo();
		
	public abstract Planta generarPlanta(char c);

	public abstract Zombie generarZombie(char c);
	
	public abstract String getFondo();
	
	public abstract String getCesped();	
	
}
