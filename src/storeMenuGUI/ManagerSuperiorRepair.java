package storeMenuGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class ManagerSuperiorRepair extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPanePendingRepairsTable;
	private JTable pendingRepairsTable;
	private DefaultTableModel tableModel;
	private JTextField textFieldRepairCost;
	private JComboBox<String> comboBoxColor;
	private JButton btnAssign;
	


	public ManagerSuperiorRepair() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		JLabel lblNewLabel = new JLabel("Pending Repairs");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 35));
		lblNewLabel.setBounds(100, 50, 300, 75);
		add(lblNewLabel);
		
		scrollPanePendingRepairsTable = new JScrollPane();
		scrollPanePendingRepairsTable.setBounds(120, 125, 1640, 650);
		add(scrollPanePendingRepairsTable);
		
		
		
		tableModel = new DefaultTableModel();
		String[] productTableHeaders = {"Repair ID","Instrument","Description"};
		tableModel.setColumnIdentifiers(productTableHeaders);
		tableModel=addRepairs(tableModel);
		pendingRepairsTable = new JTable();
		scrollPanePendingRepairsTable.setViewportView(pendingRepairsTable);
		pendingRepairsTable.setModel(tableModel);
		pendingRepairsTable.setEnabled(false);
		
		btnAssign = new JButton("Assign");
		btnAssign.setForeground(Color.WHITE);
		btnAssign.setFont(new Font("Onyx", Font.BOLD, 45));
		btnAssign.setBackground(new Color(0, 151, 178));
		btnAssign.setBounds(1530, 820, 230, 50);
		add(btnAssign);
		btnAssign.addActionListener(this);
		btnAssign.addKeyListener(this);
		
		JLabel lblRepairCost = new JLabel("Repair cost");
		lblRepairCost.setBackground(new Color(240, 240, 240));
		lblRepairCost.setFont(new Font("Constantia", Font.BOLD, 35));
		lblRepairCost.setBounds(120, 820, 220, 50);
		add(lblRepairCost);
		
		textFieldRepairCost = new JTextField();
		textFieldRepairCost.setName("Price");
		textFieldRepairCost.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldRepairCost.setColumns(10);
		textFieldRepairCost.setBounds(340, 820, 200, 50);
		add(textFieldRepairCost);
		
		JLabel lblTechnician = new JLabel("Assigned Technician");
		lblTechnician.setFont(new Font("Constantia", Font.BOLD, 35));
		lblTechnician.setBounds(650, 820, 350, 50);
		add(lblTechnician);
		
		comboBoxColor = new JComboBox<String>();
		comboBoxColor.setName("Color");
		comboBoxColor.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxColor.setBounds(1000, 820, 300, 50);
		add(comboBoxColor);
		
		JLabel lblRepairCostMonetaryUnit = new JLabel("€");
		lblRepairCostMonetaryUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblRepairCostMonetaryUnit.setFont(new Font("Constantia", Font.BOLD, 35));
		lblRepairCostMonetaryUnit.setBounds(550, 820, 35, 50);
		add(lblRepairCostMonetaryUnit);
		
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
		
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(e.getSource() instanceof JComboBox) {
				if(((JComboBox<String>) e.getSource()).getComponentCount()>0) {
					if(((JComboBox<String>) e.getSource()).getSelectedIndex()>-1) {
						((JComboBox<String>) e.getSource()).setSelectedIndex(((JComboBox<String>) e.getSource()).getSelectedIndex()-1);
					}
				}
			}
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(e.getSource() instanceof JComboBox) {
				if(((JComboBox<String>) e.getSource()).getComponentCount()>0) {
					if(((JComboBox<String>) e.getSource()).getSelectedIndex()<((JComboBox<String>) e.getSource()).getComponentCount()) {
						((JComboBox<String>) e.getSource()).setSelectedIndex(((JComboBox<String>) e.getSource()).getSelectedIndex()+1);
					}
				}
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
		if(e.getSource().equals(btnAssign)) {
			String[] options = {"Yes", "No"};

			if(JOptionPane.showOptionDialog(this, "Do you want to assaign this repair to this technician?", "Repair's Technician Assignment", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, 1)==0) {
				//metodo reparacion terminada tecnico
				
				JOptionPane.showMessageDialog(this, "Technician was assigned to the repair successfully");
			}else {
				JOptionPane.showMessageDialog(this, "Assignment cancelled.");
			}
		}
	}
}
