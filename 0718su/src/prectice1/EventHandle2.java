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
		setTitle("Ű���� �̺�Ʈ ");
		setLayout(null);
		Label label =new Label("&");
		label.setBounds(80,50,50,50);
		add(label);

		KeyListener listener = new KeyListener() {
			// ���� Ű�� ������ ��
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			// Ű���带 ������ �� ȣ��Ǵ� �޼ҵ�
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
					//Modifiers�� ���� ���� ����Ű ���� ���� // �տ����� ���� �����°� 
					if(arg0.getModifiers() == KeyEvent.ALT_MASK && 
							arg0.getKeyCode() == KeyEvent.VK_F2) {
						System.exit(0);
					}
				
						Thread th = new Thread() {// �����带 ���� ����
							public void run() {
								
								if(arg0.getKeyCode() == KeyEvent.VK_F) {
									Label label1 = new Label("�Ѿ�");
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
						//������ �����Ҽ� �ְ� ���ش�.
						th.start();
						
			
			}
			// Ű���忡�� ���� �� ��
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		//Frame�� Ű���� �̺�Ʈ ����
		addKeyListener(listener); // ���� Ű�����ʴ� handle2Ŭ������ ��������.
		//air.add~ // ����� Ű���带 �ִ°��� ����� ���̺��̶� 
		
		//������ ������ ���� �̺�Ʈ�� ó���ϱ� ���� ������
		WindowAdapter window = new WindowAdapter() { //Adapter�� ���� ������ �� �ʿ䰡 ����.
			//���� ��ư�� ���� �� ȣ��Ǵ� �޼ҵ�
			@Override
			public void windowClosing(WindowEvent e) {
				// ���α׷� ����
				System.exit(0);
			}

			
		};
		//�����ӿ� ������ �̺�Ʈ ����
		addWindowListener(window);
		
		setVisible(true);
	}
}
