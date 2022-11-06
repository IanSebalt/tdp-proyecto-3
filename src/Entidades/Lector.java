package Entidades;


public class Lector extends ZombieEspecial{
		protected boolean diario;
		
		public Lector() {
			vida = 100;
			velocidad = 5;//falta ver velocidad
			dmg = 2; //Ver dmg de zombie;
			diario = true;
			
		}

		public void morir() {
			//Falta ver como muere		
		}
		
		public void recibirDmg(int d) {
			vida -= d;
			if(vida <= 0) {
				morir();
			} else if(vida <= 80 && diario) {
				romperDiario();
			}
		}
		
		private void romperDiario() {
			diario = false;
			velocidad *= 1.5;
			//Faltaria llamar a animacion
		}

}
