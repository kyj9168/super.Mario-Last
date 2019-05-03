package model.vo;
import javax.swing.ImageIcon;

import controller.Debuggable;


/**
 * 캐릭터 클래스 
 * (게임에서 움직이는 캐릭터의 좌표와 상태 등의 정보를 갖고 있음)
 * @author 까만손오공 <a href="http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public class Character {

	/**
     * 주인공의 X좌표
     */
	int x = 50;
    
    /**
     * 주인공의 Y좌표
     */
    int y;
    
	/**
	 * 캐릭터의 방향 (오른쪽을 보고있는지의 여부)
	 */
	boolean isRight;
	
	/**
	 * 캐릭터 이미지의 번호  
	 */
	int imageNum;
	
	/**
	 * 캐릭터 이미지의 사이즈
	 */
	public static int IMAGENUM_SIZE=8;
	
	/**
	 * 캐릭터의 애니메이션을 담고 있음
	 */
	ImageIcon[] icons=new ImageIcon[IMAGENUM_SIZE];
	
	/**
	 * 캐릭터의 높이
	 */
	int height;
	
	/**
	 * 캐릭터의 넓이
	 */
	int width;
	
    /**
     * 점프하는 방향을 알고 있는 변수
     */
    int jumpdirection=0; 
    
    /**
     * 현재 점프를 한 생태 (0이면 점프안한것이고, 1이상이면 점프를 하는 중임) 
     */
    int jumpIdx=0;
    
	/**
	 * 디비거가 가능한 메인프로그램 
	 */
	Debuggable debuggable;
	
	/**
	 * 초기생성자
	 * @param debuggable 디버그가 가능한 메인프로그램
	 */
	public Character(Debuggable debuggable) {
		
		this.debuggable=debuggable;
		
		for (int i=0;i<IMAGENUM_SIZE;++i) {
			String path="images\\mario" + i + ".gif";
			this.debuggable.debug(path);
			this.icons[i]=new ImageIcon(path);
		}
		this.width=this.icons[0].getIconWidth();
		this.height=this.icons[0].getIconHeight();
	}

	
	/**
	 * 점프의 상태에 따라서 이미지를 가져옴 
	 * @return ImageIcon
	 */
	public ImageIcon getImageIcon() {
		
		switch (this.jumpIdx) {
			case 0:
				return this.icons[0];
				
			case 1:
				return this.icons[1];
				
			case 2:
				return this.icons[1];
				
			case 3:
				return this.icons[1];
				
			case 4:
				return this.icons[2];
				
			case 5:
				return this.icons[3];
				
			case 6:
				return this.icons[3];
				
			case 7:
				return this.icons[3];
			
			case 8:
				return this.icons[4];
			
			case 9:
				return this.icons[5];
			
			
			default:
				return this.icons[0];
		}
	}
	
	/**
	 * 높이를 리턴한다.
	 * @return 높이
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * 넓이를 리턴한다.
	 * @return 넓이
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * 점프의 상태를 가져옴
	 * @return 점프인덱스
	 */
	public int getJumpIdx() {
		return this.jumpIdx;
	}
	
	/**
	 * 점프의 상태를 설정함 
	 * @param jumpIdx 점프인덱스
	 */
	public void setJumpIdx(int jumpIdx) {
		this.jumpIdx=jumpIdx;
	}
	
	/**
	 * 점프의 방향을 가져옴 
	 * @return 점프방향(오른쪽방향이면 양수, 왼쪽방향이면 음수)
	 */
	public int getJumpDirection() {
		return this.jumpdirection;
	}
	
	/**
	 * 점프의 방향을 결정한 (오른쪽? 왼쪽?)
	 * @param jumpDirection
	 */
	public void setJumpDirection (int jumpDirection) {
		this.jumpdirection=jumpDirection;
	}
	
	/**
	 * 점프를 하는중인지의 여부
	 * @return 점프를 하면 true
	 */
	public boolean isJumping() {
		if (this.jumpIdx==0) return false;
		return true;
	}

	/**
	 * x좌료를 증가시킨다.
	 * @param add 증가시키려는 값
	 */
	public void addX(int add) {
		this.x+=add;
	}
	
	/**
	 * y좌표를 증가시킨다. 
	 * @param add 증가시키려는 값 
	 */
	public void addY(int add) {
		this.y+=add;
	}
	
	/**
	 * x좌료를 설정한다.
	 * @param x x좌표 
	 */
	public void setX(int x) {
		this.x=x;		
	}

	/**
	 * y좌표를 설정한다.
	 * @param y y좌표
	 */
	public void setY(int y) {
		this.y=y;
	}	
	
	/**
	 * x좌표를 조회한다.
	 * @return x좌표
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * y좌표를 조회한다.
	 * @return y좌표
	 */
	public int getY() {
		return this.y;
	}
}
