package BillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4;
	JTextField tf;
	JPasswordField pf;
	Choice c1;
	JButton b1, b2, b3;
	JPanel p1, p2, p3, p4;

	Login() {
		super("Login Page");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(400, 220, 500, 290);
		l1 = new JLabel("Username");
		l1.setBounds(180, 50, 100, 20);
		add(l1);

		l2 = new JLabel("Password");
		l2.setBounds(180, 90, 100, 20);
		add(l2);

		l3 = new JLabel("Logging in as");
		l3.setBounds(180, 130, 100, 20);
		add(l3);

		tf = new JTextField(15);
		tf.setBounds(300, 50, 150, 20);
		add(tf);
		pf = new JPasswordField(15);
		pf.setBounds(300, 90, 150, 20);
		add(pf);

		c1 = new Choice();
		c1.add("Admin");
		c1.add("Customer");
		c1.setBounds(300, 130, 150, 20);
		add(c1);

		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/loginimage.png"));
		Image i = ic.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);

		l4 = new JLabel(new ImageIcon(i));

		l4.setBounds(-10, 40, 200, 190);
		add(l4);

		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		b1 = new JButton("Login", new ImageIcon(i1));
		b1.setBounds(230, 170, 95, 20);
		add(b1);

		ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
		Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		b2 = new JButton("Cancel", new ImageIcon(i2));
		b2.setBounds(340, 170, 95, 20);
		add(b2);

		ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		Image i3 = ic3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		b3 = new JButton("SignUp", new ImageIcon(i3));
		b3.setBounds(280, 200, 95, 20);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				Conn c = new Conn();
				String a = tf.getText();
				String b = pf.getText();
				String d = c1.getSelectedItem();
				String q = "select * from login where username ='" + a + "' and password ='" + b + "' and user ='" + d
						+ "'";
				ResultSet rs = c.s.executeQuery(q);
				if (rs.next()) {
				  new Project(rs.getString("meter_no"),rs.getString("user")).setVisible(true);
					
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid User");
					tf.setText("");
					pf.setText("");

				}

			} catch (Exception ae) {
				ae.printStackTrace();
			}

		} else if (e.getSource() == b2) {
			this.setVisible(false);
			System.exit(0);
		} else if (e.getSource() == b3) {
			this.setVisible(false);
			new SignUp().setVisible(true);
		}

	}

	public static void main(String[] args) {
		new Login().setVisible(true);
	}

}
