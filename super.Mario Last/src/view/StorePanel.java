package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.vo.Coin;
import model.vo.Member;

public class StorePanel extends JPanel {
	ArrayList<Member> list = new ArrayList<Member>();

	private JPanel panel;
	private JFrame mf;

	public StorePanel(JFrame mf,String array,String array2) {
		JTextField tf = new JTextField(10);
		this.mf = mf;
		panel = this;

		this.setLayout(null);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/store background.PNG").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);


		JButton buy1 = new JButton(
				new ImageIcon(new ImageIcon("images/buy.PNG").getImage().getScaledInstance(200, 100, 0)));
		buy1.setBounds(700, 350, 180, 80);
		buy1.setContentAreaFilled(false);
		buy1.setBorderPainted(false);
		buy1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "아메리카노 쿠폰을 구매 하시겠습니까?", "confirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					tf.setText("just closed without selection");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf, array, array2);
					cp.replacePanel(sp);
				} else if (result == JOptionPane.YES_OPTION) {
					tf.setText("Yes");
					if (Member.getCoins() > 2000) {

						list.add(new Member().setName(Member.getName()).setId(Member.getId())
								.setPassword(Member.getPassword()).setCoins(Member.getCoins() - 2000));

						FileWriter out = null;
						PrintWriter out2 = null;

						try {
							out = new FileWriter(Member.getName());
							out2 = new PrintWriter(out, true);
							for (Member m : list) {
								out2.printf("%1$s,%2$s,%3$s,%4$s,%5$d", Member.getId(), Member.getPassword(),
										Member.getName(), Member.getHp(), Member.getCoins());
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

						tf.setText("just closed without selection");
						ChangePanel cp = new ChangePanel(mf, panel);
						StorePanel sp = new StorePanel(mf, array, array2);
						cp.replacePanel(sp);
						JOptionPane.showMessageDialog(null, "구매가 완료되었습니다.");
						cp.replacePanel(sp);
					} else if (Member.getCoins() < 2000) {
						tf.setText("No");
						JOptionPane.showMessageDialog(null, "구매를 취소하였습니다.");

						ChangePanel cp = new ChangePanel(mf, panel);
						StorePanel sp = new StorePanel(mf, array, array2);
					}
				}
			}
		});

		JLabel coin = new JLabel("보유 코인 : " + Member.getCoins());
		coin.setForeground(Color.WHITE);
		coin.setFont(new Font("궁서", Font.BOLD, 20));
		coin.setBounds(800, 55, 300, 150);

		JButton buy2 = new JButton(
				new ImageIcon(new ImageIcon("images/buy.PNG").getImage().getScaledInstance(200, 100, 0)));

		buy2.setBounds(700, 650, 180, 80);
		buy2.setContentAreaFilled(false);
		buy2.setBorderPainted(false);

		buy2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "한식 뷔페 쿠폰을 구매 하시겠습니까?", "confirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					tf.setText("just closed without selection");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf, array, array2);
					cp.replacePanel(sp);
				} else if (result == JOptionPane.YES_OPTION) {
					tf.setText("Yes");
					if (Member.getCoins() > 2000) {

						list.add(new Member().setName(Member.getName()).setId(Member.getId())
								.setPassword(Member.getPassword()).setCoins(Member.getCoins() - 2000));

						FileWriter out = null;
						PrintWriter out2 = null;

						try {
							out = new FileWriter(Member.getName());
							out2 = new PrintWriter(out, true);
							for (Member m : list) {
								out2.printf("%1$s,%2$s,%3$s,%4$s,%5$d", Member.getId(), Member.getPassword(),
										Member.getName(), Member.getHp(), Member.getCoins());
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
						JOptionPane.showMessageDialog(null, "구매가 완료되었습니다.");
						ChangePanel cp = new ChangePanel(mf, panel);
						StorePanel sp = new StorePanel(mf, array, array2);
						cp.replacePanel(sp);
					} else {
						tf.setText("No");
						JOptionPane.showMessageDialog(null, "구매를 취소하였습니다.");
						ChangePanel cp = new ChangePanel(mf, panel);
						StorePanel sp = new StorePanel(mf, array, array2);
						cp.replacePanel(sp);
					}
				}
			}
		});

		JButton home = new JButton(
				new ImageIcon(new ImageIcon("images/backButtomWhite.png").getImage().getScaledInstance(80, 80, 0)));
		home.setBounds(0, 0, 80, 80);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				todayCoin tc = new todayCoin(mf, array, array2);
				cp.replacePanel(tc);
			}
		});
		
		this.add(label);
		this.add(coin);
		this.add(buy1);
		this.add(buy2);
		this.add(home);
		this.setComponentZOrder(label, 4);
		this.setSize(1000, 800);
	}
}
