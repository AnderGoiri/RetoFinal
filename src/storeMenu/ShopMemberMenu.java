package storeMenu;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class ShopMemberMenu extends JPanel {
	private JCheckBox chckbxSale;
	private JTextField textField;
	private JComboBox comboBox;
	
	/**
	 * Create the panel.
	 */
	public ShopMemberMenu() {
	setBounds(0, 0, 1860, 950);
	setLayout(null);
	
	chckbxSale = new JCheckBox("Sale");
	chckbxSale.setFont(new Font("Constantia", Font.PLAIN, 30));
	chckbxSale.setBounds(159, 264, 113, 65);
	add(chckbxSale);
	
	comboBox = new JComboBox();
	comboBox.setBackground(new Color(255, 255, 255));
	comboBox.setFont(new Font("Constantia", Font.PLAIN, 15));
	comboBox.setBounds(984, 206, 316, 52);
	add(comboBox);
	
	textField = new JTextField();
	textField.setBounds(159, 205, 815, 53);
	add(textField);
	textField.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("Welcome to our shop");
	lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 55));
	lblNewLabel.setBounds(509, 10, 598, 154);
	add(lblNewLabel);
	
	JButton btnNewButton = new JButton("");
	btnNewButton.setBackground(UIManager.getColor("ScrollPane.background"));
	btnNewButton.setIcon(new ImageIcon(ShopMemberMenu.class.getResource("/media/lupaPequeña.png")));
	btnNewButton.setBounds(1310, 198, 70, 63);
	add(btnNewButton);
	
	JLabel lblNewLabel_1 = new JLabel("Look for a product");
	lblNewLabel_1.setForeground(new Color(0, 151, 178));
	lblNewLabel_1.setFont(new Font("Constantia", Font.PLAIN, 25));
	lblNewLabel_1.setBounds(159, 174, 496, 31);
	add(lblNewLabel_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(94, 372, 1340, 413);
	add(scrollPane);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	}