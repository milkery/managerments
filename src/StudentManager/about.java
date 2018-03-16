package StudentManager;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

//关于
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
		jLabel1.setText("<html>做此系统主要是验证添加、删除、查询功能，以巩固学生所学知识！当然，此系统还有一此不够"
				+"<p>完善，望多多指教！谢谢！"
				+"<p>"
				+"<p>默认管理员号为：admin,密码：123，老师号为：teachar，密码：123  学生号为：student,密码：123");// 帮助信息内容
		sure.setBounds(new Rectangle(80, 200, 80, 30));
		sure.setFont(new java.awt.Font("Dialog", 0, 15));
		sure.setText("确定");
		sure.addActionListener(new about_sure_actionAdapter(this));
		this.setTitle("帮助信息");
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
