package swing;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.sun.prism.Image;
import com.sun.prism.paint.Color;

//윈도우 클래스를 만들었다.
public class Mywindow extends JFrame {
	public Mywindow() {
		//위치와 크기 설정
		setBounds(700,150,1000,1000);
		//제목 설정
		setTitle("스윙을 이욯한 윈도우");
		//종료 버튼 이벤트 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE); //awt는 이것을 안쓰기 때문에 종료버튼을 눌러도 안되는 것
		//패널을 생성
		JPanel panel = new JPanel();
		ImageIcon icon = new ImageIcon("C:\\Users\\503-25\\Desktop\\자원\\이미지\\Rainbow.jpg");
		
		
		
		JLabel label = new JLabel(icon);
		label.setIcon(icon);
		label.setToolTipText("안녕");
		/*TitledBorder border = new TitledBorder("경계선");
		label.setBorder(border);*/
		EtchedBorder border = new EtchedBorder();
		label.setBorder(border);
		
		panel.add(label);
		
		JButton btn = new JButton("버튼");
		panel.add(btn);
		
		//패널을 프레임에 부착
		add(panel);
		//화면 출력
		setVisible(true);		
		
		//배열은 만들면 크기 변경이 안됩니다.
		//그림 파일 이름을 배열로 만들기
		String [] images = {"image1.png","image3.png","image4.png"};
		
		// 리스트는 크기 변경이 가능한 배열입니다.
		ArrayList<String> list = new ArrayList<String>();
		list.add("image1.png");
		list.add("image3.png");
		list.add("image4.png");
		
		
		
		//이미지가 변경되는 동안에도 다른 작업을 할 수 있어야 하므로 이미지 변경은 스레드로 생성
		Thread th = new Thread() { //작업하고 있는 동안 다른작업을 할 수 있게 해주는 것이다
			public void run() {
				int idx = 0;
				while(true) {
					try {
						//배열을 가지고 하고 싶을 때는 밑에 코드처럼 한다.
						/*Thread.sleep(1000);
						ImageIcon icon = new ImageIcon("C:\\Users\\503-25\\Desktop\\자원\\이미지\\" + images[idx%images.length]);
						label.setIcon(icon);*/
						
						Thread.sleep(1000);
						// 리스트를 가지고 계속 돌리고 싶을때는 밑에 코드처럼 사용
						ImageIcon icon = new ImageIcon("C:\\Users\\503-25\\Desktop\\자원\\이미지\\" + list.get(idx%list.size()));
						label.setIcon(icon);
						
						idx = idx+1;
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	
			}
		};
		th.start();
	}
}
