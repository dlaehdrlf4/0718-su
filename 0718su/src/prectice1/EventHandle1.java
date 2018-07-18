package prectice1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class EventHandle1 extends Frame {
	//생성자 만들기
	public EventHandle1() {
		//위치와 크기 설정
		setBounds(1000,1000,1000,1000);
		//제목 설정
		setTitle("이벤트 처리 연습");
		//여러 개를 배치하기 위해서 패널 배치
		Panel panel = new Panel();
		
		TextField tf1 = new TextField(5);
		panel.add(tf1);
		//글자를 보여주고 싶을때는 label
		Label plus = new Label("+");
		panel.add(plus);
		
		TextField tf2 = new TextField(5);
		panel.add(tf2);
		Label assign = new Label("=");
		panel.add(assign);
		
		TextField result = new TextField(5);
		panel.add(result);
		
		
		Button btn = new Button("계산");
		panel.add(btn);
		
		//ActionListener 인터페이스의 anonymous class 생성
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 첫번째 와 두번째 텍스트 필드의 내용 가져오기
				String n1 = tf1.getText();
				String n2 = tf2.getText();
				
				int r = Integer.parseInt(n1) +  Integer.parseInt(n2);
				String b = String.format("%d", r);
				result.setText(b);
				//result.setText(String.format("%d", r));	
			}
			
		};
		btn.addActionListener(listener);
		
		
		Label labpw = new Label("비밀번호");
		panel.add(labpw);
		TextField pw = new TextField(15);
		panel.add(pw);
		Label pwResult = new Label();
		panel.add(pwResult);
	
		//텍스트 필드의 내용이 변경될 때를 처리할 수 있는 인터페이스의 인스턴스를 생성
		TextListener t1 = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				
				String password = pw.getText();
				//영문 대소문자와 숫자 그리고 특수문자의 개수 세기
				int dae = 0; // 개수를 저장한 변수 만들기
				int so = 0;
				int su = 0;
				int etc = 0;
				//password의 모든 글자를 순회// 각 글자를 가져와야하니까 for문을가져옴
				for(int i=0;i<password.length();i=i+1) {
					//i번째 글자 가져오기
					char ch = password.charAt(i);
					//대문자 인지 확인 : A - Z
					if(ch >= 'A' && ch <= 'Z') {
						dae = dae + 1;
					}
					else if(ch >= 'a' && ch <= 'z') {
						so = so + 1;
					}
					else if(ch >= '0' && ch <= '9') {
						su = su + 1;
					}
					else {
						etc = etc + 1;
					}
				}
				// 4개 중에 한개도 0이 없으면
				if(dae * so * su * etc > 0) { // 대문자 소문자 숫자 특수문자를 모두다 가지고 있어야 된다.
					pwResult.setBackground(Color.yellow);
					pwResult.setText("사용 가능한 비밀번호");
				} else {
					pwResult.setBackground(Color.red);
					pwResult.setText("비밀번호가 약합니다.");
				}
			}
		};
		pw.addTextListener(t1);
		
		add(panel);
		//화면 출력
		setVisible(true);
		
	}
}


