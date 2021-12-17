package BillingSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import net.proteanit.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener {

	JPanel p1, p2;
	JLabel l1, l2;
	Choice c1, c2;
	JButton b1, b2;
	JTable table;
	

	public DepositDetails() {

		// first Panel
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setSize(600, 100);
		p1.setBackground(Color.WHITE);
		l1 = new JLabel("Sort by Meter Number");
		l1.setBounds(25, 20, 150, 20);
		p1.add(l1);
		c1 = new Choice();
		try {
			String q = "select meter_no from customer";
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(q);
			while (rs.next()) {
				c1.add(rs.getString("meter_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(175, 20, 100, 20);
		p1.add(c1);

		l2 = new JLabel("Sort By Month");
		l2.setBounds(360, 20, 100, 20);
		p1.add(l2);
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

		c2.setBounds(470, 20, 100, 20);
		p1.add(c2);

		b1 = new JButton("Search");
		b1.setBounds(25, 70, 100, 20);

		b2 = new JButton("Print");
		b2.setBounds(147, 70, 100, 20);
		b1.addActionListener(this);
		b2.addActionListener(this);
		p1.add(b1);
		p1.add(b2);

		p2 = new JPanel();
		p2.setLayout(null);
	

		int i = 0, j = 0;
		try {
			String q = "Select * from bill";
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(q);
			table = new JTable();
			table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 0, 636, 461);
		p2.add(jsp);
		p2.setSize(600, 400);
		setLayout(null);

		p1.setBounds(0, 0, 650, 100);
		p2.setBounds(0, 100, 650, 500);
		add(p1);
		add(p2);


		setSize(650, 600);
		setLocation(260,100);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			try {
				String query = "Select * from bill where meter_no='" + c1.getSelectedItem() + "' AND month='"+c2.getSelectedItem()+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));				

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			try {
				table.print();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new DepositDetails().setVisible(true);
	}

}
