package StudentManager;

import java.awt.*;
import javax.swing.*;



import java.awt.event.*;
import java.sql.*;

//����û�
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
		jLabel1.setText("�������û���");
		jLabel1.setBounds(new Rectangle(5, 10, 120, 35));

		jLabel2.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel2.setText("����������");
		jLabel2.setBounds(new Rectangle(5, 60, 120, 35));

		jLabel3.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel3.setText("�ٴ���������");
		jLabel3.setBounds(new Rectangle(5, 110, 120, 35));

		jLabel4.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel4.setText("��ѡ��Ȩ��");
		jLabel4.setBounds(new Rectangle(5, 160, 120, 35));

		jb1.setBounds(new Rectangle(40, 200, 90, 35));
		jb1.setFont(new java.awt.Font("Dialog", 0,20));
		jb1.setText("ȷ  ��");
		jb1.addActionListener(this);

		jb2.setBounds(new Rectangle(150, 200, 90, 35));
		jb2.setFont(new java.awt.Font("Dialog", 0, 20));
		jb2.setText("ȡ  ��");
		jb2.addActionListener(this);

		this.setTitle("����û�");
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
		power.addItem("����Ա");
		power.addItem("��ʦ");
		power.addItem("ѧ��");
         if(dl.xuanqian.equals("��ʦ")){
			power.removeItem("����Ա");
		}
		panel1.add(power);
		panel1.add(jLabel4);

		this.setBounds(480, 250,330, 300);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
//		 TODO �Զ����ɷ������
		if(e.getSource()==jb1){
			if(username.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			}
			if(pwd.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			}
			else if(!pwd.getText().trim().equals(pwd1.getText().trim())){
				JOptionPane.showMessageDialog(null, "�������벻һ�£�����������");
			}
			else{
				int choose=JOptionPane.showConfirmDialog(null, "ȷ������û���", "��ʾ", JOptionPane.YES_OPTION);
				if(choose==0){
					try {
						 Connection con=null;
						 Database.joinDB(); con=Database.cn;
						ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ps.executeUpdate("Insert Into uster Values('"
							+ username.getText().trim() + "','"
							+ pwd.getText().trim() + "','"
							+ power.getSelectedItem().toString().trim() + "')");
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
						this.dispose();
					} catch (Exception err) {
					}
					finally{
						if(con!=null){
							try {
								con.close();
							} catch (SQLException e2) {
								// TODO �Զ����� catch ��
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
