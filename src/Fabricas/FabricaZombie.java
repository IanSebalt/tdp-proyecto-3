package Fabricas;

import Entidades.*;

public interface FabricaZombie {
	public ZombieBasico getZombieComun();
	public ZombieEspecial getZombieEspecial();
	public ZombieRobusto getZombieRobusto();
}
