package BillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class GenerateBill extends JFrame implements ActionListener{
	JPanel p;
	JLabel l1,l2;
	JButton b1;
	JTextArea t1;
	Choice c1,c2;
	String meterno;
	public GenerateBill(String meterno) {
		super("Generate Bill");
		setSize(500,700);
		setLayout(new BorderLayout());
        this.meterno=meterno;
		l1=new JLabel("Generate Bill");
		p=new JPanel();
		
		l2=new JLabel(meterno);
		
		c2=new Choice();
		
		

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
		
		b1=new JButton("Generate Bill");
		t1=new JTextArea(90,50);
		
		JScrollPane jsp=new JScrollPane(t1);
		t1.setFont(new Font("Sanserif",Font.PLAIN,18));
		t1.setText("\t Click Generate Bill Button\n\t To get the Bill Statement");
		
		p.add(l1);
		p.add(l2);
		p.add(c2);
		
		add(p,"North");
		add(b1,"South");
		
		add(jsp,"Center");
		
		b1.addActionListener(this);
		setLocation(350,40);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Conn c=new Conn();
		    String month=c2.getSelectedItem();
		   
		    t1.setText("                 Uttar Pradesh Power Corporation Limited\n              Electricity Bill for the month of "+month+" ,2021\n\n\n");
		    ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meterno+"'");
		    if(rs.next())
		    {
		    	t1.append("\n     Customer Name :       "+rs.getString("name"));
		    	t1.append("\n     Meter Number  :       "+rs.getString("meter_no"));
		    	t1.append("\n     Address       :       "+rs.getString("address"));
		    	t1.append("\n     State         :       "+rs.getString("state"));
		    	t1.append("\n     City          :       "+rs.getString("city"));
		    	t1.append("\n     Email         :       "+rs.getString("email"));
		    	t1.append("\n     Phone number  :       "+rs.getString("phone"));
		    	t1.append("\n--------------------------------------------------------------");
		    	t1.append("\n\n");}
		    
		      rs=c.s.executeQuery("select * from meterinfo where meterno='"+meterno+"'");
		    		  if(rs.next())
		    		  {
		    			  t1.append("\n     Meter Location :       "+rs.getString("meterlocation"));
		    			  t1.append("\n     Meter Type     :       "+rs.getString("metertype"));
		    			  t1.append("\n     Phase Code     :       "+rs.getString("phasecode"));
		    			  t1.append("\n     Bill Type      :       "+rs.getString("billtype"));
		    			  t1.append("\n     Days           :       "+rs.getString("days"));
		    			  t1.append("\n");
		    			  t1.append("\n---------------------------------------------------------------");
		    			  t1.append("\n\n");
		    		  }
		    rs=c.s.executeQuery("select * from tax");	
		    if(rs.next())
		    {             t1.append("\n     Meter Rent         :       "+rs.getString("meter_rent"));
		    			  t1.append("\n     Service Charge     :       "+rs.getString("service_charge"));
		    			  t1.append("\n     Service Tax        :       "+rs.getString("service_tax"));
		    			  t1.append("\n     Swacch Bharat CESS :       "+rs.getString("swacch_bharat_cess"));
		    			  t1.append("\n     Fixed Tax          :       "+rs.getString("fixed_tax"));
		    			  t1.append("\n\n");
		    		  }
		      rs=c.s.executeQuery("select * from bill where meter_no='"+meterno+"'");
		              if(rs.next())
		              {
		            	  t1.append("\n     Current Month :       "+rs.getString("month"));
		            	  t1.append("\n     Units Conumed :       "+rs.getString("units"));
		            	  t1.append("\n     Total Charges :       "+rs.getString("totalbill"));
		            	  t1.append("\n     Status        :       "+rs.getString("status"));
		            	  t1.append("\n-----------------------------------------------------------------");
		            	  t1.append("\n     Total Payable :       "+rs.getString("totalbill"));
		              }
		    		  }
		    	
		    
		 catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
   public static void main(String[] args) {
	new GenerateBill("").setVisible(true);
}
}
