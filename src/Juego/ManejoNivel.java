package Juego;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ManejoNivel {
	
	protected Properties prop;	
	
	public ManejoNivel() {
		prop = new Properties();
	}
	
	public void generarArchivoNivel() {
		try {
			OutputStream archivo = new FileOutputStream("Niveles.properties");
			prop.setProperty("OleadasNivel1", "1"); //Cambiar a 5 despues de sacar coment
			prop.setProperty("Nivel1Soles", "100");
			prop.setProperty("Nivel1_Oleada1ZombieBasico", "5");
			prop.setProperty("Nivel1_Oleada1ZombieRobusto", "0");
			prop.setProperty("Nivel1_Oleada1ZombieEspecial", "0");
			
			
			/*
			prop.setProperty("Nivel1_Oleada2ZombieBasico", "5");
			prop.setProperty("Nivel1_Oleada2ZombieRobusto", "2");
			prop.setProperty("Nivel1_Oleada2ZombieEspecial", "2");
			
			prop.setProperty("Nivel1_Oleada3ZombieBasico", "15");
			prop.setProperty("Nivel1_Oleada3ZombieRobusto", "5");
			prop.setProperty("Nivel1_Oleada3ZombieEspecial", "5");
			
			prop.setProperty("Nivel1_Oleada4ZombieBasico", "20");
			prop.setProperty("Nivel1_Oleada4ZombieRobusto", "7");
			prop.setProperty("Nivel1_Oleada4ZombieEspecial", "8");
			
			prop.setProperty("Nivel1_Oleada5ZombieBasico", "25");
			prop.setProperty("Nivel1_Oleada5ZombieRobusto", "10");
			prop.setProperty("Nivel1_Oleada5ZombieEspecial", "10");
			
			*/
			
			prop.setProperty("OleadasNivel2", "7");
			prop.setProperty("Nivel2Soles", "150");
			prop.setProperty("Nivel2_Oleada1ZombieBasico", "10");
			prop.setProperty("Nivel2_Oleada1ZombieRobusto", "0");
			prop.setProperty("Nivel2_Oleada1ZombieEspecial", "0");
			
			prop.setProperty("Nivel2_Oleada2ZombieBasico", "11");
			prop.setProperty("Nivel2_Oleada2ZombieRobusto", "2");
			prop.setProperty("Nivel2_Oleada2ZombieEspecial", "2");
			
			prop.setProperty("Nivel2_Oleada3ZombieBasico", "15");
			prop.setProperty("Nivel2_Oleada3ZombieRobusto", "5");
			prop.setProperty("Nivel2_Oleada3ZombieEspecial", "5");
			
			prop.setProperty("Nivel2_Oleada4ZombieBasico", "20");
			prop.setProperty("Nivel2_Oleada4ZombieRobusto", "7");
			prop.setProperty("Nivel2_Oleada4ZombieEspecial", "8");
			
			prop.setProperty("Nivel2_Oleada5ZombieBasico", "25");
			prop.setProperty("Nivel2_Oleada5ZombieRobusto", "10");
			prop.setProperty("Nivel2_Oleada5ZombieEspecial", "10");
			
			prop.setProperty("Nivel2_Oleada6ZombieBasico", "30");
			prop.setProperty("Nivel2_Oleada6ZombieRobusto", "12");
			prop.setProperty("Nivel2_Oleada6ZombieEspecial", "13");
			
			prop.setProperty("Nivel2_Oleada7ZombieBasico", "35");
			prop.setProperty("Nivel2_Oleada7ZombieRobusto", "15");
			prop.setProperty("Nivel2_Oleada7ZombieEspecial", "15");
			
			prop.store(archivo, null);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public int getInformacion(String tipoZombie) {
		int toReturn = 0;
		toReturn = Integer.parseInt(prop.getProperty(tipoZombie));
		return toReturn;
	}	
	
}
