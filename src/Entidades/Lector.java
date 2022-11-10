package Entidades;


public class Lector extends ZombieEspecial{
		protected boolean diario;
		
		public Lector() {
			vida = 100;
			velocidad = 5;//falta ver velocidad
			dmg = 2; //Ver dmg de zombie;
			diario = true;
			
		}
		
		public void visit(Proyectil p) {
			p.recibirDmg(1);
			recibirDmg(p.obtenerDmg());
			if(vida<= 0) {
				morir();
			} else if(vida <= 80 && diario) {
				romperDiario();
			}
		}
		
		public void morir() {
			//Falta ver como muere		
		}		
		
		private void romperDiario() {
			diario = false;
			velocidad *= 1.5;
			//Faltaria llamar a animacion
		}

}
