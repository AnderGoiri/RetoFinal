package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import storeMenu.StoreMenu;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import java.awt.Component;


import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_login_register extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel switchLilPanel;
	private CardLayout cardLayout;
	private UserRegister uR;
	private UserLogIn uL;
	private JButton btnLogIn;
	private JButton btnSignUp;

	private JButton btnConfirm;
	private JLabel lblLogoFill;


	/**
	 * Launch the application.
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		


		cardLayout=new CardLayout();
		switchLilPanel=new JPanel();
		uL=new UserLogIn();
		uR=new UserRegister();
		switchLilPanel.setBounds(247, 0, 837, 460);
		contentPane.add(switchLilPanel);
		switchLilPanel.setLayout(cardLayout);
		switchLilPanel.add("LogIn",uL);
		switchLilPanel.add("SignUp",uR);

		
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
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBackground(new Color(0, 151, 178));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Onyx", Font.BOLD, 45));
		btnSignUp.setBounds(387, 470, 183, 81);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(this);
		

		JLabel lblLogo = new JLabel("");
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
		btnConfirm.addActionListener(this);
		
	}

	/**
	 * @author Fran
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
			//String panelName=getSelectedPanelName(switchLilPanel);
			
			//for(Component component : switchLilPanel.getComponents()) {
				//if(component.isVisible()) {
					//panelName=component.getName();
				//}
			//}
			
			//if(panelName.equals("LogIn")) {
				
			//}else {
				
			//} 
			StoreMenu sM = new StoreMenu();
			sM.setVisible(true);
			sM.setLocationRelativeTo(null);
		}
	}
	public String getSelectedPanelName(JPanel jP) {
		String name="";
		
		for(Component component : switchLilPanel.getComponents()) {
			if(component.isVisible()) {
				name=component.getName();
			}
		}
		
		return name;
		
	}
	
}

