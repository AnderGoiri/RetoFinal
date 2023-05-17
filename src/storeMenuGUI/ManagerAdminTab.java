package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ManagerAdminTab extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxStatus;
	private JLabel lblManagerSignUpRequests, lblManagerStatus;
	private JScrollPane scrollPaneManagerAccounts;
	private JButton btnApply;
	private JTable managerTable;
	private DefaultTableModel managerTableModel;
	
	
	/**
	 * Create the panel.
	 */
	public ManagerAdminTab() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		
		// --- JLabels --- //
		
		lblManagerSignUpRequests = new JLabel("Manager Sign Up Requests");
		lblManagerSignUpRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerSignUpRequests.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblManagerSignUpRequests.setBounds(50, 50, 550, 80);
		add(lblManagerSignUpRequests);
		
		lblManagerStatus = new JLabel("Manager Account State:");
		lblManagerStatus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblManagerStatus.setBounds(50, 815, 350, 50);
		add(lblManagerStatus);
		
		
		// --- JScrollPane --- //
		
		scrollPaneManagerAccounts = new JScrollPane();
		scrollPaneManagerAccounts.setBounds(50, 165, 1760, 600);
		add(scrollPaneManagerAccounts);
		
		
		// --- JTable that lists the pending managers --- // 
		
		managerTable = new JTable();
		scrollPaneManagerAccounts.setViewportView(managerTable);
		
		managerTableModel = new DefaultTableModel();
		String[] cabeceras = {"Id Manager","Username","Name","Surname"};
		managerTableModel.setColumnIdentifiers(cabeceras);
		managerTableModel=addPendingManagersInsideTable(managerTableModel);
		
		managerTable.setModel(managerTableModel);
		
		
		// --- JButton --- //
		
		btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnApply.setBounds(1610, 815, 200, 50);
		add(btnApply);
		btnApply.addActionListener(this);
		
		comboBoxStatus = new JComboBox<String>() ;
		comboBoxStatus.setBounds(400, 815, 500, 50);
		add(comboBoxStatus);
		
		
		// --- 
		
		
	}


	


	private DefaultTableModel addPendingManagersInsideTable(DefaultTableModel managerTableModel) {
		// TODO Add an object that has the same type as the factory that calls the controller in charge of the managers
		
		//Or initialize an iterator that saves inside of itself a collection(Set) of all the pending managers
		
		Object[] row;
		
		//while(itProd.hasNext()){
			row=new Object[11];
			
			row[0]=""; //getName of the manager
			row[1]="";
			row[2]="";
			row[3]="";
			
			managerTableModel.addRow(row);
			//}
		return managerTableModel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnApply)) {
			if(comboBoxStatus.getSelectedIndex()!=-1 ) {
				comboBoxStatus.getSelectedItem().toString(); //The string that this line returns can be used in the manager status modification method
			}
		}
	}
}
