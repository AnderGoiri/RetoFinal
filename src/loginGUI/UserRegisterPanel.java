package loginGUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

import logicTier.LoginControllable;
import logicTier.LoginFactory;
import model.EnumStatusManager;
import model.Manager;
import model.Member;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * The UserRegisterPanel class is a JPanel that allows users to sign up into the
 * application.
 * 
 * @author Francisco Rafael de Ysasi González
 * @author Ander Goirigolzarri Iturburu
 */
public class UserRegisterPanel extends JPanel implements ActionListener, KeyListener, FocusListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldName, textFieldSurname, textFieldUsername, textFieldAddress, textFieldCreditCard,
			textFieldEmail;
	private JCheckBox chckbxManager, chckbxTechnician, chckbxSupervisor, chckbxShowHideSignUp;
	private JLabel lblAddress, lblCredirCard, lblRegistrationTitle, lblUserName, lblPassword, lblEmail, lblSurname,
			lblName, lblLogInAdvice, lblLogIn;
	private JPasswordField textFieldPassword;
	private JButton btnSignUp;
	private final Font font1 = new Font("Tahoma", Font.ITALIC, 11);
	private final Font font2 = new Font("Tahoma", Font.BOLD | Font.ITALIC, 11);

	// --- Getters ---
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldSurname() {
		return textFieldSurname;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public JTextField getTextFieldAddress() {
		return textFieldAddress;
	}

	public JTextField getTextFieldCreditCard() {
		return textFieldCreditCard;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JCheckBox getChckbxManager() {
		return chckbxManager;
	}

	public JCheckBox getChckbxTechnician() {
		return chckbxTechnician;
	}

	public JCheckBox getChckbxSupervisor() {
		return chckbxSupervisor;
	}

	public JLabel getLblAddress() {
		return lblAddress;
	}

	public JLabel getLblCredirCard() {
		return lblCredirCard;
	}
	// -----------------------------

	/**
	 * Create the panel.
	 */
	public UserRegisterPanel() {
		setLayout(null);
		setBounds(0, 0, 837, 560);

		// --- JLabel ---
		lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(58, 289, 244, 41);
		lblUserName.setFont(new Font("Constantia", Font.PLAIN, 25));
		add(lblUserName);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblPassword.setBounds(58, 369, 182, 41);
		add(lblPassword);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblEmail.setBounds(449, 120, 182, 51);
		add(lblEmail);

		lblCredirCard = new JLabel("Credit Card:");
		lblCredirCard.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblCredirCard.setBounds(449, 284, 201, 51);
		add(lblCredirCard);

		lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblSurname.setBounds(58, 210, 244, 41);
		add(lblSurname);

		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblName.setBounds(58, 131, 244, 41);
		add(lblName);

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblAddress.setBounds(449, 205, 264, 51);
		add(lblAddress);

		lblRegistrationTitle = new JLabel("Registration");
		lblRegistrationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationTitle.setFont(new Font("Elephant", Font.PLAIN, 45));
		lblRegistrationTitle.setBounds(256, 10, 323, 60);
		add(lblRegistrationTitle);

		lblLogInAdvice = new JLabel("Do you have a registered account?");
		lblLogInAdvice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogInAdvice.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInAdvice.setForeground(Color.DARK_GRAY);
		lblLogInAdvice.setBounds(255, 492, 234, 30);
		add(lblLogInAdvice);

		lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setForeground(new Color(0, 151, 178));
		lblLogIn.setBounds(484, 492, 55, 30);
		add(lblLogIn);
		lblLogIn.addMouseListener(this);

		// --- TextField ---
		textFieldName = new JTextField();
		textFieldName.setBounds(58, 169, 311, 41);
		add(textFieldName);
		textFieldName.setColumns(10);

		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(58, 249, 311, 41);
		add(textFieldSurname);

		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(58, 330, 311, 41);
		add(textFieldUsername);
		textFieldUsername.addFocusListener(this);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setEchoChar('*');
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(58, 409, 311, 41);
		add(textFieldPassword);

		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(449, 248, 311, 41);
		add(textFieldAddress);

		textFieldCreditCard = new JTextField();
		textFieldCreditCard.setColumns(10);
		textFieldCreditCard.setBounds(449, 328, 311, 41);
		add(textFieldCreditCard);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(449, 167, 311, 41);
		add(textFieldEmail);

		// --- CheckBox ---
		chckbxManager = new JCheckBox("Manager");
		chckbxManager.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxManager.setBounds(58, 76, 244, 41);
		chckbxManager.setOpaque(false);
		chckbxManager.addActionListener(managerListener);
		add(chckbxManager);
		chckbxManager.addKeyListener(this);

		chckbxSupervisor = new JCheckBox("Supervisor");
		chckbxSupervisor.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxSupervisor.setEnabled(false);
		chckbxSupervisor.setVisible(false);
		chckbxSupervisor.setOpaque(false);
		chckbxSupervisor.setBounds(459, 257, 201, 33);
		add(chckbxSupervisor);
		chckbxSupervisor.addKeyListener(this);

		chckbxTechnician = new JCheckBox("Technician");
		chckbxTechnician.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxTechnician.setEnabled(false);
		chckbxTechnician.setVisible(false);
		chckbxTechnician.setOpaque(false);
		chckbxTechnician.setBounds(459, 341, 201, 30);
		add(chckbxTechnician);
		chckbxTechnician.addKeyListener(this);

		chckbxShowHideSignUp = new JCheckBox("");
		chckbxShowHideSignUp.setOpaque(false);
		chckbxShowHideSignUp.setBounds(373, 409, 41, 41);
		add(chckbxShowHideSignUp);
		chckbxShowHideSignUp.addActionListener(this);

		// --- JButton ---
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Onyx", Font.PLAIN, 35));
		btnSignUp.setBackground(new Color(0, 151, 178));
		btnSignUp.setBounds(449, 409, 311, 41);
		add(btnSignUp);
		btnSignUp.addActionListener(this);

	}

// ActionListener for the manager check box
	ActionListener managerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (chckbxManager.isSelected()) {
				chckbxTechnician.setEnabled(true);
				chckbxTechnician.setVisible(true);
				chckbxSupervisor.setEnabled(true);
				chckbxSupervisor.setVisible(true);

				lblAddress.setEnabled(false);
				lblAddress.setVisible(false);
				lblCredirCard.setEnabled(false);
				lblCredirCard.setVisible(false);
				textFieldAddress.setEditable(false);
				textFieldAddress.setVisible(false);
				textFieldCreditCard.setEnabled(false);
				textFieldCreditCard.setVisible(false);

			} else {
				chckbxTechnician.setEnabled(false);
				chckbxTechnician.setVisible(false);
				chckbxSupervisor.setEnabled(false);
				chckbxSupervisor.setVisible(false);

				lblAddress.setEnabled(true);
				lblAddress.setVisible(true);
				lblCredirCard.setEnabled(true);
				lblCredirCard.setVisible(true);
				textFieldAddress.setEditable(true);
				textFieldAddress.setVisible(true);
				textFieldCreditCard.setEnabled(true);
				textFieldCreditCard.setVisible(true);
			}
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnSignUp)) {
			try {
				// Create a LoginControllable Object
				LoginControllable login = LoginFactory.getLoginControllable();

				// If statement depending on the state of the check box for manager
				if (!chckbxManager.isSelected()) {

					// registerUserMember
					login.registerUserMember(
							new Member(textFieldUsername.getText(), textFieldName.getText(), textFieldSurname.getText(),
									new String(textFieldPassword.getPassword()), textFieldEmail.getText(),
									LocalDate.now(), textFieldAddress.getText(), textFieldCreditCard.getText()));

				} else {

					// registerserManager
					login.registerUserManager(new Manager(textFieldUsername.getText(), textFieldName.getText(),
							textFieldSurname.getText(), new String(textFieldPassword.getPassword()),
							textFieldEmail.getText(), LocalDate.now(), 0, chckbxSupervisor.isSelected(),
							chckbxTechnician.isSelected(), false, EnumStatusManager.A));

				}
				changePanel();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "An error occured during the Sign Up");
			}
		} else if (e.getSource().equals(chckbxShowHideSignUp)) {
			if (chckbxShowHideSignUp.isSelected()) {
				textFieldPassword.setEchoChar((char) 0);
			} else {
				textFieldPassword.setEchoChar('*');
			}
		}
	}

	private void changePanel() {
		((Win_login_register) (this.getParent().getParent().getParent().getParent().getParent())).getUserLoginPanel()
				.setVisible(true);
		this.clearRegisterFields();
		this.setVisible(false);
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() instanceof JCheckBox) {
				((JCheckBox) e.getSource()).doClick();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	public void clearRegisterFields() {
		chckbxManager.setSelected(false);
		chckbxShowHideSignUp.setSelected(false);
		textFieldAddress.setText("");
		textFieldCreditCard.setText("");
		textFieldEmail.setText("");
		textFieldName.setText("");
		textFieldPassword.setText("");
		textFieldSurname.setText("");
		textFieldUsername.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// Method that displays the "UserLogInPanel" when you click the Sign Up label.
		if (e.getSource().equals(lblLogIn)) {
			changePanel();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Method that changes the Sign Up label's text format.
		if (e.getComponent().equals(lblLogIn)) {
			lblLogIn.setFont(font2);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent().equals(lblLogIn)) {
			lblLogIn.setFont(font1);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}


	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
