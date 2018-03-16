package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//修改成绩信息
public class modefyScore extends JFrame implements ActionListener{
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JButton modefycount = new JButton();
	JButton updatecount = new JButton();
	JButton deletecount = new JButton();
	JButton cencel = new JButton();
	JLabel jLabel5 = new JLabel();
	JComboBox number = new JComboBox();
	JComboBox examnumber = new JComboBox();
	JComboBox classnumber = new JComboBox();
	JLabel jLabel6 = new JLabel();
	JComboBox classes = new JComboBox();
	JLabel jLabel7 = new JLabel();
	JTextField name = new JTextField();
	JTextField mark = new JTextField();
	Statement ps, is, cr, xms, classnumbers, ins, classess;
	ResultSet rs, as, xsxm, classnumberss, classesss;
	JLabel jLabel8 = new JLabel();
	public modefyScore() {
		this.setForeground(Color.black);
		this.setResizable(false);
		this.setState(Frame.NORMAL);
		this.setTitle("查改删成绩信息");
		this.setLayout(null);
		
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel1.setText("考试编号");
		jLabel1.setBounds(new Rectangle(30, 60, 65, 30));
		
		jLabel2.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel2.setText("选择学号");
		jLabel2.setBounds(new Rectangle(30, 100, 65, 30));
		
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel3.setText("选择班号");
		jLabel3.setBounds(new Rectangle(250, 60, 65, 30));
		
		jLabel4.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel4.setText("姓        名");
		jLabel4.setBounds(new Rectangle(250, 100, 65, 30));
		
		jLabel5.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel5.setText("修改成绩信息");
		jLabel5.setBounds(new Rectangle(30, 180, 130, 30));
		
		jLabel6.setBounds(new Rectangle(30, 140, 65, 30));
		jLabel6.setText("选择课程");
		jLabel6.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jLabel7.setBounds(new Rectangle(250, 140, 65, 30));
		jLabel7.setText("分        数");
		jLabel7.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jLabel8.setBounds(new Rectangle(30, 10, 100, 30));
		jLabel8.setText("查看成绩信息");
		jLabel8.setFont(new java.awt.Font("Dialog", 0, 15));
		
		modefycount.setText("修改数据");
		modefycount.addActionListener(this);
		modefycount.setBounds(new Rectangle(30, 230, 95, 30));
		modefycount.setFont(new java.awt.Font("Dialog", 0, 15));
		
		updatecount.setText("更新数据");
		updatecount.addActionListener(this);
		updatecount.setBounds(new Rectangle(140, 230, 95, 30));
		updatecount.setFont(new java.awt.Font("Dialog", 0, 15));
		
		deletecount.setText("删除记录");
		deletecount.addActionListener(this);
		deletecount.setBounds(new Rectangle(250, 230, 95, 30));
		deletecount.setFont(new java.awt.Font("Dialog", 0, 15));
		
		cencel.setText("退  出");
		cencel.addActionListener(this);
		cencel.setBounds(new Rectangle(360, 230, 95, 30));
		cencel.setFont(new java.awt.Font("Dialog", 0, 15));
		
		examnumber.setBounds(new Rectangle(100, 60, 130, 30));
		examnumber.addActionListener(this);
		
		classnumber.setBounds(new Rectangle(320, 60, 130, 30));
		classnumber.addActionListener(this);
		
		number.setBounds(new Rectangle(100, 100, 130, 30));
		number.addActionListener(this);
		
		name.setFont(new java.awt.Font("Dialog", 0, 15));
		name.setText("");
		name.setBounds(new Rectangle(320, 100, 130, 30));
		name.setEditable(false);
		
		classes.setBounds(new Rectangle(100, 140, 130, 30));
		classes.addActionListener(this);
		
		mark.setBounds(new Rectangle(320, 140, 130, 30));
		mark.setFont(new java.awt.Font("Dialog", 0, 15));
		mark.setText("");
		
		this.add(modefycount);
		this.add(updatecount);
		this.add(jLabel5);
		this.add(cencel);
		this.add(deletecount);
		this.add(jLabel1);
		this.add(jLabel3);
		this.add(number);
		this.add(jLabel4);
		this.add(examnumber);
		this.add(classnumber);
		this.add(classes);
		this.add(jLabel7);
		this.add(name);
		this.add(mark);
		this.add(jLabel6);
		this.add(jLabel2);
		this.add(jLabel8);
		this.setBounds(400, 185, 500, 400);
		this.setVisible(true);
		
		try { // 连接数据库
			Connection con=null;
			 Database.joinDB(); con=Database.cn;
			ps = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			classnumbers = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			xms = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			is = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ins = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			classess = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery("select distinct 考试编号 from score");
			while (rs.next()) {
				examnumber.addItem(rs.getString("考试编号"));
			}
		} catch (Exception err) {
			err.printStackTrace(System.out);
		}
	}

