package controller;
/**
 * 캐릭터가 점프를 하면서 발생하는 이벤트를 받는 인터페이스 
 * @author 까만손오공 <a href="http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public interface JumpListener {
	
	/**
	 * 점프 중간의 이벤트 발생함. (현재 어느단계의 점프인지 알수 있음)
	 * @param jumpIdx 점프idx (1부터시작함)
	 * @param jumpy 점프로 인해서 계산해야 하는 캐릭터의 Y좌표 증가값
	 */
	public void jumpTimeArrived(int jumpIdx, int jumpy);
	
	/**
	 * 점프가 끝났음을 알림 
	 */
	public void jumpTimeEnded();
	
}
