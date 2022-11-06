package Fabricas;

import Entidades.Comun;
import Entidades.Lector;
import Entidades.Portero;
import Entidades.ZombieBasico;
import Entidades.ZombieEspecial;
import Entidades.ZombieRobusto;

public class FabricaZombieNoche implements FabricaZombie{
	public ZombieBasico getZombieBasico() {
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new Lector();
	}
	public ZombieRobusto getZombieRobusto() {
		return new Portero();
	}
}
