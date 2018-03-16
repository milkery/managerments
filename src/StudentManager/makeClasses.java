package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Vector;

//���ð༶�γ�
public class makeClasses extends JFrame implements ActionListener,ItemListener {   
    JLabel jLabel1 = new JLabel();
    JComboBox nianji = new JComboBox();
    JLabel jLabel2 = new JLabel();

    JButton add = new JButton();
    JButton remove = new JButton();
    JButton cancel = new JButton();
    JButton display = new JButton();
    JButton ok = new JButton();
    Statement ps;
    ResultSet rs;
    List allcourse = new List();
    List sz = new List();
    Vector v = new Vector();

    public makeClasses() {
    	  this.setLayout(null);
          this.setTitle("���ð༶�γ�");

          jLabel1.setFont(new java.awt.Font("Dialog", 0, 15));
  		jLabel1.setText("ѡ��༶");
  		jLabel1.setBounds(new Rectangle(110, 20, 80, 30));
  		nianji.setBounds(new Rectangle(200, 20, 100, 30));
  		nianji.addItemListener(this);

  		jLabel2.setFont(new java.awt.Font("Dialog", 0, 15));
  		jLabel2.setText("���пγ�");
  		jLabel2.setBounds(new Rectangle(30, 50, 80, 30));

  		add.setBounds(new Rectangle(210, 120, 80, 30));
  		add.setFont(new java.awt.Font("Dialog", 0, 15));
  		add.setText("��  ��");
          add.addActionListener(this);
        
  		remove.setBounds(new Rectangle(210, 220, 80, 30));
  		remove.setFont(new java.awt.Font("Dialog", 0, 15));
  		remove.setText("��  ��");
  		remove.addActionListener(this);
  		
  		cancel.setBounds(new Rectangle(350, 320, 80, 30));
  		cancel.setFont(new java.awt.Font("Dialog", 0, 15));
  		cancel.setText("��  ��");
          cancel.addActionListener(this);
  		
          display.setText("��ʾ���пγ�");
          display.addActionListener(this);
          display.setBounds(new Rectangle(50, 320, 130, 30));
          display.setFont(new java.awt.Font("Dialog", 0, 15));
          
  		ok.setFont(new java.awt.Font("Dialog", 0, 15));
  		ok.setBounds(new Rectangle(225, 320, 80, 30));	
          ok.setText("ȷ   ��");
          ok.addActionListener(this);
          
  		allcourse.setBounds(new Rectangle(30, 90, 150, 200));
  		sz.setBounds(new Rectangle(315, 90, 150, 200));

          this.add(cancel);
          this.add(display);
          this.add(ok);
          this.add(jLabel2);
          this.add(allcourse);
          this.add(sz);
          this.add(add);
          this.add(remove);
          this.add(nianji);
          this.add(jLabel1);
          this.setBounds(400, 185, 500, 400);
          this.setVisible(true);
        try{
        	 Connection con=null;
        	 Database.joinDB(); con=Database.cn;
            ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch (Exception err) {
            String error = err.getMessage();
            JOptionPane.showMessageDialog(null, "�������ݿ����!");
        }
        try{
            rs= ps.executeQuery("select * from class");
            while (rs.next()) {
            	nianji.addItem(rs.getString("רҵ���"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	new makeClasses();
    }

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==add){
		 try{
	            sz.add(allcourse.getSelectedItem());
	            v.addElement(allcourse.getSelectedItem().trim());
	            allcourse.remove(allcourse.getSelectedItem());
	        }
	        catch (Exception err) {
	            String error = err.getMessage();
	            JOptionPane.showMessageDialog(null, "û��ѡ���κογ�!");
	        }
	}
	if(e.getSource()==remove){
		 try{ 
	            allcourse.add(sz.getSelectedItem());
	            sz.remove(sz.getSelectedItem());
	            v.remove(sz.getSelectedItem());
	        }
	        catch (Exception err) {
	            String error = err.getMessage();
	            JOptionPane.showMessageDialog(null, "û��ѡ���κογ�!");
	        }
	}
	if(e.getSource()==display){
		allcourse.removeAll();
		 try {
		        rs = ps.executeQuery("select * from course");
		        while (rs.next()) {
		            allcourse.add(rs.getString("�γ�����"));
		        }
		    }
		    catch (Exception err) {
		        String error = err.getMessage();
		        JOptionPane.showMessageDialog(null, "û������!");
		    }
	}
	if(e.getSource()==ok){
		 JOptionPane.showConfirmDialog(null,"ȷ�����ã�", "�����꼶�γ̣�", JOptionPane.YES_NO_OPTION);                                     
		    try {
		        for(int i=0;i<v.size();i++){
		            ps.executeUpdate("Insert Into gradecourse Values('" +
		            		nianji.getSelectedItem().toString()+
		                           "','" + v.get(i) +"')");
		        }
		        JOptionPane.showMessageDialog(null, "�����ѡ�γ̳ɹ�");
		    }
		    catch (SQLException ex) {
		        String error = ex.getMessage();
		        JOptionPane.showMessageDialog(null, error);
		    }
	}
	if(e.getSource()==cancel){
		this.dispose();
	}
}

public void itemStateChanged(ItemEvent e) {
	if(e.getStateChange()==2){
	allcourse.removeAll();
	sz.removeAll();
	try {
        rs = ps.executeQuery("select * from course");
        while (rs.next()) {
            allcourse.add(rs.getString("�γ�����"));
        }
    }
    catch (Exception err) {
        String error = err.getMessage();
    }
	}
}
}