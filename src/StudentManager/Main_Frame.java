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
	JPanel contentPane=new JPanel();// ���
	JMenuBar jMenuBar = new JMenuBar();// �˵���
	JMenu jMenuFile = new JMenu();// �û�����
	JMenuItem browse = new JMenuItem();// ����û�
	JMenuItem modefy_password = new JMenuItem();// �޸�����
	JMenuItem add_user = new JMenuItem();// ����û�
	JMenuItem delete_user = new JMenuItem();// ɾ���û�
	JMenu register = new JMenu();// ѧ������
	JMenuItem search_register = new JMenuItem();// ��ѯѧ��
	JMenuItem modefy_register = new JMenuItem();// �޸�ѧ��
	JMenuItem add_register = new JMenuItem();// ���ѧ��
	JMenu cclass = new JMenu();// �༶����
	JMenuItem modefy_class = new JMenuItem();// �޸İ༶
	JMenuItem add_class = new JMenuItem();// ��Ӱ༶
	JMenu classes = new JMenu();// �γ�����
	JMenuItem make_classes = new JMenuItem();// �����꼶�γ�
	JMenuItem modefy_classes = new JMenuItem();// �޸Ŀγ�
	JMenuItem add_classes = new JMenuItem();// ��ӿγ�
	JMenu score = new JMenu();// �ɼ�����
	JMenuItem add_score = new JMenuItem();// ��ӳɼ�
	JMenuItem modefy_score = new JMenuItem();// �޸ĳɼ�
	JMenuItem search_score = new JMenuItem();// ��ѯ�ɼ�
	JMenuItem exit = new JMenuItem();// �˳�
	JMenuItem about = new JMenuItem();
	ImageIcon icon=new ImageIcon("images" + File.separator + "qhdvtc.jpg");
	JLabel jLabel1 = new JLabel(icon,JLabel.CENTER);//װͼƬ
	public Main_Frame() {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		this.setResizable(false);
		this.setTitle("ѧ����Ϣ����ϵͳ");
		contentPane.add(jLabel1);
		
		this.setJMenuBar(jMenuBar);
		this.setBounds(300, 45, 860,630);//�����ʾλ�úʹ�С
		jLabel1.setBounds(new Rectangle(1, 0, 860, 600));//jLabel1��ͼƬ�Ĵ�С
		
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
		jMenuFile.setText("�û����� ");
		jMenuFile.setBounds(0, 0, 130, 30);
		browse.setFont(new java.awt.Font("Dialog", 0, 20));
		browse.setText("����û�");
		browse.addActionListener(this);
		modefy_password.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_password.setText("�޸�����");
		modefy_password.addActionListener(this);
		add_user.setFont(new java.awt.Font("Dialog", 0, 20));
		add_user.setText("����û�");
		add_user.addActionListener(this);
		delete_user.setFont(new java.awt.Font("Dialog", 0, 20));
		delete_user.setText("ɾ���û�");
		delete_user.addActionListener(this);
		exit.setFont(new java.awt.Font("Dialog", 0, 20));
		exit.setText("�˳�ϵͳ");
		exit.addActionListener(this);
		
		register.setFont(new java.awt.Font("Dialog", 0, 20));
		register.setText("  ѧ������  ");
		register.setBounds(150, 0, 130, 30);
		add_register.setFont(new java.awt.Font("Dialog", 0, 20));
		add_register.setForeground(Color.black);
		add_register.setText("���ѧ��");
		add_register.addActionListener(this);
		modefy_register.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_register.setText("ɾ��ѧ��");
		modefy_register.addActionListener(this);
		search_register.setFont(new java.awt.Font("Dialog", 0, 20));
		search_register.setText("��ѯѧ��");
		search_register.addActionListener(this);
		
		cclass.setFont(new java.awt.Font("Dialog", 0, 20));
		cclass.setText(" �༶����");
		cclass.setBounds(300, 0, 130, 30);
		add_class.setFont(new java.awt.Font("Dialog", 0, 20));
		add_class.setText("��Ӱ༶");
		add_class.addActionListener(this);
		modefy_class.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_class.setText("ɾ�İ༶");
		modefy_class.addActionListener(this);
		
		classes.setFont(new java.awt.Font("Dialog", 0, 20));
		classes.setText("�γ̹���");
		classes.setBounds(450, 0, 130, 30);
		add_classes.setFont(new java.awt.Font("Dialog", 0, 20));
		add_classes.setText("��ӿγ�");
		add_classes.addActionListener(this);
		modefy_classes.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_classes.setText("ɾ�Ŀγ�");
		modefy_classes.addActionListener(this);
		make_classes.setFont(new java.awt.Font("Dialog", 0, 20));
		make_classes.setText("���ÿγ�");//�����꼶�γ�
		make_classes.addActionListener(this);
		
		score.setFont(new java.awt.Font("Dialog", 0, 20));
		score.setText("�ɼ�����");
		score.setBounds(680, 0, 130, 30);
		add_score.setFont(new java.awt.Font("Dialog", 0, 20));
		add_score.setText("��ӳɼ�");
		add_score.addActionListener(this);
		modefy_score.setFont(new java.awt.Font("Dialog", 0, 20));
		modefy_score.setText("ɾ�ĳɼ�");
		modefy_score.addActionListener(this);
		search_score.setFont(new java.awt.Font("Dialog", 0, 20));
		search_score.setText("��ѯ�ɼ�");
		search_score.addActionListener(this);
		about.setFont(new java.awt.Font("Dialog", 0, 20));
		about.setText("����");
		about.setBounds(760, 0, 150, 30);
		about.addActionListener(this);
        //�û���¼����
		
		if(dl.xuanqian.equals("ѧ��")){
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
		else if(dl.xuanqian.equals("��ʦ")){
			delete_user.setEnabled(false);
			add_user.setEnabled(false);
			browse.setEnabled(false);
		}
		this.setVisible(true);
		 setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

	// ������
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		new Main_Frame();
	}
	public void actionPerformed(ActionEvent e) {
      //����û�
		if(e.getSource()==browse){
			new browseUser();
		}
      // �޸�����
		else if(e.getSource()==modefy_password){
			new modefyPassword();
		}
      // ����û�
       else if(e.getSource()==add_user){
    	   new addUser();
		}
		//ɾ���û�
       else if(e.getSource()==delete_user){
    	   new deleteUser();
		}
       //�˳�ϵͳ
       else if(e.getSource()==exit){
    	   System.exit(0);
		}
        //���ѧ��
       else if(e.getSource()==add_register){
    	   new addRegister();
		}
        //�޸�ѧ��
       else if(e.getSource()==modefy_register){
    	   new modefyRegister();
		}
        //��ѯѧ��
       else if(e.getSource()==search_register){
    	   new searchRegister();
		}
         //��Ӱ༶
       else if(e.getSource()==add_class){
    	   new addClass();
		}
        //�޸İ༶
       else if(e.getSource()==modefy_class){
    	   new modefyClass();
		}
        //��ӿγ�
       else if(e.getSource()==add_classes){
    	   new addClasses();
		}
       //�޸Ŀγ�
       else if(e.getSource()==modefy_classes){
    	   new modefyClasses();
		}
        //�����꼶�γ�
       else if(e.getSource()==make_classes){
    	   new makeClasses();
		}
        //��ӳɼ�
       else if(e.getSource()==add_score){
    	   new addScore();
		}
       //�޸ĳɼ�
       else if(e.getSource()==modefy_score){
    	   new modefyScore();
		}
       //��ѯ�ɼ�
       else if(e.getSource()==search_score){
    	   new searchScore();
		}
      //������Ϣ
       else if(e.getSource()==about){
    	   new about();
		}
	}
}
