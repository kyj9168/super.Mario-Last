package controller;
import java.beans.IntrospectionException;

/**
 * ĳ���Ͱ� ������ �ϸ� ������ �Ǵ� Ŭ���� ������ �ð��������� ĳ������ ���������� �����Ų��
 * 
 * @author ��տ��� <a href=
 *         "http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public class JumpThread extends Thread {

	boolean jumping = false;

	int jumpingy[] = new int[] { 0, -30, -15, -10, -6, -6, 0, 6, 6, 10, 15, 30 }; // 0��°�� �ǹ̾���, ĳ���� �̹����� ���� �������� ����� ��ǥ��
																					// ������
	
	int jumpIdx;

	JumpListener jumpListener;

	public JumpThread(JumpListener jumpListener) {
		super();
		this.jumpIdx = 1;
		this.jumpListener = jumpListener;
	}

	public void run() {

		while (this.jumpIdx < this.jumpingy.length) {

			this.jumpListener.jumpTimeArrived(this.jumpIdx, this.jumpingy[this.jumpIdx]);

			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.jumpIdx++;
		}
		this.jumpListener.jumpTimeEnded();

	}

}