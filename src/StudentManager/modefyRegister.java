package StudentManager;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

//查改删学籍信息
public class modefyRegister extends JDialog implements ActionListener{
	Statement ps,pss;
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
	JTextField number = new JTextField();
	JTextField name = new JTextField();
	JTextField schooltime = new JTextField();
	JTextField borntime = new JTextField();
	JTextField tel = new JTextField();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTextPane address = new JTextPane();
	JScrollPane jScrollPane2 = new JScrollPane();
	JTextPane comment = new JTextPane();
	JLabel jLabel10 = new JLabel();
	JButton previous = new JButton();
	JButton next = new JButton();
	JButton last = new JButton();
	JButton first = new JButton();
	JButton modefy = new JButton();
	JButton update = new JButton();
	JButton cancel = new JButton();
	JButton delete = new JButton();
	JLabel jLabel11 = new JLabel();
	JTextField sex = new JTextField();
	JTextField classnumber = new JTextField();
	public modefyRegister() {
		this.setForeground(Color.black);
		this.setResizable(false);
		//this.setState(Frame.NORMAL);
		this.setTitle("查改删学生学籍信息");
		this.setLayout(null);
		jLabel1.setBounds(new Rectangle(30, 30, 65, 44));
		jLabel1.setText("学    号");
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel2.setBounds(new Rectangle(30, 75, 65, 44));
		jLabel2.setText("性    别");
		jLabel2.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel3.setBounds(new Rectangle(30, 120, 65, 44));
		jLabel3.setText("班    级");
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel4.setBounds(new Rectangle(30, 165, 65, 44));
		jLabel4.setText("民    族");
		jLabel4.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel5.setBounds(new Rectangle(30, 215, 65, 44));
		jLabel5.setText("备    注");
		jLabel5.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel6.setBounds(new Rectangle(300, 30, 65, 44));
		jLabel6.setText("姓    名");
		jLabel6.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel7.setBounds(new Rectangle(300, 75, 65, 44));
		jLabel7.setText("出生日期");
		jLabel7.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel8.setBounds(new Rectangle(300, 120, 65, 44));
		jLabel8.setText("联系电话");
		jLabel8.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel9.setBounds(new Rectangle(300, 170, 65, 44));
		jLabel9.setText("家庭住址");
		jLabel9.setFont(new java.awt.Font("Dialog", 0, 15));

		number.setBackground(Color.white);
		number.setEditable(false);
		number.setBounds(new Rectangle(100, 35, 150, 30));
		number.setFont(new java.awt.Font("Dialog", 0, 15));

		sex.setBounds(new Rectangle(100, 80, 150, 30));
		sex.setFont(new java.awt.Font("Dialog", 0, 15));

		classnumber.setBounds(new Rectangle(100, 125, 150, 30));
		classnumber.setFont(new java.awt.Font("Dialog", 0, 15));

		schooltime.setBounds(new Rectangle(100, 170, 153, 30));
		schooltime.setFont(new java.awt.Font("Dialog", 0, 15));

		jScrollPane2.setBounds(new Rectangle(100, 220, 150, 100));
		comment.setFont(new java.awt.Font("Dialog", 0, 15));

		name.setBounds(new Rectangle(370, 35, 150, 30));
		name.setFont(new java.awt.Font("Dialog", 0, 15));

		borntime.setBounds(new Rectangle(370, 80, 150, 30));
		borntime.setFont(new java.awt.Font("Dialog", 0, 15));

		tel.setBounds(new Rectangle(370, 125, 150, 30));
		tel.setFont(new java.awt.Font("Dialog", 0, 15));

		jScrollPane1.setBounds(new Rectangle(370, 175, 150, 100));
		address.setFont(new java.awt.Font("Dialog", 0, 15));

		jLabel10.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel10.setText("查看学籍信息");
		jLabel10.setBounds(new Rectangle(30, 350, 100, 30));

		first.setFont(new java.awt.Font("Dialog", 0, 15));
		first.setBounds(new Rectangle(30, 380, 110, 30));
		first.setText("第一条记录");
		first.addActionListener(this);

		previous.setBounds(new Rectangle(150, 380, 110, 30));
		previous.setFont(new java.awt.Font("Dialog", 0, 15));
		previous.setText("上一条记录");
		previous.addActionListener(this);

		next.setFont(new java.awt.Font("Dialog", 0, 15));
		next.setBounds(new Rectangle(270, 380, 110, 30));
		next.setText("下一条记录");

		next.addActionListener(this);
		last.setFont(new java.awt.Font("Dialog", 0, 15));
		last.setBounds(new Rectangle(390, 380, 125, 30));
		last.setText("最后一条记录");
		last.addActionListener(this);

		jLabel11.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel11.setText("改删学籍信息");
		jLabel11.setBounds(new Rectangle(30, 416, 100, 30));

		modefy.setBounds(new Rectangle(50, 450, 95, 30));
		modefy.setFont(new java.awt.Font("Dialog", 0, 15));
		modefy.setText("修改记录");
		modefy.addActionListener(this);

		update.setFont(new java.awt.Font("Dialog", 0, 15));
		update.setBounds(new Rectangle(170, 450, 95, 30));
		update.setText("更新记录");
		update.addActionListener(this);

		delete.setText("删除记录");
		delete.addActionListener(this);
		delete.setFont(new java.awt.Font("Dialog", 0, 15));
		delete.setBounds(new Rectangle(290, 450, 95, 30));

		cancel.setBounds(new Rectangle(410, 450, 95, 30));
		cancel.setFont(new java.awt.Font("Dialog", 0, 15));
		cancel.setText("退   出");
		cancel.addActionListener(this);

		this.add(jLabel1);
		this.add(number);
		this.add(jLabel3);
		this.add(jLabel2);
		this.add(jLabel5);
		this.add(jLabel4);
		this.add(schooltime);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(address);
		this.add(jScrollPane2);
		jScrollPane2.getViewport().add(comment);
		this.add(tel);
		this.add(borntime);
		this.add(name);
		this.add(jLabel7);
		this.add(jLabel6);
		this.add(jLabel8);
		this.add(jLabel9);
		this.add(jLabel10);
		this.add(previous);
		this.add(next);
		this.add(last);
		this.add(first);
		this.add(modefy);
		this.add(update);
		this.add(jLabel11);
		this.add(sex);
		this.add(delete);
		this.add(cancel);
		this.add(classnumber);
		this.add(classnumber);
		this.add(classnumber);
		this.setBounds(400, 110, 550, 550);
		this.setVisible(true);
		try {
			Connection con=null;
			 Database.joinDB(); con=Database.cn;
			ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pss = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery("select * from student"); // 读取数据库
			if (rs.next()) {
				up();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
public void up(){
	try {
	number.setText(rs.getString("学号"));
	name.setText(rs.getString("姓名"));
	sex.setText(rs.getString("性别"));
	borntime.setText(rs.getString("出生日期").substring(0, 10));
	classnumber.setText(rs.getString("班级名称"));
	schooltime.setText(rs.getString("民族"));
	tel.setText(rs.getString("联系电话"));
	address.setText(rs.getString("家庭住址"));
	comment.setText(rs.getString("备注"));
	} catch (SQLException e) {
		// TODO 自动生成 catch 块
		e.printStackTrace();
	}
}
public static void main(String args[]) {
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) {
	}
	
	new modefyRegister();
}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==first){
			try {
				if (rs.first()) {
					up();
				} else
					JOptionPane.showMessageDialog(null, "这是第一条记录");
			} catch (SQLException sqle) {
				String error = sqle.getMessage();
				JOptionPane.showMessageDialog(null, error);
				sqle.printStackTrace();
			}
		}
		 if(e.getSource()==next){
			 try {
					if (rs.next()) {
						up();
					} else
						JOptionPane.showMessageDialog(null, "这是最后一条记录");
				} catch (SQLException sqle) {
					String error = sqle.getMessage();
					JOptionPane.showMessageDialog(null, error);
					sqle.printStackTrace();
				}	
			}
        if(e.getSource()==previous){
        	try {
    			if (rs.previous()) {
    				up();
    			} else
    				JOptionPane.showMessageDialog(null, "这是第一条记录");
    		} catch (SQLException sqle) {
    			String error = sqle.getMessage();
    			JOptionPane.showMessageDialog(null, error);
    			sqle.printStackTrace();
    		}	
		}
       if(e.getSource()==last){
    	   try {
   			if (rs.last()) {
   				up();
   			} else
   				JOptionPane.showMessageDialog(null, "这是最后一条记录");
   		} catch (SQLException sqle) {
   			String error = sqle.getMessage();
   			JOptionPane.showMessageDialog(null, error);
   			sqle.printStackTrace();
   		}
       }
       if(e.getSource()==modefy){
    	   int m= JOptionPane.showConfirmDialog(null, "确定修改", "修改学籍",
   				JOptionPane.YES_NO_OPTION);
    	   if(m==0){
   		try {
   			ps.executeUpdate("update student set 姓名='"
   					+ name.getText().trim() + "',性别='"
   					+ sex.getText().trim() + "',出生日期='"
   					+ borntime.getText().trim() + "',班级名称='"
   					+ classnumber.getText().trim() + "',联系电话='"
   					+ tel.getText().trim() + "',民族='"
   					+ schooltime.getText().trim() + "',家庭住址='"
   					+ address.getText().trim() + "',备注='"
   					+ comment.getText().trim() + "' where 学号='"
   					+ number.getText().trim() + "'");
   			JOptionPane.showMessageDialog(null, "修改学籍成功");
   		} catch (SQLException sqle) {
   			String error = sqle.getMessage();
   			JOptionPane.showMessageDialog(null, error);
   			sqle.printStackTrace();
   		}
   		try {
  			rs = ps.executeQuery("select * from student"); // 读取数据库
  			if (rs.next()) {
  				up();
  			}
  		} catch (SQLException sqle) {
  			String error = sqle.getMessage();
  			JOptionPane.showMessageDialog(null, error);
  			sqle.printStackTrace();
  		}
    	   }
         }
       if(e.getSource()==update){
    	   try {
   			rs = ps.executeQuery("select * from student"); // 读取数据库
   			if (rs.next()) {
   				up();
   			}
   		} catch (SQLException sqle) {
   			String error = sqle.getMessage();
   			JOptionPane.showMessageDialog(null, error);
   			sqle.printStackTrace();
   		}
       }
      if(e.getSource()==delete){
    	  int v = JOptionPane.showConfirmDialog(this, "确定删除吗？将删除所有此学生信息", "用户确认",
  				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
  		if (v == JOptionPane.OK_OPTION) {
  			try {
  				ps.executeUpdate("delete from student where 学号='"
  						+ number.getText().trim() + "'");
  				pss.executeUpdate("delete from score where 学号='"
  						+ number.getText().trim() + "'");
  				JOptionPane.showMessageDialog(null, "删除学籍成功");
  			} catch (SQLException sqle) {
  				String error = sqle.getMessage();
  				JOptionPane.showMessageDialog(null, error);
  				sqle.printStackTrace();

  			}
  		}
  		try {
  			rs = ps.executeQuery("select * from student"); // 读取数据库
  			if (rs.next()) {
  				up();
  			}
  		} catch (SQLException sqle) {
  			String error = sqle.getMessage();
  			JOptionPane.showMessageDialog(null, error);
  			sqle.printStackTrace();
  		}
       }
      if(e.getSource()==cancel){
	   this.dispose();
      }
		
	}
}
