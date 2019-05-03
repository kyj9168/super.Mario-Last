package controller;
import java.beans.IntrospectionException;

/**
 * 캐릭터가 점프를 하면 생성이 되는 클래스 일정한 시간간격으로 캐릭터의 점프동작을 변경시킨다
 * 
 * @author 까만손오공 <a href=
 *         "http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public class JumpThread extends Thread {

	boolean jumping = false;

	int jumpingy[] = new int[] { 0, -30, -15, -10, -6, -6, 0, 6, 6, 10, 15, 30 }; // 0번째는 의미없음, 캐릭터 이미지를 보고 점프했을 경우의 좌표를
																					// 변경함
	
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
