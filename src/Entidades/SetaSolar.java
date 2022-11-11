package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;

public class SetaSolar extends PlantaGeneradora{
	public SetaSolar(Coordenada c) {
		segundos = 1;//Setear segundos;
		soles = 1;//Setear soles;
		vida = 100;
		costo = 25;
		coord = c;
	}
	
	public void actuar() {
		//Generaria soles
	}

	public void morir() {
		//Falta ver como muere
	}
}
