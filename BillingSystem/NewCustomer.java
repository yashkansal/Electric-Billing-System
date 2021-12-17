package BillingSystem;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class NewCustomer extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11;
	JTextField t1,t3,t4,t5,t6,t7;
	JButton b1,b2;
	
	public NewCustomer() {
	
	 setLocation(250,80);
	 setSize(700,580);
	 
	 JPanel p=new JPanel();
	 p.setLayout(null);
	 p.setBackground(new Color(255, 228, 140));
	 
	 //Title field
	 
	 JLabel title=new JLabel("New Customer");
	 title.setFont(new Font("Sanserif",Font.BOLD,22));
     title.setBounds(200, 10, 250, 43);
	 p.add(title);
     
	 l1=new JLabel("Customer Name");
	 l1.setBounds(110, 100, 100, 20);
	 t1=new JTextField(17);
	 t1.setBounds(250, 100, 170, 20);
	 p.add(l1);
	 p.add(t1);
	 
	 l2=new JLabel("Meter No.");
	 l2.setBounds(110, 140, 100, 20);
	 l11=new JLabel();
	 l11.setBounds(250, 140, 170, 20);
	 
	 Random ran=new Random();
	 int number=ran.nextInt(999999);
	 l11.setText(String.format("%06d", number));
	 
	 
	 
	 p.add(l2);
	 p.add(l11);
	 
	 l3=new JLabel("Address");
	 l3.setBounds(110, 180, 100, 20);
	 t3=new JTextField();
	 t3.setBounds(250, 180, 170, 20);
	 
	 p.add(l3);
	 p.add(t3);
	 
	 l4=new JLabel("City");
	 l4.setBounds(110, 220, 100, 20);
	 
	 t4=new JTextField();
	 t4.setBounds(250, 220, 170, 20);
	 
	 p.add(l4);
	 p.add(t4);
	 
	 l5=new JLabel("State");
	 l5.setBounds(110, 260, 100, 20);
	 t5=new JTextField();
	 t5.setBounds(250, 260, 170, 20);
	 p.add(l5);
	 p.add(t5);
	 
	 l6=new JLabel("Email");
	 l6.setBounds(110, 300, 100, 20);
	 t6=new JTextField();
	 t6.setBounds(250, 300, 170, 20);
	 
	 p.add(l6);
	 p.add(t6);
	 
	 l7=new JLabel("Phone Number");
	 l7.setBounds(110, 340, 100, 20);
	 t7=new JTextField();
	 t7.setBounds(250, 340, 170, 20);
	 
	 p.add(l7);
	 p.add(t7);
	 
	 b1=new JButton("Next");
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
	 
	 ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("icon/customerIcon.jpg"));
	 Image i1=ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
     l8=new JLabel(new ImageIcon(i1));
     
     add(l8,"West");
     //to make whole background of JPlane white
     getContentPane().setBackground(Color.WHITE);
     
     b1.addActionListener(this);
     b2.addActionListener(this);
     
     
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String msg=ae.getActionCommand();
		if(msg.equals("Next"))
		{
			String name=t1.getText();
            String meterNo=l11.getText();
			String address=t3.getText();
			String city=t4.getText();
			String state=t5.getText();
			String email=t6.getText();
			String phone=t7.getText();
			
           String q="insert into customer values('"+name+"','"+meterNo+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
           String q1="insert into login values('"+meterNo+"','','','','') ";
			try
			{
				Conn c1=new Conn();
				c1.s.executeUpdate(q);
				c1.s.executeUpdate(q1);
				this.setVisible(false);
				new MeterInfomation(meterNo).setVisible(true);
				
			}
			catch (Exception i) {
				i.printStackTrace();
			}
		}
		else if(msg.equals("Cancel"))
		{
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new NewCustomer().setVisible(true);
	}
}
