package Fabricas;

import Entidades.*;

public class FabricaZombieNoche implements FabricaZombie{
	public ZombieBasico getZombieComun() {
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new Lector();
	}
	public ZombieRobusto getZombieRobusto() {
		return new Portero();
	}
}
