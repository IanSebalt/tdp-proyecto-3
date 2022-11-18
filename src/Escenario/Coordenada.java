package Escenario;

/**
 * Clase Coordenada para guardar la ubicación de las entidades.
 *
 */
public class Coordenada {
	
	protected int x;
	
	protected int y;
	
	/**
	 * Contructor de la clase Coordenada que inicializa la posición X e Y.
	 * @param x - posición x de la entidad.
	 * @param y - posición y de la entidad.
	 */
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Método que modifica la posición X de la coordenada.
	 * @param x - nuevo valor x.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Método que modifica la posición Y de la coordenada.
	 * @param y - nuevo valor y.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Método que retorna la ubicación X de la coordenada.
	 * @return ubicación x.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Método que retorna la ubicación Y de la coordenada.
	 * @return ubicación y.
	 */
	public int getY() {
		return y;
	}
	
}
