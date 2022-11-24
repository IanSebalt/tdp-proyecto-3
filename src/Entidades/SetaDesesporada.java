package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;
import Juego.Juego;

public class SetaDesesporada extends PlantaDisparadora {
	public SetaDesesporada(Coordenada c) {
		segundos = 0;//Setear segundos;
		dmg = 15;//Setear dmg;
		vida = 60;
		costo = 50;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/setadesesporada.gif"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0,80,100);
	}
	
	public void actuar() {
		segundos += 500;
		Juego j = Juego.obtenerInstancia(null);
		if(j.hayZombieFila(coord) && segundos == 3000) {
			Proyectil p = new ProyectilRalentizador(dmg, coord, miRectangulo);
			j.generarProyectil(coord, p);
		}
		if(segundos>=3000)
			segundos = 0;
	}
	
}
