package StudentManager;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//修改密码
public class modefyPassword extends JDialog implements ActionListener {
	Statement ps;
	ResultSet rs;
	JPanel panel1 = new JPanel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();
	JPasswordField pwd = new JPasswordField();
	JLabel jLabel3 = new JLabel();
	JPasswordField pwd1 = new JPasswordField();
    public modefyPassword() {
    	this.setTitle("修改密码");
		panel1.setLayout(null);
		this.setModal(true);
		this.setLayout(null);
		panel1.setBounds(new Rectangle(-5, 0, 400, 300));
        
		jLabel4.setText(dl.yonghuming);
		jLabel4.setBounds(new Rectangle(130, 28, 130, 30));

		jLabel1.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel1.setText("用户名:");
		jLabel1.setBounds(new Rectangle(30, 30, 80, 30));

		jLabel2.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel2.setText("输入新密码");
		jLabel2.setBounds(new Rectangle(30, 70,100, 30));

		jLabel3.setBounds(new Rectangle(30, 110, 80, 30));
		jLabel3.setText("再次输入");
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 20));

		jb1.setBounds(new Rectangle(50, 170, 80, 30));
		jb1.setFont(new java.awt.Font("Dialog", 0, 20));
		jb1.setText("确定");
		jb1.addActionListener(this);

		jb2.setBounds(new Rectangle(150, 170, 80, 30));
		jb2.setFont(new java.awt.Font("Dialog", 0, 20));
		jb2.setText("重填");
		jb2.addActionListener(this);

		pwd.setText("");
		pwd.setBounds(new Rectangle(130, 70, 130, 30));

		pwd1.setBounds(new Rectangle(130, 110, 130, 30));
		pwd1.setText("");
		this.add(panel1);
		panel1.add(jLabel4);
		panel1.add(jLabel1);
		panel1.add(jLabel2);
		panel1.add(pwd);
		panel1.add(pwd1);
		panel1.add(jb2);
		panel1.add(jb1);
		panel1.add(jLabel3);
		this.setBounds(480, 250, 300, 250);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成方法存根
		if(e.getSource()==jb1){
			if(pwd1.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "密码不能为空！");
			}
			else if(!pwd.getText().trim().equals(pwd1.getText().trim())){
				JOptionPane.showMessageDialog(null, "两次密码不一致！请重新输入");
			}
			else{
				int choose=JOptionPane.showConfirmDialog(null, "确定修改修改密码", "提示", JOptionPane.YES_OPTION);
				if(choose==0){
					try {
						 Connection con=null ;
						 con=Database.cn;;
						 Database.joinDB();
						ps = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						ps.executeUpdate("Update uster set 密码='"
								+ pwd.getText().trim() + "' where 用户名='"
								+ dl.yonghuming + "'");
						JOptionPane.showMessageDialog(null, "修改成功");
						this.dispose();
					} catch (Exception err) {
					}
				}
					else{	
						
		         }
				}
		}
		else if(e.getSource()==jb2){
			pwd.setText("");
			pwd1.setText("");
		}
	}
}

