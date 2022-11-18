package GUI;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ManejoSonido {
	
	private Clip clip;
	
	protected boolean estaEncendida;
	
	public void musica(String musicPath) {
		try {
			File music = new File(musicPath);
			if(music.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				estaEncendida = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void musicaDia() {
		musica("salio.wav");
	}
	
	public void musicaNoche() {
		musica("cayo.wav");
	}
	
	public void parar() {
		clip.stop();
	}
	
	public void pararIniciarMusica() {
		if(estaEncendida) {
			estaEncendida = false;
			clip.stop();
		}
		else {
			estaEncendida = true;
			clip.start();
		}
	}
}
