package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//添加学籍信息
public class addRegister extends JDialog implements ActionListener {
	Statement ps;
	ResultSet rs;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JLabel jLabel9 = new JLabel();
	JTextField studentID = new JTextField();
	JComboBox sex = new JComboBox();
	JTextField name = new JTextField();
	JTextField schooltime = new JTextField();
	JTextField borntime = new JTextField();
	JTextField tel = new JTextField();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTextPane address = new JTextPane();
	JScrollPane jScrollPane2 = new JScrollPane();
	JTextPane comment = new JTextPane();
	JButton sure = new JButton();
	JButton cancel = new JButton();
	JComboBox jComboBox1 = new JComboBox();
	JComboBox classnumber = new JComboBox();
	public addRegister() {
		this.setForeground(Color.black);
		this.setResizable(false);
		//this.setState(Frame.NORMAL);
		this.setTitle("添加学生学籍信息");
		this.setLayout(null);

		jLabel1.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel1.setText("学    号");
		jLabel1.setBounds(new Rectangle(30, 30, 65, 44));

		jLabel2.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel2.setText("性    别");
		jLabel2.setBounds(new Rectangle(30, 75, 65, 44));

		jLabel3.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel3.setText("班    别");
		jLabel3.setBounds(new Rectangle(30, 120, 65, 44));

		jLabel4.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel4.setText("民   族");
		jLabel4.setBounds(new Rectangle(30, 165, 65, 44));

		jLabel5.setFont(new java.awt.Font("Dialog", 0, 20));
		jLabel5.setText("备    注");
		jLabel5.setBounds(new Rectangle(30, 210, 65, 44));

		jLabel6.setBounds(new Rectangle(300, 35, 65, 44));
		jLabel6.setText("姓    名");
		jLabel6.setFont(new java.awt.Font("Dialog", 0, 20));

		jLabel7.setBounds(new Rectangle(300, 75, 90, 44));
		jLabel7.setText("出生日期");
		jLabel7.setFont(new java.awt.Font("Dialog", 0, 20));

		jLabel8.setBounds(new Rectangle(300, 120, 90, 44));
		jLabel8.setText("联系电话");
		jLabel8.setFont(new java.awt.Font("Dialog", 0, 20));

		jLabel9.setBounds(new Rectangle(300, 165, 90, 44));
		jLabel9.setText("家庭住址");
		jLabel9.setFont(new java.awt.Font("Dialog", 0, 20));

		studentID.setBounds(new Rectangle(120, 35, 150, 30));
		studentID.setFont(new java.awt.Font("Dialog", 0, 20));

		sex.setFont(new java.awt.Font("Dialog", 0, 20));
		sex.setBounds(new Rectangle(120, 80, 150, 30));

		classnumber.setBounds(new Rectangle(120, 125, 150, 30));

		schooltime.setBounds(new Rectangle(120, 170, 150, 30));
		schooltime.setText("");
		schooltime.setFont(new java.awt.Font("Dialog", 0, 20));

		jScrollPane2.setBounds(new Rectangle(120, 220, 150, 99));
		comment.setText("");
		comment.setFont(new java.awt.Font("Dialog", 0, 20));

		name.setBounds(new Rectangle(390, 35, 150, 30));
		name.setText("");
		name.setFont(new java.awt.Font("Dialog", 0, 20));

		borntime.setBounds(new Rectangle(390, 80, 150, 30));
		borntime.setText("");
		borntime.setFont(new java.awt.Font("Dialog", 0, 20));

		tel.setBounds(new Rectangle(390, 125, 150, 30));
		tel.setText("");
		tel.setFont(new java.awt.Font("Dialog", 0, 20));

		jScrollPane1.setBounds(new Rectangle(390, 170, 150, 30));
		address.setFont(new java.awt.Font("Dialog", 0,20));
		address.setText("");

		sure.setBounds(new Rectangle(145, 350, 120, 33));
		sure.setFont(new java.awt.Font("Dialog", 0, 20));
		sure.setText("确   定");
		sure.addActionListener(this);

		cancel.setBounds(new Rectangle(340, 350, 120, 33));
		cancel.setFont(new java.awt.Font("Dialog", 0, 20));
		cancel.setText("取  消");
		cancel.addActionListener(this);

		this.add(jLabel1);
		this.add(jLabel3);
		this.add(jLabel2);
		this.add(jLabel5);
		this.add(jLabel4);
		this.add(studentID);
		this.add(sex, null);
		this.add(schooltime);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(address);
		this.add(jScrollPane2);
		jScrollPane2.getViewport().add(comment);
		this.add(sure);
		this.add(cancel);
		this.add(tel);
		this.add(borntime);
		this.add(name);
		this.add(jLabel7);
		this.add(jLabel6);
		this.add(jLabel8);
		this.add(jLabel9);
		this.add(classnumber);
		this.setBounds(450, 180, 600, 450);
		sex.addItem("男");
		sex.addItem("女");
		this.setVisible(true);
		try {
			 Connection con=null;
			 Database.joinDB(); con=Database.cn;

			ps = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery("select * from student");
			while (rs.next()) {
				classnumber.addItem(rs.getString("班级名称"));
			}
		} catch (Exception err) {
			String error = err.getMessage();
			JOptionPane.showMessageDialog(null, "连接数据库错误!");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sure){
			if(studentID.getText().equals("")||name.getText().equals("")){
				JOptionPane.showMessageDialog(this, "你输入的信息有空项，请填写完整必要的信息！");
			}
			else{
		JOptionPane.showConfirmDialog(null, "确定添加？", "添加学籍",
				JOptionPane.YES_NO_OPTION);
		try {
			try {
				ps.executeUpdate("Insert Into  student Values('"
						+ studentID.getText().trim() + "','"
						+ name.getText().trim() + "','"
						+ sex.getSelectedItem().toString() + "','"
						+ borntime.getText().trim() + "','"
						+ classnumber.getSelectedItem() + "','"
						+ tel.getText().trim() + "','"
						+ schooltime.getText().trim() + "','"
						+ address.getText().trim() + "','"
						+ comment.getText().trim() + "')");
				JOptionPane.showMessageDialog(null, "添加学籍成功");
				this.dispose();
			} catch (SQLException sqle) {
				String error = sqle.getMessage();
				JOptionPane.showMessageDialog(null, error);
				sqle.printStackTrace();

			}
		} catch (Exception ex) {
			ex.getMessage();
			String error = ex.getMessage();
			JOptionPane.showMessageDialog(null, error);
			ex.printStackTrace();
		}
			}
	}
		else if(e.getSource()==cancel){
			this.dispose();
		}
	}

	public static void main(String[] args) {
		new addRegister();
	}
}