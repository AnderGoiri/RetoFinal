package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import logicTier.ProductMemberControllable;
import logicTier.ProductMemberFactory;
import model.User;
import javax.swing.JButton;
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
	private DefaultTableModel tableModel;
	private User user;
	private String userN;

	/**
	 * Create the panel.
	 */
	public MemberAccountPanel(User user) {
		setLayout(null);
		setBounds(0, 0, 984, 718);
		this.user = user;
		/**
		 * Creation of a series of in which the user can see their data and can modify
		 * it if necessary.
		 */
		JLabel lblSurmane = new JLabel("Surname:");
		lblSurmane.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblSurmane.setBounds(290, 155, 148, 41);
		add(lblSurmane);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblName.setBounds(290, 335, 148, 41);
		add(lblName);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblUsername.setBounds(290, 65, 192, 41);
		add(lblUsername);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblEmail.setBounds(290, 245, 143, 52);
		add(lblEmail);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblAddress.setBounds(290, 425, 148, 41);
		add(lblAddress);

		/**
		 * Add a button to edit the jTextField so that the user can modify his data.
		 */
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBackground(new Color(0, 151, 178));
		btnEditProfile.setForeground(new Color(255, 255, 255));
		btnEditProfile.setFont(new Font("Onyx", Font.BOLD, 45));
		btnEditProfile.addActionListener(this);
		btnEditProfile.setBounds(33, 232, 215, 70);
		add(btnEditProfile);
		btnEditProfile.addKeyListener(this);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUsername.setBounds(466, 57, 457, 50);
		textFieldUsername.setEditable(false);
		textFieldUsername.setEnabled(false);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		textFieldUsername.addKeyListener(this);
		textFieldUsername.setForeground(Color.black);
		textFieldUsername.setDisabledTextColor(Color.black);

		textFieldSurname = new JTextField();
		textFieldSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(466, 155, 457, 50);
		textFieldSurname.setEditable(false);
		textFieldSurname.setEnabled(false);
		add(textFieldSurname);
		textFieldSurname.addKeyListener(this);
		textFieldSurname.setForeground(Color.black);
		textFieldSurname.setDisabledTextColor(Color.black);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		textFieldName.setBounds(466, 335, 457, 50);
		textFieldName.setEditable(false);
		textFieldName.setEnabled(false);
		add(textFieldName);
		textFieldName.addKeyListener(this);
		textFieldName.setForeground(Color.black);
		textFieldName.setDisabledTextColor(Color.black);

		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(466, 425, 457, 50);
		textFieldAddress.setEditable(false);
		textFieldAddress.setEnabled(false);
		add(textFieldAddress);
		textFieldAddress.addKeyListener(this);
		textFieldAddress.setForeground(Color.black);
		textFieldAddress.setDisabledTextColor(Color.black);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(466, 245, 457, 50);
		textFieldEmail.setEditable(false);
		textFieldEmail.setEnabled(false);
		add(textFieldEmail);
		textFieldEmail.addKeyListener(this);
		textFieldEmail.setForeground(Color.black);
		textFieldEmail.setDisabledTextColor(Color.black);

		/**
		 * Add a button to be able to save the changes that have been made in the
		 * JTextField.
		 */
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(this);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(716, 514, 205, 65);
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
		btnCancel.setBounds(466, 514, 205, 65);
		add(btnCancel);
		btnCancel.addKeyListener(this);

		tableModel = new DefaultTableModel();
		String[] productTableHeaders = { "Product ID", "Quantity", "Total Cost", "Date", "Status" };
		tableModel.setColumnIdentifiers(productTableHeaders);
		tableModel = addProducts(tableModel);

		JLabel lblNewFotoPerfil = new JLabel("");
		lblNewFotoPerfil.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/profile2.png")));
		lblNewFotoPerfil.setBounds(70, 57, 143, 150);
		add(lblNewFotoPerfil);
		lblNewFotoPerfil.setOpaque(false);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/descarga.jpg")));
		lblFondo.setBounds(0, 0, 984, 718);
		add(lblFondo);

		setMemberData(user);
	}

	private void setMemberData(User user) {
		textFieldUsername.setText(user.getUserName());
		textFieldSurname.setText(user.getSurname());
		textFieldName.setText(user.getName());
		textFieldAddress.setText(((model.Member) user).getAddress());
		textFieldEmail.setText(user.getMail());
		userN = textFieldUsername.getText();
	}

	public void modifyMember(User user, String UserName, String Surname, String Name, String Address, String Mail) {

		User modifiedMember = user;
		modifiedMember.setUserName(UserName);
		modifiedMember.setName(Name);
		modifiedMember.setSurname(Surname);
		modifiedMember.setMail(Mail);
		((model.Member) modifiedMember).setAddress(Address);

		try {
			ProductMemberControllable pMember = ProductMemberFactory.getProductMember();
			pMember.modifyMember((model.Member) modifiedMember, userN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private DefaultTableModel addProducts(DefaultTableModel tableModel2) {
		// TODO Auto-generated method stub
		/**
		 * Set<Product> products = controlador.metodoListarProductos();
		 * Iterator<Product> itProd = products.iterator();
		 **/
		Object[] row;

		// while(itProd.hasNext()){
		row = new Object[5];
		row[0] = "";
		row[1] = "";
		row[2] = "";
		row[3] = "";
		row[4] = "";
		;
		// Product product = itProd.next();
		// row[0]=product.get();
		// row[1]=product.get();
		// row[2]=product.get();
		// row[3]=product.get();
		// row[4]=product.get();
		// row[5]=product.get();

		tableModel.addRow(row);
		// }
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

			modifyMember(user, textFieldUsername.getText(), textFieldSurname.getText(), textFieldName.getText(),
					textFieldAddress.getText(), textFieldEmail.getText());

			JOptionPane.showConfirmDialog(null, "Do you want to modify the data?", "Saved Modification",
					JOptionPane.INFORMATION_MESSAGE);

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

			UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Button.background", new java.awt.Color(0, 151, 178));

			JOptionPane.showMessageDialog(null, "Edition has been canceled", "Modification Canceled",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() instanceof JButton) {
				((JButton) e.getSource()).doClick();
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
