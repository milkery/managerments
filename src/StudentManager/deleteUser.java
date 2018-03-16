package StudentManager;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class deleteUser extends JDialog implements ActionListener{
	Statement ps;
	ResultSet rs;
	JPanel panel1 = new JPanel();
	JLabel jLabel1 = new JLabel();
	JTextField username = new JTextField();
	JLabel jLabel2 = new JLabel();
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();
	JLabel jLabel4 = new JLabel();
	Connection con;
	public deleteUser(){
		panel1.setLayout(null);
		this.setLayout(null);
		panel1.setBounds(new Rectangle(10, 10, 452, 369));
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel1.setText("请输入要删除的用户名：");
		jLabel1.setBounds(new Rectangle(20, 20, 200, 35));
		username.setBounds(new Rectangle(60, 80, 160, 25));
		jb1.setBounds(new Rectangle(40, 180, 90, 35));
		jb1.setFont(new java.awt.Font("Dialog", 0, 20));
		jb1.setText("确  定");
		jb1.addActionListener(this);
		jb2.setBounds(new Rectangle(150, 180, 90, 35));
		jb2.setFont(new java.awt.Font("Dialog", 0, 20));
		jb2.setText("取 消");
		jb2.addActionListener(this);
		this.setTitle("删除用户");
		add(panel1);
		panel1.add(jLabel1);
		panel1.add(jb1);
		panel1.add(jb2);
		panel1.add(jLabel2);
		panel1.add(username);
		panel1.add(jLabel4);
		this.setBounds(480, 250, 300, 300);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			if (username.getText()!= null) {
				int choose=JOptionPane.showConfirmDialog(null, "确定要删除此用户吗？", "提示", JOptionPane.YES_OPTION);
				if(choose==0){
					try {
						 Database.joinDB(); con=Database.cn;
						ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ps.executeUpdate("Delete from uster where 用户名 ='"+ username.getText().trim() + "'");
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, err);
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
						JOptionPane.showMessageDialog(null, "删除成功");
						this.dispose();
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
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){}
	     new deleteUser();	
	}
}