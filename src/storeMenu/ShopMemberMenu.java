package storeMenu;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import javax.swing.plaf.ColorUIResource;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JList;

public class ShopMemberMenu extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox chckbxSale;
	private JTextField textFieldIntroduceProduct;
	private JComboBox comboBoxFilter;
	private JButton btnAdd;
	private JScrollPane scrollPaneProducts;
	private JButton btnCarrito;

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
		chckbxSale.addKeyListener(this);

		/**
		 * Add a combo box to the panel to be able to filter the products by different
		 * features.
		 */
		comboBoxFilter = new JComboBox();
		comboBoxFilter.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxFilter.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		comboBoxFilter.setFont(new Font("Constantia", Font.PLAIN, 25));
		comboBoxFilter.setBounds(919, 206, 316, 50);
		add(comboBoxFilter);
		comboBoxFilter.addKeyListener(this);

		/**
		 * Add a text field to the panel to be able to search a product by the name.
		 */
		// Busqueda de productos
		textFieldIntroduceProduct = new JTextField();
		textFieldIntroduceProduct.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		textFieldIntroduceProduct.setBounds(94, 206, 815, 50);
		add(textFieldIntroduceProduct);
		textFieldIntroduceProduct.setColumns(10);
		textFieldIntroduceProduct.addKeyListener(this);

		/**
		 * Add a label to the panel
		 */
		JLabel lblWelcome = new JLabel("Welcome to our shop");
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
		btnLupa.addKeyListener(this);
		
		/**
		 * Add a button to the panel to add the desired products to the cart
		 */
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 151, 178));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Onyx", Font.BOLD, 45));
		btnAdd.setBounds(1295, 770, 205, 65);
		add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIManager UI = new UIManager();
				UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
				UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
				UIManager.put("Button.background", new java.awt.Color(0, 151, 178));
				
				JOptionPane.showMessageDialog(null, "You want to add this product to the shopping cart?", "Add Product",
						JOptionPane.QUESTION_MESSAGE);
				/*JOptionPane.showMessageDialog(null, "You want to add this product to the shopping cart?", "Add Product", JOptionPane.INFORMATION_MESSAGE);*/
			}
		});
		btnAdd.addKeyListener(this);

		//Registro de los productos añadidos a la cesta
		btnCarrito = new JButton("");
		btnCarrito.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/carrito_.png")));
		btnCarrito.setBounds(1400, 36, 100, 100);
		add(btnCarrito);
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Are you sure you want to make this purchase?");
			}
		});
		btnCarrito.addKeyListener(this);

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

		String categories[] = { "a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a", "b", "c", "d" };

		JList listProducts = new JList(categories);
		listProducts.setFont(new Font("Constantia", Font.PLAIN, 25));
		// instanciamos la lista
		scrollPaneProducts = new JScrollPane(listProducts);
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
		JComboBox comboBoxProductType = new JComboBox();
		comboBoxProductType.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		comboBoxProductType.setFont(new Font("Constantia", Font.PLAIN, 25));
		comboBoxProductType
				.setModel(new DefaultComboBoxModel(new String[] { "", "Instrument", "Component", "Accessory" }));
		comboBoxProductType.setBounds(190, 295, 316, 50);
		add(comboBoxProductType);
		comboBoxProductType.addKeyListener(this);

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
		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() instanceof JCheckBox) {
				((JCheckBox) e.getSource()).doClick();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAdd.doClick();
				}

			}

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
