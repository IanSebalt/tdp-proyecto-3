package Fabricas;

<<<<<<< HEAD
import Entidades.*;

public class FabricaZombieDia implements FabricaZombie {
	public ZombieBasico getZombieComun() {
=======
import Entidades.AllStar;
import Entidades.CaraCono;
import Entidades.Comun;
import Entidades.ZombieBasico;
import Entidades.ZombieEspecial;
import Entidades.ZombieRobusto;

public class FabricaZombieDia implements FabricaZombie {
	public ZombieBasico getZombieBasico() {
>>>>>>> 585ad22b68b45bd67e888da5bba95b88d7092293
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new AllStar();
	}
	public ZombieRobusto getZombieRobusto() {
		return new CaraCono();
	}
}
