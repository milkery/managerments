package StudentManager;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//查询学生学籍信息
public class searchRegister extends JDialog implements ActionListener {
	Statement ps;
	ResultSet rs,rss;
	DefaultTableModel dfm;
	JScrollPane jScrollPane1;
	Vector header=new Vector();
	JTable jTable1 = new JTable();
	JButton cancel = new JButton();
	JButton ok = new JButton();
	JTextField input = new JTextField();
	ButtonGroup buttonGroup2 = new ButtonGroup();
	JRadioButton number = new JRadioButton();
	JRadioButton name = new JRadioButton();
	JRadioButton classnumber = new JRadioButton();
	JRadioButton all = new JRadioButton();

	public searchRegister() {
		init();
		this.setLocale(java.util.Locale.getDefault());
		this.setLayout(null);
		this.setTitle("查询学生学籍信息");
		jScrollPane1.setBounds(new Rectangle(6, 0, 780, 340));
		ok.setToolTipText("直接点击确定，可查询全部学生信息");

		ok.setBounds(new Rectangle(460, 410, 80, 30));
		ok.setFont(new java.awt.Font("Dialog", 0, 15));
		ok.setText("确   定");
		ok.addActionListener(this);
		cancel.setBounds(new Rectangle(560, 410, 80, 30));
		cancel.setFont(new java.awt.Font("Dialog", 0, 15));
		cancel.setText("取   消");
		cancel.addActionListener(this);

		input.setFont(new java.awt.Font("Dialog", 0, 15));
		input.setText("");
		input.setBounds(new Rectangle(300, 410, 120, 30));

		all.setBounds(new Rectangle(20, 410, 63, 30));
		all.setText("全 部");
		all.setRolloverEnabled(false);
		all.setFont(new java.awt.Font("Dialog", 0, 15));
		number.setFont(new java.awt.Font("Dialog", 0, 15));
		number.setRolloverEnabled(false);
		number.setText("按学号");
		number.setBounds(new Rectangle(80, 410, 74, 30));
		name.setBounds(new Rectangle(150, 410, 74, 30));
		name.setText("按姓名");
		name.setRolloverEnabled(false);
		name.setFont(new java.awt.Font("Dialog", 0, 15));
		classnumber.setBounds(new Rectangle(220, 410, 74, 30));
		classnumber.setText("按班号");
		classnumber.setRolloverEnabled(false);
		classnumber.setFont(new java.awt.Font("Dialog", 0, 15));
		this.add(jScrollPane1);
		this.add(input);
		this.add(ok);
		this.add(cancel);
		this.add(all);
		this.add(classnumber);
		this.add(name);
		this.add(number);
		this.setBounds(320, 120, 800, 500);
		this.setVisible(true);
		buttonGroup2.add(all);
		buttonGroup2.add(number);
		buttonGroup2.add(classnumber);
		buttonGroup2.add(name);
	}
	public void init(){
		try { 
		Connection con=null; con=Database.cn;
		 Database.joinDB();// 连接数据库
		ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = ps.executeQuery("select * from student");
		ResultSetMetaData rsm=rs.getMetaData();
		 for(int i=1;i<=rsm.getColumnCount();i++){
			 header.add(rsm.getColumnName(i));
			 }
		dfm=new DefaultTableModel(null,header);
		 while(rs.next()){
			 Vector v=new Vector();
			 for(int i=1;i<=header.size();i++){
				 v.add(rs.getString(i));
			 }
			 dfm.addRow(v);
		 }
		 jTable1=new JTable(dfm);
		 jScrollPane1=new JScrollPane(jTable1);
} catch (Exception err) {
	String err1 = err.getMessage();
	JOptionPane.showMessageDialog(null, err);
}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok){
			 jScrollPane1.remove(jTable1);
			try { 
				if (number.isSelected()) {
					rss = ps
							.executeQuery("select * from student where 学号='"
									+ input.getText().trim() + "'");
				} else if (name.isSelected()) {
					rss = ps
							.executeQuery("select * from student where 姓名='"
									+ input.getText().trim() + "'");
				} else if (classnumber.isSelected()) {
					rss = ps
							.executeQuery("select * from student where 班级名称='"
									+ input.getText().trim() + "'");
				}else if(all.isSelected()){
			   rss = ps.executeQuery("select * from student");
			   input.setText("");
			   }
				dfm=new DefaultTableModel(null,header);
				 while(rss.next()){
					 Vector v=new Vector();
					 for(int i=1;i<=header.size();i++){
						 v.add(rss.getString(i));
					 }
					 dfm.addRow(v);
				 }
				 jTable1=new JTable(dfm);
				 jScrollPane1.setViewportView(jTable1);
		} catch (Exception err) {
			String err1 = err.getMessage();
			JOptionPane.showMessageDialog(null, err);
		}
		}
		else if(e.getSource()==cancel){
			this.dispose();
		}
	}
	}