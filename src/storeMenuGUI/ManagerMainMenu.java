package storeMenuGUI;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Manager;

import java.awt.Color;

public class ManagerMainMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ManagerShopTab mngShop;
	private ManagerInsertProductTab mngInsert;
	private ManagerTechnicianRepairTab mngTechRepair;
	private ManagerSuperiorRepairTab mngSupRepair;
	private ManagerAccountTab mngAccount;
	
	/**
	 * Create the panel.
	 * @param auxUser 
	 */
	public ManagerMainMenu(Manager auxUser) {
		setBackground(new Color(0, 150, 178));
		setLayout(null);
		setBounds(0, 0, 1860, 950);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1860, 950);
		add(tabbedPane);
		
		
		mngShop = new ManagerShopTab();
		tabbedPane.addTab("Shop", mngShop);
		
		mngInsert = new ManagerInsertProductTab();
		tabbedPane.addTab("Insert", mngInsert);
		
		mngTechRepair=new ManagerTechnicianRepairTab();
		tabbedPane.addTab("Repair Tech", mngTechRepair);
		
		mngSupRepair=new ManagerSuperiorRepairTab();
		tabbedPane.addTab("Repair Sup", mngSupRepair);
		
		mngAccount=new ManagerAccountTab(auxUser);
		tabbedPane.addTab("Account", mngAccount);
		
		comprobarManager(auxUser);
		
	}

	private void comprobarManager(Manager auxUser) {
		// TODO Metodo que puede servir
		String message="Error";
		boolean tech=false,sup=false,adm=false;
		
		tech=auxUser.isTechnician();
		sup=auxUser.isSupervisor();
		adm=auxUser.isAdmin();
		
		
		if(tech) {
			message="Hello Technician "+auxUser.getIdUser();
		}else if(sup) {
			message="Hello Supervisor "+auxUser.getName();
		}else if(adm) {
			message="Hello Administator "+auxUser.getName();
		}
		
		
		JOptionPane.showMessageDialog(this, message);
		
	}
}
