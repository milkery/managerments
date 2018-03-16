package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//��ӳɼ���Ϣ
public class addScore extends JFrame implements ActionListener{
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JComboBox examnum = new JComboBox();
	JComboBox number = new JComboBox();
	JComboBox classnum = new JComboBox();
	JTextField name = new JTextField();
	JComboBox classes = new JComboBox();
	JTextField mark = new JTextField();
	JButton ok = new JButton();
	JButton ocancel = new JButton();
	Statement ps, is, kcs, cr, xms;
	ResultSet rs, as, xzkc, xsxm;

	public addScore() {
		this.setLocale(java.util.Locale.getDefault());
		this.setResizable(false);
		this.setState(Frame.NORMAL);
		this.setTitle("��ӳɼ���Ϣ");
		this.setLayout(null);

		jLabel1.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel1.setText("���Ա��");
		jLabel1.setBounds(new Rectangle(10, 10,90, 30));

		jLabel2.setBounds(new Rectangle(255, 10, 90, 30));
		jLabel2.setText("ѡ����");
		jLabel2.setFont(new java.awt.Font("Dialog", 0,20));

		jLabel3.setBounds(new Rectangle(10, 55, 90, 30));
		jLabel3.setText("ѡ��ѧ��");
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 20));

		jLabel4.setBounds(new Rectangle(255, 55, 90, 30));
		jLabel4.setText("��      ��");
		jLabel4.setFont(new java.awt.Font("Dialog", 0, 20));

		jLabel5.setBounds(new Rectangle(255, 100, 90, 30));
		jLabel5.setText("�������");
		jLabel5.setFont(new java.awt.Font("Dialog", 0,20));

		jLabel6.setBounds(new Rectangle(10, 100, 90, 30));
		jLabel6.setText("ѡ��γ�");
		jLabel6.setFont(new java.awt.Font("Dialog", 0, 20));

		examnum.setFont(new java.awt.Font("Dialog", 0, 20));
		examnum.setBounds(new Rectangle(115, 10, 120, 30));
		examnum.addItem("����");
		examnum.addItem("��ĩ");

		number.setFont(new java.awt.Font("Dialog", 0, 20));
		number.setBounds(new Rectangle(115, 60, 120, 30));
		number.addActionListener(this);

		classes.setFont(new java.awt.Font("Dialog", 0, 15));
		classes.setBounds(new Rectangle(115,110, 120, 30));
	

		classnum.setFont(new java.awt.Font("Dialog", 0, 20));
		classnum.setBounds(new Rectangle(360, 10, 100, 30));
		classnum.addActionListener(this);

		name.setText("");
		name.setFont(new java.awt.Font("Dialog", 0, 20));
		name.setBounds(new Rectangle(360, 60, 100, 30));

		mark.setText("");
		mark.setFont(new java.awt.Font("Dialog", 0, 20));
		mark.setBounds(new Rectangle(360, 110, 100, 30));

		ok.setBounds(new Rectangle(115,180, 100, 30));
		ok.setFont(new java.awt.Font("Dialog", 0, 20));
		ok.setText("ȷ   ��");
		ok.addActionListener(this);

		ocancel.setText("��  ��");
		ocancel.addActionListener(this);
		ocancel.setBounds(new Rectangle(280, 180, 100, 30));
		ocancel.setFont(new java.awt.Font("Dialog", 0, 20));

		this.add(jLabel1);
		this.add(examnum);
		this.add(jLabel3);
		this.add(jLabel6);
		this.add(classes);
		this.add(name);
		this.add(classnum);
		this.add(mark);
		this.add(jLabel5);
		this.add(jLabel4);
		this.add(jLabel2);
		this.add(number);
		this.add(ocancel);
		this.add(ok);
		this.setBounds(450, 250, 500, 300);
		this.setVisible(true);
		/** **************JDBC-ODBC�������ݿ�,����ȡ���ݿ�************ */
		try {
			 Connection con=null;
			 Database.joinDB(); con=Database.cn;
			ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			is = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			kcs = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			cr = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			xms = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		} catch (Exception err) {
			String error = err.getMessage();
			JOptionPane.showMessageDialog(null, "�������ݿ����!");
		}
		try {
			rs = ps.executeQuery("select distinct �༶���� from student ");
			while (rs.next()) {
				classnum.addItem(rs.getString("�༶����"));
			}
				xzkc = kcs.executeQuery("select  distinct �γ����� from gradecourse ");
				while (xzkc.next()) {
					classes.addItem(xzkc.getString("�γ�����"));
			}
			
		} catch (Exception err) {
			String error = err.getMessage();
		}
	}

	public static void main(String[] args) {
		new addScore();
	}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==ok){
		int y=JOptionPane.showConfirmDialog(null, "ȷ����ӣ�", "��ӳɼ�",
				JOptionPane.YES_NO_OPTION);
		if(y==0){
		try {
			cr.executeUpdate("Insert Into score Values('"
					+ examnum.getSelectedItem().toString() + "','"
					+ classnum.getSelectedItem().toString() + "','"
					+ number.getSelectedItem().toString() + "','"
					+ name.getText().trim() + "','"
					+ classes.getSelectedItem().toString() + "','"
					+ mark.getText().trim() + "')");
			JOptionPane.showMessageDialog(null, "����ɼ��ɹ���");
			mark.setText("");
		}

		catch (Exception err) {
			err.printStackTrace();
			String error = err.getMessage();
			JOptionPane.showMessageDialog(null, error);
		}
		}
	}
    if(e.getSource()==ocancel){
		this.dispose();
	}
    if(e.getSource()==number){
		name.setText("");
		try {
			xsxm = xms.executeQuery("select ���� from student where �༶����='"
							+ classnum.getSelectedItem().toString().trim()
							+ "'and ѧ��='"
							+ number.getSelectedItem().toString().trim() + "'");
			while (xsxm.next()) {
				name.setText(xsxm.getString("����"));
			}
		} catch (Exception err) {
			err.printStackTrace();
			String error = err.getMessage();
		}
	}
	if(e.getSource()==classnum){
		try {
			number.removeAllItems();
			as = is.executeQuery("select ѧ�� from student where �༶����='"
							+ classnum.getSelectedItem() + "'");
			while (as.next()) {
				number.addItem(as.getString("ѧ��"));
			}
		} catch (Exception err) {
			err.printStackTrace();
			String error = err.getMessage();
		}
	}
}
}