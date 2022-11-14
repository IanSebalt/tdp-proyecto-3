package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class SetaSolar extends PlantaGeneradora{
	public SetaSolar(Coordenada c) {
		segundos = 1;//Setear segundos;
		soles = 1;//Setear soles;
		vida = 100;
		costo = 25;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/seta_solar.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0,100,100);
	}
	
	public void actuar() {
		Juego j = Juego.obtenerInstancia(null);
		j.generarSol( coord );
	}

}
