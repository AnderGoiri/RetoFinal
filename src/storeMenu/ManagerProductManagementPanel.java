package storeMenu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ManagerProductManagementPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField textFieldModel;
	private JTextField textFieldPrice;
	private JTextField textFieldSalePercentage;
	private JComboBox<String> comboBoxName;
	private JComboBox<String> comboBoxBrand;
	private JButton btnDelete;
	private JButton btnModify;
	private JButton btnConfirm;
	private JCheckBox chckbxActive;
	private JTextArea textAreaDescription;
	private JSpinner spinnerStock;
	private JCheckBox chckbxSale;
	

	/**
	 * Create the panel.
	 */
	public ManagerProductManagementPanel() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setFont(new Font("Constantia", Font.BOLD, 35));
		lblProduct.setBounds(50, 50, 143, 52);
		add(lblProduct);
		
		JLabel lblProductId = new JLabel("*id*");
		lblProductId.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblProductId.setBounds(203, 50, 358, 52);
		add(lblProductId);
		
		JLabel lblProductType = new JLabel("*type*");
		lblProductType.setFont(new Font("Constantia", Font.ITALIC, 30));
		lblProductType.setBounds(50, 105, 358, 52);
		add(lblProductType);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Constantia", Font.BOLD, 35));
		lblModel.setBounds(50, 430, 143, 50);
		add(lblModel);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Constantia", Font.BOLD, 35));
		lblBrand.setBounds(50, 320, 143, 50);
		add(lblBrand);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Constantia", Font.BOLD, 35));
		lblStock.setBounds(50, 540, 143, 50);
		add(lblStock);
		
		JLabel lblSalePercentage = new JLabel("Sale %");
		lblSalePercentage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSalePercentage.setFont(new Font("Constantia", Font.BOLD, 35));
		lblSalePercentage.setBounds(347, 650, 134, 50);
		add(lblSalePercentage);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Constantia", Font.BOLD, 35));
		lblPrice.setBounds(338, 540, 143, 50);
		add(lblPrice);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Constantia", Font.BOLD, 35));
		lblDescription.setBounds(710, 210, 219, 50);
		add(lblDescription);
		
		chckbxSale = new JCheckBox("Sale");
		chckbxSale.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxSale.setBounds(50, 650, 267, 50);
		add(chckbxSale);
		
		spinnerStock = new JSpinner();
		spinnerStock.setFont(new Font("Constantia", Font.PLAIN, 30));
		spinnerStock.setBounds(203, 540, 114, 50);
		add(spinnerStock);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setBounds(710, 275, 1100, 425);
		add(textAreaDescription);
		
		textFieldModel = new JTextField();
		textFieldModel.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldModel.setBounds(203, 430, 457, 50);
		add(textFieldModel);
		textFieldModel.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(491, 540, 169, 50);
		add(textFieldPrice);
		
		textFieldSalePercentage = new JTextField();
		textFieldSalePercentage.setFont(new Font("Constantia", Font.PLAIN, 30));
		textFieldSalePercentage.setColumns(10);
		textFieldSalePercentage.setBounds(491, 650, 169, 52);
		add(textFieldSalePercentage);
		textFieldSalePercentage.setEnabled(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 151, 178));
		btnDelete.setFont(new Font("Onyx", Font.BOLD, 45));
		btnDelete.setBounds(300, 830, 230, 52);
		add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnModify = new JButton("Modify");
		btnModify.setForeground(Color.WHITE);
		btnModify.setBackground(new Color(0, 151, 178));
		btnModify.setFont(new Font("Onyx", Font.BOLD, 45));
		btnModify.setBounds(1330, 830, 230, 52);
		add(btnModify);
		btnModify.addActionListener(this);
		
		JSeparator separatorUp = new JSeparator();
		separatorUp.setBounds(20, 170, 1820, 3);
		add(separatorUp);
		
		JSeparator separatorDown = new JSeparator();
		separatorDown.setBounds(20, 800, 1820, 3);
		add(separatorDown);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Constantia", Font.BOLD, 35));
		lblName.setBounds(50, 210, 143, 50);
		add(lblName);
		
		chckbxActive = new JCheckBox("Active");
		chckbxActive.setFont(new Font("Constantia", Font.BOLD, 35));
		chckbxActive.setBounds(1670, 105, 140, 50);
		add(chckbxActive);
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxName.setBounds(203, 210, 457, 50);
		add(comboBoxName);
		
		comboBoxBrand = new JComboBox<String>();
		comboBoxBrand.setFont(new Font("Constantia", Font.PLAIN, 30));
		comboBoxBrand.setBounds(203, 320, 457, 52);
		add(comboBoxBrand);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(1330, 830, 230, 52);
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		add(btnConfirm);
		btnConfirm.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnModify)) {
			
		}
	}
}
