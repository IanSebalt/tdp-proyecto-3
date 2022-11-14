package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Entidades.Entidad;
import Entidades.Planta;
import Juego.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Ventana {

	private JFrame frame;
	private JPanel panelGhost;
	private JPanel panelMain;
	private JPanel panelMenu;
	private JPanel panelJuego;
	private JPanel panelTablero;
	private int plantaClick;

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
		frame.setBounds(100, 100, 1280, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 1264, 985);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 1264, 985);
		panelMain.add(panelMenu);
		panelMenu.setLayout(null);
		
		abrirMenu();
	}
	
	public void crearEntidad(Entidad e) {
		panelGhost.add(e.getSprite());
		panelGhost.revalidate();
		panelGhost.repaint();
		e.getSprite().mover(1000, e.getCoordenada().getY() * 100);
	}
	
	public void eliminarPlanta(Planta p) {		
		JLabel cont = (JLabel) panelTablero.getComponentAt(p.getCoordenada().getX() * 100, p.getCoordenada().getY() * 100);
		cont.remove(p.getSprite());
		cont.repaint();
	}
	
	public void eliminarEntidad(Entidad e) {
		panelGhost.remove(e.getSprite());
		panelGhost.repaint();
	}
	
	private void abrirMenu() {
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionJugar();
			}
		});
		btnJugar.setBounds(583, 265, 89, 23);
		panelMenu.add(btnJugar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(583, 328, 89, 23);
		panelMenu.add(btnSalir);
		
		JButton btnManual = new JButton("Manual");
		btnManual.setBounds(583, 299, 89, 23);
		panelMenu.add(btnManual);
	}
	
	public void terminarPartida() {
		panelMain.removeAll();
		abrirMenu();
	}
	
	private void funcionJugar() {
		String [] opciones = {"Dia", "Noche"};
		Juego j = Juego.obtenerInstancia(this);
		int opt = JOptionPane.showOptionDialog(panelMain, "Seleccione el modo de juego", "Modo de juego", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
		if(opt == 0) {
			j.setModo(1);
			panelMain.remove(panelMenu);
			panelJuego = new JPanel();
			panelJuego.setBounds(0, 0, 1264, 985);
			panelJuego.setLayout(null);
			panelJuego.setOpaque(false);
			panelGhost = new JPanel();
			panelGhost.setLayout(null);
			panelGhost.setBounds(0, 0, 900, 600);
			panelGhost.setOpaque(false);
			panelMain.add(panelGhost);
			generarTablero();
			generarTienda();
			panelMain.add(panelJuego);
			panelMain.repaint();
			panelMain.revalidate();
		}
		j.empezarJuego();
	}
	
	private void generarTablero() {
		panelTablero = new JPanel();
		panelTablero.setLayout(null);
		panelTablero.setBounds(0, 0, 900, 600);
		panelTablero.setOpaque(false);
		JLabel dummy = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/grasstile.png"));
		ImageIcon imgh = new ImageIcon(getClass().getResource("/imagenes/grasstile-hovered.png"));
		dummy.setSize(100, 100);
		reDimensionar(dummy, img);
		reDimensionar(dummy, imgh);
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 9; j++) {
				JLabel til = new JLabel();
				til.setBounds(j * 100, i * 100, 100, 100);
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
	
	private void generarTienda() {
		int xIni = 0;
		int yIni = 600;
		for(int i = 0; i < 3; i++) {
			JLabel tienda = new JLabel();
			tienda.setBounds(xIni + (i * 100), yIni, 100, 100);
			ImageIcon img = new ImageIcon(getClass().getResource(Juego.obtenerInstancia(null).getModo().getPlantas()[i]));
			tienda.setIcon(img);
			int x = i;
			tienda.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					plantaClick = x + 1;
				}
			});
			panelJuego.add(tienda);
		}
	}
	
	private void clickEnTil(JLabel j) {
		if(plantaClick != 0) {
			Planta plantaE = Juego.obtenerInstancia(null).generarPlanta(plantaClick, j.getX() / 100, j.getY() / 100);
			if(plantaE != null) {
				Sprite planta = plantaE.getSprite();
				planta.setBounds(0, 0, 100, 100);
				ImageIcon img = planta.getImg();
				planta.setIcon(img);
				j.add(planta);
				j.repaint();
				panelTablero.repaint();
				plantaClick = 0;
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
