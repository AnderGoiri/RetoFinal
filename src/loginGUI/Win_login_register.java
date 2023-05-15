package loginGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

/**
 * This class creates the main JFrame for a registration and login window. The
 * frame has two JPanel fields, one for the registration panel and another for
 * the login panel.
 * 
 * @author Francisco Rafael de Ysasi González
 * @author Ander Goirigolzarri Iturburu
 */
public class Win_login_register extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, switchLilPanel;
	private CardLayout cardLayout;
	private UserRegisterPanel userRegisterPanel;
	private UserLogInPanel userLoginPanel;
	private JLabel lblLogoFill, lblFondo, lblLogo;

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
		// JFrame and its components set up
		setTitle("REGISTRATION & IDENTIFICATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		userLoginPanel = new UserLogInPanel();
		userRegisterPanel = new UserRegisterPanel();

		// Creation of the Log In and Sign Up Panels' Container
		cardLayout = new CardLayout();
		switchLilPanel = new JPanel();
		switchLilPanel.setOpaque(false);
		switchLilPanel.setBounds(247, 0, 837, 560);
		contentPane.add(switchLilPanel);
		switchLilPanel.setLayout(cardLayout);
		switchLilPanel.add("LogIn", userLoginPanel);
		switchLilPanel.add("SignUp", userRegisterPanel);
		userLoginPanel.setOpaque(false);
		userRegisterPanel.setOpaque(false);
		cardLayout.show(switchLilPanel, "LogIn");

		// Old JFrame buttons

		// btnLogIn = new JButton("LOG IN");
		// btnLogIn.setBackground(new Color(0, 151, 178));
		// btnLogIn.setForeground(new Color(255, 255, 255));
		// btnLogIn.setFont(new Font("Onyx", Font.BOLD, 45));
		// btnLogIn.setBounds(806, 470, 183, 81);

		// btnLogIn = new JButton("LOG IN");
		// btnLogIn.setEnabled(false);
		// btnLogIn.setVisible(false);
		// btnLogIn.setBackground(new Color(0, 151, 178));
		// btnLogIn.setForeground(new Color(255, 255, 255));
		// btnLogIn.setFont(new Font("Onyx", Font.BOLD, 45));
		// btnLogIn.setBounds(387, 470, 183, 81);
		// contentPane.add(btnLogIn);
		// btnLogIn.addActionListener(this);
		// btnLogIn.addKeyListener(this);

		// btnSignUp = new JButton("SIGN UP");
		// btnSignUp.setBackground(new Color(0, 151, 178));
		// btnSignUp.setForeground(new Color(255, 255, 255));
		// btnSignUp.setFont(new Font("Onyx", Font.BOLD, 45));
		// btnSignUp.setBounds(387, 470, 183, 81);
		// contentPane.add(btnSignUp);
		// btnSignUp.addActionListener(this);
		// btnSignUp.addKeyListener(this);

		// btnConfirm = new JButton("CONFIRM");
		// btnConfirm.setForeground(Color.WHITE);
		// btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		// btnConfirm.setBackground(new Color(0, 151, 178));
		// btnConfirm.setBounds(806, 470, 183, 81);
		// contentPane.add(btnConfirm);
		// btnConfirm.addActionListener(this);
//		btnConfirm.addKeyListener(this);

		// --- Logo and background labels ---

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

		lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(Win_login_register.class.getResource("/media/fondo2_.png")));
		lblFondo.setBounds(0, 0, 1084, 573);
		contentPane.add(lblFondo);

	}

	// --- Getters for the JPanels ---
	public UserRegisterPanel getUserRegisterPanel() {
		return userRegisterPanel;
	}

	public UserLogInPanel getUserLoginPanel() {
		return userLoginPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	// Old method to get the name of the selected panel. Used as variable inside the
	// old Confirm button use,
	// because this had two methods, the userRegister method and the logIn method.

	// public String getSelectedPanelName(JPanel jP) {
	// String selectedPanel = "a";

	// for (Component c : jP.getComponents()) {
	// if (c.isVisible() == true) {
	// if (c instanceof UserLogInPanel) {
	// selectedPanel = "LogIn";
	// } else {
	// selectedPanel = "SignUp";
	// }
	// }
	// }

	// return selectedPanel;

	// }

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() instanceof JButton) {
				((JButton) e.getSource()).doClick();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
