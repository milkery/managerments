package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//��Ӱ༶��Ϣ
public class addClass extends JFrame implements ActionListener{
	Statement ps;
	ResultSet rs;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JTextField classnumber = new JTextField();
	JTextField teacher = new JTextField();
	JTextField grade = new JTextField();
	JButton sure = new JButton();
	JButton cancel = new JButton();
	JTextField classroom = new JTextField();

	public addClass() {
		this.setLayout(null);
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel1.setText("�༶���");
		jLabel1.setBounds(new Rectangle(50, 30, 80, 30));

		jLabel2.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel2.setText("�༶����");
		jLabel2.setBounds(new Rectangle(50, 70, 80, 30));

		jLabel3.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel3.setText("רҵ���");
		jLabel3.setBounds(new Rectangle(50, 110, 80, 30));

		jLabel4.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel4.setText("��ʦ����");
		jLabel4.setBounds(new Rectangle(50, 150, 80, 30));

		sure.setBounds(new Rectangle(80, 210, 100, 30));
		sure.setFont(new java.awt.Font("Dialog", 0, 20));
		sure.setText("ȷ��");
		sure.addActionListener(this);
		cancel.setBounds(new Rectangle(220, 210, 100, 30));
		cancel.setFont(new java.awt.Font("Dialog", 0, 20));
		cancel.setText("ȡ  ��");
		cancel.addActionListener(this);
		
		classnumber.setBounds(new Rectangle(180, 30, 110, 30));
		classnumber.setEditable(true);

		teacher.setBounds(new Rectangle(180, 70, 110, 30));
		teacher.setEditable(true);

		grade.setBounds(new Rectangle(180, 110, 110, 30));
		grade.setEditable(true);

		classroom.setBounds(new Rectangle(180, 150, 110, 30));
		classroom.setEditable(true);
		this.setResizable(false);
		this.setTitle("��Ӱ༶��Ϣ");
		this.add(teacher);
		this.add(grade);
		this.add(jLabel4);
		this.add(jLabel3);
		this.add(jLabel2);
		this.add(jLabel1);
		this.add(classroom);
		this.add(classnumber);
		this.add(sure);
		this.add(cancel);
		this.setBounds(500, 200, 420, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new addClass();
	}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==sure){
		JOptionPane.showConfirmDialog(null, "ȷ����ӣ�", "���ѧ��",
				JOptionPane.YES_NO_OPTION);
		try {
			 Connection con=null;
			 Database.joinDB(); con=Database.cn;
				ps = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ps.executeUpdate("Insert Into  class Values('"
						+ classnumber.getText().trim() + "','"
						+ teacher.getText().trim() + "','"
						+ grade.getText().trim()+ "','"
						+ classroom.getText().trim() + "')");
				ps.close();
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
				this.dispose();
			} catch (SQLException sqle) {
				String error = sqle.getMessage();
				JOptionPane.showMessageDialog(null, error);
				sqle.printStackTrace();
			}
	}
	else
		this.dispose();
	
}
}
