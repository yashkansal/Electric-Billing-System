package BillingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
	
	String meterno;
	public Project(String meterno,String person) {
		super("Electric Billing System");
		this.meterno=meterno;
		setSize(1350,800);
		
		// Adding Background image
		ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icon/billingsoftware.png"));
		Image i1=ic.getImage().getScaledInstance(1350, 677, Image.SCALE_DEFAULT);
		JLabel l1=new JLabel(new ImageIcon(i1));
		
		add(l1); // adding background to the frame
		
		//First Column
		JMenuBar mb=new JMenuBar();
		
		//master
		JMenu master=new JMenu("Master");
		JMenuItem m1=new JMenuItem("New Customer");
		JMenuItem m2=new JMenuItem("Customer Details");
		JMenuItem m3=new JMenuItem("Deposit Details");
		JMenuItem m4=new JMenuItem("Calculate Bill");
		master.setForeground(Color.BLUE);
		
		//master items
		m1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/newCustomer.png"));
		Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m1.setIcon(new ImageIcon(image1));
		m1.setMnemonic('D');
		m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
		
        m2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
		Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m2.setIcon(new ImageIcon(image2));
		m2.setMnemonic('M');
		m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        
        m3.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/deposit.png"));
		Image image3=icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m3.setIcon(new ImageIcon(image3));
		m3.setMnemonic('N');
		m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        m3.setBackground(Color.WHITE);
        
        m4.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/deposit.png"));
		Image image4=icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m4.setIcon(new ImageIcon(image4));
		m4.setMnemonic('B');
		m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        m4.setBackground(Color.WHITE);
        
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        
        //Information
        JMenu information=new JMenu("Information");
        JMenuItem if1=new JMenuItem("Update Information");
        JMenuItem if2=new JMenuItem("View Information");
        
        if1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/lastbill.png"));
		Image image5=icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		if1.setIcon(new ImageIcon(image5));
	    if1.setMnemonic('L');
		if1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        if1.setBackground(Color.WHITE);
       
        if2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/lastbill.png"));
		Image image6=icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		if2.setIcon(new ImageIcon(image6));
	    if2.setMnemonic('L');
		if2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        if2.setBackground(Color.WHITE);
        
        if1.addActionListener(this);
        if2.addActionListener(this);
        
        
        
        
        
        
        

       //User
        JMenu user=new JMenu("User");
        JMenuItem u1=new JMenuItem("Pay Bill");
        JMenuItem u2=new JMenuItem("Bill Details");
    
        user.setForeground(Color.RED);
        
        //users items
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/paybill.png"));
		Image image7=icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u1.setIcon(new ImageIcon(image7));
		u1.setMnemonic('P');
		u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
        u2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/calculatebill.png"));
		Image image8=icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u2.setIcon(new ImageIcon(image8));
		u2.setMnemonic('B');
		u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        
       
        
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        
        
        
        //Report
        JMenu report=new JMenu("Report");
        JMenuItem r1=new JMenuItem("Generate Bill");
        report.setForeground(Color.BLUE);
        
        r1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/gereatebill.png"));
		Image image9=icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		r1.setIcon(new ImageIcon(image9));
		r1.setMnemonic('R');
		r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);

        r1.addActionListener(this);
        
        //Utility
        JMenu utility=new JMenu("Utility");
        JMenuItem ut1=new JMenuItem("Notepad");
        JMenuItem ut2=new JMenuItem("Calculator");
        JMenuItem ut3=new JMenuItem("Web Browser");
        utility.setForeground(Color.RED);
        
        
        ut1.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
		Image image10=icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ut1.setIcon(new ImageIcon(image10));
		ut1.setMnemonic('C');
		ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		ut1.setBackground(Color.WHITE);
		
		ut2.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
		Image image11=icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ut2.setIcon(new ImageIcon(image11));
		ut2.setMnemonic('X');
		ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		ut2.setBackground(Color.WHITE);
        
		ut3.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/webbrowser.png"));
		Image image12=icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ut3.setIcon(new ImageIcon(image12));
		ut3.setMnemonic('W');
		ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
		ut3.setBackground(Color.WHITE);
        
		ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);
        
        JMenu exit=new JMenu("Log_out");
        JMenuItem ex=new JMenuItem("Exit");
        exit.setForeground(Color.BLUE);
        
        ex.setFont(new Font("monospaced",Font.PLAIN,12));
		ImageIcon icon13=new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
		Image image13=icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ex.setIcon(new ImageIcon(image13));
		ex.setMnemonic('Z');
		ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        
        
        master.add(m1);
        master.add(m2);
        master.add(m3);
        master.add(m4);
        
        information.add(if1);
        information.add(if2);
        
        user.add(u1);
        user.add(u2);
       
        
        report.add(r1);
        
        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);
        
        exit.add(ex);
        
        if(person.equals("Admin"))
        {mb.add(master);
        mb.add(utility);
        mb.add(exit);
        }
        else
        {
        	mb.add(information);
        	mb.add(user);
        	mb.add(report);
        	mb.add(utility);
            mb.add(exit);
        	
        }
        
        
        
        
        
        
        
        setJMenuBar(mb);
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
        
	}
   public void actionPerformed(ActionEvent ae) {
	   String msg=ae.getActionCommand();
	   if(msg.equals("New Customer"))
	   {
		   new NewCustomer().setVisible(true);
	   }
	   else if(msg.equals("Customer Details"))
	   {
		   new CustomerDetails().setVisible(true);
	   }
	   else if(msg.equals("Deposit Details"))
	   {
		   new DepositDetails().setVisible(true);
	   }
	   else if(msg.equals("Calculate Bill"))
	   {
		   new CalculateBill().setVisible(true);
	   }
	     else if(msg.equals("Update Information"))
	   {
		   new UpdateCustomerInfo(meterno).setVisible(true);
	   }
	   else if(msg.equals("View Information"))
	   {
		   new ViewCustomerDetails(meterno).setVisible(true);
	   }
	   
	   
	   
	   
	   else if(msg.equals("Pay Bill"))
	   {
		   new PayBill(meterno).setVisible(true);
	   }
	   else if(msg.equals("Bill Details"))
	   {
		   new BillDetails(meterno).setVisible(true);
	   }
	   
	   
	   
	   
	   else if(msg.equals("Generate Bill"))
	   {
		   new GenerateBill(meterno).setVisible(true);
	   }

	   
	   
	   
	   
	   
	   
	   
	   
	   
	   else if(msg.equals("Notepad"))
	   {
		   try
		   {
			   Runtime.getRuntime().exec("notepad.exe");
		   }catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   else if(msg.equals("Calculator"))
	   {
		   try
		   {
			   Runtime.getRuntime().exec("calc.exe");
		   }catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   else if(msg.equals("Web Browser"))
	   {
		   try
		   {
			   Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		   }catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   else if(msg.equals("Exit"))
	   {
		   this.setVisible(false);
		   new Login().setVisible(true);
	   }
	     }
   
   public static void main(String[] args) {
	new Project("","").setVisible(true);
}
}

