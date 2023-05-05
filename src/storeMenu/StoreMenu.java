package storeMenu;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.Win_login_register;

import java.awt.CardLayout;
import java.awt.Color;

public class StoreMenu extends JDialog {
	
	private JPanel contentPanel;
	private JPanel menuPanel;
	
	private MemberMenu memberPanel;
	private ManagerMenu managerPanel;
	private CardLayout cardLayout;


	private static final long serialVersionUID = 1L;
	
//	private ManagerMenu managerPanel;



	
	public StoreMenu(Win_login_register win_login_register, boolean b) {
		super(win_login_register,b);
		setResizable(false);
		setTitle("THOMANN STORE MENU");
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setBounds(100, 100, 1900, 1000);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0, 150, 178));
		contentPanel.setBounds(0, 0, 1900, 1000);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane (contentPanel);
		contentPanel.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(10, 0, 1860, 950);
		cardLayout = new CardLayout();
		menuPanel.setLayout (cardLayout);
		contentPanel.add(menuPanel);
		
		memberPanel = new MemberMenu();
		menuPanel.add( "Member", memberPanel);
		
		managerPanel = new ManagerMenu();
		menuPanel.add("Manager", managerPanel);
		showMenu();
	}

	private void showMenu() {
		// TODO Auto-generated method stub

		

		cardLayout.show(menuPanel, "Manager");

	}

}
