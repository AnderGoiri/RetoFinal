package storeMenuGUI;

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
import java.sql.SQLException;
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

import exceptions.ModelNotFoundException;
import exceptions.ProductNotFoundException;
import exceptions.PurchaseNotFoundException;
import exceptions.StockNotFoundException;
import exceptions.TypeNotFoundException;
import logicTier.ProductMemberControllable;
import logicTier.ProductMemberFactory;
import model.Accessory;
import model.Component;
import model.Instrument;
import model.Member;
import model.Product;
import model.Purchase;
import model.User;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.SystemColor;

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
	private JComboBox<String> cmbFilter2;
	private JComboBox<String> comboProductType;
	private JButton btnLupa;
	private JTable productTable;
	private JButton btnAdd;
	private DefaultTableModel model;
	private ProductMemberControllable pMember = ProductMemberFactory.getProductMember();
	private Set<Product> listProduct;
	private Purchase purch;
	private Product prod;
	private User user;
	
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

	public ShopMemberMenu(User user) {
		setBounds(0, 0, 1860, 950);
		setLayout(null);

		this.user = user;
		
		model = new DefaultTableModel();
		String[] columns= {"ID", "Name", "Price", "Stock", "Brand", "Model", "Color", "Sale Percentage", "Class", "Type"};
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
		btnAdd.addActionListener(this);
			
		
		chckbxSale = new JCheckBox("Sale");
		chckbxSale.setFont(new Font("Constantia", Font.PLAIN, 30));
		chckbxSale.setBounds(1349, 315, 85, 45);
		add(chckbxSale);
		chckbxSale.setOpaque(false);
		chckbxSale.addActionListener(this);
		
		cmbFilter = new JComboBox();
		cmbFilter.setModel(new DefaultComboBoxModel());
		cmbFilter.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		cmbFilter.setFont(new Font("Constantia", Font.PLAIN, 25));
		cmbFilter.setBounds(837, 206, 264, 50);
		cmbFilter.setEnabled(false);
		add(cmbFilter);
		cmbFilter.addActionListener(this);
	
		cmbFilter2 = new JComboBox();
		cmbFilter2.setFont(new Font("Constantia", Font.PLAIN, 25));
		cmbFilter2.setEnabled(false);
		cmbFilter2.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		cmbFilter2.setBounds(1110, 206, 264, 50);
		cmbFilter2.setEnabled(false);
		add(cmbFilter2);
		cmbFilter2.addActionListener(this);
		
		txtSearch = new JTextField();
		txtSearch.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		txtSearch.setBounds(94, 206, 733, 50);
		txtSearch.setEditable(getFocusTraversalKeysEnabled());
		txtSearch.setColumns(10);
		add(txtSearch);

		lblWelcome = new JLabel("Welcome to our shop");
		lblWelcome.setFont(new Font("Elephant", Font.PLAIN, 55));
		lblWelcome.setBounds(509, 10, 598, 154);
		add(lblWelcome);

		btnLupa = new JButton("");
		btnLupa.setBackground(UIManager.getColor("ScrollPane.background"));
		btnLupa.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/lupa_azul.png")));
		btnLupa.setBounds(1384, 206, 50, 50);
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
		btnRemove.addActionListener(this);
		btnRemove.addKeyListener(this)
;
		btnCarrito = new JButton("");
		btnCarrito.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/carrito_.png")));
		btnCarrito.setBounds(1400, 36, 100, 100);
		add(btnCarrito);
		btnCarrito.addActionListener(this);
		
		JLabel lblLookProduct = new JLabel("Look for a product");
		lblLookProduct.setForeground(new Color(0, 0, 0));
		lblLookProduct.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblLookProduct.setBounds(94, 176, 496, 31);
		add(lblLookProduct);

		JSeparator separator = new JSeparator();
		separator.setBounds(451, 134, 707, 2);
		add(separator);

		JLabel lblList = new JLabel("List of:");
		lblList.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblList.setBounds(94, 315, 94, 37);
		add(lblList);

		comboProductType = new JComboBox();
		comboProductType.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		comboProductType.setFont(new Font("Constantia", Font.PLAIN, 25));
		comboProductType.setModel(new DefaultComboBoxModel(new String[] { "", "All", "Instrument", "Component", "Accessory" }));
		comboProductType.setBounds(190, 295, 316, 50);
		add(comboProductType);
		comboProductType.addActionListener(this);
		
		
		JLabel lblPurchase = new JLabel("Shopping Cart");
		lblPurchase.setFont(new Font("Constantia", Font.BOLD, 25));
		lblPurchase.setBounds(1361, 134, 168, 65);
		add(lblPurchase);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/descarga.jpg")));
		lblFondo.setBounds(0, 0, 1540, 845);
		add(lblFondo);
		
		model.setRowCount(0);
		
		showAllProducts();
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(comboProductType)) {
			updateFilterComboBox();
		}
        if (e.getSource().equals(btnLupa)) {
        	model.setRowCount(0);
            makeSearch();
		}	  
        if (e.getSource().equals(btnAdd)) {
            JOptionPane.showMessageDialog(null, "You want to add this product to the shopping cart?"); 
            boolean added =  addToCart();
            if (added) {
            	JOptionPane.showMessageDialog(null, "Product added successfully to the cart");
            }
        }  
        if (e.getSource().equals(btnRemove)) {
            JOptionPane.showMessageDialog(null, "Are you sure you want to remove this product from the shopping cart?");
            boolean removed = removeFromCart();
            if (removed) {
            	JOptionPane.showMessageDialog(null, "Product removed successfully from the cart");
            }
        }
        if (e.getSource().equals(btnCarrito)) {
        	int confirm = JOptionPane.showConfirmDialog(null, "Do you want to finish the purchase?", "Confirmation", JOptionPane.YES_NO_OPTION);
        	if (confirm == JOptionPane.YES_OPTION) {
        		purch = finishPurchase();
        		if (purch!=null) {
        			float price = purch.getPurchaseTotalCost();
            		JOptionPane.showMessageDialog(null, "The final price will be: " + price);
                } 
        		
        	}
        }
	}
	private boolean removeFromCart() {
		ProductMemberControllable pMember = ProductMemberFactory.getProductMember();
		boolean removed = true;
		int productId = 0;
		Set<Product> listProduct;
		int filaSelect = productTable.getSelectedRow();
		if (filaSelect != -1) {
			productId = (int) productTable.getValueAt(filaSelect, 0);
		}

		try {
			/**
			 * Setting the selected product
			 */
			listProduct = pMember.getAllProducts("");
			prod = pMember.searchProductById(productId, listProduct);

			Member mUser = (Member) user;

			/**
			 * Setting the in progress purchase from the user
			 */
			purch = pMember.searchPurchase(mUser);

			/**
			 * Removing the product from the purchase
			 */
			purch = pMember.removeProduct(purch, prod);
		} catch (PurchaseNotFoundException e) {
			removed = false;
			JOptionPane.showMessageDialog(null, "Purchase not found", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			removed = false;
			JOptionPane.showMessageDialog(null, "Unknown Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return removed;
	}

	private Purchase finishPurchase() {
		ProductMemberControllable pMember = ProductMemberFactory.getProductMember();
		try {
			Member mUser = (Member) user;
			purch = pMember.searchPurchase(mUser);
			pMember.removePurchase(purch);
		} catch (PurchaseNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Purchase not found", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "No products added to the cart", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return purch;
	}
	
	private boolean addToCart() {
		ProductMemberControllable pMember = ProductMemberFactory.getProductMember();
		boolean added = true;
		int productId = 0;
		Set<Product> listProduct;
		int filaSelect = productTable.getSelectedRow();
		if (filaSelect != -1) {
			productId = (int) productTable.getValueAt(filaSelect, 0);
		}
		try {
			/**
			 * Setting the selected product
			 */
			listProduct = pMember.getAllProducts("");
			prod = pMember.searchProductById(productId, listProduct);
		
			Member mUser = (Member) user;
			
			/**
			 * Setting the in progress purchase from the user
			 */
			purch = pMember.searchPurchase(mUser);
			
			/**
			 * Adding the product to the purchase
			 */
			pMember.addProductPurchase(purch, prod, mUser);
			pMember.removeProduct(purch, prod);
		} catch (StockNotFoundException e) {
			added = false;
			JOptionPane.showMessageDialog(null, "Stock not found", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ProductNotFoundException e) {
			added = false;
			JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			added = false;
			JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			added = false;
			JOptionPane.showMessageDialog(null, "Unknown Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return added;
	}

	/**
	 * This method searches a product depending on the type selected in the combobox (Instrument, Component or Accessory)
	 */
	public void makeSearch() {
		ProductMemberControllable pMember = ProductMemberFactory.getProductMember();	
		
		try {	
			String search = new String(txtSearch.getText());
	
			if (comboProductType.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(this, "Selecciona un tipo de producto");
			} else {
				String sel = (String) comboProductType.getSelectedItem();
				String filter = (String) cmbFilter.getSelectedItem();
				String filter2 = (String) cmbFilter2.getSelectedItem();
				Set<Product> listProduct = new HashSet<Product>();
				comboProductType.setEnabled(true);
				if (sel.equals("All")) {
					listProduct = pMember.getAllProducts(search);
					cmbFilter.setEnabled(false);
					cmbFilter2.setEnabled(false);
				} else if (sel.equals("Instrument")) {
					listProduct = pMember.searchInstrument(search);					
				} else if (sel.equals("Component")) {
					listProduct = pMember.searchComponent(search);
				} else if (sel.equals("Accessory")) {
					listProduct = pMember.searchAccessory(search);
				} else {
					listProduct = pMember.getAllProducts(search);
				}
				if (filter != null) {
					if (!filter.equals("") || !filter.isBlank()) {
						listProduct = pMember.searchProductByClass(filter, listProduct);
					}
				}		
				if (filter2 != null) {
					if (!filter2.equals("") || !filter2.isBlank()) {
						listProduct = pMember.searchProductByType(filter2, listProduct);
					}
				}	
				if (chckbxSale.isSelected()) {
					listProduct = pMember.searchProductInSale(listProduct);
				}
				if (comboProductType.getSelectedIndex() == 0) {
					if(search.isBlank() && !sel.equals("All")) {
						JOptionPane.showMessageDialog(this, "Please, search a product.");
					}
				}
				
				for (Product prod : listProduct) {			
					if (prod instanceof Instrument) {
						Instrument instrument = (Instrument) prod;
						Object[] datos = { instrument.getIdProduct(), instrument.getNameP(), instrument.getPrice(),
								instrument.getStock(), instrument.getBrand(), instrument.getModel(),
								instrument.getColor(), instrument.getSalePercentage(), instrument.getClassInstrument(),
								instrument.getTypeInstrument().name() };
						model.addRow(datos);
					}
					if (prod instanceof Component) {
						Component component = (Component) prod;
						Object[] datos = { component.getIdProduct(), component.getNameP(), component.getPrice(),
								component.getStock(), component.getBrand(), component.getModel(), component.getColor(),
								component.getSalePercentage(), component.getClassComponent(),
								component.getTypeComponent().name() };
						model.addRow(datos);
					}
					if (prod instanceof Accessory) {
						Accessory accessory = (Accessory) prod;
						Object[] datos = { accessory.getIdProduct(), accessory.getNameP(), accessory.getPrice(),
								accessory.getStock(), accessory.getBrand(), accessory.getModel(), accessory.getColor(),
								accessory.getSalePercentage(), accessory.getClassAccessory(),
								accessory.getTypeAccessory().name() };
						model.addRow(datos);
					}

				}
				productTable.setModel(model);
				productTable.setEnabled(true);	
			}				
		} catch (ProductNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (TypeNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Type of product not found", "Error", JOptionPane.ERROR_MESSAGE);
		} 	
	}
	
	public Set<Product> showAllProducts(){
		String search = "";
		try {
			listProduct = pMember.getAllProducts(search);
			model.setRowCount(0);
			for (Product prod : listProduct) {
				if (prod instanceof Instrument) {
					Instrument instrument = (Instrument) prod;
					Object[] datos = { instrument.getIdProduct(), instrument.getNameP(), instrument.getPrice(),
							instrument.getStock(), instrument.getBrand(), instrument.getModel(),
							instrument.getColor(), instrument.getSalePercentage(), instrument.getClassInstrument(),
							instrument.getTypeInstrument().name() };
					model.addRow(datos);
				}
				if (prod instanceof Component) {
					Component component = (Component) prod;
					Object[] datos = { component.getIdProduct(), component.getNameP(), component.getPrice(),
							component.getStock(), component.getBrand(), component.getModel(), component.getColor(),
							component.getSalePercentage(), component.getClassComponent(),
							component.getTypeComponent().name() };
					model.addRow(datos);
				}
				if (prod instanceof Accessory) {
					Accessory accessory = (Accessory) prod;
					Object[] datos = { accessory.getIdProduct(), accessory.getNameP(), accessory.getPrice(),
							accessory.getStock(), accessory.getBrand(), accessory.getModel(), accessory.getColor(),
							accessory.getSalePercentage(), accessory.getClassAccessory(),
							accessory.getTypeAccessory().name() };
					model.addRow(datos);
				}
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
		productTable.setModel(model);
		productTable.setEnabled(true);
		return listProduct;
	}
	/**
	 * Method to change the filter if the product is an instrument, component or accessory
	 */
	private void updateFilterComboBox() {
	    String selectedType = (String) comboProductType.getSelectedItem();
	    DefaultComboBoxModel<String> filterModel = new DefaultComboBoxModel<String>();
	    if (selectedType != null) {
	        switch (selectedType) {
	            case "Instrument":
	            	filterModel.addElement("");
	                filterModel.addElement("WIND");
	                filterModel.addElement("STRING");
	                filterModel.addElement("PERCUSSION");
	                break;
	            case "Component":
	            	filterModel.addElement("");
	                filterModel.addElement("CHASIS");
	                filterModel.addElement("CIRCUIT");
	                break;
	            case "Accessory":
	            	filterModel.addElement("");
	                filterModel.addElement("ELECTRIC");
	                filterModel.addElement("NON-ELECTRIC");
	                break;
	        }
	    }
	    cmbFilter.setModel(filterModel);
	    cmbFilter.setEnabled(true);
	    
	    DefaultComboBoxModel<String> filter2Model = new DefaultComboBoxModel<String>();
	    if (selectedType != null) {
	        switch (selectedType) {
	            case "Instrument":
	            	filter2Model.addElement("");
	                filter2Model.addElement("ACOUSTIC");
	                filter2Model.addElement("ELECTRONIC");
	                break;
	            case "Component":
	            	filter2Model.addElement("");
	                filter2Model.addElement("ARCHITECTURE");
	                filter2Model.addElement("TUNNING");
	                filter2Model.addElement("CONNECTION");
	                break;
	            case "Accessory":
	            	filter2Model.addElement("");
	                filter2Model.addElement("AUDIO");
	                filter2Model.addElement("CONNECTION");
	                filter2Model.addElement("ITEM");
	                break;
	        }
	    }
	    cmbFilter2.setModel(filter2Model);
	    cmbFilter2.setEnabled(true);
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