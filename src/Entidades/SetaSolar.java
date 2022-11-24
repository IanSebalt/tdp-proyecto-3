package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class SetaSolar extends PlantaGeneradora{
	
	protected boolean crecio;
	
	public SetaSolar(Coordenada c) {
		segundos = 0;//Setear segundos;
		vida = 100;
		costo = 25;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/seta_solarChica.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0,80,100);
		crecio = false;
	}
	
	public void actuar() {
		segundos += 500;
		if(segundos%25000 == 0 && !crecio) {
			Juego j = Juego.obtenerInstancia(null);
			j.generarSol( coord );			
		}else
			if(segundos%20000==0 && crecio){
				Juego j = Juego.obtenerInstancia(null);
				j.generarSol( coord );
				segundos = 0;
			}
		if(segundos==75000 && crecio == false) {
			crecio = true;
			miSprite.setImg(new ImageIcon(getClass().getResource("/imagenes/seta_solar.gif")));
			miSprite.repaint();
		}
			
	}

}
