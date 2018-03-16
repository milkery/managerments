package StudentManager;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main_Frame extends JFrame implements ActionListener{
	JPanel contentPane=new JPanel();// 面板
	JMenuBar jMenuBar = new JMenuBar();// 菜单栏
	JMenu jMenuFile = new JMenu();// 用户管理
	JMenuItem browse = new JMenuItem();// 浏览用户
	JMenuItem modefy_password = new JMenuItem();// 修改密码
	JMenuItem add_user = new JMenuItem();// 添加用户
	JMenuItem delete_user = new JMenuItem();// 删除用户
	JMenu register = new JMenu();// 学籍管理
	JMenuItem search_register = new JMenuItem();// 查询学籍
	JMenuItem modefy_register = new JMenuItem();// 修改学籍
	JMenuItem add_register = new JMenuItem();// 添加学籍
	JMenu cclass = new JMenu();// 班级管理
	JMenuItem modefy_class = new JMenuItem();// 修改班级
	JMenuItem add_class = new JMenuItem();// 添加班级
	JMenu classes = new JMenu();// 课程设置
	JMenuItem make_classes = new JMenuItem();// 设置年级课程
	JMenuItem modefy_classes = new JMenuItem();// 修改课程
	JMenuItem add_classes = new JMenuItem();// 添加课程
	JMenu score = new JMenu();// 成绩管理
	JMenuItem add_score = new JMenuItem();// 添加成绩
	JMenuItem modefy_score = new JMenuItem();// 修改成绩
	JMenuItem search_score = new JMenuItem();// 查询成绩
	JMenuItem exit = new JMenuItem();// 退出
	JMenuItem about = new JMenuItem();
	ImageIcon icon=new ImageIcon("images" + File.separator + "qhdvtc.jpg");
	JLabel jLabel1 = new JLabel(icon,JLabel.CENTER);//装图片
	public Main_Frame() {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		this.setResizable(false);
		this.setTitle("学生信息管理系统");
		contentPane.add(jLabel1);
		
		this.setJMenuBar(jMenuBar);
		this.setBounds(300, 45, 860,630);//面板显示位置和大小
		jLabel1.setBounds(new Rectangle(1, 0, 860, 600));//jLabel1和图片的大小
		
		jMenuFile.add(browse);
		jMenuFile.add(modefy_password);
		jMenuFile.add(add_user);
		jMenuFile.add(delete_user);
		jMenuFile.add(exit);

		jMenuBar.add(jMenuFile);
		jMenuBar.add(register);
		jMenuBar.add(cclass);
		jMenuBar.add(classes);
		jMenuBar.add(score);
		jMenuBar.add(about);

		register.add(add_register);
		register.add(modefy_register);
		register.add(search_register);

		cclass.add(add_class);
		cclass.add(modefy_class);

		classes.add(add_classes);
		classes.add(modefy_classes);
		classes.add(make_classes);

		score.add(add_score);
		score.add(modefy_score);
		score.add(search_score);

		
		
		jMenuBar.setSize(800,40);
		jMenuFile.setFont(new java.awt.Font("Dialog", 0, 20));
		jMenuFile.setForeground(Color.black);
		jMenuFile.setText("用户管理 ");
		jMenuFile.setBounds(0, 0, 130, 30);
		browse.setFont(new java.awt.Font("Dialog", 0, 20));
		browse.setText("浏览用户");
		browse.addActionListener(this);
		modefy_password.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_password.setText("修改密码");
		modefy_password.addActionListener(this);
		add_user.setFont(new java.awt.Font("Dialog", 0, 20));
		add_user.setText("添加用户");
		add_user.addActionListener(this);
		delete_user.setFont(new java.awt.Font("Dialog", 0, 20));
		delete_user.setText("删除用户");
		delete_user.addActionListener(this);
		exit.setFont(new java.awt.Font("Dialog", 0, 20));
		exit.setText("退出系统");
		exit.addActionListener(this);
		
		register.setFont(new java.awt.Font("Dialog", 0, 20));
		register.setText("  学籍管理  ");
		register.setBounds(150, 0, 130, 30);
		add_register.setFont(new java.awt.Font("Dialog", 0, 20));
		add_register.setForeground(Color.black);
		add_register.setText("添加学籍");
		add_register.addActionListener(this);
		modefy_register.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_register.setText("删改学籍");
		modefy_register.addActionListener(this);
		search_register.setFont(new java.awt.Font("Dialog", 0, 20));
		search_register.setText("查询学籍");
		search_register.addActionListener(this);
		
		cclass.setFont(new java.awt.Font("Dialog", 0, 20));
		cclass.setText(" 班级管理");
		cclass.setBounds(300, 0, 130, 30);
		add_class.setFont(new java.awt.Font("Dialog", 0, 20));
		add_class.setText("添加班级");
		add_class.addActionListener(this);
		modefy_class.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_class.setText("删改班级");
		modefy_class.addActionListener(this);
		
		classes.setFont(new java.awt.Font("Dialog", 0, 20));
		classes.setText("课程管理");
		classes.setBounds(450, 0, 130, 30);
		add_classes.setFont(new java.awt.Font("Dialog", 0, 20));
		add_classes.setText("添加课程");
		add_classes.addActionListener(this);
		modefy_classes.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_classes.setText("删改课程");
		modefy_classes.addActionListener(this);
		make_classes.setFont(new java.awt.Font("Dialog", 0, 20));
		make_classes.setText("设置课程");//设置年级课程
		make_classes.addActionListener(this);
		
		score.setFont(new java.awt.Font("Dialog", 0, 20));
		score.setText("成绩管理");
		score.setBounds(680, 0, 130, 30);
		add_score.setFont(new java.awt.Font("Dialog", 0, 20));
		add_score.setText("添加成绩");
		add_score.addActionListener(this);
		modefy_score.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_score.setText("删改成绩");
		modefy_score.addActionListener(this);
		search_score.setFont(new java.awt.Font("Dialog", 0, 20));
		search_score.setText("查询成绩");
		search_score.addActionListener(this);
		about.setFont(new java.awt.Font("Dialog", 0, 20));
		about.setText("关于");
		about.setBounds(760, 0, 150, 30);
		about.addActionListener(this);
        //用户登录方法
		
		if(dl.xuanqian.equals("学生")){
			delete_user.setEnabled(false);
			add_user.setEnabled(false);
			browse.setEnabled(false);
			add_register.setEnabled(false);
		
			modefy_register.setEnabled(false);
			add_score.setEnabled(false);
			add_class.setEnabled(false);
			modefy_class.setEnabled(false);
			modefy_score.setEnabled(false);
		 make_classes.setEnabled(false);
		 modefy_classes.setEnabled(false); 
			 add_classes.setEnabled(false); 
		}
		else if(dl.xuanqian.equals("老师")){
			delete_user.setEnabled(false);
			add_user.setEnabled(false);
			browse.setEnabled(false);
		}
		this.setVisible(true);
		 setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

	// 主方法
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		new Main_Frame();
	}
	public void actionPerformed(ActionEvent e) {
      //浏览用户
		if(e.getSource()==browse){
			new browseUser();
		}
      // 修改密码
		else if(e.getSource()==modefy_password){
			new modefyPassword();
		}
      // 添加用户
       else if(e.getSource()==add_user){
    	   new addUser();
		}
		//删除用户
       else if(e.getSource()==delete_user){
    	   new deleteUser();
		}
       //退出系统
       else if(e.getSource()==exit){
    	   System.exit(0);
		}
        //添加学籍
       else if(e.getSource()==add_register){
    	   new addRegister();
		}
        //修改学籍
       else if(e.getSource()==modefy_register){
    	   new modefyRegister();
		}
        //查询学籍
       else if(e.getSource()==search_register){
    	   new searchRegister();
		}
         //添加班级
       else if(e.getSource()==add_class){
    	   new addClass();
		}
        //修改班级
       else if(e.getSource()==modefy_class){
    	   new modefyClass();
		}
        //添加课程
       else if(e.getSource()==add_classes){
    	   new addClasses();
		}
       //修改课程
       else if(e.getSource()==modefy_classes){
    	   new modefyClasses();
		}
        //设置年级课程
       else if(e.getSource()==make_classes){
    	   new makeClasses();
		}
        //添加成绩
       else if(e.getSource()==add_score){
    	   new addScore();
		}
       //修改成绩
       else if(e.getSource()==modefy_score){
    	   new modefyScore();
		}
       //查询成绩
       else if(e.getSource()==search_score){
    	   new searchScore();
		}
      //帮助信息
       else if(e.getSource()==about){
    	   new about();
		}
	}
}
