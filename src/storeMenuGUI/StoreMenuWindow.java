package storeMenuGUI;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicTier.LoginControllable;
import logicTier.LoginFactory;
import loginGUI.Win_login_register;
import model.Manager;
import model.Member;
import model.User;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionListener;

/**
 * The StoreMenuWindow class represents a dialog window for the store menu. It
 * extends the JDialog class and provides a graphical user interface (GUI) for
 * the store menu functionality.
 * 
 * @author Francisco Rafael de Ysasi González
 */
public class StoreMenuWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel, menuPanel;
	private MemberMainMenu memberPanel;
	private ManagerMainMenu managerPanel;
	private CardLayout cardLayout;
	
	public StoreMenuWindow(Win_login_register login,  boolean b, User auxUser) {
		super(login);
		setModal(b);
		this.setContentPane(login.getContentPane());
		setResizable(false);
		setTitle("THOMANN STORE MENU");
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1024, 768);
		/**
		 * A panel is created that will contain all the other components.
		 */
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0, 150, 178));
		contentPanel.setBounds(0, 0, 1024, 768);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		/**
		 * A panel containing the different menus is created.
		 */
		menuPanel = new JPanel();
		menuPanel.setBounds(10, 0, 1024, 768);
		cardLayout = new CardLayout();
		menuPanel.setLayout(cardLayout);
		contentPanel.add(menuPanel);

		/**
		 * A panel for the members menu is created and added to the menu panel.
		 */
		showMenu(auxUser);
	}

	/**
	 * This method displays the members menu.
	 * 
	 * @param auxUser
	 */

	private void showMenu(User auxUser) {

		if (auxUser instanceof Member) {
			memberPanel = new MemberMainMenu((Member) auxUser);

			menuPanel.add("Member", memberPanel);
			cardLayout.show(menuPanel, "Member");
		}

		if (auxUser instanceof Manager) {
			managerPanel = new ManagerMainMenu((Manager) auxUser);

			menuPanel.add("Manager", managerPanel);
			cardLayout.show(menuPanel, "Manager");
		}
		cardLayout.show(menuPanel, "Member");
	}

}
