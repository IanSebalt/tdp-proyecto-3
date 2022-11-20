package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Escenario.Coordenada;
import GUI.Sprite;

public class ProyectilRalentizador  extends Proyectil{
	public ProyectilRalentizador(int d, Coordenada c, Rectangle rec) {
		vida = 1;
		dmg = d;
		coord = c;
		ImageIcon img = new ImageIcon(getClass().getResource( "/imagenes/espora.png"));
		miSprite = new Sprite(img);
		miRectangulo = new Rectangle(0,0, anchoRectangulo, (int)rec.getHeight());
		miRectangulo.setLocation((c.getX()*100) + 50, c.getY()*100);
	}
	
	
	
	public void accept(VisitorZombie v){
	 	v.visit(this);
	 }
	
}


