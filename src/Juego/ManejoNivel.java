package Juego;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * 
 * Clase ManejoNivel para guardar la información de los niveles y sus respectivas oleadas del juego con el uso
 * de la clase properties.
 *
 */
public class ManejoNivel {
	
	protected Properties prop;	
	
	/**
	 * Constructor ManejoNivel que inicializa la variable prop con un nuevo Properties.
	 */
	public ManejoNivel() {
		prop = new Properties();
	}
	
	/**
	 * Método que genera el archivo Niveles.properties con todos los niveles y sus oleadas.
	 */
	public void generarArchivoNivel() {
		try {
			OutputStream archivo = new FileOutputStream("Niveles.properties");
			
			//Se crea clave valor para el nivel 1.
			prop.setProperty("OleadasNivel1", "3"); //Cambiar a 5 despues de sacar coment
			prop.setProperty("Nivel1Soles", "100");
			prop.setProperty("Nivel1_Oleada1ZombieBasico", "5");
			prop.setProperty("Nivel1_Oleada1ZombieRobusto", "0");
			prop.setProperty("Nivel1_Oleada1ZombieEspecial", "0");			
			
			prop.setProperty("Nivel1_Oleada2ZombieBasico", "7");
			prop.setProperty("Nivel1_Oleada2ZombieRobusto", "0");
			prop.setProperty("Nivel1_Oleada2ZombieEspecial", "1");
			
			prop.setProperty("Nivel1_Oleada3ZombieBasico", "10");
			prop.setProperty("Nivel1_Oleada3ZombieRobusto", "1");
			prop.setProperty("Nivel1_Oleada3ZombieEspecial", "1");
			
			//Se crea clave valor para el nivel 2.		
			prop.setProperty("OleadasNivel2", "4");
			prop.setProperty("Nivel2Soles", "100");
			prop.setProperty("Nivel2_Oleada1ZombieBasico", "6");
			prop.setProperty("Nivel2_Oleada1ZombieRobusto", "0");
			prop.setProperty("Nivel2_Oleada1ZombieEspecial", "0");
			
			prop.setProperty("Nivel2_Oleada2ZombieBasico", "7");
			prop.setProperty("Nivel2_Oleada2ZombieRobusto", "2");
			prop.setProperty("Nivel2_Oleada2ZombieEspecial", "0");
			
			prop.setProperty("Nivel2_Oleada3ZombieBasico", "10");
			prop.setProperty("Nivel2_Oleada3ZombieRobusto", "2");
			prop.setProperty("Nivel2_Oleada3ZombieEspecial", "2");
			
			prop.setProperty("Nivel2_Oleada4ZombieBasico", "13");
			prop.setProperty("Nivel2_Oleada4ZombieRobusto", "3");
			prop.setProperty("Nivel2_Oleada4ZombieEspecial", "4");
			
			//Se crea clave valor para el nivel 3
			prop.setProperty("OleadasNivel3", "5");
			prop.setProperty("Nivel3Soles", "100");
			
			prop.setProperty("Nivel3_Oleada1ZombieBasico", "7");
			prop.setProperty("Nivel3_Oleada1ZombieRobusto", "0");
			prop.setProperty("Nivel3_Oleada1ZombieEspecial", "0");
			
			prop.setProperty("Nivel3_Oleada2ZombieBasico", "8");
			prop.setProperty("Nivel3_Oleada2ZombieRobusto", "3");
			prop.setProperty("Nivel3_Oleada2ZombieEspecial", "0");
			
			prop.setProperty("Nivel3_Oleada3ZombieBasico", "10");
			prop.setProperty("Nivel3_Oleada3ZombieRobusto", "2");
			prop.setProperty("Nivel3_Oleada3ZombieEspecial", "4");
			
			prop.setProperty("Nivel3_Oleada4ZombieBasico", "14");
			prop.setProperty("Nivel3_Oleada4ZombieRobusto", "3");
			prop.setProperty("Nivel3_Oleada4ZombieEspecial", "4");
			
			prop.setProperty("Nivel3_Oleada5ZombieBasico", "16");
			prop.setProperty("Nivel3_Oleada5ZombieRobusto", "5");
			prop.setProperty("Nivel3_Oleada5ZombieEspecial", "5");
			
			//Se crea clave valor para el nivel 4.
			prop.setProperty("OleadasNivel4", "6");
			prop.setProperty("Nivel4Soles", "125");
			
			prop.setProperty("Nivel4_Oleada1ZombieBasico", "8");
			prop.setProperty("Nivel4_Oleada1ZombieRobusto", "0");
			prop.setProperty("Nivel4_Oleada1ZombieEspecial", "0");
			
			prop.setProperty("Nivel4_Oleada2ZombieBasico", "9");
			prop.setProperty("Nivel4_Oleada2ZombieRobusto", "3");
			prop.setProperty("Nivel4_Oleada2ZombieEspecial", "0");
			
			prop.setProperty("Nivel4_Oleada3ZombieBasico", "11");
			prop.setProperty("Nivel4_Oleada3ZombieRobusto", "4");
			prop.setProperty("Nivel4_Oleada3ZombieEspecial", "2");
			
			prop.setProperty("Nivel4_Oleada4ZombieBasico", "14");
			prop.setProperty("Nivel4_Oleada4ZombieRobusto", "3");
			prop.setProperty("Nivel4_Oleada4ZombieEspecial", "4");
			
			prop.setProperty("Nivel4_Oleada5ZombieBasico", "17");
			prop.setProperty("Nivel4_Oleada5ZombieRobusto", "6");
			prop.setProperty("Nivel4_Oleada5ZombieEspecial", "5");
			
			prop.setProperty("Nivel4_Oleada6ZombieBasico", "20");
			prop.setProperty("Nivel4_Oleada6ZombieRobusto", "7");
			prop.setProperty("Nivel4_Oleada6ZombieEspecial", "8");
			
			//Se crea clave valor para el nivel 5.
			prop.setProperty("OleadasNivel5", "7");
			prop.setProperty("Nivel5Soles", "150");
			
			prop.setProperty("Nivel5_Oleada1ZombieBasico", "10");
			prop.setProperty("Nivel5_Oleada1ZombieRobusto", "0");
			prop.setProperty("Nivel5_Oleada1ZombieEspecial", "0");
			
			prop.setProperty("Nivel5_Oleada2ZombieBasico", "11");
			prop.setProperty("Nivel5_Oleada2ZombieRobusto", "5");
			prop.setProperty("Nivel5_Oleada2ZombieEspecial", "2");
			
			prop.setProperty("Nivel5_Oleada3ZombieBasico", "14");
			prop.setProperty("Nivel5_Oleada3ZombieRobusto", "4");
			prop.setProperty("Nivel5_Oleada3ZombieEspecial", "4");
			
			prop.setProperty("Nivel5_Oleada4ZombieBasico", "16");
			prop.setProperty("Nivel5_Oleada4ZombieRobusto", "5");
			prop.setProperty("Nivel5_Oleada4ZombieEspecial", "4");
			
			prop.setProperty("Nivel5_Oleada5ZombieBasico", "19");
			prop.setProperty("Nivel5_Oleada5ZombieRobusto", "6");
			prop.setProperty("Nivel5_Oleada5ZombieEspecial", "8");
			
			prop.setProperty("Nivel5_Oleada6ZombieBasico", "22");
			prop.setProperty("Nivel5_Oleada6ZombieRobusto", "8");
			prop.setProperty("Nivel5_Oleada6ZombieEspecial", "8");
			
			prop.setProperty("Nivel5_Oleada7ZombieBasico", "25");
			prop.setProperty("Nivel5_Oleada7ZombieRobusto", "10");
			prop.setProperty("Nivel5_Oleada7ZombieEspecial", "10");
			
			prop.store(archivo, null);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Método para retornar los valores de las oleadas y la cantidad de zombies que se van a generar en el juego y la cantidad
	 * de soles con los que va a iniciar el jugador.
	 * @param info - nivel y oleada del juego a verificar el valor.
	 * @return valor de clave recibida por parámetro.
	 */
	public int getInformacion(String info) {
		int toReturn = 0;
		toReturn = Integer.parseInt(prop.getProperty(info));
		return toReturn;
	}	
	
}
