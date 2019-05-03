package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RankPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public RankPanel(JFrame mf) {
		
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		this.setBounds(300, 200, 1000, 800);
		
		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/ranking.jpg").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);
			
		JButton home = new JButton(new ImageIcon(new ImageIcon("images/home2.PNG").getImage().getScaledInstance(50, 50, 0)));
		home.setBounds(30,30,50,50);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		
		home.addActionListener(new ActionListener() {

	          @Override
	          public void actionPerformed(ActionEvent e) {
	             ChangePanel cp = new ChangePanel(mf, panel);
					todayCoin todayCoin = new todayCoin(mf, getName(), getName());
					cp.replacePanel(todayCoin);
	          }
	       });
	       this.add(home);

		JPanel panel2 = new JPanel();
		panel2.setSize(1000,800);
			
		panel2.setLayout(null);
			
		panel2.add(home);
		panel2.add(label);
			
		this.add(panel2);
	}
	
	public void printRank() {
		
	}
}
