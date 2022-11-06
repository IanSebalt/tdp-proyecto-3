package Juego;

public class SupervivenciaDia extends ModoDeJuego{	
	
	public SupervivenciaDia(Juego j) {
		super(j);
		super.fabricaPlan = new FabricaPlantaDia();
		super.fabricaZom = new FabricaZombieDia();
	}
	
	@Override
	public void accionModo() {
		// TODO generar soles dia		
	}

	@Override
	public Planta generarPlanta(char c) {		
		Planta nuevaPlanta = null;
		if(c == 'a')
			nuevaPlanta = fabricaPlan.getPlantaGeneradora();
		else
			if(c == 'b')
				nuevaPlanta = fabricaPlan.getPlantaEspecial();
			else
				if(c == 'c')
					nuevaPlanta = fabricaPlan.getPlantaDisparadora();
		return nuevaPlanta;
	}

	@Override
	public Zombie generarZombie(char c) {
		Zombie nuevoZombie = null;
		if(c == 'a')
			nuevoZombie = fabricaPlan.getZombieComun();
		else
			if(c == 'b')
				nuevoZombie = fabricaPlan.getZombieEspecial();
			else
				if(c == 'c')
					nuevoZombie = fabricaPlan.getZombieRobusto();
		return nuevoZombie;
	}

	@Override
	public String getFondo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCesped() {
		// TODO Auto-generated method stub
		return null;
	}

}
