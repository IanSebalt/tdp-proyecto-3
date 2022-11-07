package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite extends JLabel{
	private ImageIcon img;
	
	public Sprite(ImageIcon img) {
		super();
		this.img = img;
		setIcon(this.img);
		setBounds(0, 0, 100, 100);
	}
	
	public void setImg(ImageIcon img) {
		this.img = img;
	}
	
	public void mover(int x, int y) {
		setLocation(x, y);
	}
	
	public ImageIcon getImg() {
		return img;
	}
}