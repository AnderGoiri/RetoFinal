package storeMenu;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ManagerMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	private ManagerShopPanel mngShop;
	private ManagerProductManagementPanel mngProduct;
	/**
	 * Create the panel.
	 */
	public ManagerMenu() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1860, 950);
		add(tabbedPane);
		
		
		mngShop = new ManagerShopPanel();
		tabbedPane.addTab("Shop", null, mngShop, null);
		
		mngProduct = new ManagerProductManagementPanel();
		tabbedPane.addTab("Manage", null, mngProduct, null);
	}
}
