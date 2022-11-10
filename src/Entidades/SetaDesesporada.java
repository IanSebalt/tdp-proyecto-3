package Entidades;

public class SetaDesesporada extends PlantaDisparadora {
	public SetaDesesporada() {
		segundos = 1;//Setear segundos;
		dmg = 15;//Setear dmg;
		vida = 60;
		costo = 0;
	}
	
	public void actuar() {
		new Proyectil(dmg);
	}

	public void morir() {
		//Falta ver como muere
	}
	
}
