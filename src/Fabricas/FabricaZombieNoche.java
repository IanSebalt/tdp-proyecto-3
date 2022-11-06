package Fabricas;

public class FabricaZombieNoche implements FabricaZombie{
	public ZombieComun getZombieComun() {
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new Lector();
	}
	public ZombieRobusto getZombieRobusto() {
		return new Portero();
	}
}
