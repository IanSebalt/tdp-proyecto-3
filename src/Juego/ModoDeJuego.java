package Juego;

import Entidades.Planta;
import Entidades.Zombie;
import Escenario.Coordenada;
import Fabricas.FabricaPlanta;
import Fabricas.FabricaZombie;

public abstract class ModoDeJuego {
	
	protected Juego miJuego;
	
	protected FabricaZombie fabricaZom;
	
	protected FabricaPlanta fabricaPlan;	
	
	public abstract void accionModo();
		
	public abstract Planta generarPlanta(int i, Coordenada c);

	public abstract Zombie generarZombie(char c);
	
	public abstract String getFondo();
	
	public abstract String[] getCesped();	
	
	public abstract String[] getPlantas();
	
}