	public static void main(String[] args) {
		new modefyScore();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==modefycount){
			int v=JOptionPane.showConfirmDialog(null, "确定修改", "修改成绩",
					JOptionPane.YES_NO_OPTION);
			if(v==0){
			try {
				ins.executeUpdate("Update score set 成绩='"
						+ mark.getText().trim() + "' where 考试编号='"
						+ examnumber.getSelectedItem() + "'and 学号='"
						+ number.getSelectedItem() + "'and 班级编号='"
						+ classnumber.getSelectedItem() + "'");
				JOptionPane.showMessageDialog(null, "修改成功!");
				try {
					examnumber.removeAllItems();
					rs = ps.executeQuery("select distinct 考试编号 from score");
					if (rs.next()) {
						examnumber.addItem(rs.getString("考试编号"));
					}
				} catch (Exception err) {
					err.printStackTrace(System.out);
				}
			} catch (SQLException ex) {
				String err = ex.getMessage();
			}
			}
		}
		if(e.getSource()==updatecount){
			JOptionPane.showMessageDialog(null, "数据已更新");
			try {
				examnumber.removeAllItems();
				rs = ps.executeQuery("select distinct 考试编号 from score");
				if (rs.next()) {
					examnumber.addItem(rs.getString("考试编号"));
				}
			} catch (Exception err) {
				err.printStackTrace(System.out);
			}
		}
		if(e.getSource()==deletecount){
			int v=JOptionPane.showConfirmDialog(null, "确定删除！", "删除成绩",
					JOptionPane.YES_NO_OPTION);
			if(v==0){
			try {
				ins.executeUpdate("delete from score  where 考试编号='"
						+ examnumber.getSelectedItem().toString().trim()
						+ "'and 学号='"
						+ number.getSelectedItem().toString().trim()
						+ "'and 班级编号='"
						+ classnumber.getSelectedItem().toString().trim()
						+ "' and 课程名称='"
						+ classes.getSelectedItem().toString().trim() + "'");
				JOptionPane.showMessageDialog(null, "删除成功!");
				this.dispose();
			} catch (SQLException ex) {
				String err = ex.getMessage();
			}
			}
		}
		if(e.getSource()==cencel){
			this.dispose();
		}
         if(e.getSource()==examnumber){
        	 try {
     			classnumber.removeAllItems();
     			classnumberss = classnumbers.executeQuery("select distinct 班级编号  from score where 考试编号='"
     							+ examnumber.getSelectedItem() + "'"); 
     			while (classnumberss.next()) {
     				classnumber.addItem(classnumberss.getString("班级编号"));
     			}
     		} catch (Exception err) {
     			err.printStackTrace();
     			String error = err.getMessage();
     		}
		} 
         if(e.getSource()==classnumber){
        	 try {
     			number.removeAllItems();
     			as = is
     					.executeQuery("select 学号 from score where 班级编号='"
     							+ classnumber.getSelectedItem()
     							+ "' and 考试编号='"
     							+ examnumber.getSelectedItem() + "'"); 
     			while (as.next()) {
     				number.addItem(as.getString("学号"));
     			}
     		} catch (Exception err) {
     			err.printStackTrace();
     			String error = err.getMessage();
     		}
		} 
         if(e.getSource()==number){
        	 classes.removeAllItems();
     		name.setText("");
     		try {
     			xsxm = xms.executeQuery("select * from score where 班级编号='"
     					+ classnumber.getSelectedItem().toString().trim()
     					+ "'and 学号='"
     					+ number.getSelectedItem().toString().trim() + "'and 考试编号='"
     					+ examnumber.getSelectedItem().toString().trim() + "'"); 
     			while (xsxm.next()) {
     				name.setText(xsxm.getString("姓名"));
     				classes.addItem(xsxm.getString("课程名称"));
     				
     			}
     		} catch (Exception err) {
     			err.printStackTrace();
     			String error = err.getMessage();
     		}
		} 
         if(e.getSource()==classes){
        	 mark.setText("");
     		try {
     			classesss = classess.executeQuery("select 成绩 from score where 班级编号='"
     					+ classnumber.getSelectedItem().toString().trim()
     					+ "'and 学号='"
     					+ number.getSelectedItem().toString().trim() + "'and 考试编号='"
     					+ examnumber.getSelectedItem().toString().trim()
     					+ "'and 课程名称='"
     					+ classes.getSelectedItem().toString().trim() + "'"); 
     			while (classesss.next()) {
     				mark.setText(classesss.getString("成绩"));
     			}
     		} catch (Exception err) {
     			err.printStackTrace();
     			String error = err.getMessage();
     		}
		}
		
	}
}