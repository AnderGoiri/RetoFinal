package loginGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;
import logicTier.LoginControllable;
import logicTier.LoginFactory;
import model.User;
import storeMenuGUI.StoreMenuWindow;

import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class UserLogInPanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername, lblPassword, lblTitle, lblAdvice, lblSignUpAdvice, lblSignUp;
	private JSeparator separator, separatorSignUp;
	private JButton btnLogIn, btnChangeToSignUp;
	private JCheckBox chckbxShowHideLogIn;
	private final Font font1 = new Font("Tahoma", Font.ITALIC, 11);
	private final Font font2 = new Font("Tahoma", Font.BOLD | Font.ITALIC, 11);

	// --- Getters ---
	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	// ----------------

	/**
	 * Create the panel.
	 */
	public UserLogInPanel() {

		setLayout(null);
		setBounds(0, 0, 837, 560);

		// --- JLabels ---
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblUsername.setBounds(40, 150, 128, 68);
		add(lblUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblPassword.setBounds(40, 268, 128, 68);
		add(lblPassword);

		lblTitle = new JLabel("Welcome!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Elephant", Font.PLAIN, 45));
		lblTitle.setBounds(50, 10, 735, 68);
		add(lblTitle);

		lblAdvice = new JLabel("Please, identify yourself by inserting your username and password");
		lblAdvice.setForeground(new Color(0, 151, 178));
		lblAdvice.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdvice.setBounds(50, 89, 735, 30);
		add(lblAdvice);

		// --- JTextField ---
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldUsername.setBounds(168, 150, 560, 68);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);

		// --- PasswordField ---
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*'); //Cambia los caracteres del texto, mostrando el texto introducido con *
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(168, 268, 492, 68);
		add(passwordField);

		// --- Separator ---
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(10, 80, 817, 1);
		add(separator);

		// --- JButton ---
		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(588, 380, 160, 65);
		add(btnLogIn);
		btnLogIn.addActionListener(this);

		/*
		 * This is the code for the button when it was on the Win_login_Register. It is
		 * kept to use the same style later
		 * 
		 * btnLogIn = new JButton("LOG IN"); btnLogIn.setEnabled(false);
		 * btnLogIn.setVisible(false); btnLogIn.setBackground(new Color(0, 151, 178));
		 * btnLogIn.setForeground(new Color(255, 255, 255)); btnLogIn.setFont(new
		 * Font("Onyx", Font.BOLD, 45)); btnLogIn.setBounds(387, 470, 183, 81);
		 * contentPane.add(btnLogIn); btnLogIn.addActionListener(this);
		 * btnLogIn.addKeyListener(this);
		 */

		
		separatorSignUp = new JSeparator();
		separatorSignUp.setForeground(Color.WHITE);
		separatorSignUp.setBounds(10, 483, 817, 1);
		add(separatorSignUp);
		
		lblSignUpAdvice = new JLabel("You don't have an account?");
		lblSignUpAdvice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUpAdvice.setForeground(Color.DARK_GRAY);
		lblSignUpAdvice.setBounds(313, 505, 160, 30);
		add(lblSignUpAdvice);
		
		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(font1);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(new Color(0, 151, 178));
		lblSignUp.setBounds(473, 505, 50, 30);
		add(lblSignUp);
		lblSignUp.addMouseListener(this);
		
		chckbxShowHideLogIn = new JCheckBox("");
		chckbxShowHideLogIn.setOpaque(false);
		chckbxShowHideLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxShowHideLogIn.setBounds(660, 268, 68, 68);
		add(chckbxShowHideLogIn);
		chckbxShowHideLogIn.addActionListener(this);

		/*
		 * btnSignUp = new JButton("SIGN UP"); btnSignUp.setBackground(new Color(0, 151,
		 * 178)); btnSignUp.setForeground(new Color(255, 255, 255));
		 * btnSignUp.setFont(new Font("Onyx", Font.BOLD, 45)); btnSignUp.setBounds(387,
		 * 470, 183, 81); contentPane.add(btnSignUp); btnSignUp.addActionListener(this);
		 * btnSignUp.addKeyListener(this);
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(chckbxShowHideLogIn)) {
			if(chckbxShowHideLogIn.isSelected()) {
				passwordField.setEchoChar((char)0); //Casting 0 as a char makes the passwordField change the character
													//format of the text, uncensuring the text inside of it.
			}else {
				passwordField.setEchoChar('*');
			}
		}else if (e.getSource().equals(btnLogIn)) { // actionPerformed receives the event from the login button
			try {

				// Create a LoginControllable Object
				LoginControllable login = LoginFactory.getLoginControllable();

				// the values for username and password are retrieved
				String username = new String(textFieldUsername.getText());
				String password = new String(passwordField.getPassword());

				if (username.isBlank() || password.isBlank()) {
					JOptionPane.showMessageDialog(this, "Please, insert your username and password");
				} else {
					// the userLogin method is executed
					User auxUser = login.userLogin(username, password);

					// if the login is successful, this window will disclose and the corresponding
					// member/manager window will open
					StoreMenuWindow storeMenuPanel = new StoreMenuWindow(this, true, auxUser);
					storeMenuPanel.setVisible(true);
					storeMenuPanel.setLocationRelativeTo(null);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		

	}

	private void changePanel() {
		((Win_login_register) (this.getParent().getParent().getParent().getParent().getParent()))
		.getUserRegisterPanel().setVisible(true);
		this.clearRegisterFields();
		this.setVisible(false);
	}

	private void clearRegisterFields() {
		passwordField.setText("");
		textFieldUsername.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Method that displays the "UserRegisterPanel" when you click the Sign Up label.
		if(e.getSource().equals(lblSignUp)) {
			changePanel();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// Method that changes the Sign Up label's text format.
		if(e.getComponent().equals(lblSignUp)) {
			lblSignUp.setFont(font2);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getComponent().equals(lblSignUp)) {
			lblSignUp.setFont(font1);
		}
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
}
