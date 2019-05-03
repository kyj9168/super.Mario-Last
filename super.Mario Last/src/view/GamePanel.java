package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Debuggable;
import controller.JumpListener;
import controller.JumpThread;
import model.vo.Bomb;
import model.vo.Coin;
import model.vo.Member;
import model.vo.PinkCoin;

public class GamePanel extends JPanel implements JumpListener, Debuggable {
	int mode = MODE_DEBUG;
	/**
	 * ����
	 */
	String VERSION = "0.1.0";
	/**
	 * ���ٴ��� Y�� (�� �̻��� �����δ� ���ΰ��� Y��ǥ���� ��ȭ���� ����)
	 */
	int BOTTOM_Y = 423;
	int lastPressedKeyCode = 1;
	/**
	 * ������ �����Ŀ� �����Ǿ ���������� �ϴ� ������
	 */
	JumpThread jumpThread;
	/**
	 * ������ �ϴ� ĳ���Ϳ� ���� ������ ��� �ִ� Ŭ����
	 */
	private JFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private JLabel mario;
	private JLabel back;
	ArrayList<Coin> coins = new ArrayList<Coin>();
	ArrayList<PinkCoin> pinkCoins = new ArrayList<PinkCoin>();
	ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	Member m = new Member();
	ArrayList<Member> list = new ArrayList<Member>();

	int width;
	int height;

	int coinCtn = 0;

	int x, y, w, h;
	int dx = 0, dy = 0;

	int score;

	Image imgBack, imgPlayer, imgCoin, imgPinkCoin, imgBomb;

	public GamePanel(JFrame mf) {

		this.mf = mf;
		panel = this;
		this.setBounds(0, 0, 1000, 800);

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		imgBack = toolkit.getImage("images/back.png");

		imgPlayer = toolkit.getImage("images/mario.png");

		imgCoin = toolkit.getImage("images/gold_0000.gif");

		imgPinkCoin = toolkit.getImage("images/pink03.gif");

		imgBomb = toolkit.getImage("images/bomb2.png");

		MainFrame.Sound("audio/MainTheme.wav", false);

		GameThread gThread = new GameThread();
		gThread.start();

		
		this.setVisible(true);

	}

	int coin;
	int pink;
	int bomb;

	@Override

	public void paintComponent(Graphics g) {

		if (width == 0 || height == 0) {
			width = getWidth();

			height = getHeight();

			imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_DEFAULT);

			imgPlayer = imgPlayer.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

			x = width / 2;
			y = height - 123;
			w = 100;
			h = 100;
		}

		g.drawImage(imgBack, 0, 0, this);

		for (Coin t : coins) {
			g.drawImage(t.getImg(), t.getX() - t.getW(), t.getY() - t.getH(), this);
		}
		for (PinkCoin p : pinkCoins) {
			g.drawImage(p.getImg(), p.getX() - p.getW(), p.getY() - p.getH(), this);
		}
		for (Bomb b : bombs) {
			g.drawImage(b.getImg(), b.getX() - b.getW(), b.getY() - b.getH(), this);
		}

		String scoin = "������ ���� �� : " + coin;
		g.setColor(Color.BLACK);
		g.drawString(scoin, 800, 50);

		String spink = "������ ��ũ ���� �� : " + pink;
		g.setColor(Color.BLACK);
		g.drawString(spink, 800, 80);

		String sbomb = "������ ��ź �� : " + bomb;
		g.setColor(Color.RED);
		g.drawString(sbomb, 800, 110);

		g.drawImage(imgPlayer, x - w, y - h, this);

		g.setFont(new Font(null, Font.BOLD, 20));

		g.drawString("Score: " + score, 10, 50);

		String info = " ���� : ĳ���͸� �����̷��� ����ȭ���� �ѹ� Ŭ���ߴ� �ٽ� ���ƿ�����";
		g.setColor(Color.RED);
		g.setFont(new Font("���ʷյ���", Font.BOLD, 13));
		g.drawString(info, 10, 80);

