package storeMenu;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

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
import javax.swing.table.DefaultTableModel;

import exceptions.ProductNotFoundException;
import logicTier.ProductMemberControllable;
import logicTier.ProductMemberFactory;
import model.Accessory;
import model.Component;
import model.Instrument;
import model.Member;
import model.Product;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class ShopMemberMenu extends JPanel implements ActionListener, KeyListener, FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox chckbxSale;
	private JTextField txtSearch;
	private JButton btnRemove;
	private JScrollPane scrollPaneProducts;
	private JButton btnCarrito;
	private JLabel lblWelcome;
	private JComboBox<String> cmbFilter;
	private JComboBox<String> comboProductType;
	private JButton btnLupa;
	private JTable productTable;
	private JButton btnAdd;
	private DefaultTableModel model;

	public JCheckBox getChckbxSale() {
		return chckbxSale;
	}


	public void setChckbxSale(JCheckBox chckbxSale) {
		this.chckbxSale = chckbxSale;
	}


	public JTextField getTxtSearch() {
		return txtSearch;
	}


	public void setTxtSearch(JTextField txtSearch) {
		this.txtSearch = txtSearch;
	}


	public JButton getBtnAdd() {
		return btnRemove;
	}


	public void setBtnAdd(JButton btnAdd) {
		this.btnRemove = btnAdd;
	}


	public JScrollPane getScrollPaneProducts() {
		return scrollPaneProducts;
	}


	public void setScrollPaneProducts(JScrollPane scrollPaneProducts) {
		this.scrollPaneProducts = scrollPaneProducts;
	}


	public JButton getBtnCarrito() {
		return btnCarrito;
	}


	public void setBtnCarrito(JButton btnCarrito) {
		this.btnCarrito = btnCarrito;
	}


	public JLabel getLblWelcome() {
		return lblWelcome;
	}


	public void setLblWelcome(JLabel lblWelcome) {
		this.lblWelcome = lblWelcome;
	}


	public JComboBox<String> getCmbFilter() {
		return cmbFilter;
	}


	public void setCmbFilter(JComboBox<String> cmbFilter) {
		this.cmbFilter = cmbFilter;
	}

	public JComboBox<String> getComboProductType() {
		return comboProductType;
	}


	public void setComboProductType(JComboBox<String> comboProductType) {
		this.comboProductType = comboProductType;
	}


	public JButton getBtnLupa() {
		return btnLupa;
	}


	public void setBtnLupa(JButton btnLupa) {
		this.btnLupa = btnLupa;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


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
		
		
		
		model = new DefaultTableModel();
		String[] columns= {"ID", "Name", "Price", "Stock", "Brand", "Model", "Color", "Sale Percentage"};
		model.setColumnIdentifiers(columns);
		productTable = new JTable();	
		productTable.setModel(model);
		productTable.setEnabled(false);
		
		scrollPaneProducts = new JScrollPane(productTable);
		scrollPaneProducts.setBounds(94, 372, 1340, 371);
		scrollPaneProducts.setViewportView(productTable);
		add(scrollPaneProducts);
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 35));
		btnAdd.setBackground(new Color(0, 151, 178));
		btnAdd.setBounds(999, 770, 205, 65);
		add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You want to add this product to the shopping cart?");
			}
		});
		
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
		cmbFilter = new JComboBox(arrayFilter);
		cmbFilter.setModel(new DefaultComboBoxModel(arrayFilter));
		cmbFilter.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		cmbFilter.setFont(new Font("Constantia", Font.PLAIN, 25));
		cmbFilter.setBounds(919, 206, 316, 50);
		cmbFilter.setEnabled(false);
		add(cmbFilter);
	
		/**
		 * Add a text field to the panel to be able to search a product by the name.
		 */
		txtSearch = new JTextField();
		txtSearch.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		txtSearch.setBounds(94, 206, 815, 50);
		txtSearch.setEditable(getFocusTraversalKeysEnabled());
		txtSearch.setColumns(10);
		add(txtSearch);

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
		btnLupa = new JButton("");
		btnLupa.setBackground(UIManager.getColor("ScrollPane.background"));
		btnLupa.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/lupa_azul.png")));
		btnLupa.setBounds(1245, 206, 50, 50);
		add(btnLupa);
		btnLupa.setOpaque(false);
		btnLupa.addActionListener(this);
		btnLupa.addKeyListener(this);	
			
		
		btnRemove = new JButton("Remove");
		btnRemove.setBackground(new Color(0, 151, 178));
		btnRemove.setForeground(new Color(255, 255, 255));
		btnRemove.setFont(new Font("Dialog", Font.BOLD, 35));
		btnRemove.setBounds(1229, 770, 205, 65);
		add(btnRemove);
		
		
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
		comboProductType = new JComboBox();
		comboProductType.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		comboProductType.setFont(new Font("Constantia", Font.PLAIN, 25));
		comboProductType.setModel(new DefaultComboBoxModel(new String[] { "", "Instrument", "Component", "Accessory" }));
		comboProductType.setBounds(190, 295, 316, 50);
		add(comboProductType);
		
		JLabel lblPurchase = new JLabel("Shopping Cart");
		lblPurchase.setFont(new Font("Constantia", Font.BOLD, 25));
		lblPurchase.setBounds(1361, 134, 168, 65);
		add(lblPurchase);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/descarga.jpg")));
		lblFondo.setBounds(0, 0, 1540, 845);
		add(lblFondo);
		
		model.setRowCount(0);
	
	}

	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLupa)) {
            makeSearch();
        }
        if (e.getSource().equals(btnAdd)) {
            JOptionPane.showMessageDialog(null, "You want to add this product to the shopping cart?");
        }
        if (e.getSource().equals(btnRemove)) {
            JOptionPane.showMessageDialog(null, "Are you sure you want to remove this product from the shopping cart?");
        }
		
	}
	/**
	 * This method searches a product depending on the type selected in the combobox (Instrument, Component or Accessory)
	 */
	public void makeSearch() {
		ProductMemberControllable pMember = ProductMemberFactory.getProductMember();	
		
		try {	
			String search = new String(txtSearch.getText());
	
			if (comboProductType.getSelectedIndex()==-1) {
				JOptionPane.showMessageDialog(this, "Selecciona un tipo de producto");
			} else {
				String sel = (String) comboProductType.getSelectedItem();
				if(search.isBlank()) {
					JOptionPane.showMessageDialog(this, "Please, search a product.");
				} else {
					comboProductType.setEnabled(true);
					Set<Product> listProduct = new HashSet<Product>();
					if (sel.equals("Instrument")) {
						listProduct = pMember.searchInstrument(search);
					}
					if (sel.equals("Component")) {
						listProduct = pMember.searchComponent(search);
					}
					if (sel.equals("Accessory")) {
						listProduct = pMember.searchAccessory(search);
					}
					
					for (Product prod : listProduct) {		
						//TODO Mostrar Class y Type
						//TODO Connection closed al buscar por segunda vez con la app abierta
						if (prod instanceof Instrument) {
					        Instrument instrument = (Instrument) prod;
					        Object[] datos = {instrument.getIdProduct(), instrument.getNameP(), instrument.getPrice(), instrument.getStock(), instrument.getBrand(), instrument.getModel(), instrument.getColor(), instrument.getSalePercentage(), instrument.getTypeInstrument().name()};	
					        model.addRow(datos);
					    }
					    if (prod instanceof Component) {
					        Component component = (Component) prod;
					        Object[] datos = {component.getIdProduct(), component.getNameP(), component.getPrice(), component.getStock(), component.getBrand(), component.getModel(), component.getColor(), component.getSalePercentage(), component.getTypeComponent().name()};	
					        model.addRow(datos);
					    }
					    if (prod instanceof Accessory) {
					        Accessory accessory = (Accessory) prod;
					        Object[] datos = {accessory.getIdProduct(), accessory.getNameP(), accessory.getPrice(), accessory.getStock(), accessory.getBrand(), accessory.getModel(), accessory.getColor(), accessory.getSalePercentage(), accessory.getTypeAccessory().name()};	
					        model.addRow(datos);
					    }
										
					}	
					productTable.setModel(model);
					productTable.setEnabled(true);
					
					cmbFilter.setEnabled(true);
					
					/**
					 * TODO FILTRO
					 */
					
				}				
			}				
		} catch (ProductNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 	
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(e.getSource().equals(txtSearch)){
				btnLupa.doClick();
			}
		}
	}


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
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