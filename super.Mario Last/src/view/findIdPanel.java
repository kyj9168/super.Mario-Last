package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class findIdPanel extends JPanel {

	ImageIcon icon;
	private JTextField nameField;
	private JTextField hpField;
	private JFrame mf;
	private JPanel panel;

	public findIdPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		JLabel label = new JLabel(new ImageIcon(
				new ImageIcon("images/findid background.png").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		JLabel lblId = new JLabel();
		lblId.setBounds(100, 480, 200, 40);
		this.add(lblId);

		nameField = new JTextField();
		nameField.setBounds(415, 300, 260, 40);
		this.add(nameField);
		nameField.setColumns(10);

		hpField = new JTextField();
		hpField.setBounds(415, 450, 260, 40);
		this.add(hpField);

		JButton lblFindId = new JButton();
		Image findId = new ImageIcon("images/findid2.png").getImage().getScaledInstance(300, 100, 0);
		lblFindId.setIcon(new ImageIcon(findId));
		lblFindId.setBounds(400, 570, 300, 200);
		lblFindId.setContentAreaFilled(false);
		lblFindId.setBorderPainted(false);

		lblFindId.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				try {
					String s = null;

					boolean result = true;
					BufferedReader br = new BufferedReader(new FileReader("회원명단.txt"));

					while ((s = br.readLine()) != null) {

						String[] array = s.split("/");

						if (nameField.getText().equals(array[0])) {

							if (hpField.getText().equals(array[3])) {
								result = false;
								JOptionPane.showMessageDialog(null, "아이디는 " + array[1] + "입니다.");
								ChangePanel cp = new ChangePanel(mf, panel);
								Login login = new Login(mf);
								cp.replacePanel(login);

							}
						}
					}
					if (result) {
						JOptionPane.showMessageDialog(null, "없는 정보입니다. 다시 입력하시요.");
						return;
					}

				} catch (IOException E10) {
					E10.printStackTrace();
				}
			}
		});

		JButton lblback = new JButton();
		Image back = new ImageIcon("images/backbutton.png").getImage().getScaledInstance(50, 50, 0);
		lblback.setIcon(new ImageIcon(back));
		lblback.setBounds(0, 0, 170, 80);
		lblback.setOpaque(false);
		lblback.setContentAreaFilled(false);
		lblback.setBorderPainted(false);

		lblback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				Login login = new Login(mf);
				cp.replacePanel(login);
			}
		});
		this.add(lblback);

		this.add(lblFindId);
		this.add(label);
		this.setSize(1000, 800);

	}

}
