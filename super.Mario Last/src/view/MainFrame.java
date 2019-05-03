package view;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import model.vo.Character;

public class MainFrame extends JFrame {

	Character character;

	public MainFrame() {
		

		
		this.setTitle("super.Mario");
		this.setBounds(200, 100, 1000, 800);

		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));

		this.add(new BackgroundPanel(this));

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Sound("audio/click.wav", false);
			}
		});
		
		
	}

	public static void Sound(String file, boolean Loop) {
		Clip clip;
		System.out.println("sound");
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			if(Loop)clip.loop(-1);
			
			if(file.length() < 0) {
				clip.close();
			}
		} catch (Exception e) {
			
		}
		
		
	}
}
