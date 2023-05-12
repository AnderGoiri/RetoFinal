package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ManagerShopPanel extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldProductId;
	private JButton btnSearch;
	private JButton btnShow;
	private JScrollPane scrollPaneProductList;
	private JTable productsTable;
	private DefaultTableModel tableModel;
	private ManagerProductManagementPanel mngProduct;
	

	/**
	 * Create the panel.
	 */
	public ManagerShopPanel() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setFont(new Font("Constantia", Font.BOLD, 35));
		lblProductId.setBounds(160, 50, 190, 50);
		add(lblProductId);
		
		textFieldProductId = new JTextField();
		textFieldProductId.setBounds(360, 50, 1090, 50);
		add(textFieldProductId);
		textFieldProductId.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Onyx", Font.BOLD, 35));
		btnSearch.setBounds(1460, 50, 270, 50);
		add(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.addKeyListener(this);
		
		
		scrollPaneProductList = new JScrollPane();
		scrollPaneProductList.setBounds(120, 125, 1640, 695);
		add(scrollPaneProductList);
		
		tableModel = new DefaultTableModel();
		String[] productTableHeaders = {"Product ID","Brand","Model","Product Type","Name","Description","Color","Price","Sale","Sale %","Stock"};
		tableModel.setColumnIdentifiers(productTableHeaders);
		tableModel=addProducts(tableModel);
		productsTable = new JTable();
		scrollPaneProductList.setViewportView(productsTable);
		productsTable.setModel(tableModel);
		productsTable.setEnabled(false);
		
		
		btnShow = new JButton("Show");
		btnShow.setFont(new Font("Onyx", Font.BOLD, 35));
		btnShow.setBounds(1460, 844, 270, 52);
		add(btnShow);
		btnShow.addActionListener(this);
		btnShow.addKeyListener(this);

	}

	private DefaultTableModel addProducts(DefaultTableModel tableModel) {
		// TODO Auto-generated method stub
		/**
		Set<Product> products = controlador.metodoListarProductos();
		Iterator<Product> itProd = products.iterator();
		**/
		Object[] row;
		
		//while(itProd.hasNext()){
			row=new Object[11];
			row[0]="";
			row[1]="";
			row[2]="";
			row[3]="";
			row[4]="";
			row[5]="";
			row[6]="";
			row[7]="";
			row[8]="";
			row[9]="";
			row[10]="";
			//Product product = itProd.next();
			//row[0]=product.get();
			//row[1]=product.get();
			//row[2]=product.get();
			//row[3]=product.get();
			//row[4]=product.get();
			//row[5]=product.get();
			//row[6]=product.get();
			//row[7]=product.get();
			//row[8]=product.get();
			//row[9]=product.get();
			//row[10]=product.get();
			
			tableModel.addRow(row);
			//}
			return tableModel;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnShow)) {
			mngProduct = new ManagerProductManagementPanel();
			((JTabbedPane) this.getParent()).insertTab("Manage",null, mngProduct, null, ((JTabbedPane) this.getParent()).indexOfComponent(this)+1);
			((JTabbedPane) this.getParent()).setSelectedIndex(((JTabbedPane) this.getParent()).getSelectedIndex()+1);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(e.getSource().equals(btnSearch)){
				btnSearch.doClick();
			}else if(e.getSource().equals(btnShow)) {
				btnShow.doClick();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
