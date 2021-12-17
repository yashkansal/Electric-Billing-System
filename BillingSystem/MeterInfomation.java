package BillingSystem;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class MeterInfomation extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,imagelabel;
	JTextField t1;
	Choice c1,c2,c3,c4;
	JButton b1,b2;
	
	public MeterInfomation(String meterno) {
	 
	 setLocation(250,80);
	 setSize(700,580);
	 
	 JPanel p=new JPanel();
	 p.setLayout(null);
	 p.setBackground(new Color(255, 228, 140));
	 
	 //Title field
	 
	 JLabel title=new JLabel("Meter Information");
	 title.setFont(new Font("Sanserif",Font.BOLD,22));
     title.setBounds(180, 10, 250, 43);
	 p.add(title);
     
	 l1=new JLabel("Meter Number");
	 l1.setBounds(110, 100, 100, 20);
	 l10=new JLabel();
	 l10.setBounds(250, 100, 170, 20);
	 
	 l10.setText(meterno);
	 
	 p.add(l1);
	 p.add(l10);
	 
	 l2=new JLabel("Meter Location");
	 l2.setBounds(110, 140, 100, 20);
	 c1=new Choice();
     c1.add("Inside");
     c1.add("Outside");
	 c1.setBounds(250, 140, 170, 20);
	 
	 
	 
	 
	 
	 p.add(l2);
	 p.add(c1);
	 
	 l3=new JLabel("Meter Type");
	 l3.setBounds(110, 180, 100, 20);
	 c2=new Choice();
	 c2.add("Solar Meter");
	 c2.add("Electric Meter");
	 c2.add("Smart Meter");
	 c2.setBounds(250, 180, 170, 20);
	 
	 p.add(l3);
	 p.add(c2);
	 
	 l4=new JLabel("Phase Code");
	 l4.setBounds(110, 220, 100, 20);
	 
	 c3=new Choice();
	 c3.add("011");
	 c3.add("022");
	 c3.add("033");
	 c3.add("044");
	 c3.add("055");
	 c3.add("066");
	 c3.add("077");
	 c3.add("088");
	 c3.add("099");
	 c3.setBounds(250, 220, 170, 20);
	 
	 p.add(l4);
	 p.add(c3);
	 
	 l5=new JLabel("Bill Type");
	 l5.setBounds(110, 260, 100, 20);
	 c4=new Choice();
	 c4.add("Normal");
	 c4.add("Industrial");
	 c4.setBounds(250, 260, 170, 20);
	 p.add(l5);
	 p.add(c4);
	 
	 l6=new JLabel("Days");
	 l6.setBounds(110, 300, 100, 20);
	 l7=new JLabel("30");
	 l7.setBounds(250, 300, 170, 20);
	 
	 p.add(l6);
	 p.add(l7);
	 
	 l8=new JLabel("Note");
	 l8.setBounds(110, 340, 100, 20);
	 l9=new JLabel("By default Bill is calculated for 30 days Only");
	 l9.setBounds(250, 340, 300, 20);
	 
	 p.add(l8);
	 p.add(l9);
	 
	 b1=new JButton("Submit");
	 b2=new JButton("Cancel");
	 
	 b1.setBounds(120, 420, 120, 30);
	 b2.setBounds(280, 420, 120, 30);
	 b1.setBackground(Color.BLACK);
	 b2.setBackground(Color.BLACK);
	 b1.setForeground(Color.WHITE);
	 b2.setForeground(Color.WHITE);
	  
	 
	 p.add(b1);
	 p.add(b2);
	
	 setLayout(new BorderLayout());
	 add(p,"Center");
	 
	 ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("icon/eleMeter.jfif"));
	 Image i1=ic1.getImage().getScaledInstance(150, 350, Image.SCALE_DEFAULT);
     imagelabel=new JLabel(new ImageIcon(i1));
     
     add(imagelabel,"West");
     //to make whole background of JPlane white
     getContentPane().setBackground(Color.WHITE);
     
     b1.addActionListener(this);
     b2.addActionListener(this);
     
     
	}
	
	

	public void actionPerformed(ActionEvent ae)
	{
		String msg=ae.getActionCommand();
		if(msg.equals("Submit"))
		{
			String meterno=l10.getText();
			String meterlocation=c1.getSelectedItem();
			String metertype=c2.getSelectedItem();
			String phasecode=c3.getSelectedItem();
			String billtype=c4.getSelectedItem();

			
            String query="insert into meterinfo values('"+meterno+"','"+meterlocation+"','"+metertype+"','"+phasecode+"','"+billtype+"','"+30+"')";
			try
			{
				Conn c=new Conn();
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Customer Created");
				this.setVisible(false);
				new NewCustomer().setVisible(true);
				
			}
			catch (Exception i) {
				i.printStackTrace();
			}
		}
		else if(msg.equals("Cancel"))
		{
			this.setVisible(false);
			new NewCustomer().setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new MeterInfomation("meterno").setVisible(true);
	}
}
