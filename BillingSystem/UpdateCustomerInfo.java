package BillingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCustomerInfo extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1,b2;
	JTextField tf1,tf2,tf3,tf4,tf5;
	String meterno;
	public UpdateCustomerInfo(String meterno) {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setSize(680,480);
		setLocation(300,250);
		this.meterno=meterno;
		
		JLabel title=new JLabel("UPDATE CUSTOMER INFORMATION");
		title.setBounds(75, 10, 300, 40);
		title.setFont(new Font("Tohima",Font.BOLD,16));
		title.setForeground(Color.GRAY);
		add(title);
		
		l1=new JLabel("Name");
		l1.setBounds(35, 80, 100, 20);
		l2=new JLabel("Sample Name");
		l2.setBounds(170, 80, 100, 20);
		add(l1);
		add(l2);
		
		l3=new JLabel("Meter Number");
		l3.setBounds(35, 120, 100, 20);
		l4=new JLabel("Sample Number");
		l4.setBounds(170,120,100,20);
		add(l3);
		add(l4);
		
		l5=new JLabel("Address");
		l5.setBounds(35, 160, 100,20);
		tf1=new JTextField();
		tf1.setBounds(170, 160, 200, 20);
		add(l5);
		add(tf1);
		
		l6=new JLabel("City");
		l6.setBounds(35, 200, 100, 20);
		tf2=new JTextField();
		tf2.setBounds(170, 200, 200, 20);
		add(l6);
		add(tf2);
		
		l7=new JLabel("State");
		l7.setBounds(35, 240, 100, 20);
		tf3=new JTextField();
		tf3.setBounds(170, 240, 200, 20);
		add(l7);
		add(tf3);
		
		l8=new JLabel("Email");
		l8.setBounds(35, 280, 100, 20);
		tf4=new JTextField();
		tf4.setBounds(170, 280, 200, 20);
		add(l8);
		add(tf4);
		
		l9=new JLabel("Phone");
		l9.setBounds(35, 320, 100, 20);
		tf5=new JTextField();
		tf5.setBounds(170, 320, 200, 20);
		add(l9);
		add(tf5);
		
		b1=new JButton("Update");
		b1.setBounds(40, 375, 100, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(200, 375, 100, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icon/updateicon.jpg"));
		Image i=ic.getImage().getScaledInstance(240, 260, Image.SCALE_DEFAULT);
		l10 =new JLabel(new ImageIcon(i));
		l10.setBounds(390, 90, 240, 260);
		add(l10);
		
		
		try
		{  String q="Select * from customer where meter_no ='"+meterno+"'";
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery(q);
			while(rs.next())
			{
				l2.setText(rs.getString("name"));
				l4.setText(rs.getString("meter_no"));
				tf1.setText(rs.getString("address"));
				tf2.setText(rs.getString("city"));
				tf3.setText(rs.getString("state"));
				tf4.setText(rs.getString("email"));
				tf5.setText(rs.getString("phone"));
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
 	}
	
	public void actionPerformed(ActionEvent ae)
	{if(ae.getSource()==b1)
	{
		try
		{  String q="Update customer SET address ='"+tf1.getText()+"',city ='"+tf2.getText()+"',state ='"+tf3.getText()+"',email ='"+tf4.getText()+"',phone ='"+tf5.getText()+"' where meter_no ='"+meterno+"' ";
			Conn c=new Conn();
			c.s.executeUpdate(q);
		    JOptionPane.showMessageDialog(null,"Infomation Updated");
		    this.setVisible(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	else
	{
		this.setVisible(false);
	}
		
	}
	public static void main(String[] args) {
		new UpdateCustomerInfo("").setVisible(true);
	}

}
