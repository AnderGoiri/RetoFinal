package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_login_register extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel switchLilPanel;
	private CardLayout cardLayout;
	private UserRegister uR;
	private UserLogIn uL;
	private JButton btnLogIn;
	private JButton btnSignUp;

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
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(this);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBackground(new Color(0, 151, 178));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Onyx", Font.BOLD, 45));
		btnSignUp.setBounds(387, 470, 183, 81);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(Win_login_register.class.getResource("/media/SAXO 1.png")));
		lblNewLabel.setBounds(0, 0, 247, 560);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLogIn)) {
			cardLayout.show(switchLilPanel, "LogIn");
		}else if(e.getSource().equals(btnSignUp)){
			cardLayout.show(switchLilPanel, "SignUp");
		}
	}
}
