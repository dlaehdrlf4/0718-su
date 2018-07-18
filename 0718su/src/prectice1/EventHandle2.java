package prectice1;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventHandle2 extends Frame {
	public EventHandle2() {
		setBounds(1000,1000,1000,1000);
		setTitle("키보드 이벤트 ");
		setLayout(null);
		Label label =new Label("&");
		label.setBounds(80,50,50,50);
		add(label);

		KeyListener listener = new KeyListener() {
			// 문자 키를 눌렀을 때
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			// 키보드를 눌렀을 때 호출되는 메소드
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_DOWN);
					int x = label.getLocation().x;
					int y = label.getLocation().y;
					if(arg0.getKeyCode() == arg0.VK_LEFT) {
						x = x - 10;
					}
					if(arg0.getKeyCode() == arg0.VK_RIGHT) {
						x = x + 10;
					}
					if(arg0.getKeyCode() == arg0.VK_UP) {
						y = y - 10;
					}
					if(arg0.getKeyCode() == arg0.VK_DOWN) {
						y = y + 10;
					}
					label.setLocation(x,y);
					//Modifiers는 같이 누른 조합키 값을 리턴 // 앞에껄로 같이 누르는거 
					if(arg0.getModifiers() == KeyEvent.ALT_MASK && 
							arg0.getKeyCode() == KeyEvent.VK_F2) {
						System.exit(0);
					}
				
						Thread th = new Thread() {// 스레드를 만들어서 실행
							public void run() {
								
								if(arg0.getKeyCode() == KeyEvent.VK_F) {
									Label label1 = new Label("총알");
									label1.setBounds(label.getLocation().x,label.getLocation().y-30,30,30);
									add(label1);
								
								try {
									while(true) {
									Thread.sleep(1000);
									int x = label1.getLocation().x;
									int y = label1.getLocation().y;
									label1.setLocation(x,y-10);
									if(y<50)
										break;
									}
									label1.setVisible(false);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							}	
						};
						//스레드 시작할수 있게 해준다.
						th.start();
						
			
			}
			// 키보드에서 손을 땔 때
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		//Frame에 키보드 이벤트 설정
		addKeyListener(listener); // 에드 키리스너는 handle2클래스에 가져간다.
		//air.add~ // 에어에서 키보드를 넣는거임 에어는 레이블이라서 
		
		//윈도우 조작을 위한 이벤트를 처리하기 위한 리스너
		WindowAdapter window = new WindowAdapter() { //Adapter을 쓰면 재정의 할 필요가 없다.
			//종료 버튼을 누를 때 호출되는 메소드
			@Override
			public void windowClosing(WindowEvent e) {
				// 프로그램 종료
				System.exit(0);
			}

			
		};
		//프레임에 윈도우 이벤트 연결
		addWindowListener(window);
		
		setVisible(true);
	}
}
