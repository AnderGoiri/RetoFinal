package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import java.awt.Color;

public class ManagerTechnicianRepair extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPanePendingRepairsTable;
	private JTable pendingRepairsTable;
	private DefaultTableModel tableModel;
	private JButton btnConfirm;

	/**
	 * Create the panel.
	 */
	public ManagerTechnicianRepair() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		JLabel lblNewLabel = new JLabel("Pending Repairs");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 35));
		lblNewLabel.setBounds(100, 50, 300, 75);
		add(lblNewLabel);
		
		scrollPanePendingRepairsTable = new JScrollPane();
		scrollPanePendingRepairsTable.setBounds(120, 125, 1640, 670);
		add(scrollPanePendingRepairsTable);
		
		
		
		tableModel = new DefaultTableModel();
		String[] productTableHeaders = {"Repair ID","Instrument","Description"};
		tableModel.setColumnIdentifiers(productTableHeaders);
		tableModel=addRepairs(tableModel);
		pendingRepairsTable = new JTable();
		scrollPanePendingRepairsTable.setViewportView(pendingRepairsTable);
		pendingRepairsTable.setModel(tableModel);
		pendingRepairsTable.setEnabled(false);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(1530, 830, 230, 50);
		add(btnConfirm);
		btnConfirm.addActionListener(this);
		btnConfirm.addKeyListener(this);
		
	}

	private DefaultTableModel addRepairs(DefaultTableModel tableModel) {
		// TODO Auto-generated method stub
		/**
		Set<Repair> pendingRepairs = controlador.metodoListarRepairs();
		Iterator<Repair> itRepair = pendingRepairs.iterator();
		**/
		Object[] row;
		
		//while(itRepair.hasNext()){
			row=new Object[11];
			row[0]="";
			row[1]="";
			row[2]="";
			
			//Repair pendingRepair = itRepair.next();
			//row[0]=pendingRepair.get();
			//row[1]=pendingRepair.get();
			//row[2]=pendingRepair.get();
			
			
			tableModel.addRow(row);
			//}
			return tableModel;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(e.getSource() instanceof JButton){
				((JButton) e.getSource()).doClick();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnConfirm)) {
			String[] options = {"Yes", "No"};
			if(JOptionPane.showOptionDialog(this, "Do you want to mark this repair as Finished?", "Repair Completed Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, 1)==0) {
				//metodo reparacion terminada tecnico
				
				JOptionPane.showMessageDialog(this, "The repair is finished, the client will be notified");
			}else {
				JOptionPane.showMessageDialog(this, "Proccess cancelled.");
			}
		}
	}
}
