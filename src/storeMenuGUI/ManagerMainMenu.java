package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Manager;

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
	private ManagerTechnicianRepairTab mngTechRepair;
	private ManagerSuperiorRepairTab mngSupRepair;
	private JTabbedPane tabbedPane;

	/**
	 * Create the panel.
	 */
	public ManagerMainMenu(Manager auxUser) {
		setBackground(new Color(0, 150, 178));
		setLayout(null);
		setBounds(0, 0, 984, 718);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 984, 718);
		add(tabbedPane);

		mngShop = new ManagerShopTab();
		tabbedPane.addTab("Shop", mngShop);

		mngInsert = new ManagerInsertProductTab();
		tabbedPane.addTab("Insert", mngInsert);

		mngTechRepair = new ManagerTechnicianRepairTab();
		tabbedPane.addTab("Repair Tech", mngTechRepair);

		mngSupRepair = new ManagerSuperiorRepairTab();
		tabbedPane.addTab("Repair Sup", mngSupRepair);

		// comprobarManager(auxUser);
	}

	/*
	 * private void comprobarManager(Manager auxUser) { String message="Error";
	 * boolean tech=false,sup=false,adm=false;
	 * 
	 * tech=auxUser.isTechnician(); sup=auxUser.isSupervisor();
	 * adm=auxUser.isAdmin();
	 * 
	 * 
	 * if(tech) { message="Hello Technician "+auxUser.getIdUser(); }else if(sup) {
	 * message="Hello Supervisor "+auxUser.getName(); }else if(adm) {
	 * message="Hello Administator "+auxUser.getName(); }
	 * 
	 * 
	 * JOptionPane.showMessageDialog(this, message);
	 */

}
