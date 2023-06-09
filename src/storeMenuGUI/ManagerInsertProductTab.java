package storeMenuGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.ProductFoundException;
import logicTier.ProductManagerControllable;
import logicTier.ProductManagerFactory;
import model.EnumClassComponent;
import model.EnumClassInstrument;
import model.EnumTypeAccessory;
import model.EnumTypeComponent;
import model.EnumTypeInstrument;
import model.Instrument;
import model.Accessory;
import model.Component;
import model.EnumClassAccessory;
import java.awt.Color;


/**
 * A panel for inserting a product into the store.
 * 
 * @author Francisco Rafael de Ysasi González
 */
public class ManagerInsertProductTab extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldPrice, textFieldModel, textFieldSalePercentage, textFieldBrand, textFieldName,
			textFieldColor;
	private final ButtonGroup buttonGroupProductType = new ButtonGroup();
	private JRadioButton rdbtnInstrument, rdbtnComponent, rdbtnAccessory;
	private JTextArea textAreaDescription;
	private JComboBox<String> comboBoxClass, comboBoxType;
	private JSpinner spinnerStock;
	private JCheckBox chckbxSale;
	private JLabel lblSalePercentage, lblDescription, lblBrand, lblModel, lblName, lblClass, lblType, lblColor,
			lblPrice, lblStock;
	private JSeparator separator;
	private JButton btnConfirm;
	private DefaultComboBoxModel<String> classModel = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<String> typeModel = new DefaultComboBoxModel<>();

	/**
	 * Create the panel.
	 */
	public ManagerInsertProductTab() {
		setLayout(null);
		setBounds(0, 0, 984, 718);

		// --- JRadioButtons ---
		rdbtnInstrument = new JRadioButton("Instrument");
		buttonGroupProductType.add(rdbtnInstrument);
		rdbtnInstrument.setFont(new Font("Constantia", Font.BOLD, 35));
		rdbtnInstrument.setBounds(50, 63, 259, 50);
		add(rdbtnInstrument);
		rdbtnInstrument.addActionListener(this);
		rdbtnInstrument.addKeyListener(this);

		rdbtnComponent = new JRadioButton("Component");
		buttonGroupProductType.add(rdbtnComponent);
		rdbtnComponent.setFont(new Font("Constantia", Font.BOLD, 35));
		rdbtnComponent.setBounds(367, 63, 223, 50);
		add(rdbtnComponent);
		rdbtnComponent.addActionListener(this);
		rdbtnComponent.addKeyListener(this);

		rdbtnAccessory = new JRadioButton("Accessory");
		buttonGroupProductType.add(rdbtnAccessory);
		rdbtnAccessory.setFont(new Font("Constantia", Font.BOLD, 35));
		rdbtnAccessory.setBounds(686, 63, 208, 50);
		add(rdbtnAccessory);
		rdbtnAccessory.addActionListener(this);
		rdbtnAccessory.addKeyListener(this);

		// --- JCheckBox ---
		chckbxSale = new JCheckBox("Sale");
		chckbxSale.setFont(new Font("Constantia", Font.BOLD, 20));
		chckbxSale.setBounds(222, 574, 75, 50);
		add(chckbxSale);
		chckbxSale.addActionListener(this);
		chckbxSale.addKeyListener(this);

		// --- JSeparator ---
		separator = new JSeparator();
		separator.setBounds(20, 130, 1820, 3);
		add(separator);

		// --- JLabel ---
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Constantia", Font.BOLD, 20));
		lblDescription.setBounds(500, 340, 137, 30);
		add(lblDescription);

		lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Constantia", Font.BOLD, 20));
		lblBrand.setBounds(50, 180, 75, 30);
		add(lblBrand);

		lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Constantia", Font.BOLD, 20));
		lblModel.setBounds(50, 260, 75, 30);
		add(lblModel);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Constantia", Font.BOLD, 20));
		lblName.setBounds(50, 340, 75, 30);
		add(lblName);

		lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Constantia", Font.BOLD, 20));
		lblClass.setBounds(500, 180, 75, 30);
		add(lblClass);

		lblType = new JLabel("Type");
		lblType.setFont(new Font("Constantia", Font.BOLD, 20));
		lblType.setBounds(500, 260, 75, 30);
		add(lblType);

		lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Constantia", Font.BOLD, 20));
		lblColor.setBounds(50, 420, 75, 30);
		add(lblColor);

		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Constantia", Font.BOLD, 20));
		lblPrice.setBounds(50, 500, 75, 30);
		add(lblPrice);

		lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Constantia", Font.BOLD, 20));
		lblStock.setBounds(50, 580, 75, 30);
		add(lblStock);

		lblSalePercentage = new JLabel("%");
		lblSalePercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalePercentage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSalePercentage.setFont(new Font("Constantia", Font.PLAIN, 20));
		lblSalePercentage.setBounds(380, 579, 30, 30);
		lblSalePercentage.setVisible(false);
		add(lblSalePercentage);

		// --- TextArea ---
		textAreaDescription = new JTextArea();
		textAreaDescription.setEditable(true);
		textAreaDescription.setBounds(500, 370, 450, 245);
		add(textAreaDescription);
		textAreaDescription.setName("Description");
		textAreaDescription.addKeyListener(this);

		// --- JComboBox ---
		comboBoxType = new JComboBox<String>();
		comboBoxType.setFont(new Font("Constantia", Font.PLAIN, 10));
		comboBoxType.setBounds(600, 260, 250, 30);
		add(comboBoxType);
		comboBoxType.setName("Specification Type");

		comboBoxClass = new JComboBox<String>();
		comboBoxClass.setFont(new Font("Constantia", Font.PLAIN, 10));
		comboBoxClass.setBounds(600, 180, 250, 30);
		add(comboBoxClass);
		comboBoxClass.setName("Specification Class");
		comboBoxClass.addKeyListener(this);

		// --- TextField ---
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 15));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(156, 500, 250, 30);
		add(textFieldPrice);
		textFieldPrice.setName("Price");

		textFieldModel = new JTextField();
		textFieldModel.setFont(new Font("Constantia", Font.PLAIN, 15));
		textFieldModel.setColumns(10);
		textFieldModel.setBounds(155, 260, 250, 30);
		add(textFieldModel);
		textFieldModel.setName("Model");

		textFieldSalePercentage = new JTextField();
		textFieldSalePercentage.setFont(new Font("Constantia", Font.PLAIN, 15));
		textFieldSalePercentage.setColumns(10);
		textFieldSalePercentage.setBounds(300, 574, 80, 40);
		textFieldSalePercentage.setVisible(false);
		textFieldSalePercentage.setEnabled(false);
		add(textFieldSalePercentage);
		textFieldSalePercentage.setName("Sale Percentage");

		textFieldBrand = new JTextField();
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 15));
		textFieldBrand.setBounds(156, 180, 250, 30);
		textFieldBrand.setColumns(10);
		add(textFieldBrand);
		textFieldBrand.setName("Brand");

		textFieldName = new JTextField();
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 15));
		textFieldName.setBounds(156, 340, 250, 30);
		textFieldName.setColumns(10);
		add(textFieldName);
		textFieldName.setName("Name");

		textFieldColor = new JTextField();
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 15));
		textFieldColor.setBounds(156, 420, 250, 30);
		textFieldColor.setColumns(10);
		add(textFieldColor);
		textFieldColor.setName("Color");

		// --- JSpinner ---
		spinnerStock = new JSpinner();
		spinnerStock.setBounds(156, 580, 60, 30);
		add(spinnerStock);

		// --- JButton ---
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setFont(new Font("Onyx", Font.PLAIN, 25));
		btnConfirm.setBounds(850, 630, 100, 40);
		add(btnConfirm);
		btnConfirm.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(chckbxSale)) {
			if (chckbxSale.getModel().isSelected()) {
				lblSalePercentage.setVisible(true);
				textFieldSalePercentage.setVisible(true);
				textFieldSalePercentage.setEnabled(true);
			} else {
				lblSalePercentage.setVisible(false);
				textFieldSalePercentage.setVisible(false);
				textFieldSalePercentage.setEnabled(false);
			}

		} else if (e.getSource().equals(btnConfirm)) {
			if (blankText()) {
				if (rdbtnInstrument.isSelected()) {

					// Get all the info from the panel
					String description = textAreaDescription.getText();
					String brand = textFieldBrand.getText();
					String model = textFieldModel.getText();
					String name = textFieldName.getText();
					String color = textFieldColor.getText();
					float price = Float.parseFloat(textFieldPrice.getText());
					int stock = (int) spinnerStock.getValue();
					boolean isSale = chckbxSale.isSelected(); // Check if sale is selected
					boolean isActive = true;
					int salePercentage = 0;
					if (isSale) {
						// Get sale percentage from text field and convert to int
						salePercentage = Integer.parseInt(textFieldSalePercentage.getText());
					}

					EnumClassInstrument selectedClass = EnumClassInstrument
							.getValue((String) comboBoxClass.getSelectedItem());
					EnumTypeInstrument selectedType = EnumTypeInstrument
							.getValue((String) comboBoxType.getSelectedItem());

					// Create a new Instrument with the info
					Instrument instrument = new Instrument(name, model, description, price, stock, isActive, isSale,
							salePercentage, color, brand, selectedClass, selectedType);

					// Use the Factory to send the info to the logicTier
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					try {
						proManager.addProduct(instrument);
						JOptionPane.showMessageDialog(this, "Product added successfully"); // Show success message
					} catch (ProductFoundException | SQLException e1) {
						// Show error message if product already exists or if there's a database error
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}

				} else if (rdbtnComponent.isSelected()) {

					// Get all the info from the panel
					String description = textAreaDescription.getText();
					String brand = textFieldBrand.getText();
					String model = textFieldModel.getText();
					String name = textFieldName.getText();
					String color = textFieldColor.getText();
					float price = Float.parseFloat(textFieldPrice.getText());
					int stock = (int) spinnerStock.getValue();
					boolean isSale = chckbxSale.isSelected();// Check if sale is selected
					boolean isActive = true;
					int salePercentage = 0;
					if (isSale) {
						// Get sale percentage from text field and convert to int
						salePercentage = Integer.parseInt(textFieldSalePercentage.getText());
					}

					EnumClassComponent selectedClass = EnumClassComponent
							.getValue((String) comboBoxClass.getSelectedItem());
					EnumTypeComponent selectedType = EnumTypeComponent
							.getValue((String) comboBoxType.getSelectedItem());

					// Create a new Component with the info
					Component component = new Component(name, model, description, price, stock, isActive, isSale,
							salePercentage, color, brand, selectedClass, selectedType);

					// Use the Factory to send the info to the logicTier
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					try {
						proManager.addProduct(component);
						JOptionPane.showMessageDialog(this, "Product added successfully"); // Show success message
					} catch (ProductFoundException e1) {
						// Show error message if product already exists
						JOptionPane.showMessageDialog(this,
								"Product not found. Please check the product details and try again.");
					} catch (SQLException e1) {
						// Show error message if there's a database error
						JOptionPane.showMessageDialog(this,
								"An error occurred while accessing the database. Please contact the system administrator for assistance.");
					}

				} else if (rdbtnAccessory.isSelected()) {

					// Get all the info from the panel
					String description = textAreaDescription.getText();
					String brand = textFieldBrand.getText();
					String model = textFieldModel.getText();
					String name = textFieldName.getText();
					String color = textFieldColor.getText();
					float price = Float.parseFloat(textFieldPrice.getText());
					int stock = (int) spinnerStock.getValue();
					boolean isSale = chckbxSale.isSelected();// Check if sale is selected
					boolean isActive = true;
					int salePercentage = 0;
					if (isSale) {
						// Get sale percentage from text field and convert to int
						salePercentage = Integer.parseInt(textFieldSalePercentage.getText());
					}

					EnumClassAccessory selectedClass = EnumClassAccessory
							.getValue((String) comboBoxClass.getSelectedItem());
					EnumTypeAccessory selectedType = EnumTypeAccessory
							.getValue((String) comboBoxType.getSelectedItem());

					// Create a new Accessory with the info
					Accessory accessory = new Accessory(name, model, description, price, stock, isActive, isSale,
							salePercentage, color, brand, selectedClass, selectedType);

					// Use the Factory to send the info to the logicTier
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					try {
						proManager.addProduct(accessory);
						JOptionPane.showMessageDialog(this, "Product added successfully"); // Show success message
					} catch (ProductFoundException e1) {
						// Show error message if product already exists
						JOptionPane.showMessageDialog(this,
								"Product not found. Please check the product details and try again.");
					} catch (SQLException e1) {
						// Show error message if there's a database error
						JOptionPane.showMessageDialog(this,
								"An error occurred while accessing the database. Please contact the system administrator for assistance.");
					}

				} else {
					JOptionPane.showMessageDialog(this, "Please select what kind of Product you want to add");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Please complete all the information before Confirm");
			}

		} else if (e.getSource().equals(rdbtnInstrument)) { // When Instrument is selected
			// Class and Type Combo-boxes are enabled and loaded

			comboBoxClass.removeAllItems(); // Clear Combo boxes

			// Add options to the class combo box
			classModel.addElement("Wind");
			classModel.addElement("String");
			classModel.addElement("Percussion");
			comboBoxClass.setModel(classModel);

			comboBoxType.removeAllItems(); // Clear Combo boxes

			// Add options to the type combo box
			typeModel.addElement("Acoustic");
			typeModel.addElement("Electronic");
			comboBoxType.setModel(typeModel);

		} else if (e.getSource().equals(rdbtnComponent)) {

			// Class and Type Combo-boxes are enabled and loaded

			comboBoxClass.removeAllItems(); // Clear Combo boxes

			// Add options to the class combo box
			classModel.addElement("Chasis");
			classModel.addElement("Circuit");
			comboBoxClass.setModel(classModel);

			comboBoxType.removeAllItems(); // Clear Combo boxes

			// Add options to the type combo box
			typeModel.addElement("Architecture");
			typeModel.addElement("Tuning");
			typeModel.addElement("Connection");
			comboBoxType.setModel(typeModel);

		} else if (e.getSource().equals(rdbtnAccessory)) {
			// Class and Type Combo-boxes are enabled and loaded

			comboBoxClass.removeAllItems(); // Clear Combo boxes

			// Add options to the class combo box
			classModel.addElement("Electric");
			classModel.addElement("nonElectric");
			comboBoxClass.setModel(classModel);

			comboBoxType.removeAllItems(); // Clear Combo boxes

			// Add options to the type combo box
			typeModel.addElement("Audio");
			typeModel.addElement("Connection");
			typeModel.addElement("Item");
			comboBoxType.setModel(typeModel);
		}

	}

	private boolean blankText() {
		boolean thereIsBlankText = false;
		String blankSpaceComponents = "";
		JTextField[] textFields = { textFieldBrand, textFieldModel, textFieldName, textFieldColor, textFieldPrice,
				textFieldSalePercentage };
		JComboBox[] comboBoxes = { comboBoxClass, comboBoxType };

		for (JTextField textField : textFields) {
			if (textField.getText().trim().isEmpty() && textField.isEnabled()) {
				if (blankSpaceComponents.equals("")) {
					blankSpaceComponents += textField.getName();
				} else {
					blankSpaceComponents += textField.getName();
				}
			}
		}

		for (JComboBox comboBox : comboBoxes) {
			if (comboBox.getSelectedIndex() == -1) {
				if (blankSpaceComponents.equals("")) {
					blankSpaceComponents += comboBox.getName();
				} else {
					blankSpaceComponents += comboBox.getName();
				}
			}
		}

		if (buttonGroupProductType.getSelection() == null) {
			if (blankSpaceComponents.equals("")) {
				blankSpaceComponents += "Product Type";
			} else {
				blankSpaceComponents += ", Product Type";
			}
		}

		if (!blankSpaceComponents.equals("")) {
			thereIsBlankText = true;

			JOptionPane.showMessageDialog(this, "There are empty fields. Those are:\n" + blankSpaceComponents,
					"Empty Fields", JOptionPane.ERROR_MESSAGE);
		}

		return thereIsBlankText;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() instanceof JButton) {
				((JButton) e.getSource()).doClick();
			} else if (e.getSource() instanceof JCheckBox) {
				((JCheckBox) e.getSource()).doClick();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (e.getSource().equals(spinnerStock)) {
				spinnerStock.setValue(spinnerStock.getNextValue());
			} else if (e.getSource() instanceof JComboBox) {
				if (((JComboBox<String>) e.getSource()).getComponentCount() > 0) {
					if (((JComboBox<String>) e.getSource()).getSelectedIndex() > -1) {
						((JComboBox<String>) e.getSource())
								.setSelectedIndex(((JComboBox<String>) e.getSource()).getSelectedIndex() - 1);
					}
				}
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (e.getSource().equals(spinnerStock)) {
				spinnerStock.setValue(spinnerStock.getPreviousValue());
			} else if (e.getSource().equals(textFieldBrand)) {
				if (((JComboBox<String>) e.getSource()).getComponentCount() > 0) {
					if (((JComboBox<String>) e.getSource()).getSelectedIndex() < ((JComboBox<String>) e.getSource())
							.getComponentCount()) {
						((JComboBox<String>) e.getSource())
								.setSelectedIndex(((JComboBox<String>) e.getSource()).getSelectedIndex() + 1);
					}
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_TAB) {
			if (e.getSource().equals(textAreaDescription) && textAreaDescription.getText().isBlank()) {
				// ((Component) e.getSource()).transferFocus();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
