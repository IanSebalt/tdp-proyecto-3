package Fabricas;

<<<<<<< HEAD
import Entidades.*;

public class FabricaZombieNoche implements FabricaZombie{
	public ZombieBasico getZombieComun() {
=======
import Entidades.Comun;
import Entidades.Lector;
import Entidades.Portero;
import Entidades.ZombieBasico;
import Entidades.ZombieEspecial;
import Entidades.ZombieRobusto;

public class FabricaZombieNoche implements FabricaZombie{
	public ZombieBasico getZombieBasico() {
>>>>>>> 585ad22b68b45bd67e888da5bba95b88d7092293
		return new Comun();
	}
	public ZombieEspecial getZombieEspecial() {
		return new Lector();
	}
	public ZombieRobusto getZombieRobusto() {
		return new Portero();
	}
}
