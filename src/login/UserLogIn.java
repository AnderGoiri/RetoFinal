package login;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class UserLogIn extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public UserLogIn() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblNewLabel.setBounds(50, 150, 128, 68);
		add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblPassword.setBounds(50, 310, 128, 68);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(188, 150, 559, 68);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 310, 559, 68);
		add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Old English Text MT", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(50, 10, 735, 68);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 80, 817, 7);
		add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Please, identify yourself by inserting your username and password");
		lblNewLabel_2.setForeground(new Color(0, 151, 178));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(50, 89, 697, 30);
		add(lblNewLabel_2);
	}
}
