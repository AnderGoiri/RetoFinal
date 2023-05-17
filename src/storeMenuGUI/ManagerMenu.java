package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Manager;

import java.awt.Color;

public class ManagerMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ManagerShopTab mngShop;
	private ManagerProductManagementPanel mngProduct;
	private ManagerInsertProductPanel mngInsert;
	private ManagerTechnicianRepairTab mngTechRepair;
	private ManagerSuperiorRepairTab mngSupRepair;
	
	/**
	 * Create the panel.
	 * @param auxUser 
	 */
	public ManagerMenu(Manager auxUser) {
		setBackground(new Color(0, 150, 178));
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1860, 950);
		add(tabbedPane);
		
		
		mngShop = new ManagerShopTab();
		tabbedPane.addTab("Shop", mngShop);
		
		mngProduct = new ManagerProductManagementPanel();
		tabbedPane.addTab("Manage", mngProduct);
		
		mngInsert = new ManagerInsertProductPanel();
		tabbedPane.addTab("Insert", mngInsert);
		
		mngTechRepair=new ManagerTechnicianRepairTab();
		tabbedPane.addTab("Repair Tech", mngTechRepair);
		
		mngSupRepair=new ManagerSuperiorRepairTab();
		tabbedPane.addTab("Repair Sup", mngSupRepair);
		
	}
}
