package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class ManagerInsertProductPanel extends JPanel implements ActionListener, KeyListener, FocusListener{

	private static final long serialVersionUID = 1L;
	
	private JButton btnConfirm;
	private JTextField textFieldPrice;
	private JTextField textFieldModel;
	private JTextField textFieldSalePercentage;
	private final ButtonGroup buttonGroupProductType = new ButtonGroup();
	private JCheckBox chckbxInstrument;
	private JCheckBox chckbxAccessory;
	private JCheckBox chckbxComponent;
	private JTextArea textAreaDescription;
	private JComboBox<String> comboBoxBrand;
	private JComboBox<String> comboBoxName;
	private JComboBox<String> comboBoxColor;
	private JComboBox<String> comboBoxClass;
	private JComboBox<String> comboBoxType;
	private JSpinner spinnerStock;
	private JCheckBox chckbxSale;
	private JLabel lblSalePercentage;

	/**
	 * Create the panel.
	 */
	public ManagerInsertProductPanel() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		chckbxInstrument = new JCheckBox("Instrument");
		buttonGroupProductType.add(chckbxInstrument);
		chckbxInstrument.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxInstrument.setBounds(100, 50, 267, 50);
		add(chckbxInstrument);
		chckbxInstrument.addActionListener(this);
		chckbxInstrument.addKeyListener(this);
		
		chckbxAccessory = new JCheckBox("Accessory");
		buttonGroupProductType.add(chckbxAccessory);
		chckbxAccessory.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxAccessory.setBounds(1490, 50, 270, 50);
		add(chckbxAccessory);
		chckbxAccessory.addActionListener(this);
		chckbxAccessory.addKeyListener(this);
		
		
		chckbxComponent = new JCheckBox("Component");
		buttonGroupProductType.add(chckbxComponent);
		chckbxComponent.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxComponent.setBounds(797, 50, 267, 50);
		add(chckbxComponent);
		chckbxComponent.addActionListener(this);
		chckbxComponent.addKeyListener(this);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 130, 1820, 3);
		add(separator);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Constantia", Font.BOLD, 35));
		lblDescription.setBounds(700, 330, 210, 50);
		add(lblDescription);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(1580, 802, 230, 50);
		add(btnConfirm);
		btnConfirm.addActionListener(this);
		btnConfirm.addKeyListener(this);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Constantia", Font.BOLD, 35));
		lblBrand.setBounds(50, 220, 140, 50);
		add(lblBrand);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Constantia", Font.BOLD, 35));
		lblModel.setBounds(50, 330, 140, 50);
		add(lblModel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Constantia", Font.BOLD, 35));
		lblName.setBounds(50, 440, 140, 50);
		add(lblName);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setEditable(true);
		textAreaDescription.setBounds(910, 330, 900, 380);
		add(textAreaDescription);
		textAreaDescription.setName("Description");
		textAreaDescription.addKeyListener(this);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Constantia", Font.BOLD, 35));
		lblClass.setBounds(700, 220, 140, 50);
		add(lblClass);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Constantia", Font.BOLD, 35));
		lblType.setBounds(1270, 220, 140, 50);
		add(lblType);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Constantia", Font.BOLD, 35));
		lblColor.setBounds(50, 550, 140, 50);
		add(lblColor);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Constantia", Font.BOLD, 35));
		lblPrice.setBounds(50, 660, 140, 50);
		add(lblPrice);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStock.setFont(new Font("Constantia", Font.BOLD, 35));
		lblStock.setBounds(420, 550, 140, 50);
		add(lblStock);
		
		comboBoxBrand = new JComboBox<String>();
		comboBoxBrand.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxBrand.setBounds(190, 220, 450, 50);
		add(comboBoxBrand);
		comboBoxBrand.setName("Brand");
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxName.setBounds(190, 440, 450, 50);
		add(comboBoxName);
		comboBoxName.setName("Name");
		comboBoxName.addKeyListener(this);
		
		comboBoxColor = new JComboBox<String>();
		comboBoxColor.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxColor.setBounds(190, 550, 210, 50);
		add(comboBoxColor);
		comboBoxColor.setName("Color");
		comboBoxColor.addKeyListener(this);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(190, 661, 210, 50);
		add(textFieldPrice);
		textFieldPrice.setName("Price");
		
		comboBoxClass = new JComboBox<String>();
		comboBoxClass.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxClass.setBounds(840, 220, 400, 50);
		add(comboBoxClass);
		comboBoxClass.setName("Specification Class");
		comboBoxClass.addKeyListener(this);
		
		comboBoxType = new JComboBox<String>();
		comboBoxType.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxType.setBounds(1410, 220, 400, 50);
		add(comboBoxType);
		comboBoxType.setName("Specification Type");
		
		textFieldModel = new JTextField();
		textFieldModel.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldModel.setColumns(10);
		textFieldModel.setBounds(190, 330, 450, 50);
		add(textFieldModel);
		textFieldModel.setName("Model");
		
		spinnerStock = new JSpinner();
		spinnerStock.setBounds(560, 550, 80, 50);
		add(spinnerStock);
		
		chckbxSale = new JCheckBox("Sale");
		chckbxSale.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxSale.setBounds(420, 660, 100, 50);
		add(chckbxSale);
		chckbxSale.addActionListener(this);
		chckbxSale.addKeyListener(this);
		
		lblSalePercentage = new JLabel("%");
		lblSalePercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalePercentage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSalePercentage.setFont(new Font("Constantia", Font.BOLD, 35));
		lblSalePercentage.setBounds(520, 660, 45, 50);
		lblSalePercentage.setVisible(false);
		add(lblSalePercentage);
		
		textFieldSalePercentage = new JTextField();
		textFieldSalePercentage.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldSalePercentage.setColumns(10);
		textFieldSalePercentage.setBounds(565, 660, 75, 50);
		textFieldSalePercentage.setVisible(false);
		textFieldSalePercentage.setEnabled(false);
		add(textFieldSalePercentage);
		textFieldSalePercentage.setName("Sale Percentage");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(chckbxSale)) {
			if(chckbxSale.getModel().isSelected()) {
				lblSalePercentage.setVisible(true);
				textFieldSalePercentage.setVisible(true);
				textFieldSalePercentage.setEnabled(true);
			}else {
				lblSalePercentage.setVisible(false);
				textFieldSalePercentage.setVisible(false);
				textFieldSalePercentage.setEnabled(false);
			}
			
			//TODO Modificar lista productos con sale
		}else if(e.getSource().equals(btnConfirm)){
			if(blankText()==false) {
				//TODO Introducir productos en la base de datos
				JOptionPane.showMessageDialog(this, "Product added succesfully");
			}
		}
		
	}

	private boolean blankText() {
		// TODO Auto-generated method stub
		boolean thereIsBlankText=false;
		String blankSpaceComponents="";
		
		for(Component c : this.getComponents()) {
			if(c.isEnabled()) {
				if(c instanceof JTextField) {
					if(((JTextField)c).getText().isBlank()) {
						if(blankSpaceComponents.equals("")) {
							blankSpaceComponents+=c.getName();
						}else {
							blankSpaceComponents+=", "+c.getName();
						}
					}
					
				}else if(c instanceof JComboBox) {
					if(((JComboBox<?>)c).getSelectedIndex()==-1) {
						if(blankSpaceComponents.equals("")) {
							blankSpaceComponents+=c.getName();
						}else {
							blankSpaceComponents+=", "+c.getName();
						}
					}
					
				}else if(c instanceof JTextArea) {
					if(((JTextArea)c).getText().isBlank()) {
						if(blankSpaceComponents.equals("")) {
							blankSpaceComponents+=c.getName();
						}else {
							blankSpaceComponents+=", "+c.getName();
						}
					}
				}
				
			}
			
		}
		if(buttonGroupProductType.getSelection()==null) {
			if(blankSpaceComponents.equals("")) {
				blankSpaceComponents+="Product Type";
			}else {
				blankSpaceComponents+=", Product Type";
			}
		}
		
		if(!blankSpaceComponents.equals("")) {
			thereIsBlankText=true;
			
			JOptionPane.showMessageDialog(this, "Hay campos obligatorios que estan vacios. Estos son:\n"+blankSpaceComponents, "Campos vacios", JOptionPane.ERROR_MESSAGE);
		}
		
		
		return thereIsBlankText;
	}

	

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
		//Metodo comprobar id producto registrado
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(e.getSource() instanceof JButton) {
				((JButton) e.getSource()).doClick();
			}else if(e.getSource() instanceof JCheckBox){
				((JCheckBox) e.getSource()).doClick();
			}
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
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
		
		else if(e.getKeyCode()==KeyEvent.VK_TAB) {
			if(e.getSource().equals(textAreaDescription) && textAreaDescription.getText().isBlank()) {
				((Component) e.getSource()).transferFocus();
			}
		}
	}
	
	
	@Override
	public void focusGained(FocusEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}
