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
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import exceptions.ProductNotFoundException;
import logicTier.ProductManagerControllable;
import logicTier.ProductManagerFactory;
import model.Accessory;
import model.Component;
import model.EnumClassAccessory;
import model.EnumClassComponent;
import model.EnumClassInstrument;
import model.EnumTypeAccessory;
import model.EnumTypeComponent;
import model.EnumTypeInstrument;
import model.Instrument;
import model.Product;

import java.awt.Color;
import javax.swing.JComboBox;

public class ManagerProductManagementTab extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldModel, textFieldPrice, textFieldSalePercentage, textFieldName, textFieldBrand;
	private JButton btnDelete, btnModify, btnConfirm, btnCancel, btnGoBack;
	private JTextArea textAreaDescription;
	private JSpinner spinnerStock;
	private JCheckBox chckbxSale, chckbxActive;
	private JLabel lblProduct, lblProductId, lblProductType, lblModel, lblBrand, lblStock, lblPrice, lblDescription,
		lblName, lblSalePercentage, lblType, lblClass;
	private JSeparator separatorUp, separatorDown;
	private JComboBox<String> comboBoxType, comboBoxClass;
	private Product product;
	private JLabel lblColor;
	private JTextField textFieldColor;
	
	/**
	 * Create the panel.
	 * @param selectedProduct 
	 */
	
	
	//TODO El constructor recogeria un objeto tipo Product 
	
	public ManagerProductManagementTab(Product selectedProduct) {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		product=selectedProduct;
		
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
		lblModel.setBounds(50, 505, 140, 50);
		add(lblModel);
		
		lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Constantia", Font.BOLD, 35));
		lblBrand.setBounds(50, 395, 140, 50);
		add(lblBrand);
		
		lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Constantia", Font.BOLD, 35));
		lblStock.setBounds(50, 615, 140, 50);
		add(lblStock);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Constantia", Font.BOLD, 35));
		lblPrice.setBounds(345, 615, 140, 50);
		add(lblPrice);
		
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Constantia", Font.BOLD, 35));
		lblDescription.setBounds(710, 285, 220, 50);
		add(lblDescription);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Constantia", Font.BOLD, 35));
		lblName.setBounds(50, 175, 140, 50);
		add(lblName);
		
		
		// --- CheckBox --- //
		
		chckbxSale = new JCheckBox("Sale");
		chckbxSale.setEnabled(false);
		chckbxSale.setSelected(false);
		chckbxSale.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxSale.setBounds(50, 725, 140, 50);
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
		lblSalePercentage.setBounds(345, 725, 140, 50);
		add(lblSalePercentage);
		
		
		// --- JSpinner --- //
		
		spinnerStock = new JSpinner();
		spinnerStock.setFont(new Font("Constantia", Font.PLAIN, 30));
		spinnerStock.setBounds(200, 615, 115, 50);
		spinnerStock.setEnabled(false);
		add(spinnerStock);
		spinnerStock.addKeyListener(this);
		
		
		// --- JTextArea --- //
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setEditable(false);
		textAreaDescription.setBounds(710, 350, 1100, 425);
		add(textAreaDescription);
		
		
		// --- JTextField --- //
		
		textFieldModel = new JTextField();
		textFieldModel.setEditable(false);
		textFieldModel.setEnabled(false);
		textFieldModel.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldModel.setBounds(200, 505, 460, 50);
		add(textFieldModel);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setEditable(false);
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(490, 615, 170, 50);
		add(textFieldPrice);
		
		textFieldSalePercentage = new JTextField();
		if(!chckbxSale.isSelected()) {
			textFieldSalePercentage.setVisible(false);
		}		
		textFieldSalePercentage.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldSalePercentage.setColumns(10);
		textFieldSalePercentage.setBounds(490, 725, 170, 50);
		add(textFieldSalePercentage);
		
		
		// --- JComboBox --- //
		
		textFieldName = new JTextField();
		textFieldName.setEnabled(false);
		textFieldName.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldName.setBounds(200, 176, 460, 50);
		add(textFieldName);
		
		textFieldBrand = new JTextField();
		textFieldBrand.setEnabled(false);
		textFieldBrand.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldBrand.setBounds(200, 395, 460, 50);
		add(textFieldBrand);
		
		
		// --- JSeparator --- //
		
		separatorUp = new JSeparator();
		separatorUp.setBounds(20, 160, 1820, 3);
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
		
		lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Constantia", Font.BOLD, 35));
		lblClass.setBounds(1300, 175, 140, 50);
		add(lblClass);
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Constantia", Font.BOLD, 35));
		lblType.setBounds(710, 175, 140, 50);
		add(lblType);
		
		
		// --- JComboBox --- //
		
		comboBoxClass = new JComboBox<String>();
		comboBoxClass.setBounds(1450, 176, 360, 50);
		comboBoxClass.setEnabled(false);
		add(comboBoxClass);
		
		comboBoxType = new JComboBox<String>();
		comboBoxType.setBounds(860, 176, 360, 50);
		comboBoxType.setEnabled(false);
		add(comboBoxType);
		
		lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Constantia", Font.BOLD, 35));
		lblColor.setBounds(50, 285, 140, 50);
		add(lblColor);
		
		textFieldColor = new JTextField();
		textFieldColor.setText((String) null);
		textFieldColor.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldColor.setEnabled(false);
		textFieldColor.setBounds(200, 285, 460, 50);
		add(textFieldColor);
		
	//TODO
		// --- Method that set the options of the class and type comboboxes, based on the product type --- //
		setClassAndTypeComboBoxValues(selectedProduct);
		
		// --- Method that print the received product data inside the components --- //
		
		getSelectedProductData(selectedProduct);	//  <--- [The product object should be between the method's brackets]
		

	}


	private void setClassAndTypeComboBoxValues(Product selectedProduct) {
		// TODO Auto-generated method stub
		if(selectedProduct instanceof Instrument) {
			comboBoxClass.addItem("Wind");
			comboBoxClass.addItem("String");
			comboBoxClass.addItem("Percussion");
			
			comboBoxType.addItem("Acoustic");
			comboBoxType.addItem("Electronic");
			
		}else if(selectedProduct instanceof Component) {
			comboBoxClass.addItem("Chasis");
			comboBoxClass.addItem("Circuit");
			
			comboBoxType.addItem("Architecture");
			comboBoxType.addItem("Tuning");
			comboBoxType.addItem("Connection");
		}else if(selectedProduct instanceof Accessory) {
			comboBoxClass.addItem("Electric");
			comboBoxClass.addItem("Non-electric");
			
			comboBoxType.addItem("Audio");
			comboBoxType.addItem("Connection");
			comboBoxType.addItem("Item");
		}
	}


	private void getSelectedProductData(Product selectedProduct) {
		// TODO Method that transfers the product data 
		chckbxActive.setSelected(selectedProduct.isActive());
		chckbxSale.setSelected(selectedProduct.isSaleActive());
		lblProductId.setText(""+selectedProduct.getIdProduct());
		lblProductType.setText(showType(selectedProduct));
		spinnerStock.setValue(selectedProduct.getStock());
		textAreaDescription.setText(selectedProduct.getDescriptionP());
		textFieldBrand.setText(selectedProduct.getBrand());
		textFieldModel.setText(selectedProduct.getModel());
		textFieldName.setText(selectedProduct.getNameP());
		textFieldPrice.setText(""+selectedProduct.getPrice());
		textFieldColor.setText(selectedProduct.getColor());
		if(selectedProduct.isSaleActive()==true) {
			textFieldSalePercentage.setVisible(true);
			textFieldSalePercentage.setText(""+selectedProduct.getSalePercentage());
			lblSalePercentage.setVisible(true);
		}
		
	}


	private String showType(Product selectedProduct) {
		// TODO Auto-generated method stub
		if(selectedProduct instanceof Instrument) {
			comboBoxClass.setSelectedItem(((Instrument) selectedProduct).getClassInstrument().getLabel());
			comboBoxType.setSelectedItem(((Instrument) selectedProduct).getTypeInstrument().getLabel());
			return "Instrument";
		}else if(selectedProduct instanceof Component) {
			comboBoxClass.setSelectedItem(((Component) selectedProduct).getClassComponent().getLabel());
			comboBoxType.setSelectedItem(((Component) selectedProduct).getTypeComponent().getLabel());
			return "Component";
		}else if(selectedProduct instanceof Accessory) {
			comboBoxClass.setSelectedItem(((Accessory) selectedProduct).getClassAccessory().getLabel());
			comboBoxType.setSelectedItem(((Accessory) selectedProduct).getTypeAccessory().getLabel());
			return "Accessory";
		}else
			return "Product";
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
				ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
				try {
					proManager.removeProduct(product);
				} catch (ProductNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Product successfully taken off the market.");
				
				goBackToTheShopPanel();
				
			}else {
				JOptionPane.showMessageDialog(this, "The deletion proccess has been cancelled.");
			}
		}
		
		else if(e.getSource().equals(btnConfirm)) {
			if(JOptionPane.showConfirmDialog(this, "Do you want to save the updated product?", "Save changes", JOptionPane.YES_NO_OPTION)==0) {
				ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
				try {
					float price=Float.parseFloat(textFieldPrice.getText());
					int salePercentage=Integer.parseInt(textFieldSalePercentage.getText());
					
					if(product instanceof Instrument) {
						proManager.modifyProduct(new Instrument(product.getIdProduct(),textFieldName.getText(),
								price, textAreaDescription.getText(), (int)spinnerStock.getValue(),
								textFieldBrand.getText(), textFieldModel.getText(), textFieldColor.getText(),
								chckbxSale.isSelected(), salePercentage, chckbxActive.isSelected(),
								EnumClassInstrument.getValue((String) comboBoxClass.getSelectedItem()),
								EnumTypeInstrument.getValue((String) comboBoxType.getSelectedItem())));
						
					}else if (product instanceof Component) {
						proManager.modifyProduct(new Component(product.getIdProduct(),textFieldName.getText(),
								price, textAreaDescription.getText(), (int)spinnerStock.getValue(),
								textFieldBrand.getText(), textFieldModel.getText(), textFieldColor.getText(),
								chckbxSale.isSelected(), salePercentage, chckbxActive.isSelected(),
								EnumClassComponent.getValue((String) comboBoxClass.getSelectedItem()),
								EnumTypeComponent.getValue((String) comboBoxType.getSelectedItem())));
						
					}else if(product instanceof Accessory) {
						proManager.modifyProduct(new Accessory(product.getIdProduct(),textFieldName.getText(),
								price, textAreaDescription.getText(), (int)spinnerStock.getValue(),
								textFieldBrand.getText(), textFieldModel.getText(), textFieldColor.getText(),
								chckbxSale.isSelected(), salePercentage, chckbxActive.isSelected(),
								EnumClassAccessory.getValue((String) comboBoxClass.getSelectedItem()),
								EnumTypeAccessory.getValue((String) comboBoxType.getSelectedItem())));
						
					}
					
				} catch (ProductNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Product successfully modified.");	
				
				goBackToTheShopPanel();
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
				goBackToTheShopPanel();
			}
		}
		
	}


	private void goBackToTheShopPanel() {
		// TODO Auto-generated method stub
		((JTabbedPane) this.getParent()).setSelectedIndex(((JTabbedPane) this.getParent()).getSelectedIndex()-1);
		((JTabbedPane) this.getParent()).remove(this);
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
			textFieldName.setEnabled(group1);
			textFieldBrand.setEnabled(group1);
			spinnerStock.setEnabled(group1);
			comboBoxClass.setEnabled(group1);
			comboBoxType.setEnabled(group1);
					
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
			}
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(e.getSource().equals(spinnerStock)) {
				spinnerStock.setValue(spinnerStock.getPreviousValue());
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
