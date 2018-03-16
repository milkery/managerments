package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//查改删课程信息
public class modefyClasses extends JFrame implements ActionListener{
	private ResultSet rs;
	Statement ps,pss;
	String must = new String("必修");
	String random = new String("选修");
	String only = new String("限选");
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JTextField classesnum = new JTextField();
	JTextField classesname = new JTextField();
	JButton first = new JButton();
	JLabel jLabel5 = new JLabel();
	JButton next = new JButton();
	JButton last = new JButton();
	JButton previous = new JButton();
	JButton modefy = new JButton();
	JButton update = new JButton();
	JButton delete = new JButton();
	JButton cencel = new JButton();
	JLabel jLabel6 = new JLabel();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTextPane discript = new JTextPane();
	JComboBox kind = new JComboBox();

	public modefyClasses() {
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel1.setText("课程编号");
		jLabel1.setBounds(new Rectangle(40, 30, 65, 30));
		this.setLayout(null);

		jLabel2.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel2.setText("课程类型");
		jLabel2.setBounds(new Rectangle(40, 80, 65, 30));

		jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel3.setText("课程名称");
		jLabel3.setBounds(new Rectangle(240, 30, 65, 30));

		jLabel4.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel4.setText("课程描述");
		jLabel4.setBounds(new Rectangle(240, 80, 65, 30));

		classesnum.setText("");
		classesnum.setBounds(new Rectangle(110, 30, 120, 30));

		classesname.setText("");
		classesname.setBounds(new Rectangle(320, 30, 120, 30));

		kind.setBounds(new Rectangle(110, 80, 120, 30));
		jScrollPane1.setBounds(new Rectangle(320, 80, 120, 80));

		jLabel5.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel5.setText("查看课程信息");
		jLabel5.setBounds(new Rectangle(40, 135, 104, 30));

		first.setBounds(new Rectangle(40, 180, 80, 30));
		first.setFont(new java.awt.Font("Dialog", 0, 15));
		first.setText("第一条");
		first.addActionListener(this);

		previous.setText("上一条");
		previous.addActionListener(this);
		previous.setBounds(new Rectangle(140, 180, 80, 30));
		previous.setFont(new java.awt.Font("Dialog", 0, 15));

		next.setText("下一条");
		next.addActionListener(this);
		next.setBounds(new Rectangle(240, 180, 80, 30));
		next.setFont(new java.awt.Font("Dialog", 0, 15));

		last.setText("最后一条");
		last.addActionListener(this);
		last.setBounds(new Rectangle(340, 180, 95, 30));
		last.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel6.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel6.setText("改删课程信息");
		jLabel6.setBounds(new Rectangle(40, 230, 130, 41));

		modefy.setText("修改数据");
		modefy.addActionListener(this);
		modefy.setBounds(new Rectangle(40, 270, 95, 30));
		modefy.setFont(new java.awt.Font("Dialog", 0, 15));

		update.setText("更新数据");
		update.addActionListener(this);
		update.setBounds(new Rectangle(140, 270, 95, 30));
		update.setFont(new java.awt.Font("Dialog", 0, 15));

		delete.setText("删除记录");
		delete.addActionListener(this);
		delete.setBounds(new Rectangle(240, 270, 95, 30));
		delete.setFont(new java.awt.Font("Dialog", 0, 15));

		cencel.setText("退出");
		cencel.addActionListener(this);
		cencel.setBounds(new Rectangle(340, 270, 95, 30));
		cencel.setFont(new java.awt.Font("Dialog", 0, 15));

		this.setResizable(false);
		this.setTitle("查改删课程信息");

		this.add(jLabel2);
		this.add(classesnum);
		this.add(jLabel3);
		this.add(classesname);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(modefy);
		this.add(update);
		this.add(jLabel6);
		this.add(next);
		this.add(last);
		this.add(previous);
		this.add(cencel);
		this.add(delete);
		this.add(jLabel1);
		this.add(jScrollPane1);
		this.add(first);
		this.add(kind);
		jScrollPane1.getViewport().add(discript);
		this.setBounds(400, 185, 500, 400);
		this.setVisible(true);
		
		try { // 连接数据库
			 Connection con=null;
			 Database.joinDB(); con=Database.cn;
			ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pss = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery("select * from course");
			if (rs.next()) {
				up();
				
			}
		} catch (Exception err) {
			err.printStackTrace(System.out);
		}
	}
public void up(){
	try {
		classesnum.setText(rs.getString("课程编号"));
		classesname.setText(rs.getString("课程名称"));
		if (rs.getString("课程类型").trim().equals(must)) {
			kind.addItem(must);
			kind.addItem(random);
			kind.addItem(only);
		}
		else if (rs.getString("课程类型").trim().equals(only)) {
			kind.addItem(only);
			kind.addItem(must);
			kind.addItem(random);
		} else  {
			kind.addItem(random);
			kind.addItem(must);
			kind.addItem(only);
		}
		discript.setText(rs.getString("课程描述"));
	} catch (SQLException e) {
		// TODO 自动生成 catch 块
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		new modefyClasses();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==first){
			kind.removeAllItems();
			try {
				if (rs.first()) {
					up();
				}
			} catch (SQLException ex) {
				String err = ex.getMessage();
				JOptionPane.showMessageDialog(null, err);
			}
		}
       if(e.getSource()==previous){
    	   kind.removeAllItems();
   		try {
   			if (rs.previous()) {
   				up();
   			} else {
   				JOptionPane.showMessageDialog(null, "这是第一条记录!");
   			}
   		} catch (SQLException ex) {
   		}
		}
        if(e.getSource()==next){
        	kind.removeAllItems();
    		try {
    			if (rs.next()) {
    			up();
    			} else {
    				JOptionPane.showMessageDialog(null, "这是最后一条记录!");
    			}
    		} catch (SQLException ex) {
    		}
        }
        if(e.getSource()==last){
        	kind.removeAllItems();
    		try {
    			if (rs.last()) {
    				up();
    			}
    		} catch (SQLException ex) {
    			String err = ex.getMessage();
    			JOptionPane.showMessageDialog(null, "这是最后一条记录！");
    		}
         }
        if(e.getSource()==modefy){
        	JOptionPane.showConfirmDialog(null, "确定修改", "修改课程",
    				JOptionPane.YES_NO_OPTION);
    		try {
    			ps.executeUpdate("Update course set 课程名称='"
    					+ classesname.getText().trim() + "' ,课程类型='"
    					+ kind.getSelectedItem().toString() + "' ,课程描述='"
    					+ discript.getText().trim() + "'  where 课程编号='"
    					+ classesnum.getText().trim() + "'");
    			JOptionPane.showMessageDialog(null, "修改课程成功!");
    		} catch (SQLException ex) {
    			String err = ex.getMessage();
    			JOptionPane.showMessageDialog(null, err);
    		}
         }
       if(e.getSource()==update){
    		try {
    			rs = ps.executeQuery("select * from course");
    			if (rs.next()) {
    				up();
    			}
    		} catch (SQLException ex) {
    			String err = ex.getMessage();
    			JOptionPane.showMessageDialog(null, err);
    		}
         }
       if(e.getSource()==delete){
    	   int v=JOptionPane.showConfirmDialog(null, "确定删除？", "删除课程",
   				JOptionPane.YES_NO_OPTION);
    	   if(v==0){
    		   try {
   					ps.executeUpdate("delete from course where 课程编号='"
   							+ classesnum.getText() + "'");
   					pss.executeUpdate("delete from score where 课程名称='"
   							+ classesname.getText() + "'");
   			JOptionPane.showMessageDialog(null, "删除成功!");
   				rs = ps.executeQuery("select * from course");
   				kind.removeAllItems();
   				if (rs.next()) {
   					up();
   				}
   		} catch (SQLException ex) {
   			String err = ex.getMessage();
   			JOptionPane.showMessageDialog(null, err);
   		}
    	   }
        }
       if(e.getSource()==cencel){
	this.dispose();
        }
		
	}
}