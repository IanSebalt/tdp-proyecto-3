package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import GUI.Sprite;

public class Lector extends ZombieEspecial{
		protected boolean diario;
		
		public Lector() {
			vida = 100;
			velocidad = 5;//falta ver velocidad
			dmg = 2; //Ver dmg de zombie;
			diario = true;
			ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/zombie_lector.gif"));
			miSprite = new Sprite(img);
			miRectangulo = new Rectangle(0,0, anchoRectanguloZombie, altoRectanguloZombie);
			
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
		
		private void romperDiario() {
			diario = false;
			velocidad *= 1.5;
			//Faltaria llamar a animacion
		}

}
