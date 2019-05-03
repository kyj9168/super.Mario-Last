package controller;

/**
 * 디버가 가능한 프로그램이냐
 * @author 까만손오공 <a href="http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public interface Debuggable {
	
	/**
	 * 디버그 모드 (각종 이벤트및 중요한 정보를 출력하는 상태)
	 */
	public static int MODE_DEBUG=0;
	
	/**
	 * 릴리즈 모드 (출력이 없는 정상 모드)
	 */
	public static int MODE_RELEASE=1;
	
		
	/**
	 * 디버거를 하기 위해서 무엇인가를 표한함
	 * @param s
	 */
	public void debug(String s);
}
