package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import exceptions.ProductNotFoundException;
import logicTier.ProductManagerControllable;
import logicTier.ProductManagerFactory;
import model.Accessory;
import model.Component;
import model.Instrument;
import model.Product;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

/**
 * The ManagerShopTab class represents a JPanel that displays the manager's shop
 * tab in the store menu GUI.
 * 
 * It allows the manager to search for products and show all products in the
 * inventory.
 * 
 * This class implements the ActionListener and KeyListener interfaces to handle
 * user actions.
 * 
 * @author Ander Goirigolzarri Iturburu
 * @author Francisco Rafael de Ysasi González
 */
public class ManagerShopTab extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JTextField textFieldSearchBar;
	private JButton btnSearch, btnShow;
	private JScrollPane scrollPaneProductList;
	private JTable productsTable;
	private DefaultTableModel modelProduct;
	private Set<Product> products;
	private JComboBox<String> comboBoxSearchBy;
	private JLabel lblSearchBy;
	private JCheckBox chckbxIsInSale;
	private DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<>();
	private ManagerProductManagementTab mngProduct;

	/**
	 * Creates a new instance of the ManagerShopTab class. Initializes and
	 * configures the GUI components.
	 */
	public ManagerShopTab() {
		setLayout(null);

		setBounds(0, 0, 984, 718);

		// --- TextField ---
		textFieldSearchBar = new JTextField();
		textFieldSearchBar.setBounds(255, 125, 500, 50);
		add(textFieldSearchBar);
		textFieldSearchBar.setColumns(10);

		// --- JButton ---

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Onyx", Font.PLAIN, 45));
		btnSearch.setBounds(755, 125, 195, 50);
		add(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.addKeyListener(this);

		btnShow = new JButton("Show");
		btnShow.setFont(new Font("Onyx", Font.PLAIN, 45));
		btnShow.setBounds(755, 630, 195, 50);
		add(btnShow);
		btnShow.addActionListener(this);
		btnShow.addKeyListener(this);

		// --- JScrollPane ---
		scrollPaneProductList = new JScrollPane();
		scrollPaneProductList.setBounds(50, 200, 900, 400);
		add(scrollPaneProductList);

		// --- JTable ---
		modelProduct = new DefaultTableModel(); // Establish the default table model
		modelProduct.setColumnIdentifiers(new Object[] { "ID", "Name", "Price", "Description", "Stock", "Brand",
				"Model", "Color", "Sale Active", "Sale %", "Active", "Class", "Type" });
		productsTable = new JTable();
		productsTable.setCellSelectionEnabled(false);
		productsTable.setRowSelectionAllowed(true);
		scrollPaneProductList.setViewportView(productsTable);
		productsTable.setModel(modelProduct);
		productsTable.setEnabled(false);


		// --- JComboBox ---
		comboBoxSearchBy = new JComboBox<String>();
		comboBoxSearchBy.setBounds(50, 125, 205, 50);
		add(comboBoxSearchBy);

		// Add options to the class combo box
		searchModel.addElement("All");
		searchModel.addElement("ID");
		searchModel.addElement("Name");
		searchModel.addElement("Brand");
		searchModel.addElement("Model");
		searchModel.addElement("Type");
		searchModel.addElement("Class");
		comboBoxSearchBy.setModel(searchModel);

		// --- JLabel ---
		lblSearchBy = new JLabel("Search By");
		lblSearchBy.setBounds(50, 50, 180, 50);
		lblSearchBy.setFont(new Font("Onyx", Font.PLAIN, 45));
		add(lblSearchBy);

		// --- JCheckBox ---
		chckbxIsInSale = new JCheckBox("Sale");
		chckbxIsInSale.setVerticalAlignment(SwingConstants.BOTTOM);
		chckbxIsInSale.setFont(new Font("Constantia", Font.PLAIN, 20));
		chckbxIsInSale.setBounds(230, 62, 93, 35);
		add(chckbxIsInSale);
		chckbxIsInSale.addActionListener(this);

		// --- Show all Products when the Tab is Created
		showAllProducts();

	}

	/**
	 * 
	 * Displays all products in the inventory by retrieving the data from the logic
	 * tier.
	 * 
	 * @return The set of products retrieved from the inventory.
	 */
	private Set<Product> showAllProducts() {
		// Create a ProductManagerControllable object
		ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();

		// Receive the data from the logicTier
		try {
			products = proManager.getAllProducts();
			modelProduct = (DefaultTableModel) productsTable.getModel();
			modelProduct.setRowCount(0);

			// Add the data to the JTable
			for (Product product : products) {
				Object[] rowData = null;
				if (product instanceof Instrument) {
					Instrument instrument = (Instrument) product;
					rowData = new Object[] { instrument.getIdProduct(), instrument.getNameP(), instrument.getPrice(),
							instrument.getDescriptionP(), instrument.getStock(), instrument.getBrand(),
							instrument.getModel(), instrument.getColor(), instrument.isSaleActive() ? "Yes" : "No",
							instrument.getSalePercentage(), instrument.isActive() ? "Yes" : "No",
							instrument.getClassInstrument().getLabel(), instrument.getTypeInstrument().getLabel() };

				} else if (product instanceof Component) {
					Component component = (Component) product;
					rowData = new Object[] { component.getIdProduct(), component.getNameP(), component.getPrice(),
							component.getDescriptionP(), component.getStock(), component.getBrand(),
							component.getModel(), component.getColor(), component.isSaleActive() ? "Yes" : "No",
							component.getSalePercentage(), component.isActive() ? "Yes" : "No",
							component.getClassComponent().getLabel(), component.getTypeComponent().getLabel() };

				} else if (product instanceof Accessory) {
					Accessory accessory = (Accessory) product;
					rowData = new Object[] { accessory.getIdProduct(), accessory.getNameP(), accessory.getPrice(),
							accessory.getDescriptionP(), accessory.getStock(), accessory.getBrand(),
							accessory.getModel(), accessory.getColor(), accessory.isSaleActive() ? "Yes" : "No",
							accessory.getSalePercentage(), accessory.isActive() ? "Yes" : "No",
							accessory.getClassAccessory().getLabel(), accessory.getTypeAccessory().getLabel() };
				}
				modelProduct.addRow(rowData);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}

		// Set the table model to the JTable
		productsTable.setModel(modelProduct);
		productsTable.setEnabled(true);
		return products;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnSearch) && textFieldSearchBar.getText().isBlank()
				&& comboBoxSearchBy.getSelectedItem().equals("All")) {
			showAllProducts();

		} else if (e.getSource().equals(btnSearch) && !textFieldSearchBar.getText().isBlank()) {

			String selectedOption = comboBoxSearchBy.getSelectedItem().toString();

			switch (selectedOption) {

			case "ID":
				try {
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					Product searchProduct = proManager.searchProductById(Integer.parseInt(textFieldSearchBar.getText()),
							products);
					modelProduct = (DefaultTableModel) productsTable.getModel();
					modelProduct.setRowCount(0);
					Object[] rowData = null;
					if (searchProduct instanceof Instrument) {
						Instrument instrument = (Instrument) searchProduct;
						rowData = new Object[] { instrument.getIdProduct(), instrument.getNameP(),
								instrument.getPrice(), instrument.getDescriptionP(), instrument.getStock(),
								instrument.getBrand(), instrument.getModel(), instrument.getColor(),
								instrument.isSaleActive() ? "Yes" : "No", instrument.getSalePercentage(),
								instrument.isActive() ? "Yes" : "No", instrument.getClassInstrument().getLabel(),
								instrument.getTypeInstrument().getLabel() };

					} else if (searchProduct instanceof Component) {
						Component component = (Component) searchProduct;
						rowData = new Object[] { component.getIdProduct(), component.getNameP(), component.getPrice(),
								component.getDescriptionP(), component.getStock(), component.getBrand(),
								component.getModel(), component.getColor(), component.isSaleActive() ? "Yes" : "No",
								component.getSalePercentage(), component.isActive() ? "Yes" : "No",
								component.getClassComponent().getLabel(), component.getTypeComponent().getLabel() };

					} else if (searchProduct instanceof Accessory) {
						Accessory accessory = (Accessory) searchProduct;
						rowData = new Object[] { accessory.getIdProduct(), accessory.getNameP(), accessory.getPrice(),
								accessory.getDescriptionP(), accessory.getStock(), accessory.getBrand(),
								accessory.getModel(), accessory.getColor(), accessory.isSaleActive() ? "Yes" : "No",
								accessory.getSalePercentage(), accessory.isActive() ? "Yes" : "No",
								accessory.getClassAccessory().getLabel(), accessory.getTypeAccessory().getLabel() };
					}
					modelProduct.addRow(rowData);

				} catch (NumberFormatException | ProductNotFoundException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				break;

			case "Name":
				try {
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					Set<Product> searchProducts = proManager.searchProductByName(textFieldSearchBar.getText(),
							products);
					selectSetofProducts(searchProducts);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				break;

			case "Brand":
				try {
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					Set<Product> searchProducts = proManager.searchProductByBrand(textFieldSearchBar.getText(),
							products);
					selectSetofProducts(searchProducts);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				break;

			case "Model":
				try {
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					Set<Product> searchProducts = proManager.searchProductByModel(textFieldSearchBar.getText(),
							products);
					selectSetofProducts(searchProducts);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				break;

			case "Type":
				try {
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					Set<Product> searchProducts = proManager.searchProductByType(textFieldSearchBar.getText(),
							products);
					selectSetofProducts(searchProducts);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				break;

			case "Class":
				try {
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
					Set<Product> searchProducts = proManager.searchProductByClass(textFieldSearchBar.getText(),
							products);
					selectSetofProducts(searchProducts);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				break;
			}

		} else if (e.getSource().equals(btnShow) && productsTable.getSelectedRow() != -1) {
			// Use the product controller to create a product object using the getValueAt o
			// searching it inside the db
			ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
			Product selectedProduct = null;
			Product auxProduct = null;
			int idSelectedProduct;

			try {
				idSelectedProduct = (int) productsTable.getValueAt(productsTable.getSelectedRow(), 0);

				auxProduct = proManager.searchProductById(idSelectedProduct, proManager.getAllProducts());

				if (auxProduct instanceof Instrument) {
					selectedProduct = new Instrument();
					selectedProduct = (Instrument) auxProduct;
				} else if (auxProduct instanceof Component) {
					selectedProduct = new Component();
					selectedProduct = (Component) auxProduct;
				} else if (auxProduct instanceof Accessory) {
					selectedProduct = new Accessory();
					selectedProduct = (Accessory) auxProduct;
				}
			} catch (ProductNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
			}

			mngProduct = new ManagerProductManagementTab(selectedProduct);
			((JTabbedPane) this.getParent()).insertTab("Manage", null, mngProduct, null,
					((JTabbedPane) this.getParent()).indexOfComponent(this) + 1);
			((JTabbedPane) this.getParent()).setSelectedIndex(((JTabbedPane) this.getParent()).getSelectedIndex() + 1);

		} else if (e.getSource().equals(chckbxIsInSale)) {
			try {
				ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();
				Set<Product> searchProducts = proManager.searchProductInSale(products);
				selectSetofProducts(searchProducts);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource().equals(btnSearch)) {
				btnSearch.doClick();
			} else if (e.getSource().equals(btnShow)) {
				btnShow.doClick();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void selectSetofProducts(Set<Product> searchProducts) {
		modelProduct = (DefaultTableModel) productsTable.getModel();
		modelProduct.setRowCount(0);
		Object[] rowData = null;
		for (Product product : searchProducts) {
			if (product instanceof Instrument) {
				Instrument instrument = (Instrument) product;
				rowData = new Object[] { instrument.getIdProduct(), instrument.getNameP(), instrument.getPrice(),
						instrument.getDescriptionP(), instrument.getStock(), instrument.getBrand(),
						instrument.getModel(), instrument.getColor(), instrument.isSaleActive() ? "Yes" : "No",
						instrument.getSalePercentage(), instrument.isActive() ? "Yes" : "No",
						instrument.getClassInstrument().getLabel(), instrument.getTypeInstrument().getLabel() };

			} else if (product instanceof Component) {
				Component component = (Component) product;
				rowData = new Object[] { component.getIdProduct(), component.getNameP(), component.getPrice(),
						component.getDescriptionP(), component.getStock(), component.getBrand(), component.getModel(),
						component.getColor(), component.isSaleActive() ? "Yes" : "No", component.getSalePercentage(),
						component.isActive() ? "Yes" : "No", component.getClassComponent().getLabel(),
						component.getTypeComponent().getLabel() };

			} else if (product instanceof Accessory) {
				Accessory accessory = (Accessory) product;
				rowData = new Object[] { accessory.getIdProduct(), accessory.getNameP(), accessory.getPrice(),
						accessory.getDescriptionP(), accessory.getStock(), accessory.getBrand(), accessory.getModel(),
						accessory.getColor(), accessory.isSaleActive() ? "Yes" : "No", accessory.getSalePercentage(),
						accessory.isActive() ? "Yes" : "No", accessory.getClassAccessory().getLabel(),
						accessory.getTypeAccessory().getLabel() };
			}
			modelProduct.addRow(rowData);
		}
	}
}