		String info2 = "�����ϴϱ� �ü�ü�Դϴ�.";
		g.setColor(Color.RED);
		g.setFont(new Font("�ü�", Font.BOLD | Font.ITALIC, 13));
		g.drawString(info2, 10, 100);

	}

	public void move() {
		for (int i = coins.size() - 1; i >= 0; i--) {
			Coin t = coins.get(i);
			t.move();

			if (t.isDead()) {
				coins.remove(i);
			}
		}
		for (int i = pinkCoins.size() - 1; i >= 0; i--) {
			PinkCoin p = pinkCoins.get(i);
			p.move();

			if (p.isDead()) {
				pinkCoins.remove(i);
			}
		}
		for (int i = bombs.size() - 1; i >= 0; i--) {
			Bomb b = bombs.get(i);
			b.move();

			if (b.isDead()) {
				bombs.remove(i);
			}
		}
		x += dx;
		// y += dy;

		if (x < w)
			x = w;

		if (x > width - w)
			x = width - w;

		if (y < h)
			y = h;

		if (y > height - h)
			y = height - h;
	}

	public void makeCoin() {

		if (width == 0 || height == 0)
			return;

		Random rnd = new Random();

		int n = rnd.nextInt(22);

		if (n == 0) {
			coins.add(new Coin(imgCoin, width, height));
			coin++;
		}

		Random rndo = new Random();

		int n1 = rndo.nextInt(40);

		if (n1 == 0) {
			pinkCoins.add(new PinkCoin(imgPinkCoin, width, height));
			pink++;
		}
		Random rndom = new Random();

		int n2 = rndom.nextInt(45);

		if (n2 == 0) {
			bombs.add(new Bomb(imgBomb, width, height));
			bomb++;
		}

	}

	public void checkCollision() {

		for (Coin t : coins) {
			int left = t.getX() - t.getW();

			int right = t.getX() + t.getW();

			int top = t.getY() - t.getH();

			int bottom = t.getY() + t.getH();

			if (x > left && x < right && y > top && y < bottom) {

				t.setDead(true); // �浹����

				MainFrame.Sound("audio/Coin.wav", false);

				score += 50;
				m.setCoins(Member.getCoins() + 50);
				System.out.println(Member.getCoins());

			}

		}
		for (PinkCoin p : pinkCoins) {
			int left = p.getX() - p.getW();

			int right = p.getX() + p.getW();

			int top = p.getY() - p.getH();

			int bottom = p.getY() + p.getH();

			if (x > left && x < right && y > top && y < bottom) {

				p.setDead(true); // �浹����

				MainFrame.Sound("audio/Power up.wav", false);

				score += 150;
				m.setCoins(Member.getCoins() + 150);
				System.out.println(Member.getCoins());
			}

		}
		for (Bomb b : bombs) {
			int left = b.getX() - b.getW();

			int right = b.getX() + b.getW();

			int top = b.getY() - b.getH();

			int bottom = b.getY() + b.getH();

			if (x > left && x < right && y > top && y < bottom) {

				b.setDead(true); // �浹����

				MainFrame.Sound("audio/bomb.wav", false);

				score -= 50;
				m.setCoins(Member.getCoins() - 50);

			}

		}
	}

	class GameThread extends Thread {
		@Override
		public void run() {
			JLabel label = new JLabel("�����ð� : ");
			label.setBounds(850, 0, 150, 50);
			label.setFont(new Font("Sanscerif", Font.BOLD, 20));
			panel.add(label);
			for (int i = 1200; i >= 0; i--) { // ���� �ð�

				try { // �ʹ� ���� ���Ƽ� õõ�� ������
					label.setText("�����ð� : " + (i / 40));

					makeCoin();
					move();
					checkCollision();
					repaint();

					sleep(25);

				} catch (InterruptedException e) {
				}
			}
			
			ChangePanel cp = new ChangePanel(mf, panel);
			gameEnd gameEnd = new gameEnd(mf);
			cp.replacePanel(gameEnd);

		}

	}

	/**
	 * ȭ�鿡 �׷����� ȣ���� ��.
	 */
	/*
	 * public void paint(Graphics g) { super.paint(g); g.drawLine(0, BOTTOM_Y,
	 * this.getWidth(), BOTTOM_Y); g.setColor(Color.black); String info =
	 * "��ó: ������ ������ "; g.drawString(info, 10, 45); g.setColor(Color.blue); String
	 * info2 = "��� : ����ȭ�� �ѹ� Ŭ���ϰ� ���α׷� �ٽ� Ŭ���ؾ� ������"; g.drawString(info2, 10, 60);
	 * 
	 * 
	 * Image image = null; image =
	 * Toolkit.getDefaultToolkit().getImage("images/mario0.gif");
	 * 
	 * BufferedImage bi = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	 * g.drawImage(image, this.character.getX(), this.character.getY(), this);
	 * g.drawImage(bi, this.character.getX(), this.character.getY(), this);
	 * 
	 * }
	 */
	/**
	 * ����׸� �ϱ� ���� �Լ� (�Լ����ο��� ������ ����ϰ�� ǥ������� ���� �ʵ��� ��)
	 */
	public void debug(String s) {
		if (this.mode == MODE_DEBUG)
			System.out.println(s);
	}

	public void background() {
		URL url2 = getClass().getClassLoader().getResource("background_0000.gif");
		back = new JLabel(new ImageIcon(url2));
		back.setBounds(0, 0, 1000, 800);
		this.add(back);

		this.repaint();
	}

	@Override
	public void jumpTimeArrived(int jumpIdx, int jumpy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jumpTimeEnded() {
		// TODO Auto-generated method stub

	}

}