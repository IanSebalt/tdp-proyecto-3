package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import Entidades.Entidad;
import Entidades.Planta;
import Escenario.Coordenada;
import Juego.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Ventana {

	private JFrame frame;
	private JPanel panelGhost;
	private JPanel panelMain;
	private JPanel panelMenu;
	private JPanel panelJuego;
	private JPanel panelTablero;
	private JLabel soles;
	private ManejoSonido miSonido;
	private int plantaClick;

	private static final int ancho = 100;
	private static final int largo = 100;
	private static final int cols = 9;
	private static final int filas = 6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 900, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 1264, 985);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 1264, 985);
		panelMenu.setLayout(null);
		
		abrirMenu();
	}
	
	public void crearEntidad(Entidad e) {
		panelGhost.add(e.getSprite());
		panelGhost.revalidate();
		panelGhost.repaint();
		e.getSprite().mover(e.getCoordenada().getX()* ancho, e.getCoordenada().getY() * largo);
	}
	
	public void eliminarPlanta(Planta p) {		
		JLabel cont = (JLabel) panelTablero.getComponentAt(p.getCoordenada().getX() * ancho, p.getCoordenada().getY() * largo);
		cont.remove(p.getSprite());
		cont.repaint();
	}
	
	public void eliminarEntidad(Entidad e) {
		panelGhost.remove(e.getSprite());
		panelGhost.repaint();
	}
	
	public void generarSol(Coordenada c) {
		JLabel sol = new JLabel();
		sol.setBounds(c.getX() * 100, c.getY() * 100, 30, 30);
		ImageIcon i = new ImageIcon(getClass().getResource("/imagenes/sol.png"));
		sol.setIcon(i);
		sol.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Juego miJuego = Juego.obtenerInstancia(null);
				miJuego.sumarSoles(25);
				actualizarSoles();
				panelGhost.remove(sol);
			}
		});
		panelGhost.add(sol);
	}
	
	public void mostrarCambioOleada() {
		JLabel transicion = new JLabel();
		transicion.setBounds(100, 50, 700, 300);
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/oleada.png"));
		transicion.setIcon(img);
		panelGhost.add(transicion);
		ActionListener t = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				panelGhost.remove(transicion);
				panelGhost.repaint();
			}
		};
		Timer time = new Timer(3000, t);
		actualizarSoles();
		time.setRepeats(false);
		time.start();
	}
	
	public boolean pedirVolver() {
		String [] opciones = {"Menú", "Siguiente nivel"};
		int opt = JOptionPane.showOptionDialog(panelMain, "¿Quiere volver al menú o pasar al siguiente nivel?", "Nivel", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
		boolean retornar;
		if(opt == 0)
			retornar = true;
		else retornar = false;
		return retornar;
	}
	
	public void generarLapida(Coordenada c) {
		JLabel cont = (JLabel) panelTablero.getComponentAt(c.getX()*100, c.getY()*100);
		JLabel lap = new JLabel();
		lap.setBounds(0, 0, ancho, largo);
		ImageIcon i = new ImageIcon(getClass().getResource("/imagenes/grave.png"));
		lap.setIcon(i);
		cont.add(lap);
		cont.repaint();
	}
	
	private void abrirMenu() {
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionJugar();
			}
		});
		btnJugar.setBounds(375, 292, 89, 23);
		panelMenu.add(btnJugar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(375, 379, 89, 23);
		panelMenu.add(btnSalir);
		
		JButton btnManual = new JButton("Manual");
		btnManual.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnManual.setBounds(375, 334, 89, 23);
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirManual();
			}
		});
		panelMenu.add(btnManual);
		
		JLabel title = new JLabel();
		title.setBounds(90, 0, 700, 300);
		ImageIcon t = new ImageIcon(getClass().getResource("/imagenes/niantas.png"));
		title.setIcon(t);
		panelMenu.add(title);
		
		JLabel background = new JLabel();
		background.setBounds(0, 0, 900, 750);
		ImageIcon back = new ImageIcon(getClass().getResource("/imagenes/background.png"));
		background.setIcon(back);
		panelMenu.add(background);
		panelMain.add(panelMenu);
		panelMain.repaint();
	}
	
	public void terminarPartida() {
		panelMain.removeAll();
		miSonido.parar();
		abrirMenu();
		JOptionPane.showMessageDialog(frame, "Terminó la partida.");
	}
	
	public void siguienteNivel() {
		panelGhost.removeAll();
		panelJuego.removeAll();
		panelTablero.removeAll();
		generarTablero();
		generarTienda();
		panelJuego.repaint();
		actualizarSoles();
	}
	
	private void funcionJugar() {
		String [] opciones = {"Dia", "Noche"};
		Juego j = Juego.obtenerInstancia(this);
		int opt = JOptionPane.showOptionDialog(panelMain, "Seleccione el modo de juego", "Modo de juego", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
		if(opt == 0) {
			j.setModo(1);
			miSonido = new ManejoSonido();
			miSonido.musicaDia();
			panelMain.remove(panelMenu);
			panelJuego = new JPanel();
			panelJuego.setBounds(0, 0, 1264, 985);
			panelJuego.setLayout(null);
			panelJuego.setOpaque(false);
			panelGhost = new JPanel();
			panelGhost.setLayout(null);
			panelGhost.setBounds(0, 0, cols * largo, filas * ancho);
			panelGhost.setOpaque(false);
			panelMain.add(panelGhost);
			generarTablero();
			generarTienda();
			panelMain.add(panelJuego);
			panelMain.repaint();
			panelMain.revalidate();
		}else {
			j.setModo(2);
			miSonido = new ManejoSonido();
			miSonido.musicaNoche();
			panelMain.remove(panelMenu);
			panelJuego = new JPanel();
			panelJuego.setBounds(0, 0, 1264, 985);
			panelJuego.setLayout(null);
			panelJuego.setOpaque(false);
			panelGhost = new JPanel();
			panelGhost.setLayout(null);
			panelGhost.setBounds(0, 0, cols * largo, filas * ancho);
			panelGhost.setOpaque(false);
			panelMain.add(panelGhost);
			generarTablero();
			generarTienda();
			panelMain.add(panelJuego);
			panelMain.repaint();
			panelMain.revalidate();
		}
		j.empezarJuego();
		actualizarSoles();
	}
	
	private void generarTablero() {
		Juego juego = Juego.obtenerInstancia(this);
		panelTablero = new JPanel();
		panelTablero.setLayout(null);
		panelTablero.setBounds(0, 0, cols * largo, filas * ancho);
		panelTablero.setOpaque(false);
		JLabel dummy = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource(juego.getCesped()[0]));
		ImageIcon imgh = new ImageIcon(getClass().getResource(juego.getCesped()[1]));
		dummy.setSize(ancho, largo);
		reDimensionar(dummy, img);
		reDimensionar(dummy, imgh);
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 9; j++) {
				JLabel til = new JLabel();
				til.setBounds(j * ancho, i * largo, ancho, largo);
				til.setIcon(img);
				til.setOpaque(false);
				til.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						clickEnTil(til);
					}
					
					public void mouseEntered(MouseEvent e) {
						til.setIcon(imgh);
					}
					
					public void mouseExited(MouseEvent e) {
						til.setIcon(img);
					}
				});
				panelTablero.add(til);
			}
			
		}
		panelMain.add(panelTablero);
	}
	
	private void abrirManual() {
		panelMain.removeAll();
		panelMain.repaint();
		JPanel panelManual = new JPanel();
		panelManual.setBounds(0, 0, 1264, 985);
		JTextArea t = new JTextArea();
		t.setBackground(null);
		t.setBounds(0, 0, 1264, 500);
		t.setText("Bienvenido al manual del juego:"
				+ "\n\n El juego posee dos modos de juego. Cada modo de juego posee dos niveles. En cada modo de juego, a partir del segundo nivel, se pone a disposción\n una nueva planta, para un "
				+ "total de tres."
				+ "\n\n En el modo día caen soles del cielo y hay disponibles las siguientes plantas:"
				+ "\n\n Planta Lanzaguisantes: principal baza de ataque durante el día. Una planta que dispara guisantes hacia los zombies, haciendo un daño moderado."
				+ "\n Girasol: planta generadora durante el día. Genera soles cada 25 segundos."
				+ "\n Nuez: principal defensa durante el día. Resiste bien las mordidas de los zombies, pero no puede responder ante ellas. Se desbloquea en el nivel dos."
				+ "\n\n En el modo noche no caen soles del cielo, y además hay lápidas de las cuales salen zombies luego de un rato. Las plantas disponibles son:"
				+ "\n\n Seta Desesporada: principal baza de ataque durante la noche. Una seta que dispara esporas hacia los zombies, ralentizando su caminar."
				+ "\n Seta Solar: planta generadora durante el día. Genera soles cada 25 segundos cuando es pequeña, y cada 20 segundos cuando crece. Crece al pasar\n 75 segundos."
				+ "\n Cactus: principal defensa durante la noche. Resiste bien las mordidas de los zombies y además dispara poderosos proyectiles a los zombies,\n pero con una cadencia lenta. "
				+ "\n Se desbloquea en el nivel dos.");
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.removeAll();
				abrirMenu();
			}
		});
		btnVolver.setBounds(375, 400, 89, 23);
		panelManual.add(btnVolver); 
		panelManual.add(t);
		panelMain.add(panelManual);
	}
	
	private void generarTienda() {
		int xIni = 0;
		int yIni = 600;
		for(int i = 0; i < 3; i++) {
			JLabel tienda = new JLabel();
			tienda.setBounds(xIni + (i * ancho), yIni, ancho, largo);
			ImageIcon img = new ImageIcon(getClass().getResource(Juego.obtenerInstancia(null).getModo().getPlantas()[i]));
			tienda.setIcon(img);
			int x = i;
			tienda.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					plantaClick = x + 1;
				}
				public void mousePressed(MouseEvent e) {
					plantaClick = x + 1;
				}
			});
			if( x != 1 || Juego.obtenerInstancia(this).getNivel() >= 2)
				panelJuego.add(tienda);
		}
		soles = new JLabel();
		soles.setText("Soles: "+Juego.obtenerInstancia(this).getSoles());
		soles.setBounds(xIni + 300, 625, 100, 30);
		soles.setFont(new Font("Unispace", Font.PLAIN, 11));
		panelJuego.add(soles);
		JButton botonMusica = new JButton();
		botonMusica.setText("Musica");
		botonMusica.setBounds(xIni + 800, 625, 80, 60);
		botonMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miSonido.pararIniciarMusica();
			}
		});
		panelJuego.add(botonMusica);
	}
	
	public void actualizarSoles() {		
		soles.setText("Soles: "+Juego.obtenerInstancia(this).getSoles());
	}
	
	private void clickEnTil(JLabel j) {
		if(plantaClick != 0) {
			Planta plantaE = Juego.obtenerInstancia(null).generarPlanta(plantaClick, j.getX() / ancho, j.getY() / largo);
			if(plantaE != null && plantaE.getCosto()<= Juego.obtenerInstancia(this).getSoles()) {
				Sprite planta = plantaE.getSprite();
				planta.setBounds(0, 0, ancho, largo	);
				ImageIcon img = planta.getImg();
				planta.setIcon(img);
				j.add(planta);
				j.repaint();
				panelTablero.repaint();
				plantaClick = 0;
				Juego.obtenerInstancia(this).restarSoles(plantaE.getCosto());
				actualizarSoles();
			}
		}
	}
	
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if(image != null) {
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.repaint();
		}
	}
}
