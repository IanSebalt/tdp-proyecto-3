package Fabricas;


import Entidades.ZombieBasico;
import Entidades.ZombieEspecial;
import Entidades.ZombieRobusto;

public interface FabricaZombie {
	public ZombieBasico getZombieBasico();
	public ZombieEspecial getZombieEspecial();
	public ZombieRobusto getZombieRobusto();
}
