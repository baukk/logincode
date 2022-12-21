package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class checklogin {

	private JFrame frame;
	private JTextField usercheck;
	private JPasswordField passcheck;
	private JButton b1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checklogin window = new checklogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public checklogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(34, 62, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("check login");
		lblNewLabel_1.setBounds(76, 10, 144, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(23, 143, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		usercheck = new JTextField();
		usercheck.setBounds(139, 59, 96, 19);
		frame.getContentPane().add(usercheck);
		usercheck.setColumns(10);
//		String us="";
//		String ps="";
		passcheck = new JPasswordField();
		passcheck.setBounds(139, 140, 96, 19);
		frame.getContentPane().add(passcheck);
		
		b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=(String)usercheck.getText();
				String pass=(String)passcheck.getText();
				 String us = null,ps = null; 
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3360/login","root","root");
//					String q="Select * from logininfo";
					String q="select * from logininfo where username='"+user+"' and password='"+pass+"' ";
					Statement st= con.createStatement();
					 ResultSet rs = st.executeQuery(q);
				    
					 while (rs.next()) {
				        us = rs.getString(1);
				        ps = rs.getString(2);
				        System.out.println(user +pass + pass + ps);
				      }
				      if(user.equals(us) && pass.equals(ps)) {
					JOptionPane.showMessageDialog(b1, "Correct");
					}
				      else {
				    	  JOptionPane.showMessageDialog(b1, "wrong");
				      }

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b1.setBounds(76, 205, 85, 21);
		frame.getContentPane().add(b1);
	}

}
