package StudentManager;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import javax.swing.*;
import java.sql.*;
public class dl extends JDialog implements ActionListener {
   JButton jb1,jb2;
   JLabel jl1,jl2,jl3;
   JTextField jt;
   JPasswordField jpf;
   JProgressBar pb=new JProgressBar(1,100);
  Timer timer;
   int n=100;
   public static String xuanqian;
   public static String yonghuming;
  JComboBox power = new JComboBox();
  ImageIcon icon=new ImageIcon("images" + File.separator + "tx.jpg");
	JLabel jLabel1 = new JLabel(icon,JLabel.CENTER);//装图片
   public dl(){
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize =this.getSize();
		this.setLocationRelativeTo(null);
	   this.getContentPane().setLayout(null);
	   jl1=new JLabel("用户名：");
	   jl1.setBounds(new Rectangle(115,22, 80,30));
	   jl1.setFont(new java.awt.Font("Dialog", 0, 20));
	   jl2=new JLabel("密  码：");
	   jl2.setBounds(new Rectangle(115,65, 80,30));
	   jl2.setFont(new java.awt.Font("Dialog", 0, 20));
	   jl3=new JLabel("用户类型：");
	   jl3.setBounds(new Rectangle(115,110,100,30));
	   jl3.setFont(new java.awt.Font("Dialog", 0, 20));
	   jt=new JTextField(18);
	   jt.setBounds(new Rectangle(205,20,130,30));
	   jt.setFont(new java.awt.Font("Dialog", 0, 20));
	   jpf=new JPasswordField(18);
	   jpf.setBounds(new Rectangle(205,65,130,30));
	   jpf.setFont(new java.awt.Font("Dialog", 0, 20));
	   jb1=new JButton("确 定");
	   jb1.setBounds(new Rectangle(115,180,100,25));
	   jb1.setFont(new java.awt.Font("Dialog", 0, 20));
	   jb2=new JButton("取 消");
	   jb2.setBounds(new Rectangle(265,180,100,25));
	   jb2.setFont(new java.awt.Font("Dialog", 0, 20));
	   power.addItem("管理员");
	   power.addItem("老师");
	   power.addItem("学生");
	   power.setSelectedItem("管理员");
	   power.setBounds(new Rectangle(215,110,125,30));
	   power.setFont(new java.awt.Font("Dialog", 0, 20));
	   add(jl1);
	   add(jt);
	   add(jl2);
	   add(jpf);
	   add(jl3);
	   add(power);
	   add(jb1);
	   add(jb2);
	   add(pb);
	   add(jLabel1);
	   jLabel1.setBounds(new Rectangle(0, 0, 480, 320));//jLabel1和图片的大小
	   pb.setBounds(new Rectangle(0,250,480,30));
	   pb.setFont(new java.awt.Font("Dialog", 0, 20));
	   pb.setVisible(false);
	   jt.addActionListener(this);
	   jpf.addActionListener(this);
	   jb1.addActionListener(this);
	   jb2.addActionListener(this);
	  setTitle("学生信息管理系统");
	  this.setBounds(360,200,480,320);
	  setVisible(true);
	  setResizable(false);
	  setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
   }
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){}
	     new dl();	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			 Connection con=null;
			 
	         String username=jt.getText().trim();
	         String password=new String(jpf.getPassword()).trim();
			 if(username.isEmpty()){    
			        JOptionPane.showMessageDialog(this, "用户名不能为空!");
			        jt.requestFocus(); //设置焦点
			    }
			    else if(password.isEmpty()){
			         JOptionPane.showMessageDialog(this, "密码不能为空!");
			         jpf.requestFocus(); //设置焦点
			    }
			    else if(power.getSelectedItem()==null){
			    	  JOptionPane.showMessageDialog(this, "请选择权限!");
			    }
	else {	
         try {
        	 Database.joinDB();
        	 con=Database.cn;
        	
        	
        	// System.out.printf(con==null?"con==null":"con!=null");
        	// System.out.printf(con.createStatement()==null?"sta==null":"sta!=null");
        	
			
        	 Statement sta=con.createStatement();
			
			String sql="select * from uster where 用户名='"+username+"'and 密码='"+password+"'";
			ResultSet rs=sta.executeQuery(sql);
			 if(rs.next()){
				 String sql1="select * from uster where 用户名='"+username+"'and 密码='"+password+"'and 类型='"+power.getSelectedItem()+"'";
					ResultSet rs1=sta.executeQuery(sql1);
			  if(rs1.next()){
				  pb.setVisible(true);
				  yonghuming=username;
				  xuanqian=(String) power.getSelectedItem();
				  pb.setStringPainted(true);
				   pb.setString("正在进入系统请稍后.....");
				  timer=new Timer(100,this);
				  timer.start();
				  timer.addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e){
						 n=n-3;
						 if(n>0){
							 pb.setValue(100-n);
							 timer.restart();
						 }
						 else{
							 timer.stop();
							 dispose();
							 new Main_Frame();
						 }
					 }
				  });
			    }
			  else{
			  JOptionPane.showMessageDialog(this, "您选择的用户名与用户类型不相符，请重新选择用户类型!");
			  power.setSelectedItem(null);
			  }
			 }
			else{
				JOptionPane.showMessageDialog(this,"您输入的用户名或密码错误，请重新输入。");
                jpf.setText("");
                jt.requestFocus(); //设置焦点
                jt.setSelectionStart(0); //设置选中文本开始位置
                power.setSelectedItem(null);
			}
		} catch (Exception e1) {
			// TODO 自动生成 catch 块
			System.out.printf("执行这个，表示try里面异常了,异常的原因是："+e.toString());
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
		}
		 if(e.getSource()==jb2){
        	 dispose();
        	 System.exit(0);
		 }
		 if(e.getSource()==jt)
			 jpf.requestFocus();
		 if(e.getSource()==jpf)
			power.requestFocus();
	}
}
