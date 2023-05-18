package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import model.User;

import java.awt.Color;

/**
 * The ManagerMainMenu class represents a JPanel that displays the main menu for
 * the manager in the store menu GUI.
 * 
 * It contains tabs for various manager functions, such as managing the shop,
 * inserting products, and managing repairs.
 * 
 * The class extends JPanel.
 * 
 * @author Francisco Rafael de Ysasi González
 */
public class ManagerMainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private ManagerShopTab mngShop;
	private ManagerInsertProductTab mngInsert;
	private JTabbedPane tabbedPane;
	private ManagerAccountTab mngAccount;

	/**
	 * Create the panel.
	 * 
	 * @param auxUser
	 */
	public ManagerMainMenu(User auxUser) {
		setBackground(new Color(0, 150, 178));
		setLayout(null);
		setBounds(0, 0, 1024, 768);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 984, 718);
		add(tabbedPane);

		mngShop = new ManagerShopTab();
		tabbedPane.addTab("Shop", mngShop);

		mngInsert = new ManagerInsertProductTab();
		tabbedPane.addTab("Insert", mngInsert);

		mngAccount = new ManagerAccountTab(auxUser);
		tabbedPane.addTab("Account", mngAccount);

	}
}
