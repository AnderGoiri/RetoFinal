package loginGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class UserLogInPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername, lblPassword, lblTitle, lblAdvice;
	private JSeparator separator;
	private JButton btnLogIn, btnChangeToSignUp;

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
		setOpaque(false);

		// --- JLabels ---
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblUsername.setBounds(50, 150, 128, 68);
		add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblPassword.setBounds(50, 258, 128, 68);
		add(lblPassword);
		
		lblTitle = new JLabel("Welcome!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Elephant", Font.PLAIN, 45));
		lblTitle.setBounds(50, 10, 735, 68);
		add(lblTitle);
		
		lblAdvice = new JLabel("Please, identify yourself by inserting your username and password");
		lblAdvice.setForeground(new Color(0, 151, 178));
		lblAdvice.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdvice.setBounds(50, 89, 697, 30);
		add(lblAdvice);

		// --- JTextField ---
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldUsername.setBounds(188, 150, 559, 68);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);

		// --- PasswordField ---
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(188, 253, 559, 68);
		add(passwordField);

		// --- Separator ---
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(10, 80, 817, 1);
		add(separator);

		// --- JButton ---
		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(559, 338, 188, 79);
		add(btnLogIn);
		btnLogIn.addActionListener(logInListener);

		btnChangeToSignUp = new JButton("Sign Up");
		btnChangeToSignUp.setBounds(188, 350, 160, 67);
		add(btnChangeToSignUp);
		btnChangeToSignUp.addActionListener(this);
	}

	ActionListener logInListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				// actionPerformed receives the event from the login button

				// Create a LoginControllable Object
				LoginControllable login = LoginFactory.getLoginControllable();

				// the values for username and password are retrieved
				String username = new String(textFieldUsername.getText());
				String password = new String(passwordField.getPassword());

				if (username.isBlank() || password.isBlank()) {
					JOptionPane.showInputDialog(this, "Please, insert your username and password");
				} else {
					// the userLogin method is executed
					User auxUser = login.userLogin(username, password);

					// if the login is succesful, this window will disclose and the corresponding
					// member/manager window will open
					StoreMenuWindow storeMenuPanel = new StoreMenuWindow(this, true, auxUser);
					// dispose this window
					storeMenuPanel.setVisible(true);
					storeMenuPanel.setLocationRelativeTo(null);
				}
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(null, e1.getMessage());
			
			}

		}

	};

	@Override
	public void actionPerformed(ActionEvent e) {
		// To call the UserRegisterPanel we need to go back to the JFrame
		((Win_login_register)(this.getParent().getParent().getParent().getParent().getParent())).getUserRegisterPanel().setVisible(true);
		this.setVisible(false);

	}

}
