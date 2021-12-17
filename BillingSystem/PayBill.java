package BillingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PayBill extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l6, l7, l8, image;
	JLabel tf1, tf2, tf3, tf4;
	Choice  c2;
	JButton b1, b2;
	JPanel p1;
    String meterno;
  
	public PayBill(String meterno) {

		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
        this.meterno=meterno;
		
		JLabel title = new JLabel("Calculate Electricity Bill");
		title.setFont(new Font("Sanserif", Font.BOLD, 26));
		title.setBounds(85, 20, 300, 45);
		p1.add(title);

		l1 = new JLabel("Meter Number");
		l1.setBounds(80, 90, 100, 20);
		tf1 = new JLabel("Sample Meter");

		tf1.setBounds(240, 90, 150, 20);

		p1.add(l1);
		p1.add(tf1);

		l2 = new JLabel("Name");
		l2.setBounds(80, 130, 100, 20);
		l3 = new JLabel("Customer Name");
		l3.setBounds(240, 130, 150, 20);
		p1.add(l2);
		p1.add(l3);

		l4 = new JLabel("Month");
		l4.setBounds(80, 170, 100, 20);
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
		
		
		
		c2.setBounds(240, 170, 150, 20);
		p1.add(l4);
		p1.add(c2);

		l6 = new JLabel("Units");
		l6.setBounds(80, 210, 100, 20);
		tf2 = new JLabel("Sample Units");
		tf2.setBounds(240, 210, 100, 20);
		p1.add(l6);
		p1.add(tf2);

		l7 = new JLabel("Total Bill");
		l7.setBounds(80, 250, 100, 20);
		tf3 = new JLabel("Sample Bill");
		tf3.setBounds(240, 250, 150, 20);
		p1.add(l7);
		p1.add(tf3);

		l8 = new JLabel("Status");
		l8.setBounds(80, 290, 100, 20);
		tf4 = new JLabel("Sample Status");
		tf4.setBounds(240, 290, 100, 20);
		p1.add(l8);
		p1.add(tf4);

		b1 = new JButton("PAY");
		b1.setBounds(100, 360, 100, 30);
		b2 = new JButton("Cancel");
		b2.setBounds(260, 360, 100, 30);

		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p1.add(b1);
		p1.add(b2);

		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/paybillicon.png"));
		Image i1 = ic1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		image = new JLabel(new ImageIcon(i1));

		setLayout(null);
		image.setBounds(35, 105, 220, 220);
		p1.setBounds(220, 0, 400, 460);
		add(image);
		add(p1);

		b1.addActionListener(this);
		b2.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);
		setSize(700, 480);
		setLocation(350, 220);
		
		try {
			String q = "select * from bill where meter_no='" + meterno + "' AND month='"+"January"+"'";
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(q);
			while (rs.next()) {
				tf2.setText(rs.getString("units"));
				tf3.setText(rs.getString("totalbill"));
				tf4.setText(rs.getString("status"));
				if (rs.getString("status").equals("NOT PAID")) {
					
					tf4.setForeground(Color.RED);
				} else {
					
					tf4.setForeground(Color.GREEN);
				}

			}

			String q2 = "select name from customer where meter_no ='" + meterno + "'";
			rs = c.s.executeQuery(q2);
			while (rs.next()) {
				tf1.setText(rs.getString("meter_no"));
				l3.setText(rs.getString("name"));
			}
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		
       
		c2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {

				try {
					String q = "select * from bill where meter_no='" + meterno + "' AND month='"+ c2.getSelectedItem()+"'";
					Conn c = new Conn();
					ResultSet rs = c.s.executeQuery(q);
					while (rs.next()) {
						tf2.setText(rs.getString("units"));
						tf3.setText(rs.getString("totalbill"));
						tf4.setText(rs.getString("status"));
						if (rs.getString("status").equals("NOT PAID")) {
							
							tf4.setForeground(Color.RED);
						} else {
							
							tf4.setForeground(Color.GREEN);
						}

					}

					String q2 = "select name from customer where meter_no ='" + meterno + "'";
					rs = c.s.executeQuery(q2);
					while (rs.next()) {
						tf1.setText(rs.getString("meter_no"));
						l3.setText(rs.getString("name"));
					}
				} catch (Exception ae) {
					ae.printStackTrace();
				}
				
			}
		});

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			try {
				String q = "Update bill SET status ='PAID' where meter_no='"+meterno+"'";
				Conn c = new Conn();
				c.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Paid Successfully");
				this.setVisible(false);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new PayBill("").setVisible(true);
	}
}
