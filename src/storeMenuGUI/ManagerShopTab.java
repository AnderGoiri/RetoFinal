package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
		
		// Replaces the column identifiers in the model with our data structure
		String[] productTableHeaders = { "Product ID", "Brand", "Model", "Product Type", "Name", "Description", "Color",
				"Price", "Sale", "Sale %", "Stock","Type","Class"};
		modelProduct.setColumnIdentifiers(productTableHeaders);
		
		productsTable = new JTable();
		scrollPaneProductList.setViewportView(productsTable);
		productsTable.setModel(modelProduct);
		productsTable.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSearch)) {
			
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
}
