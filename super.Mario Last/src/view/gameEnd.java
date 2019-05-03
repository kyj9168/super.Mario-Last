package view;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.vo.Member;

public class gameEnd extends JPanel{
	ImageIcon icon;
	private JTextField nameField;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField hpField;
	private JFrame mf;
	private JPanel panel;
	ArrayList<Member> list = new ArrayList<Member>();
	
	public gameEnd(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		this.setLayout(null);

		MainFrame.Sound("audio/GameOver.wav", true);
		
		
		
		list.add(new Member().setName(Member.getName()).setId(Member.getId()).setPassword(Member.getPassword())
				.setCoins(Member.getCoins()));

		FileWriter out = null;
		PrintWriter out2 = null;

		
		try {
			out = new FileWriter(Member.getName());
			out2 = new PrintWriter(out, true);
			for (Member m : list) {
				out2.printf("%1$s,%2$s,%3$s,%4$s,%5$d", Member.getId(), Member.getPassword(), Member.getName(),
						Member.getHp(), Member.getCoins());
			}
		} catch (Exception e2) {
			System.out.println("저장 중 에러 발생");
		} finally {
			if (out2 != null) {
				out2.close();
				try {
					out.close();
				} catch (Exception e2) {

				}
			}
		}
		
		
		
		
		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/gamebackground2.jpg").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		

		
		String coins = Member.getCoins()+"P";
		
		JLabel lblGain = new JLabel(coins);
		lblGain.setText(coins);
		lblGain.setBounds(480, 310, 320, 100);
		this.add(lblGain);
		lblGain.setForeground(Color.WHITE);
		lblGain.setFont(lblGain.getFont().deriveFont(80.0f));
		
		


		JButton jRetry = new JButton();
		Image retry = new ImageIcon("images/retry.png").getImage().getScaledInstance(200, 60, 0);
		jRetry.setIcon(new ImageIcon(retry));
		jRetry.setBounds(200, 450, 300, 200);
		jRetry.setOpaque(false);
		jRetry.setContentAreaFilled(false);
		jRetry.setBorderPainted(false);
		
		jRetry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel cp = new ChangePanel(mf, panel);
				GamePanel gp = new GamePanel(mf);
				cp.replacePanel(gp);
			}
		});
		this.add(jRetry);

		
		JButton jMain = new JButton();
		Image main = new ImageIcon("images/main.png").getImage().getScaledInstance(200, 60, 0);
		jMain.setIcon(new ImageIcon(main));
		jMain.setBounds(550, 450, 300, 200);
		jMain.setOpaque(false);
		jMain.setContentAreaFilled(false);
		jMain.setBorderPainted(false);
		
		jMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel cp = new ChangePanel(mf, panel);
				todayCoin tc = new todayCoin(mf, null, null);
				cp.replacePanel(tc);
			}
		});
		this.add(jMain);

		
		this.add(label);
		this.setSize(1000, 800);
		this.setVisible(true);
	}
}
