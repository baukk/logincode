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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class addlogin {

	private JFrame frame;
	private JTextField addloginuser;
	private JPasswordField addloginpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addlogin window = new addlogin();
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
	public addlogin() {
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
		
		JLabel lblNewLabel = new JLabel("user");
		lblNewLabel.setBounds(46, 33, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPswd = new JLabel("pswd");
		lblPswd.setBounds(46, 84, 45, 13);
		frame.getContentPane().add(lblPswd);
		
		addloginuser = new JTextField();
		addloginuser.setBounds(127, 30, 96, 19);
		frame.getContentPane().add(addloginuser);
		addloginuser.setColumns(10);
		
		addloginpass = new JPasswordField();
		addloginpass.setBounds(127, 81, 96, 19);
		frame.getContentPane().add(addloginpass);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String useradd=addloginuser.getText();
				String passadd=addloginpass.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3360/login","root","root");
//					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3360/ticket","root","root");
					String q="insert into logininfo values('"+useradd+"','"+passadd+"')";
					Statement st= con.createStatement();
					st.executeUpdate(q);
					JOptionPane.showMessageDialog(btnNewButton, "Login Info Added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(75, 139, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
