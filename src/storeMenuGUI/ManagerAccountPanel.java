package storeMenuGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ManagerAccountPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField textaUsername;
	private JTextField textSurname;
	private JTextField textEmail;
	private JTextField textName;
	private JTextField textAddress;
	private JButton btnEditProfile;
	private JButton btnConfirm;
	private JButton btnCancel;
	
	/**
	 * @author Francisco Rafael de Ysasi González
	 */
	public ManagerAccountPanel() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		
		// --- JLabels ---
		
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
			
			JLabel lblPurchase = new JLabel("Repairs");
			lblPurchase.setFont(new Font("Elephant", Font.BOLD, 35));
			lblPurchase.setBounds(51, 426, 417, 41);
			add(lblPurchase);
			
			JLabel lblNewFotoPerfil = new JLabel("");
			lblNewFotoPerfil.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/profile2.png")));
			lblNewFotoPerfil.setBounds(57, 47, 143, 150);
			add(lblNewFotoPerfil);
			lblNewFotoPerfil.setOpaque(false);
			
			
		
		
		// --- JSeparator ---
			
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(255, 255, 255));
			separator.setBounds(33, 390, 1482, 1);
			add(separator);
			
			
		// --- JTextField ---
			
			textaUsername = new JTextField();
			textaUsername.setBounds(442, 72, 457, 50);
			textaUsername.setEditable(false);
			textaUsername.setEnabled(false);
			add(textaUsername);
			textaUsername.setColumns(10);

			textSurname = new JTextField();
			textSurname.setColumns(10);
			textSurname.setBounds(442, 157, 457, 50);
			textSurname.setEditable(false);
			textSurname.setEnabled(false);
			add(textSurname);

			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(442, 243, 457, 50);
			textEmail.setEditable(false);
			textEmail.setEnabled(false);
			add(textEmail);

			textName = new JTextField();
			textName.setColumns(10);
			textName.setBounds(1055, 72, 457, 50);
			textName.setEditable(false);
			textName.setEnabled(false);
			add(textName);

			textAddress = new JTextField();
			textAddress.setColumns(10);
			textAddress.setBounds(1055, 157, 457, 50);
			textAddress.setEditable(false);
			textAddress.setEnabled(false);
			add(textAddress);
			
			
			
		// --- JButton ---
			
			btnEditProfile = new JButton("Edit Profile");
			btnEditProfile.setBackground(new Color(0, 151, 178));
			btnEditProfile.setForeground(new Color(255, 255, 255));
			btnEditProfile.setFont(new Font("Onyx", Font.BOLD, 45));
			btnEditProfile.addActionListener(this);
			btnEditProfile.setBounds(33, 232, 205, 65);
			add(btnEditProfile);
			
			btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(this);
			btnConfirm.setForeground(Color.WHITE);
			btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
			btnConfirm.setEnabled(false);
			btnConfirm.setVisible(false);
			btnConfirm.setBackground(new Color(0, 151, 178));
			btnConfirm.setBounds(1055, 232, 205, 65);
			add(btnConfirm);

			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(this);
			btnCancel.setForeground(Color.WHITE);
			btnCancel.setFont(new Font("Onyx", Font.BOLD, 45));
			btnCancel.setEnabled(false);
			btnCancel.setVisible(false);
			btnCancel.setBackground(new Color(0, 151, 178));
			btnCancel.setBounds(1310, 232, 205, 65);
			add(btnCancel);
			
			
		// --- JCalendar ---
			
			
			
			
		// -- JLabel background ---
			JLabel lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/descarga.jpg")));
			lblFondo.setBounds(0, 0, 1860, 910);
			add(lblFondo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnEditProfile)) {
			textaUsername.setEditable(true);
			textaUsername.setEnabled(true);
			textSurname.setEditable(true);
			textSurname.setEnabled(true);
			textEmail.setEditable(true);
			textEmail.setEnabled(true);
			textName.setEditable(true);
			textName.setEnabled(true);
			textAddress.setEditable(true);
			textAddress.setEnabled(true);
			btnConfirm.setEnabled(true);
			btnConfirm.setVisible(true);
			btnCancel.setEnabled(true);
			btnCancel.setVisible(true);

		} else if (e.getSource().equals(btnConfirm)) {
			textaUsername.setEditable(false);
			textaUsername.setEnabled(false);
			textSurname.setEditable(false);
			textSurname.setEnabled(false);
			textEmail.setEditable(false);
			textEmail.setEnabled(false);
			textName.setEditable(false);
			textName.setEnabled(false);
			textAddress.setEditable(false);
			textAddress.setEnabled(false);
			btnConfirm.setEnabled(false);
			btnConfirm.setVisible(false);
			btnCancel.setEnabled(false);
			btnCancel.setVisible(false);

			JOptionPane.showMessageDialog(null, "Your profile has been edited successfully");

		} else if (e.getSource().equals(btnCancel)) {
			textaUsername.setEditable(false);
			textaUsername.setEnabled(false);
			textSurname.setEditable(false);
			textSurname.setEnabled(false);
			textEmail.setEditable(false);
			textEmail.setEnabled(false);
			textName.setEditable(false);
			textName.setEnabled(false);
			textAddress.setEditable(false);
			textAddress.setEnabled(false);
			btnConfirm.setEnabled(false);
			btnConfirm.setVisible(false);
			btnCancel.setEnabled(false);
			btnCancel.setVisible(false);

			JOptionPane.showMessageDialog(null, "Edition has been canceled","Modification Canceled",JOptionPane.ERROR_MESSAGE);

		}
	}

}
