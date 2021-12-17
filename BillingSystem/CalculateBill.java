package BillingSystem;

import java.awt.*;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.event.*;
import java.sql.ResultSet;

public class CalculateBill extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	Choice c1, c2;
	JTextField tf1;
	JButton b1, b2;
	JPanel p1;

	public CalculateBill() {

		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(248, 250, 195));

		JLabel title = new JLabel("Calculate Electricity Bill");
		title.setFont(new Font("Sanserif", Font.BOLD, 26));
		title.setBounds(85, 20, 300, 45);
		p1.add(title);

		l1 = new JLabel("Meter Number");
		l1.setBounds(80, 90, 100, 20);
		c1 = new Choice();
		try {
			String q = "Select meter_no from customer";
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(q);
			while (rs.next()) {
				c1.add(rs.getString("meter_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		c1.setBounds(240, 90, 150, 20);
		
		
		p1.add(l1);
		p1.add(c1);

		l2 = new JLabel("Name");
		l2.setBounds(80, 130, 100, 20);
		l3 = new JLabel("Customer Name");
		l3.setBounds(240, 130, 150, 20);
		p1.add(l2);
		p1.add(l3);

		l4 = new JLabel("Address");
		l4.setBounds(80, 170, 100, 20);
		l5 = new JLabel("Customer Address");
		l5.setBounds(240, 170, 150, 20);
		p1.add(l4);
		p1.add(l5);
		
		//set default selected name and address
		try
		{
			String query="Select name,address from customer where meter_no ='"+c1.getSelectedItem()+"'";
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next())
			{
				l3.setText(rs.getString("name"));
				l5.setText(rs.getString("address"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//set name and address
		
	c1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					String query="Select name,address from customer where meter_no ='"+c1.getSelectedItem()+"'";
					Conn c=new Conn();
					ResultSet rs=c.s.executeQuery(query);
					if(rs.next())
					{
						l3.setText(rs.getString("name"));
						l5.setText(rs.getString("address"));
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		

		l6 = new JLabel("Units Consumed");
		l6.setBounds(80, 210, 100, 20);
		tf1 = new JTextField(15);
		tf1.setBounds(240, 210, 150, 20);
		p1.add(l6);
		p1.add(tf1);

		l7 = new JLabel("Month");
		l7.setBounds(80, 250, 100, 20);
		c2 = new Choice();
		c2.add("January");
		c2.add("February");
		c2.add("March");
		c2.add("April");
		c2.add("May");
		c2.add("June");
		c2.add("July");
		c2.add("August");
		c2.add("September");
		c2.add("October");
		c2.add("November");
		c2.add("December");
		c2.setBounds(240, 250, 150, 20);
		p1.add(l7);
		p1.add(c2);

		b1 = new JButton("Submit");
		b1.setBounds(100, 330, 100, 30);
		b2 = new JButton("Cancel");
		b2.setBounds(260, 330, 100, 30);

		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p1.add(b1);
		p1.add(b2);

		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/calbill.jpg"));
		Image i1 = ic1.getImage().getScaledInstance(240, 280, Image.SCALE_DEFAULT);
		l8 = new JLabel(new ImageIcon(i1));

		setLayout(new BorderLayout());

		add(l8, "West");
		add(p1, "Center");

		b1.addActionListener(this);
		b2.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);
		setSize(700, 460);
		setLocation(350, 220);
	}

	public void actionPerformed(ActionEvent ae) {
     
		if(ae.getSource()==b1)
		{
		String meterno= c1.getSelectedItem();
		String name= l3.getText();
		String address = l5.getText();
		String units=tf1.getText();
		String month=c2.getSelectedItem();
		
		try
		{   String q="Select * from tax";
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery(q);
			int costPerUnit = 0,meterrent=0,servicecharge=0,servicetax=0,cess=0,fixedtax=0;
			while(rs.next())
			{
				 costPerUnit=Integer.parseInt(rs.getString("cost_per_unit"));
				 meterrent=Integer.parseInt(rs.getString("meter_rent"));
				 servicecharge=Integer.parseInt(rs.getString("service_charge"));
				 servicetax=Integer.parseInt(rs.getString("service_tax"));
				 cess=Integer.parseInt(rs.getString("swacch_bharat_cess"));
				 fixedtax=Integer.parseInt(rs.getString("fixed_tax"));
			}
			int unit=Integer.parseInt(units);
			
			int total=(costPerUnit*unit)+meterrent+servicecharge+servicetax+cess+fixedtax;		
			String totalunits=""+total;
			
			String q2="insert into bill values('"+meterno+"','"+month+"','"+units+"','"+totalunits+"','"+"NOT PAID"+"')";
			c.s.executeUpdate(q2);
			JOptionPane.showMessageDialog(null, "bill generated");
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
		new CalculateBill().setVisible(true);
	}

}