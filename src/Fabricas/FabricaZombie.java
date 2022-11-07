package Fabricas;

<<<<<<< HEAD
import Entidades.*;

public interface FabricaZombie {
	public ZombieBasico getZombieComun();
=======
import Entidades.ZombieBasico;
import Entidades.ZombieEspecial;
import Entidades.ZombieRobusto;

public interface FabricaZombie {
	public ZombieBasico getZombieBasico();
>>>>>>> 585ad22b68b45bd67e888da5bba95b88d7092293
	public ZombieEspecial getZombieEspecial();
	public ZombieRobusto getZombieRobusto();
}
