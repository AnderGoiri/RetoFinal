package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Member;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;

public class MemberMainMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShopMemberMenu panelStore;
	private MemberRepairPanel panelRepair;
	private MemberAccountPanel panelAccount;
	/**
	 * Create the panel.
	 * @param auxUser 
	 */
	public MemberMainMenu(Member auxUser) {
		setBounds(100, 100, 1860, 950);
		setLayout(null);
	/**
	 * 	Creating a JTabbedPane and configuring its appearance.
	 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1860, 950);
		tabbedPane.setFont(new Font("Elephant", Font.PLAIN, 15));
		add(tabbedPane);
		tabbedPane.setFont(new Font("Elephant", Font.PLAIN, 15));
	/**
	 * Add a panel called panelStore to the JTabbedPane tab in which the member can consult the products in the store.
	 */
		
		panelStore = new ShopMemberMenu();
		panelStore.setForeground(new Color(0, 151, 178));
		tabbedPane.addTab("Store", null, panelStore, null);
	/**
	 * Add a panel called panelRepair to the JTabbedPane tab where the member can request a repair of a product
	 */
		panelRepair = new MemberRepairPanel();
		panelRepair.setForeground(new Color(0, 151, 178));
		tabbedPane.setFont(new Font("Elephant", Font.PLAIN, 15));
		tabbedPane.addTab("Repair", null, panelRepair, null);
		
	/**
	 * Add a panel called panelAccount to the JTabbedPane tab where the member can consult his account information.
	 */
		panelAccount = new MemberAccountPanel();
		panelAccount.setForeground(new Color(0, 151, 178));
		tabbedPane.addTab("Account", null, panelAccount, null);
		

	}
}
