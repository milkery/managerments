package StudentManager;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

//����
public class about extends JDialog {
	JLabel jLabel1 = new JLabel();
	JButton sure = new JButton();

	public about(Frame frame, String title, boolean modal) {
		super(frame, title, true);
		try {
			jbInit();
			pack();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public about() {
		this(null, "", true);
	}
	public static void main(String[] args) {
		new about();
	}
	private void jbInit() throws Exception {
		jLabel1.setBounds(new Rectangle(5, 0, 280, 180));
		jLabel1.setText("<html>����ϵͳ��Ҫ����֤��ӡ�ɾ������ѯ���ܣ��Թ���ѧ����ѧ֪ʶ����Ȼ����ϵͳ����һ�˲���"
				+"<p>���ƣ������ָ�̣�лл��"
				+"<p>"
				+"<p>Ĭ�Ϲ���Ա��Ϊ��admin,���룺123����ʦ��Ϊ��teachar�����룺123  ѧ����Ϊ��student,���룺123");// ������Ϣ����
		sure.setBounds(new Rectangle(80, 200, 80, 30));
		sure.setFont(new java.awt.Font("Dialog", 0, 15));
		sure.setText("ȷ��");
		sure.addActionListener(new about_sure_actionAdapter(this));
		this.setTitle("������Ϣ");
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(sure, null);
		this.setBounds(480, 250, 300, 320);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}

	void sure_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}

class about_sure_actionAdapter implements java.awt.event.ActionListener {
	about adaptee;

	about_sure_actionAdapter(about adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.sure_actionPerformed(e);
	}
	
}
