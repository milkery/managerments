package StudentManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

//浏览用户
public class browseUser extends JDialog implements ActionListener{
	Statement ps;
	ResultSet rs;
	Connection con;
	DefaultTableModel dfm;
	JScrollPane jScrollPane1;
	Vector columnNames =new Vector();
	JTable jTable1;
	JButton ok = new JButton();
	public browseUser() {
		init();
		this.setResizable(false);
		this.setTitle("浏览用户");
		this.setLayout(null);
		jScrollPane1.setBounds(new Rectangle(10, 10, 430, 228));
		ok.setBounds(new Rectangle(180, 250, 90, 30));
		ok.setFont(new java.awt.Font("Dialog", 0, 20));
		ok.setText("确  定");
		ok.addActionListener(this);
		this.add(jScrollPane1);
		this.add(ok);
		this.setBounds(480, 250, 450, 350);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new browseUser();
	}
	public void init(){
		try {
			
			 Connection con=null; 
			 Database.joinDB(); 
			 con=Database.cn;
			ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(dl.xuanqian.equals("老师")){
			 rs = ps.executeQuery("select * from uster where 类型= '学生' ");
			}
			else
			rs = ps.executeQuery("select * from uster");
			ResultSetMetaData rsm=rs.getMetaData();
			for(int i=1;i<=rsm.getColumnCount();i++){
				columnNames.add(rsm.getColumnName(i));
				 }
			dfm=new DefaultTableModel(null,columnNames);
			 while(rs.next()){
				 Vector rowData =new Vector();
				 for(int i=1;i<=columnNames.size();i++){
					 rowData.add(rs.getString(i));
				 }
				 dfm.addRow(rowData);
			 }
			 jTable1=new JTable(dfm);
			 jScrollPane1=new JScrollPane(jTable1);
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
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		
	}
	
}