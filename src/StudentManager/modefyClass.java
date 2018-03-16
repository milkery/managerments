package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//查改删班级信息
public class modefyClass extends JFrame implements ActionListener{
	private ResultSet rs;
	Statement ps,ins,sc;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JTextField classnum = new JTextField();
	JTextField teacher = new JTextField();
	JTextField grade = new JTextField();
	JTextField classroom = new JTextField();
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

	public modefyClass() {
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel1.setText("班级编号");
		jLabel1.setBounds(new Rectangle(30, 30, 60, 40));
		jLabel2.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel2.setText("班级名称");
		jLabel2.setBounds(new Rectangle(30, 80, 60, 40));
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel3.setText("专业编号");
		jLabel3.setBounds(new Rectangle(260, 30, 60, 40));
		jLabel4.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel4.setText("教师名称");
		jLabel4.setBounds(new Rectangle(260, 80, 60, 40));
		classnum.setBackground(SystemColor.menu);
		classnum.setEditable(true);
		classnum.setBounds(new Rectangle(100, 30, 120, 30));
		teacher.setBounds(new Rectangle(100, 80, 120, 30));
		grade.setBounds(new Rectangle(330, 30, 120, 30));
		classroom.setBounds(new Rectangle(330, 80, 120, 30));
		jLabel5.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel5.setText("查看班级信息");
		jLabel5.setBounds(new Rectangle(50, 135, 104, 50));

		first.setText("第一条");
		first.addActionListener(this);
		first.setBounds(new Rectangle(50, 180, 95, 30));
		first.setFont(new java.awt.Font("Dialog", 0, 15));

		previous.setText("上一条");
		previous.addActionListener(this);
		previous.setBounds(new Rectangle(150, 180, 95, 30));
		previous.setFont(new java.awt.Font("Dialog", 0, 15));

		next.setText("下一条");
		next.addActionListener(this);
		next.setBounds(new Rectangle(250, 180, 95, 30));
		next.setFont(new java.awt.Font("Dialog", 0, 15));

		last.setText("最后一条");
		last.addActionListener(this);
		last.setBounds(new Rectangle(350, 180, 95, 30));
		last.setFont(new java.awt.Font("Dialog", 0, 15));

		modefy.setText("修改数据");
		modefy.addActionListener(this);
		modefy.setBounds(new Rectangle(50, 274, 95, 30));
		modefy.setFont(new java.awt.Font("Dialog", 0, 15));
		update.setText("更新数据");
		update.addActionListener(this);
		update.setBounds(new Rectangle(150, 274, 95, 30));
		update.setFont(new java.awt.Font("Dialog", 0, 15));
		delete.setText("删除记录");
		delete.addActionListener(this);
		delete.setBounds(new Rectangle(250, 275, 95, 30));
		delete.setFont(new java.awt.Font("Dialog", 0, 15));
		cencel.setText("退  出");
		cencel.addActionListener(this);
		cencel.setBounds(new Rectangle(350, 275, 95, 30));
		cencel.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel6.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel6.setText("改删班级信息");
		jLabel6.setBounds(new Rectangle(50, 231, 130, 41));
		this.setResizable(false);
		this.setTitle("查改删班级信息");
		this.setLayout(null);
		this.add(jLabel1);
		this.add(jLabel2);
		this.add(classnum);
		this.add(teacher);
		this.add(jLabel3);
		this.add(grade);
		this.add(classroom);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(modefy);
		this.add(update);
		this.add(jLabel6);
		this.add(next);
		this.add(last);
		this.add(previous);
		this.add(first);
		this.add(cencel);
		this.add(delete);
		this.setBounds(400, 185, 500, 400);
		this.setVisible(true);
		try { // 连接数据库
			Connection con=null;
			 Database.joinDB(); con=Database.cn;
			ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			sc= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ins = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery("select * from class");
			if (rs.next()) {
				up();
			}
		} catch (Exception err) {
			err.printStackTrace(System.out);
		}
	}
public void up(){
	try {
		classnum.setText(rs.getString("班级编号"));
		grade.setText(rs.getString("班级名称"));
		teacher.setText(rs.getString("专业编号"));
		classroom.setText(rs.getString("教师名称"));
	} catch (SQLException e) {
		// TODO 自动生成 catch 块
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		new modefyClass();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==first){
			try {
				if (rs.first()) {
					up();
				}
			} catch (SQLException ex) {
			}
		}
       if(e.getSource()==previous){
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
    	   try {
      			if (rs.last()) {
      				up();
      			}
      		} catch (SQLException ex) {
      		}
        }
       if(e.getSource()==modefy){
    	   JOptionPane.showConfirmDialog(null, "确定修改！", "修改记录",
   				JOptionPane.YES_NO_OPTION);
   		try {
   			ps.executeUpdate("Update class set 班级名称='"
   					+ grade.getText().trim() + "' ,专业编号='"
   					+ teacher.getText().trim() + "' ,教师名称='"
   					+ classroom.getText().trim() + "'  where 班级编号='"
   					+ classnum.getText().trim() + "'");
   			JOptionPane.showMessageDialog(null, "修改数据成功!");
   		} catch (SQLException ex) {
   			String err = ex.getMessage();
   			JOptionPane.showMessageDialog(null, err);
   		}
         }
       if(e.getSource()==update){
    	   try {
   			rs = ps.executeQuery("select * from class");
   			rs.beforeFirst();
   			try {
   				if (rs.next()) {
   					up();
   				}
   			} catch (SQLException ex) {
   			}
   		} catch (SQLException ex) {
   		}
         }
       if(e.getSource()==delete){
    	   JOptionPane.showConfirmDialog(null, "确定删除？将删除数据库中所有此班级记录！", "删除记录",
   				JOptionPane.YES_NO_OPTION);
   		try {
   			if (!(classnum.getText().trim() == null)) {
   				ps.executeUpdate("delete from class where 班级编号='"
   						+ classnum.getText().trim() + "'");
   				sc.executeUpdate("delete from score where 班级编号='"
   						+ classnum.getText().trim() + "'");
   				ins.executeUpdate("delete from student where 班级编号='"
   						+ classnum.getText().trim() + "'");
   				JOptionPane.showMessageDialog(null, "删除成功!");
   				rs = ps.executeQuery("select * from class");
   			} else {
   				JOptionPane.showMessageDialog(null, "已经没有记录了!");
   			}
   		} catch (SQLException ex) {
   		}
        }
       if(e.getSource()==cencel){
    		this.dispose();
       }
		
	}
}