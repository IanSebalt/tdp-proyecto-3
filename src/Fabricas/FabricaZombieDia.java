package Fabricas;


import Entidades.AllStar;
import Entidades.CaraCono;
import Entidades.Comun;
import Entidades.ZombieBasico;
import Entidades.ZombieEspecial;
import Entidades.ZombieRobusto;

public class FabricaZombieDia implements FabricaZombie {
	public ZombieBasico getZombieBasico() {
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new AllStar();
	}
	public ZombieRobusto getZombieRobusto() {
		return new CaraCono();
	}
}
