package storeMenu;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;

public class MemberMenu extends JPanel {
	private ShopMemberMenu panelStore;
	/**
	 * Create the panel.
	 */
	public MemberMenu() {
		setBounds(100, 100, 1860, 950);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1860, 950);
		tabbedPane.setFont(new Font("Elephant", Font.PLAIN, 15));
		add(tabbedPane);
		
		panelStore = new ShopMemberMenu();
		panelStore.setForeground(new Color(0, 151, 178));
		tabbedPane.setFont(new Font("Elephant", Font.PLAIN, 15));
		tabbedPane.addTab("Store", null, panelStore, null);
		
		
		JPanel panelRepair = new JPanel();
		panelRepair.setForeground(new Color(0, 151, 178));
		tabbedPane.setFont(new Font("Elephant", Font.PLAIN, 15));
		tabbedPane.addTab("Repair", null, panelRepair, null);
		
		JPanel panelAccount = new JPanel();
		panelAccount.setForeground(new Color(0, 151, 178));
		tabbedPane.addTab("Account", null, panelAccount, null);
		

	}
}