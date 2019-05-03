package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private JFrame mf;
	private JPanel panel;
	public BackgroundPanel(JFrame mf) {

		this.mf = mf;
		panel = this;
		this.setLayout(null);
		this.setBackground(Color.black);
		
		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/start background.PNG").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		JButton join = new JButton(
				new ImageIcon(new ImageIcon("images/join.PNG").getImage().getScaledInstance(200, 100, 0)));
		join.setBounds(180, 550, 200, 100);
		join.setContentAreaFilled(false);
		join.setBorderPainted(false);
		join.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel cp = new ChangePanel(mf, panel);
				Join join = new Join(mf);
				cp.replacePanel(join);
			}
		});
		
		
		JButton login = new JButton(
				new ImageIcon(new ImageIcon("images/login2.PNG").getImage().getScaledInstance(200, 100, 0)));

		login.setBounds(580, 565, 200, 100);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		this.add(label);
		this.add(join);
		this.add(login);
		this.setComponentZOrder(label, 2);

		login.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				Login login = new Login(mf);
				cp.replacePanel(login);
			}
		});
		this.setBounds(0,0,1000, 800);
		this.repaint();
	}

}
