package loginGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.UserNotFoundException;
import exceptions.WrongCredentialsException;
import logicTier.LoginControllable;
import logicTier.LoginFactory;
import model.EnumStatusManager;
import model.Manager;
import model.Member;
import storeMenuGUI.StoreMenu;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Win_login_register extends JFrame implements ActionListener, KeyListener, FocusListener{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel switchLilPanel;
	private CardLayout cardLayout;
	private UserRegisterPanel userRegisterPanel;
	private UserLogInPanel userLoginPanel;
	private JButton btnLogIn;
	private JButton btnSignUp;
	private JButton btnConfirm;
	private JLabel lblLogoFill;
	private JLabel label;
	private JLabel lblFondo;
	private JLabel lblLogo;


	/**
	 * TODO Delete later
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_login_register frame = new Win_login_register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Win_login_register() {
		setTitle("REGISTRATION & IDENTIFICATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		cardLayout=new CardLayout();
		switchLilPanel=new JPanel();
		switchLilPanel.setOpaque(false);
		userLoginPanel=new UserLogInPanel();
		userRegisterPanel=new UserRegisterPanel();
		switchLilPanel.setBounds(247, 0, 837, 460);
		contentPane.add(switchLilPanel);
		switchLilPanel.setLayout(cardLayout);
		switchLilPanel.add("LogIn",userLoginPanel);
		switchLilPanel.add("SignUp",userRegisterPanel);
		userLoginPanel.setOpaque(false);
		userRegisterPanel.setOpaque(false);

		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setBackground(new Color(0, 151, 178));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Onyx", Font.BOLD, 45));
		btnLogIn.setBounds(806, 470, 183, 81);

		cardLayout.show(switchLilPanel, "LogIn");
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setEnabled(false);
		btnLogIn.setVisible(false);
		btnLogIn.setBackground(new Color(0, 151, 178));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Onyx", Font.BOLD, 45));
		btnLogIn.setBounds(387, 470, 183, 81);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(this);
		btnLogIn.addKeyListener(this);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBackground(new Color(0, 151, 178));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Onyx", Font.BOLD, 45));
		btnSignUp.setBounds(387, 470, 183, 81);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(this);
		btnSignUp.addKeyListener(this);
		

		lblLogo = new JLabel("");
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setIcon(new ImageIcon(Win_login_register.class.getResource("/media/SAXO 1.png")));
		lblLogo.setBounds(20, 0, 227, 560);
		contentPane.add(lblLogo);
		
		lblLogoFill = new JLabel("");
		lblLogoFill.setIcon(new ImageIcon(Win_login_register.class.getResource("/media/blanco.png")));
		lblLogoFill.setBackground(Color.WHITE);
		lblLogoFill.setBounds(0, 0, 20, 560);
		contentPane.add(lblLogoFill);
		
		btnConfirm = new JButton("CONFIRM");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(806, 470, 183, 81);
		contentPane.add(btnConfirm);
		
		label = new JLabel("New label");
		label.setBounds(20, 10, 45, 13);
		contentPane.add(label);
		
		lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(Win_login_register.class.getResource("/media/fondo2_.png")));
		lblFondo.setBounds(0, 0, 1084, 573);
		contentPane.add(lblFondo);
		btnConfirm.addActionListener(this);
		btnConfirm.addKeyListener(this);
		
	}

	/**
	 * @author Fran
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO ask Maria switch
				
		if(e.getSource().equals(btnLogIn)) {
			cardLayout.show(switchLilPanel, "LogIn");
			btnLogIn.setEnabled(false);
			btnLogIn.setVisible(false);
			btnSignUp.setEnabled(true);
			btnSignUp.setVisible(true);
			
		}else if(e.getSource().equals(btnSignUp)){
			cardLayout.show(switchLilPanel, "SignUp");
			btnLogIn.setEnabled(true);
			btnLogIn.setVisible(true);
			btnSignUp.setEnabled(false);
			btnSignUp.setVisible(false);
			
		}else if(e.getSource().equals(btnConfirm)) {			
			String panelName=getSelectedPanelName(switchLilPanel);
			if(panelName.equals("a")) {
				JOptionPane.showMessageDialog(null, "There's a bug on you!", "Hey!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(panelName.equals("LogIn")) {
					
					//metodo comprobar identificacion
					LoginControllable login = LoginFactory.getLoginControllable();
					
						//recoge los valores de los textfields de Username y Password y comprueba que no esten vacios
					//TODO fix
						String password = new String(userLoginPanel.getPasswordField().toString());
						if(userLoginPanel.getTextFieldUsername().getText().isBlank() || password.isBlank()) {
							JOptionPane.showMessageDialog(this, "Please, insert your username and password");
							
						}else {
					
						//Comprobamos de que los valores introducidos corresponda con los datos de algun usuario registrado
							try {
								login.userLogin(userLoginPanel.getTextFieldUsername().getText(), userLoginPanel.getPasswordField().toString());
								
								//Si los valores son correctos, se mostrara el menu de la tienda
								StoreMenu storeMenuPanel = new StoreMenu(this, true);
								storeMenuPanel.setVisible(true);
								storeMenuPanel.setLocationRelativeTo(null);
								
								//De lo contrario, mostrara el usuario un mensaje adviertiendole del error
							} catch (WrongCredentialsException | UserNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						}
					
					
				}else {
					try {
						
					//obtener obj LoginControllable llamando al metodo de la factoria
					LoginControllable login = LoginFactory.getLoginControllable();
					//evaluar si se registra un member o un manager
					if(userRegisterPanel.getChckbxManager().isSelected()==false) {
						//si es un miembro, 
						
							//recogemos todos los datos del miembro de la ventana y llamamos al metodo registerUserMember
							login.registerUserMember(new Member(
							userRegisterPanel.getTextFieldUsername().getText(),
							userRegisterPanel.getTextFieldName().getText(),
							userRegisterPanel.getTextFieldSurname().getText(),
							userRegisterPanel.getTextFieldPassword().getText(),
							userRegisterPanel.getTextFieldEmail().getText(),
							LocalDate.now(),
							userRegisterPanel.getTextFieldAddress().getText(),
							userRegisterPanel.getTextFieldCreditCard().getText()
							));
						
					}else {
			
						//si es un manager, 
					
							//recogemos todos los datos del miembro de la ventana y llamamos al metodo registerUserManager
							login.registerUserManager(new Manager(
								userRegisterPanel.getTextFieldUsername().getText(),
								userRegisterPanel.getTextFieldName().getText(),
								userRegisterPanel.getTextFieldSurname().getText(),
								userRegisterPanel.getTextFieldPassword().getText(),
								userRegisterPanel.getTextFieldEmail().getText(),
								LocalDate.now(),
								0, //TODO how to manage id supervisor
								userRegisterPanel.getChckbxSupervisor().isSelected(),
								userRegisterPanel.getChckbxTechnician().isSelected(),
								false, //TODO how to manage isAdmin
								EnumStatusManager.P
								)
							);
					
					}
					//si el registro es correcto, le mandamos al login
						userRegisterPanel.clearRegisterFields();
						cardLayout.show(switchLilPanel, "LogIn");
						btnLogIn.setEnabled(false);
						btnLogIn.setVisible(false);
						btnSignUp.setEnabled(true);
						btnSignUp.setVisible(true);
					//Si se produce alguna excepcion, mostramos un mensaje advirtiendo al usuario
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
					
					
				} 
			}
			
			
		}
	}

	public String getSelectedPanelName(JPanel jP) {
		String selectedPanel="a";
		
		for(Component c : jP.getComponents()) {
			if(c.isVisible()==true) {
				if(c instanceof UserLogInPanel) {
					selectedPanel="LogIn";
				}else {
					selectedPanel="SignUp";
				}
			}
		}
		
		return selectedPanel;
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		//Comprobar que el username esta registrado
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(e.getSource() instanceof JButton){
				((JButton) e.getSource()).doClick();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void focusGained(FocusEvent e) {}
}

