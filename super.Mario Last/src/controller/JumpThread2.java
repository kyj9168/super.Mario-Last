package controller;
import javax.swing.ImageIcon;

public class JumpThread2 extends Thread {
    boolean jumping=false;
    
    int jumpingy[]=new int[]{0, -15, -10,-6,-6,0,6,6,10,15}; // 0번째는 의미없음, 캐릭터 이미지를 보고 점프했을 경우의 좌표를 변경함 
    
    int jumpIdx;
    
    JumpListener jumpListener;
    
    public JumpThread2(JumpListener jumpListener) {
    	super();
    	this.jumpIdx=1;
    	this.jumpListener=jumpListener;
    }
    
    public void run() {
    	
    	while(this.jumpIdx<this.jumpingy.length) {
    		
    		this.jumpListener.jumpTimeArrived(this.jumpIdx, this.jumpingy[this.jumpIdx]);
	    	try {
	    		Thread.sleep(0);
	    	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	this.jumpIdx++;
    	}
    	this.jumpListener.jumpTimeEnded();
    		
    }
	
}