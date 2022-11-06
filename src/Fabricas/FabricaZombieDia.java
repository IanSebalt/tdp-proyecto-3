package Fabricas;

public class FabricaZombieDia implements FabricaZombie {
	public ZombieComun getZombieComun() {
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new AllStar();
	}
	public ZombieRobusto getZombieRobusto() {
		return new Caracono();
	}
}
