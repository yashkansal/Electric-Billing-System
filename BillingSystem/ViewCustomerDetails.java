package BillingSystem;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class ViewCustomerDetails extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JLabel image,tl1,tl2,tl3,tl4,tl5,tl6,tl7;
	JButton b1;
	String meterno;
	
	public ViewCustomerDetails(String meterno) {
		setLayout(null);
		setSize(620,520);
		getContentPane().setBackground(Color.WHITE);
		setLocation(400, 200);
		this.meterno=meterno;
		
		JLabel title=new JLabel("VIEW  CUSTOMER  INFORMATION");
		title.setBounds(170, 20, 300, 30);
		title.setFont(new Font("Arial",Font.BOLD,16));
		title.setForeground(new Color(173,187,191));
		add(title);
		
		l1=new JLabel("Name");
		l1.setBounds(40, 80, 100, 20);
		add(l1);
		tl1=new JLabel("Smaple Name");
		tl1.setBounds(160,80,100,20);
		add(tl1);
		
		l2=new JLabel("Meter Number");
		l2.setBounds(40, 120, 100, 20);
		add(l2);
		
		tl2=new JLabel("Sample No");
		tl2.setBounds(160, 120, 100, 20);
		add(tl2);
		
		l3=new JLabel("Address");
		l3.setBounds(40, 160, 100, 20);
		add(l3);
		
		tl3=new JLabel("Sample Address");
		tl3.setBounds(160, 160, 100, 20);
		add(tl3);
		
		l4=new JLabel("City");
		l4.setBounds(40, 200, 100, 20);
		add(l4);
		
		tl4=new JLabel("Sample City");
		tl4.setBounds(160, 200, 100, 20);
		add(tl4);
		
		l5=new JLabel("State");
		l5.setBounds(350, 80, 100, 20);
		add(l5);
        
		tl5=new JLabel("Sample State");
		tl5.setBounds(425, 80, 100, 20);
		add(tl5);
		
		l6=new JLabel("Email");
		l6.setBounds(350, 120, 100, 20);
		add(l6);
		
		tl6=new JLabel("Sample Email");
		tl6.setBounds(425, 120, 150, 20);
		add(tl6);
		
		l7=new JLabel("Phone");
		l7.setBounds(350, 160, 100, 20);
		add(l7);
		tl7=new JLabel("Sample Phone");
		tl7.setBounds(425, 160, 100, 20);
		add(tl7);
		
		ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcus.jpg"));
		Image i=ic1.getImage().getScaledInstance(400, 190, Image.SCALE_DEFAULT);
		image=new JLabel(new ImageIcon(i));
		image.setBounds(80, 300, 400, 190);
		add(image);
		
		
		
		
		b1=new JButton("Back");
		b1.setBackground(Color.GRAY);
		b1.setForeground(Color.WHITE);
		b1.setBounds(250,275,100,30);
		add(b1);
		
		
		try
		{ String q="Select * from customer where meter_no='"+meterno+"'";
			Conn c=new Conn();
		    ResultSet rs=c.s.executeQuery(q);
		    while(rs.next())
		    {
		    	tl1.setText(rs.getString("name"));
		    	tl2.setText("459408");
		    	tl3.setText(rs.getString("address"));
		    	tl4.setText(rs.getString("city"));
		    	tl5.setText(rs.getString("state"));
		    	tl6.setText(rs.getString("email"));
		    	tl7.setText(rs.getString("phone"));
		    }
		    
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		b1.addActionListener(this);
		
		
	}
   
	public void actionPerformed(ActionEvent ae)
	{
	if(	ae.getSource()==b1)
	{
		this.setVisible(false);
	}
		
	}
	public static void main(String[] args)
	{
		new ViewCustomerDetails("").setVisible(true);
	}
	
}
