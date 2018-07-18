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

//������ Ŭ������ �������.
public class Mywindow extends JFrame {
	public Mywindow() {
		//��ġ�� ũ�� ����
		setBounds(700,150,1000,1000);
		//���� ����
		setTitle("������ �̟G�� ������");
		//���� ��ư �̺�Ʈ ó��
		setDefaultCloseOperation(EXIT_ON_CLOSE); //awt�� �̰��� �Ⱦ��� ������ �����ư�� ������ �ȵǴ� ��
		//�г��� ����
		JPanel panel = new JPanel();
		ImageIcon icon = new ImageIcon("C:\\Users\\503-25\\Desktop\\�ڿ�\\�̹���\\Rainbow.jpg");
		
		
		
		JLabel label = new JLabel(icon);
		label.setIcon(icon);
		label.setToolTipText("�ȳ�");
		/*TitledBorder border = new TitledBorder("��輱");
		label.setBorder(border);*/
		EtchedBorder border = new EtchedBorder();
		label.setBorder(border);
		
		panel.add(label);
		
		JButton btn = new JButton("��ư");
		panel.add(btn);
		
		//�г��� �����ӿ� ����
		add(panel);
		//ȭ�� ���
		setVisible(true);		
		
		//�迭�� ����� ũ�� ������ �ȵ˴ϴ�.
		//�׸� ���� �̸��� �迭�� �����
		String [] images = {"image1.png","image3.png","image4.png"};
		
		// ����Ʈ�� ũ�� ������ ������ �迭�Դϴ�.
		ArrayList<String> list = new ArrayList<String>();
		list.add("image1.png");
		list.add("image3.png");
		list.add("image4.png");
		
		
		
		//�̹����� ����Ǵ� ���ȿ��� �ٸ� �۾��� �� �� �־�� �ϹǷ� �̹��� ������ ������� ����
		Thread th = new Thread() { //�۾��ϰ� �ִ� ���� �ٸ��۾��� �� �� �ְ� ���ִ� ���̴�
			public void run() {
				int idx = 0;
				while(true) {
					try {
						//�迭�� ������ �ϰ� ���� ���� �ؿ� �ڵ�ó�� �Ѵ�.
						/*Thread.sleep(1000);
						ImageIcon icon = new ImageIcon("C:\\Users\\503-25\\Desktop\\�ڿ�\\�̹���\\" + images[idx%images.length]);
						label.setIcon(icon);*/
						
						Thread.sleep(1000);
						// ����Ʈ�� ������ ��� ������ �������� �ؿ� �ڵ�ó�� ���
						ImageIcon icon = new ImageIcon("C:\\Users\\503-25\\Desktop\\�ڿ�\\�̹���\\" + list.get(idx%list.size()));
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
