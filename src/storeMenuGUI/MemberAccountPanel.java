package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MemberAccountPanel extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsername;
	private JTextField textFieldSurname;
	private JTextField textFieldEmail;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JButton btnEditProfile;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable productsTable;
	private User user;
	/*tengo que hacer que coger la informacion del login y que se muestre la informacion necesaria*//*pull de la rama dev_Frander*/
	
	public MemberAccountPanel(User user) {
		    this(); // llama al constructor predeterminado
		    this.user = user;
		    // ahora puedes acceder a la información de inicio de sesión del usuario a través del objeto 'user'
		}
	/*// Obtén los datos de la cuenta del usuario
String username = "nombreDeUsuario"; // Reemplaza "nombreDeUsuario" con el identificador único del usuario
String surname = obtenerApellidoDeUsuario(username); // Reemplaza "obtenerApellidoDeUsuario" con el método que obtiene el apellido del usuario
String name = obtenerNombreDeUsuario(username); // Reemplaza "obtenerNombreDeUsuario" con el método que obtiene el nombre del usuario
String address = obtenerDireccionDeUsuario(username); // Reemplaza "obtenerDireccionDeUsuario" con el método que obtiene la dirección del usuario
String email = obtenerEmailDeUsuario(username); // Reemplaza "obtenerEmailDeUsuario" con el método que obtiene el email del usuario

// Mostrar la información en los campos correspondientes
textFieldUsername.setText(username);
textFieldSurname.setText(surname);
textFieldName.setText(name);
textFieldAddress.setText(address);
textFieldEmail.setText(email);
*/
	public MemberAccountPanel() {
	
	    textFieldUsername.setText(user.getUsername());
	    textFieldSurname.setText(user.getSurname());
	    textFieldEmail.setText(user.getEmail());
	    textFieldName.setText(user.getName());
	    textFieldAddress.setText(user.getAddress());

	}

	/**
	 * Create the panel.
	 */
	public MemberAccountPanel() {
		setLayout(null);
		setBounds(0, 0, 1582, 845);
		



		/**
		 * Creation of a series of in which the user can see their data and can modify
		 * it if necessary.
		 */
		JLabel lblSurmane = new JLabel("Surname:");
		lblSurmane.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblSurmane.setBounds(268, 165, 148, 41);
		add(lblSurmane);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblName.setBounds(913, 80, 148, 41);
		add(lblName);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblUsername.setBounds(268, 80, 192, 41);
		add(lblUsername);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblEmail.setBounds(268, 245, 143, 52);
		add(lblEmail);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblAddress.setBounds(913, 165, 148, 41);
		add(lblAddress);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(33, 390, 1482, 1);
		add(separator);

		JLabel lblPurchase = new JLabel("Your Purchase List");
		lblPurchase.setFont(new Font("Elephant", Font.BOLD, 35));
		lblPurchase.setBounds(51, 426, 417, 41);
		add(lblPurchase);

		/**
		 * Add a button to edit the jTextField so that the user can modify his data.
		 */
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBackground(new Color(0, 151, 178));
		btnEditProfile.setForeground(new Color(255, 255, 255));
		btnEditProfile.setFont(new Font("Onyx", Font.BOLD, 45));
		btnEditProfile.addActionListener(this);
		btnEditProfile.setBounds(33, 232, 205, 65);
		add(btnEditProfile);
		btnEditProfile.addKeyListener(this);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(442, 72, 457, 50);
		textFieldUsername.setEditable(false);
		textFieldUsername.setEnabled(false);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		textFieldUsername.addKeyListener(this);

		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(442, 157, 457, 50);
		textFieldSurname.setEditable(false);
		textFieldSurname.setEnabled(false);
		add(textFieldSurname);
		textFieldSurname.addKeyListener(this);

		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(1055, 72, 457, 50);
		textFieldName.setEditable(false);
		textFieldName.setEnabled(false);
		add(textFieldName);
		textFieldName.addKeyListener(this);

		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(1055, 157, 457, 50);
		textFieldAddress.setEditable(false);
		textFieldAddress.setEnabled(false);
		add(textFieldAddress);
		textFieldAddress.addKeyListener(this);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(442, 243, 457, 50);
		textFieldEmail.setEditable(false);
		textFieldEmail.setEnabled(false);
		add(textFieldEmail);
		textFieldEmail.addKeyListener(this);

		/**
		 * Add a button to be able to save the changes that have been made in the JTextField.
		 */
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(this);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(1055, 232, 205, 65);
		add(btnConfirm);
		btnConfirm.addKeyListener(this);
		
		/**
		 * Add a button to cancel data that has been modified in the JTextField.
		 */
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Onyx", Font.BOLD, 45));
		btnCancel.setEnabled(false);
		btnCancel.setVisible(false);
		btnCancel.setBackground(new Color(0, 151, 178));
		btnCancel.setBounds(1310, 232, 205, 65);
		add(btnCancel);
		btnCancel.addKeyListener(this);

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 469, 1437, 314);
		add(scrollPane);
		
		tableModel = new DefaultTableModel();
		String[] productTableHeaders = {"Product ID","Quantity","Total Cost","Date","Status"};
		tableModel.setColumnIdentifiers(productTableHeaders);
		tableModel=addProducts(tableModel);
		productsTable = new JTable();
		scrollPane.setViewportView(productsTable);
		productsTable.setModel(tableModel);
		productsTable.setEnabled(false);

		JLabel lblNewFotoPerfil = new JLabel("");
		lblNewFotoPerfil.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/profile2.png")));
		lblNewFotoPerfil.setBounds(57, 47, 143, 150);
		add(lblNewFotoPerfil);
		lblNewFotoPerfil.setOpaque(false);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/descarga.jpg")));
		lblFondo.setBounds(0, 0, 1540, 870);
		add(lblFondo);
	}

	private DefaultTableModel addProducts(DefaultTableModel tableModel2) {
		// TODO Auto-generated method stub
		/**
		Set<Product> products = controlador.metodoListarProductos();
		Iterator<Product> itProd = products.iterator();
		**/
		Object[] row;
		
		//while(itProd.hasNext()){
			row=new Object[5];
			row[0]="";
			row[1]="";
			row[2]="";
			row[3]="";
			row[4]="";
			;
			//Product product = itProd.next();
			//row[0]=product.get();
			//row[1]=product.get();
			//row[2]=product.get();
			//row[3]=product.get();
			//row[4]=product.get();
			//row[5]=product.get();
			
			
			tableModel.addRow(row);
			//}
		return tableModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnEditProfile)) {
			textFieldUsername.setEditable(true);
			textFieldUsername.setEnabled(true);
			textFieldSurname.setEditable(true);
			textFieldSurname.setEnabled(true);
			textFieldEmail.setEditable(true);
			textFieldEmail.setEnabled(true);
			textFieldName.setEditable(true);
			textFieldName.setEnabled(true);
			textFieldAddress.setEditable(true);
			textFieldAddress.setEnabled(true);
			btnConfirm.setEnabled(true);
			btnConfirm.setVisible(true);
			btnCancel.setEnabled(true);
			btnCancel.setVisible(true);

		} else if (e.getSource().equals(btnConfirm)) {
			textFieldUsername.setEditable(false);
			textFieldUsername.setEnabled(false);
			textFieldSurname.setEditable(false);
			textFieldSurname.setEnabled(false);
			textFieldEmail.setEditable(false);
			textFieldEmail.setEnabled(false);
			textFieldName.setEditable(false);
			textFieldName.setEnabled(false);
			textFieldAddress.setEditable(false);
			textFieldAddress.setEnabled(false);
			btnConfirm.setEnabled(false);
			btnConfirm.setVisible(false);
			btnCancel.setEnabled(false);
			btnCancel.setVisible(false);

			UIManager UI = new UIManager();
			UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Button.background", new java.awt.Color(0, 151, 178));
			
			JOptionPane.showMessageDialog(null, "Your profile has been edited successfully", "Saved Modification",
					JOptionPane.INFORMATION_MESSAGE);
			
			/*JOptionPane.showMessageDialog(null, "Your profile has been edited successfully");*/

		} else if (e.getSource().equals(btnCancel)) {
			textFieldUsername.setEditable(false);
			textFieldUsername.setEnabled(false);
			textFieldSurname.setEditable(false);
			textFieldSurname.setEnabled(false);
			textFieldEmail.setEditable(false);
			textFieldEmail.setEnabled(false);
			textFieldName.setEditable(false);
			textFieldName.setEnabled(false);
			textFieldAddress.setEditable(false);
			textFieldAddress.setEnabled(false);
			btnConfirm.setEnabled(false);
			btnConfirm.setVisible(false);
			btnCancel.setEnabled(false);
			btnCancel.setVisible(false);

			UIManager UI = new UIManager();
			UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Button.background", new java.awt.Color(0, 151, 178));
			
			JOptionPane.showMessageDialog(null, "Edition has been canceled", "Modification Canceled",
					JOptionPane.ERROR_MESSAGE);
			
			/*JOptionPane.showMessageDialog(null, "Edition has been canceled", "Modification Canceled",
					JOptionPane.ERROR_MESSAGE);*/
		}

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() instanceof JButton) {
				((JButton) e.getSource()).doClick();
				/*
				 * if(e.getSource() instanceof JCheckBox) { ((JCheckBox)
				 * e.getSource()).doClick();
				 * 
				 * }
				 */

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
