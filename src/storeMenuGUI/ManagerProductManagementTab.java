package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;

public class ManagerProductManagementTab extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldModel, textFieldPrice, textFieldSalePercentage;
	private JComboBox<String> comboBoxName, comboBoxBrand;
	private JButton btnDelete, btnModify, btnConfirm, btnCancel, btnGoBack;
	private JTextArea textAreaDescription;
	private JSpinner spinnerStock;
	private JCheckBox chckbxSale, chckbxActive;
	private JLabel lblProduct, lblProductId, lblProductType, lblModel, lblBrand, lblStock, lblPrice, lblDescription, lblName, lblSalePercentage;
	private JSeparator separatorUp, separatorDown;
	
	/**
	 * Create the panel.
	 */
	
	
	//TODO El constructor recogeria un objeto tipo Product 
	
	public ManagerProductManagementTab() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		
		// --- JLabel --- //
		
		lblProduct = new JLabel("Product");
		lblProduct.setFont(new Font("Constantia", Font.BOLD, 35));
		lblProduct.setBounds(50, 50, 140, 50);
		add(lblProduct);
		
		lblProductId = new JLabel("*id*");
		lblProductId.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblProductId.setBounds(200, 50, 360, 50);
		add(lblProductId);
		
		lblProductType = new JLabel("*type*");
		lblProductType.setFont(new Font("Constantia", Font.ITALIC, 30));
		lblProductType.setBounds(50, 100, 360, 50);
		add(lblProductType);
		
		lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Constantia", Font.BOLD, 35));
		lblModel.setBounds(50, 430, 140, 50);
		add(lblModel);
		
		lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Constantia", Font.BOLD, 35));
		lblBrand.setBounds(50, 320, 140, 50);
		add(lblBrand);
		
		lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Constantia", Font.BOLD, 35));
		lblStock.setBounds(50, 540, 140, 50);
		add(lblStock);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Constantia", Font.BOLD, 35));
		lblPrice.setBounds(345, 540, 140, 50);
		add(lblPrice);
		
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Constantia", Font.BOLD, 35));
		lblDescription.setBounds(710, 210, 220, 50);
		add(lblDescription);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Constantia", Font.BOLD, 35));
		lblName.setBounds(50, 210, 140, 50);
		add(lblName);
		
		
		// --- CheckBox --- //
		
		chckbxSale = new JCheckBox("Sale");
		chckbxSale.setEnabled(false);
		chckbxSale.setSelected(false);
		chckbxSale.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxSale.setBounds(50, 650, 140, 50);
		UIManager.put("CheckBox.disabledText", Color.BLACK);
		chckbxSale.updateUI();
		add(chckbxSale);
		chckbxSale.addActionListener(this);
		chckbxSale.addKeyListener(this);
		
		chckbxActive = new JCheckBox("Active");
		chckbxActive.setEnabled(false);
		chckbxActive.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxActive.setBounds(1670, 105, 140, 50);
		add(chckbxActive);
		chckbxActive.addActionListener(this);
		chckbxActive.addKeyListener(this);
		
		
		// --- Sale Percentage Label --- //
		
		lblSalePercentage = new JLabel("Sale %");
		if(!chckbxSale.isSelected()) {
			lblSalePercentage.setVisible(false);
		}
		lblSalePercentage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSalePercentage.setFont(new Font("Constantia", Font.BOLD, 35));
		lblSalePercentage.setBounds(345, 650, 140, 50);
		add(lblSalePercentage);
		
		
		// --- JSpinner --- //
		
		spinnerStock = new JSpinner();
		spinnerStock.setFont(new Font("Constantia", Font.PLAIN, 30));
		spinnerStock.setBounds(200, 540, 115, 50);
		spinnerStock.setEnabled(false);
		add(spinnerStock);
		spinnerStock.addKeyListener(this);
		
		
		// --- JTextArea --- //
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setEditable(false);
		textAreaDescription.setBounds(710, 275, 1100, 425);
		add(textAreaDescription);
		
		
		// --- JTextField --- //
		
		textFieldModel = new JTextField();
		textFieldModel.setEditable(false);
		textFieldModel.setEnabled(false);
		textFieldModel.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldModel.setBounds(200, 430, 460, 50);
		add(textFieldModel);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setEditable(false);
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(490, 540, 170, 50);
		add(textFieldPrice);
		
		textFieldSalePercentage = new JTextField();
		if(!chckbxSale.isSelected()) {
			textFieldSalePercentage.setVisible(false);
		}		
		textFieldSalePercentage.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldSalePercentage.setColumns(10);
		textFieldSalePercentage.setBounds(490, 650, 170, 50);
		add(textFieldSalePercentage);
		
		
		// --- JComboBox --- //
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.setMaximumRowCount(20);
		comboBoxName.setEnabled(false);
		comboBoxName.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxName.setBounds(200, 210, 460, 50);
		add(comboBoxName);
		comboBoxName.addActionListener(this);
		comboBoxName.addKeyListener(this);
		
		comboBoxBrand = new JComboBox<String>();
		comboBoxBrand.setEnabled(false);
		comboBoxBrand.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxBrand.setBounds(200, 320, 460, 50);
		add(comboBoxBrand);
		comboBoxBrand.addActionListener(this);
		comboBoxBrand.addKeyListener(this);
		
		
		// --- JSeparator --- //
		
		separatorUp = new JSeparator();
		separatorUp.setBounds(20, 170, 1820, 3);
		add(separatorUp);
		
		separatorDown = new JSeparator();
		separatorDown.setBounds(20, 800, 1820, 3);
		add(separatorDown);
		
		
		// --- JButton --- //
				
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 151, 178));
		btnDelete.setFont(new Font("Onyx", Font.BOLD, 45));
		btnDelete.setBounds(1530, 830, 230, 52);
		add(btnDelete);
		btnDelete.addActionListener(this);
		btnDelete.addKeyListener(this);
		
		btnModify = new JButton("Modify");
		btnModify.setForeground(Color.WHITE);
		btnModify.setBackground(new Color(0, 151, 178));
		btnModify.setFont(new Font("Onyx", Font.BOLD, 45));
		btnModify.setBounds(1250, 830, 230, 52);
		add(btnModify);
		btnModify.addActionListener(this);
		btnModify.addKeyListener(this);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(1250, 830, 230, 52);
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		add(btnConfirm);
		btnConfirm.addActionListener(this);
		btnConfirm.addKeyListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		btnCancel.setVisible(false);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Onyx", Font.BOLD, 45));
		btnCancel.setBackground(new Color(0, 151, 178));
		btnCancel.setBounds(1530, 830, 230, 52);
		add(btnCancel);
		btnCancel.addActionListener(this);
		btnCancel.addKeyListener(this);
		
		btnGoBack = new JButton("Go back");
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setFont(new Font("Onyx", Font.BOLD, 45));
		btnGoBack.setBackground(new Color(0, 151, 178));
		btnGoBack.setBounds(300, 830, 230, 52);
		add(btnGoBack);
		btnGoBack.addActionListener(this);
		
	//TODO
		
		// --- Method that print the received product data inside the components --- //
		
		getSelectedProductData();	//  <--- [The product object should be between the method's brackets]
		

	}


	private void getSelectedProductData() {
		// TODO Method that transfers the product data 
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnModify)) {
			componentsAccessibility("Enable");
		}
		
		else if(e.getSource().equals(btnDelete)) {
			String[] optPaneOptionsValues = {"Yes","No"};

			int chosenOptionValue = JOptionPane.showOptionDialog(this, "Are you sure you want to take this product off the Market? if you close this pop-up, the proccess will be cancelled.", "Product removal", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, optPaneOptionsValues, 1);
			
			if(chosenOptionValue==0) {
				JOptionPane.showMessageDialog(this, "Product successfully taken off the market.");
			}else {
				JOptionPane.showMessageDialog(this, "The deletion proccess has been cancelled.");
			}
		}
		
		else if(e.getSource().equals(btnConfirm)) {
			if(JOptionPane.showConfirmDialog(this, "Do you want to save the updated product?", "Save changes", JOptionPane.YES_NO_OPTION)==0) {
				JOptionPane.showMessageDialog(this, "Product successfully modified.");	
			}else {
				JOptionPane.showMessageDialog(this, "The proccess has been cancelled.");
			}
			componentsAccessibility("Disable");
		}
		
		else if(e.getSource().equals(btnCancel)) {
			JOptionPane.showMessageDialog(this, "The proccess has been cancelled.");
			componentsAccessibility("Disable");	
		}
		
		else if(e.getSource().equals(chckbxSale)){
			if(chckbxSale.isSelected()) {
				textFieldSalePercentage.setVisible(true);
				lblSalePercentage.setVisible(true);
				if(chckbxSale.isEnabled()) {
					textFieldSalePercentage.setEnabled(true);
				}else {
					textFieldSalePercentage.setEnabled(false);
				}
			}else {
				textFieldSalePercentage.setVisible(false);
				lblSalePercentage.setVisible(false);
			}
		}
			
		else if(e.getSource().equals(btnGoBack)) {
			if(JOptionPane.showConfirmDialog(this, "Are you sure want to leave this tab?", "Close Tab", JOptionPane.YES_NO_OPTION)==0) {
				((JTabbedPane) this.getParent()).setSelectedIndex(((JTabbedPane) this.getParent()).getSelectedIndex()-1);
				((JTabbedPane) this.getParent()).remove(this);
			}
		}
		
	}


	private void componentsAccessibility(String s) {
		boolean group1, group2;
		
		if(s.equals("Enable")) {
			
			group1=true;
			group2=false;
		}else {
			group1=false;
			group2=true;			
		}
		
		//Group 1
			textAreaDescription.setEditable(group1);
			textFieldModel.setEditable(group1);
			textFieldModel.setEnabled(group1);
			textFieldPrice.setEditable(group1);
			textFieldSalePercentage.setEnabled(group1);
			chckbxSale.setEnabled(group1);
			chckbxActive.setEnabled(group1);
			comboBoxName.setEnabled(group1);
			comboBoxBrand.setEnabled(group1);
			spinnerStock.setEnabled(group1);
					
			btnCancel.setEnabled(group1);
			btnCancel.setVisible(group1);
			btnConfirm.setEnabled(group1);
			btnConfirm.setVisible(group1);
			
		
		//Group2
			btnModify.setEnabled(group2);
			btnModify.setVisible(group2);
			btnDelete.setEnabled(group2);
			btnDelete.setVisible(group2);
			
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
			}else if(e.getSource() instanceof JCheckBox) {
				((JCheckBox) e.getSource()).doClick();
			}
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(e.getSource().equals(spinnerStock)) {
				spinnerStock.setValue(spinnerStock.getNextValue());
			}else if(e.getSource() instanceof JComboBox) {
				if(((JComboBox<String>) e.getSource()).getComponentCount()>0) {
					if(((JComboBox<String>) e.getSource()).getSelectedIndex()>-1) {
						((JComboBox<String>) e.getSource()).setSelectedIndex(((JComboBox<String>) e.getSource()).getSelectedIndex()-1);
					}
				}
			}
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(e.getSource().equals(spinnerStock)) {
				spinnerStock.setValue(spinnerStock.getPreviousValue());
			}else if(e.getSource().equals(comboBoxBrand)) {
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
}
