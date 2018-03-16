package StudentManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//添加课程信息
public class addClasses extends JFrame implements ActionListener {
	Statement ps;
	JLabel jLabel1 = new JLabel();
	JTextField classesnum = new JTextField();
	JLabel jLabel2 = new JLabel();
	JTextField classesname = new JTextField();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTextPane discript = new JTextPane();
	JComboBox kind = new JComboBox();
	JButton ok = new JButton();
	JButton cancel = new JButton();

	public addClasses() {
		this.setResizable(false);
		this.setTitle("添加课程信息");
		this.setLayout(null);
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel1.setText("课程编号");
		jLabel1.setBounds(new Rectangle(20, 30, 80, 30));
				
		jLabel3.setBounds(new Rectangle(20, 80, 80, 30));
		jLabel3.setText("课程类型");
		jLabel3.setFont(new java.awt.Font("Dialog", 0,20));
		
		jLabel2.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel2.setText("课程名称");
		jLabel2.setBounds(new Rectangle(20, 130, 80, 30));
		
		jLabel4.setBounds(new Rectangle(320, 30, 90, 30));
		jLabel4.setText("课程描述:");
		jLabel4.setFont(new java.awt.Font("Dialog", 0, 20));
		
		classesnum.setFont(new java.awt.Font("Dialog", 0, 20));
		classesnum.setText("");
		classesnum.setBounds(new Rectangle(120, 30, 120, 30));
						
		kind.setFont(new java.awt.Font("Dialog", 0, 20));
		kind.setBounds(new Rectangle(120, 80, 120, 30));			
		jScrollPane1.setBounds(new Rectangle(320, 70, 111, 100));
		
		kind.addItem("必修");
		kind.addItem("限选");
		kind.addItem("任选");		
		kind.setFont(new java.awt.Font("Dialog", 0, 20));
		kind.setBounds(new Rectangle(120, 80, 120, 30));
		
		classesname.setFont(new java.awt.Font("Dialog", 0, 20));
		classesname.setText("");
		classesname.setBounds(new Rectangle(120, 130, 120, 30));
		
		ok.setBounds(new Rectangle(120, 250, 80, 30));
		ok.setFont(new java.awt.Font("Dialog", 0, 20));
		ok.setText("确定");
		ok.addActionListener(this);
		cancel.setText("取消 ");
		cancel.addActionListener(this);
		cancel.setFont(new java.awt.Font("Dialog", 0, 20));
		cancel.setBounds(new Rectangle(300, 250, 80, 30));
		this.add(jLabel1);
		this.add(classesnum);
		this.add(jLabel2);
		this.add(classesname);
		this.add(jLabel3);
		this.add(kind);
		this.add(jLabel4);
		this.add(jScrollPane1);
		this.add(ok);
		this.add(kind);
		jScrollPane1.getViewport().add(discript);
		this.add(cancel);
		this.setBounds(450, 200, 500, 400);
		this.setVisible(true);
	}


	public static void main(String[] args) {
		new addClasses();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok){
			if(classesnum.getText().equals("")){
				 JOptionPane.showMessageDialog(this, "请填写课程编号！");
				 classesnum.requestFocus();
			}
			else if(classesname.getText().equals("")){
				JOptionPane.showMessageDialog(this, "请填写课程名称！");
				classesname.requestFocus();
			}
			else{
			JOptionPane.showConfirmDialog(null, "确定添加？", "添加课程",
					JOptionPane.YES_NO_OPTION);
			try {
				
					 Connection con=null;
					 Database.joinDB(); con=Database.cn;
					ps = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, "连接数据库错误!");
				}
				try {
					ps.executeUpdate("Insert Into course Values('"
							+ classesnum.getText().trim() + "','" + classesname.getText().trim()
							+ "','" + kind.getSelectedItem().toString() + "','"
							+ discript.getText().trim() + "')");
					JOptionPane.showMessageDialog(null, "添加成功");
				} catch (SQLException sqle) {
					String error = sqle.getMessage();
					JOptionPane.showMessageDialog(null, error);
					sqle.printStackTrace();
				}
			}
		}
		if(e.getSource()==cancel){
			this.dispose();
		}
		
	}
}