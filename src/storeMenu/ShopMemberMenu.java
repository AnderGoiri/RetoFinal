package storeMenu;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class ShopMemberMenu extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox chckbxSale;
	private JTextField txtSearch;
	private JButton btnAdd;
	private JScrollPane scrollPaneProducts;
	private JButton btnCarrito;
	private JLabel lblWelcome;
	private JComboBox<String> cmbFilter;
	private JList list;

	/**
	 * Create the panel.
	 */
	public ShopMemberMenu() {
		setBounds(0, 0, 1860, 950);
		setLayout(null);

		/**
		 * add a check box to the panel to be able to select only the products that are
		 * currently on sale.
		 */
		chckbxSale = new JCheckBox("Sale");
		chckbxSale.setFont(new Font("Constantia", Font.PLAIN, 30));
		chckbxSale.setBounds(1349, 315, 85, 45);
		add(chckbxSale);
		chckbxSale.setOpaque(false);

		/**
		 * Add a combo box to the panel to be able to filter the products by different
		 * features.
		 */
		String[] arrayFilter = new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		JComboBox cmbFilter = new JComboBox(arrayFilter);
		cmbFilter.setModel(new DefaultComboBoxModel(arrayFilter));
		cmbFilter.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		cmbFilter.setFont(new Font("Constantia", Font.PLAIN, 25));
		cmbFilter.setBounds(919, 206, 316, 50);
		add(cmbFilter);

		/**
		 * Add a text field to the panel to be able to search a product by the name.
		 */
		txtSearch = new JTextField();
		txtSearch.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		txtSearch.setBounds(94, 206, 815, 50);
		add(txtSearch);
		txtSearch.setColumns(10);

		/**
		 * Add a label to the panel
		 */
		lblWelcome = new JLabel("Welcome to our shop");
		lblWelcome.setFont(new Font("Elephant", Font.PLAIN, 55));
		lblWelcome.setBounds(509, 10, 598, 154);
		add(lblWelcome);

		/**
		 * Add a button to the panel to search for the products when you have already
		 * entered them in textField.
		 */
		JButton btnLupa = new JButton("");
		btnLupa.setBackground(UIManager.getColor("ScrollPane.background"));
		btnLupa.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/lupa_azul.png")));
		btnLupa.setBounds(1245, 206, 50, 50);
		add(btnLupa);
		btnLupa.setOpaque(false);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 151, 178));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Onyx", Font.BOLD, 45));
		btnAdd.setBounds(1295, 770, 205, 65);
		add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You want to add this product to the shopping cart?");
			}
		});

		btnCarrito = new JButton("");
		btnCarrito.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/carrito_.png")));
		btnCarrito.setBounds(1400, 36, 100, 100);
		add(btnCarrito);
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Are you sure you want to make this purchase?");
			}
		});
		
		
		
		/**
		 * Add a label to the panel.
		 */
		JLabel lblLookProduct = new JLabel("Look for a product");
		lblLookProduct.setForeground(new Color(0, 0, 0));
		lblLookProduct.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblLookProduct.setBounds(94, 176, 496, 31);
		add(lblLookProduct);

		/**
		 * Add a scroll pane to the panel to see the list of all the products.
		 */
		
		
		String categories[] = { "a", "b", "c", "d", "e","a", "b", "c", "d", "e","a", "b", "c", "d"};
		
		list = new JList(categories);
		list.setFont(new Font("Constantia", Font.PLAIN, 25));
		//instanciamos la lista
		scrollPaneProducts = new JScrollPane(list);
		scrollPaneProducts.setBounds(94, 372, 1340, 371);
		add(scrollPaneProducts);
		
		/**
		 * 
		 */
		JSeparator separator = new JSeparator();
		separator.setBounds(451, 134, 707, 2);
		add(separator);

		/**
		 * Add a label to the panel.
		 */
		JLabel lblList = new JLabel("List of:");
		lblList.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblList.setBounds(94, 315, 94, 37);
		add(lblList);

		/**
		 * Add a combo box to the panel to be able to select the specific type of
		 * product you are looking for (Instrument, component and accessory).
		 */
		JComboBox comboProductType = new JComboBox();
		comboProductType.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		comboProductType.setFont(new Font("Constantia", Font.PLAIN, 25));
		comboProductType.setModel(new DefaultComboBoxModel(new String[] { "", "Instrument", "Component", "Accessory" }));
		comboProductType.setBounds(190, 295, 316, 50);
		add(comboProductType);
		
		JLabel lblPurchase = new JLabel("Purchase");
		lblPurchase.setFont(new Font("Constantia", Font.BOLD, 25));
		lblPurchase.setBounds(1396, 135, 116, 61);
		add(lblPurchase);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/descarga.jpg")));
		lblFondo.setBounds(0, 0, 1540, 845);
		add(lblFondo);
		
	
	}

	
	public void actionPerformed(ActionEvent e) {
		//TODO if textbox empty && btn
		//comboProductType.getSelectedItem;
	}
}