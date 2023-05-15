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
import logicTier.ProductManagerControllable;
import logicTier.ProductManagerFactory;
import model.Accessory;
import model.Component;
import model.Instrument;
import model.Product;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * 
 * @author Ander Goirigolzarri Iturburu
 */
public class ManagerShopTab extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JTextField textFieldProductId;
	private JButton btnSearch, btnShow;
	private JScrollPane scrollPaneProductList;
	private JTable productsTable;
	private JLabel lblProductId;
	private DefaultTableModel modelProduct;

	/**
	 * Create the panel.
	 */
	public ManagerShopTab() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);

		
		// --- JLabel ---
		lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Constantia", Font.BOLD, 35));
		lblProductId.setBounds(160, 50, 190, 50);
		add(lblProductId);

		// --- TextField ---
		textFieldProductId = new JTextField();
		textFieldProductId.setBounds(360, 50, 1090, 50);
		add(textFieldProductId);
		textFieldProductId.setColumns(10);
		

		// --- JButton ---

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Onyx", Font.BOLD, 35));
		btnSearch.setBounds(1460, 50, 270, 50);
		add(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.addKeyListener(this);
		
		btnShow = new JButton("Show");
		btnShow.setFont(new Font("Onyx", Font.BOLD, 35));
		btnShow.setBounds(1460, 844, 270, 52);
		add(btnShow);
		btnShow.addActionListener(this);
		btnShow.addKeyListener(this);
		
		// --- JScrollPane ---
		scrollPaneProductList = new JScrollPane();
		scrollPaneProductList.setBounds(120, 125, 1640, 695);
		add(scrollPaneProductList);

		// --- JTable ---
		modelProduct = new DefaultTableModel(); // Establish the default table model
		modelProduct.setColumnIdentifiers(new Object[] { "ID", "Name", "Price", "Description", "Stock", "Brand",
				"Model", "Color", "Sale Active", "Sale Percentage", "Active", "Class", "Type" });
		productsTable = new JTable();
		scrollPaneProductList.setViewportView(productsTable);
		productsTable.setModel(modelProduct);
		productsTable.setEnabled(false);
		
		showAllProducts();

	}

	private void showAllProducts() {
		// Create a ProductManagerControllable object
					ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();

					// Receive the data from the logicTier
					try {
						Set<Product> products = proManager.getAllProducts();
						modelProduct = (DefaultTableModel) productsTable.getModel();
						modelProduct.setRowCount(0);

						// Add the data to the JTable
						for (Product product : products) {
							Object[] rowData = null;
							if (product instanceof Instrument) {
								Instrument instrument = (Instrument) product;
								rowData = new Object[] { instrument.getIdProduct(), instrument.getNameP(),
										instrument.getPrice(), instrument.getDescriptionP(), instrument.getStock(),
										instrument.getBrand(), instrument.getModel(), instrument.getColor(),
										instrument.isSaleActive() ? "Yes" : "No", instrument.getSalePercentage(),
										instrument.isActive() ? "Yes" : "No", instrument.getClassInstrument().getLabel(),
										instrument.getTypeInstrument().getLabel() };

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnSearch) && textFieldProductId.getText().isBlank()) {
			// Create a ProductManagerControllable object
			ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();

			// Receive the data from the logicTier
			try {
				Set<Product> products = proManager.getAllProducts();
				modelProduct = (DefaultTableModel) productsTable.getModel();
				modelProduct.setRowCount(0);

				// Add the data to the JTable
				for (Product product : products) {
					Object[] rowData = null;
					if (product instanceof Instrument) {
						Instrument instrument = (Instrument) product;
						rowData = new Object[] { instrument.getIdProduct(), instrument.getNameP(),
								instrument.getPrice(), instrument.getDescriptionP(), instrument.getStock(),
								instrument.getBrand(), instrument.getModel(), instrument.getColor(),
								instrument.isSaleActive() ? "Yes" : "No", instrument.getSalePercentage(),
								instrument.isActive() ? "Yes" : "No", instrument.getClassInstrument().getLabel(),
								instrument.getTypeInstrument().getLabel() };

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
		}
		if (e.getSource().equals(btnShow)) {
			// Create a ProductManagerControllable object
			ProductManagerControllable proManager = ProductManagerFactory.getProductManagerControllable();

			// Receive the data from the logicTier
			try {
				Set<Product> products = proManager.getAllProducts();
				modelProduct = (DefaultTableModel) productsTable.getModel();
				modelProduct.setRowCount(0);

				// Add the data to the JTable
				for (Product product : products) {
					Object[] rowData = null;
					if (product instanceof Instrument) {
						Instrument instrument = (Instrument) product;
						rowData = new Object[] { instrument.getIdProduct(), instrument.getNameP(),
								instrument.getPrice(), instrument.getDescriptionP(), instrument.getStock(),
								instrument.getBrand(), instrument.getModel(), instrument.getColor(),
								instrument.isSaleActive() ? "Yes" : "No", instrument.getSalePercentage(),
								instrument.isActive() ? "Yes" : "No", instrument.getClassInstrument(),
								instrument.getTypeInstrument() };

					} else if (product instanceof Component) {
						Component component = (Component) product;
						rowData = new Object[] { component.getIdProduct(), component.getNameP(), component.getPrice(),
								component.getDescriptionP(), component.getStock(), component.getBrand(),
								component.getModel(), component.getColor(), component.isSaleActive() ? "Yes" : "No",
								component.getSalePercentage(), component.isActive() ? "Yes" : "No",
								component.getClassComponent(), component.getTypeComponent() };

					} else if (product instanceof Accessory) {
						Accessory accessory = (Accessory) product;
						rowData = new Object[] { accessory.getIdProduct(), accessory.getNameP(), accessory.getPrice(),
								accessory.getDescriptionP(), accessory.getStock(), accessory.getBrand(),
								accessory.getModel(), accessory.getColor(), accessory.isSaleActive() ? "Yes" : "No",
								accessory.getSalePercentage(), accessory.isActive() ? "Yes" : "No",
								accessory.getClassAccessory(), accessory.getTypeAccessory() };
					}
					modelProduct.addRow(rowData);
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}

			// Set the table model to the JTable
			productsTable.setModel(modelProduct);
			productsTable.setEnabled(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(e.getSource().equals(btnSearch)){
				btnSearch.doClick();
			}else if(e.getSource().equals(btnShow)) {
				btnShow.doClick();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
