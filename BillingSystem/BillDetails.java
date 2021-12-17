package BillingSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;

public class BillDetails extends JFrame {
JPanel p1;
JTable t;
public BillDetails(String meterno)
{
	setSize(650, 600);
	setLocation(260,100);
	try
	{   String q="select * from bill where meter_no ='"+meterno+"'";
		Conn c=new Conn();
		ResultSet rs=c.s.executeQuery(q);
		t=new JTable();
		t.setModel(DbUtils.resultSetToTableModel(rs));
		JScrollPane jsp=new JScrollPane(t);
		add(jsp,"Center");
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
public static void main(String[] args) {
	new BillDetails("").setVisible(true);
}
}
