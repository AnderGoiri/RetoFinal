package login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

public class UserRegister extends JPanel implements ActionListener, KeyListener, FocusListener{
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldAddress;
	private JTextField textFieldCreditCard;
	private JTextField textFieldEmail;
	private JCheckBox chckbxManager;
	private JCheckBox chckbxTechnician;
	private JCheckBox chckbxSupervisor;
	private JLabel lblAddress;
	private JLabel lblCredirCard;
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroupManagerRole = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public UserRegister() {
		setLayout(null);
		setBounds(0,0,837,460);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(58, 289, 244, 41);
		lblUserName.setFont(new Font("Constantia", Font.PLAIN, 25));
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblPassword.setBounds(58, 369, 182, 41);
		add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblEmail.setBounds(449, 120, 182, 51);
		add(lblEmail);
		
		lblCredirCard = new JLabel("Credit Card:");
		lblCredirCard.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblCredirCard.setBounds(449, 284, 201, 51);
		add(lblCredirCard);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblSurname.setBounds(58, 210, 244, 41);
		add(lblSurname);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblName.setBounds(58, 131, 244, 41);
		add(lblName);
		
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
		
		textFieldPassword = new JTextField();
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
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblAddress.setBounds(449, 205, 264, 51);
		add(lblAddress);
		
		chckbxManager = new JCheckBox("Manager");
		chckbxManager.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxManager.setBounds(58, 76, 244, 41);
		chckbxManager.addActionListener(this);
		add(chckbxManager);
		chckbxManager.addKeyListener(this);
		
		JLabel lblRegistrationTitle = new JLabel("Registration");
		lblRegistrationTitle.setFont(new Font("Elephant", Font.PLAIN, 45));
		lblRegistrationTitle.setBounds(293, 10, 323, 60);
		add(lblRegistrationTitle);
		
		chckbxSupervisor = new JCheckBox("Supervisor");
		buttonGroupManagerRole.add(chckbxSupervisor);
		chckbxSupervisor.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxSupervisor.setEnabled(false);
		chckbxSupervisor.setVisible(false);
		chckbxSupervisor.setBounds(459, 257, 201, 33);
		add(chckbxSupervisor);
		chckbxSupervisor.addKeyListener(this);
		
		chckbxTechnician = new JCheckBox("Technician");
		buttonGroupManagerRole.add(chckbxTechnician);
		chckbxTechnician.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxTechnician.setEnabled(false);
		chckbxTechnician.setVisible(false);
		chckbxTechnician.setBounds(459, 341, 201, 30);
		add(chckbxTechnician);
		chckbxTechnician.addKeyListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(chckbxManager)) {
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
			
			}
			else {
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
		
	}

	

	@Override
	public void focusLost(FocusEvent e) {
		
		// Metodo para comprobar si el username existe
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(e.getSource() instanceof JCheckBox) {
				((JCheckBox) e.getSource()).doClick();
			}
		}
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void focusGained(FocusEvent e) {}
}
