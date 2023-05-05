package storeMenu;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class StoreMenu extends JDialog {
	
	private JPanel contentPanel;
	private JPanel menuPanel;
	
	private MemberMenu memberPanel;
	private CardLayout cardLayout;


	private static final long serialVersionUID = 1L;
	
//	private ManagerMenu managerPanel;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			/**
			 * A new instance of StoreMenu, which is a JDialog, is created and displayed.
			 */
			StoreMenu dialog = new StoreMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StoreMenu() {
		setLayout(null);
		setBounds(100, 100, 1900, 1000);
		/**
		 * A panel is created that will contain all the other components.
		 */
		contentPanel = new JPanel();
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
		
		
		
	//	managerPanel = new ManagerMenu();
	//	menuPanel.add("Manager", managerPanel);
		/**
		 * The menu is displayed.
		 */
		showMenu();
	}
	/**
	 * This method displays the members menu.
	 */
	private void showMenu() {
		// TODO Auto-generated method stub

		cardLayout.show(menuPanel, "Member");

		//		cardLayout.show(menuPanel, "Manager");

	}

}
