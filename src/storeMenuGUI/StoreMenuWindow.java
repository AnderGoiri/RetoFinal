package storeMenuGUI;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Manager;
import model.Member;
import model.User;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class StoreMenuWindow extends JDialog {
	
	private JPanel contentPanel;
	private JPanel menuPanel;
	
	private MemberMenu memberPanel;
	private ManagerMenu managerPanel;
	private CardLayout cardLayout;


	private static final long serialVersionUID = 1L;
	
//	private ManagerMenu managerPanel;

	
	public StoreMenuWindow(ActionListener actionListener, boolean b, User auxUser) {
		super();
		setResizable(false);
		setTitle("THOMANN STORE MENU");
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setBounds(100, 100, 1900, 1000);
		/**
		 * A panel is created that will contain all the other components.
		 */
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0, 150, 178));
		contentPanel.setBounds(0, 0, 1900, 1000);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane (contentPanel);
		contentPanel.setLayout(null);
		/**
		 * A panel containing the different menus is created.
		 */
		menuPanel = new JPanel();
		menuPanel.setBounds(10, 0, 1860, 950);
		cardLayout = new CardLayout();
		menuPanel.setLayout (cardLayout);
		contentPanel.add(menuPanel);
		/**
		 * A panel for the members menu is created and added to the menu panel.
		 */
		memberPanel = new MemberMenu();
		menuPanel.add( "Member", memberPanel);
	
		managerPanel = new ManagerMenu();
		menuPanel.add("Manager", managerPanel);

		showMenu(auxUser);
	}
	/**
	 * This method displays the members menu.
	 * @param auxUser 
	 */
	private void showMenu(User auxUser) {
		
		if(auxUser instanceof Member) {
			cardLayout.show(menuPanel, "Member");
		}
		
		if(auxUser instanceof Manager) {
			cardLayout.show(menuPanel, "Manager");
		}
		

	}

}
