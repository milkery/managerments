package StudentManager;

import java.awt.*;
import javax.swing.*;



import java.awt.event.*;
import java.sql.*;

//添加用户
public class addUser extends JDialog implements ActionListener{
	Statement ps;
	ResultSet rs;
	 Connection con;
	JPanel panel1 = new JPanel();
	JLabel jLabel1 = new JLabel();
	JTextField username = new JTextField();
	JLabel jLabel2 = new JLabel();
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();
	JLabel jLabel3 = new JLabel();
	JPasswordField pwd = new JPasswordField();
	JPasswordField pwd1 = new JPasswordField();
	JComboBox power = new JComboBox();
	JLabel jLabel4 = new JLabel();
	public addUser(){
		panel1.setLayout(null);
		this.setLayout(null);
		panel1.setBounds(new Rectangle(10, 10, 452, 369));

		jLabel1.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel1.setText("请输入用户名");
		jLabel1.setBounds(new Rectangle(5, 10, 120, 35));

		jLabel2.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel2.setText("请输入密码");
		jLabel2.setBounds(new Rectangle(5, 60, 120, 35));

		jLabel3.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel3.setText("再次输入密码");
		jLabel3.setBounds(new Rectangle(5, 110, 120, 35));

		jLabel4.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel4.setText("请选择权限");
		jLabel4.setBounds(new Rectangle(5, 160, 120, 35));

		jb1.setBounds(new Rectangle(40, 200, 90, 35));
		jb1.setFont(new java.awt.Font("Dialog", 0,20));
		jb1.setText("确  定");
		jb1.addActionListener(this);

		jb2.setBounds(new Rectangle(150, 200, 90, 35));
		jb2.setFont(new java.awt.Font("Dialog", 0, 20));
		jb2.setText("取  消");
		jb2.addActionListener(this);

		this.setTitle("添加用户");
		username.setBounds(new Rectangle(140, 10, 120, 30));
		pwd.setBounds(new Rectangle(140, 60, 120, 30));
		pwd1.setBounds(new Rectangle(140, 110, 120, 30));
		power.setBounds(new Rectangle(140, 160, 120, 30));

		add(panel1);
		panel1.add(jLabel1);
		panel1.add(jb1);
		panel1.add(jb2);
		panel1.add(jLabel3);
		panel1.add(jLabel2);
		panel1.add(pwd);
		panel1.add(pwd1);
		panel1.add(username);
		power.addItem("管理员");
		power.addItem("老师");
		power.addItem("学生");
         if(dl.xuanqian.equals("老师")){
			power.removeItem("管理员");
		}
		panel1.add(power);
		panel1.add(jLabel4);

		this.setBounds(480, 250,330, 300);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
//		 TODO 自动生成方法存根
		if(e.getSource()==jb1){
			if(username.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "用户名不能为空！");
			}
			if(pwd.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "密码不能为空！");
			}
			else if(!pwd.getText().trim().equals(pwd1.getText().trim())){
				JOptionPane.showMessageDialog(null, "两次密码不一致！请重新输入");
			}
			else{
				int choose=JOptionPane.showConfirmDialog(null, "确定添加用户吗？", "提示", JOptionPane.YES_OPTION);
				if(choose==0){
					try {
						 Connection con=null;
						 Database.joinDB(); con=Database.cn;
						ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ps.executeUpdate("Insert Into uster Values('"
							+ username.getText().trim() + "','"
							+ pwd.getText().trim() + "','"
							+ power.getSelectedItem().toString().trim() + "')");
						JOptionPane.showMessageDialog(null, "添加成功");
						this.dispose();
					} catch (Exception err) {
					}
					finally{
						if(con!=null){
							try {
								con.close();
							} catch (SQLException e2) {
								// TODO 自动生成 catch 块
								e2.printStackTrace();
							}
						}
					}
				}
					else{	
						
		         }
				}
		}
		else if(e.getSource()==jb2){
			this.dispose();
		}
	}
	public static void main(String[] args) {
		new addUser();
	}
	}
