package BillingSystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SignUp extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6;
	JPanel p1;
	JTextField tf1, tf2, tf3;
	JPasswordField pf;
	Choice c1;
	JButton b1, b2;

	public SignUp() {
		super("Sign-Up");
		setBounds(400, 250, 720, 450); // 4 argumnets =>first 2 Location ,last 2 size
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(20, 20, 670, 350);
		p1.setBackground(Color.WHITE);
		p1.setForeground(new Color(224, 224, 224));
		p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 113, 254)));
		add(p1);

		l1 = new JLabel("Username :");
		l1.setForeground(Color.gray);
		l1.setBounds(70, 60, 100, 20);
		l1.setFont(new Font("Sanserif", Font.BOLD, 15));
		p1.add(l1);

		l2 = new JLabel("Name :");
		l2.setForeground(Color.gray);
		l2.setBounds(70, 100, 100, 20);
		l2.setFont(new Font("Sanserif", Font.BOLD, 15));
		p1.add(l2);

		l3 = new JLabel("Password :");
		l3.setForeground(Color.gray);
		l3.setBounds(70, 140, 100, 20);
		l3.setFont(new Font("Sanserif", Font.BOLD, 15));
		p1.add(l3);

		l4 = new JLabel("Create Account As :");
		l4.setForeground(Color.gray);
		l4.setBounds(70, 180, 150, 20);
		l4.setFont(new Font("Sanserif", Font.BOLD, 15));
		p1.add(l4);

		l5 = new JLabel("Meter Number :");
		l5.setForeground(Color.gray);
		l5.setBounds(70, 220, 150, 20);
		l5.setFont(new Font("Sanserif", Font.BOLD, 15));
		p1.add(l5);

		l5.setVisible(false);

		tf3 = new JTextField(15);
		tf3.setBounds(270, 220, 170, 25);
		tf3.setFont(new Font("Sanserif", Font.PLAIN, 15));
		tf3.setForeground(Color.GRAY);
		p1.add(tf3);

		tf3.setVisible(false);

		tf1 = new JTextField(15);
		tf1.setBounds(270, 60, 170, 25);
		tf1.setFont(new Font("Sanserif", Font.PLAIN, 15));
		tf1.setForeground(Color.GRAY);
		p1.add(tf1);

		tf2 = new JTextField(15);
		tf2.setBounds(270, 100, 170, 25);
		tf2.setFont(new Font("Sanserif", Font.PLAIN, 15));
		tf2.setForeground(Color.GRAY);
		p1.add(tf2);

		pf = new JPasswordField(15);
		pf.setBounds(270, 140, 170, 25);
		p1.add(pf);

		c1 = new Choice();
		c1.add("Admin");
		c1.add("Customer");
		c1.setForeground(Color.BLUE);
		c1.setBounds(270, 180, 170, 25);
		p1.add(c1);

		c1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (c1.getSelectedItem().equals("Customer")) {
					l5.setVisible(true);
					tf3.setVisible(true);
				} else if (c1.getSelectedItem().equals("Admin")) {
					l5.setVisible(false);
					tf3.setVisible(false);
				}

			}
		});

		b1 = new JButton("Create");
		b1.setBounds(180, 280, 100, 33);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		p1.add(b1);

		b2 = new JButton("Back");
		b2.setBounds(340, 280, 100, 33);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		p1.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/signupCover.png"));
		Image i = ic.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
		l6 = new JLabel(new ImageIcon(i));
		l6.setBounds(410, 50, 300, 250);
		p1.add(l6);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			String a = tf1.getText();
			String b = tf2.getText();
			String c = pf.getText();
			String d = c1.getSelectedItem();
			String e = tf3.getText();

			String str = "";
			
				str = "insert into login values('" + e + "','" + a + "','" + b + "','" + c + "','" + d + "')";
				try {
					Conn c2 = new Conn();
					c2.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Account-Created");
					this.setVisible(false);
					new Login().setVisible(true);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			

		}
		else
		{
			this.setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new SignUp().setVisible(true);
	}
}
