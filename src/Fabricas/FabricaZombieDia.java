package Fabricas;

import Entidades.*;

public class FabricaZombieDia implements FabricaZombie {
	public ZombieBasico getZombieComun() {
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new AllStar();
	}
	public ZombieRobusto getZombieRobusto() {
		return new CaraCono();
	}
}
