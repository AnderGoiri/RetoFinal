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
import model.User;

public class ManagerAccountTab extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textaUsername;
	private JTextField textSurname;
	private JTextField textEmail;
	private JTextField textName;
	private JButton btnEditProfile;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JLabel lblSurname, lblName, lblUsername, lblEmail, lblNewFotoPerfil, lblFondo;

	/**
	 * @author Francisco Rafael de Ysasi González
	 * @param auxUser
	 */
	public ManagerAccountTab(User auxUser) {
		setLayout(null);
		setBounds(0, 0, 984, 718);

		// --- JLabels --- //

		lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblSurname.setBounds(290, 155, 148, 41);
		add(lblSurname);

		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblName.setBounds(290, 335, 148, 41);
		add(lblName);

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblUsername.setBounds(290, 65, 192, 41);
		add(lblUsername);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 35));
		lblEmail.setBounds(290, 245, 143, 52);
		add(lblEmail);

		lblNewFotoPerfil = new JLabel("");
		lblNewFotoPerfil.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/profile2.png")));
		lblNewFotoPerfil.setBounds(70, 57, 143, 150);
		add(lblNewFotoPerfil);
		lblNewFotoPerfil.setOpaque(false);

		// --- JTextField --- //

		textaUsername = new JTextField();
		textaUsername.setFont(new Font("Constantia", Font.PLAIN, 15));
		textaUsername.setBounds(466, 65, 457, 50);
		textaUsername.setEditable(false);
		textaUsername.setEnabled(false);
		add(textaUsername);
		textaUsername.setColumns(10);

		textSurname = new JTextField();
		textSurname.setFont(new Font("Constantia", Font.PLAIN, 15));
		textSurname.setColumns(10);
		textSurname.setBounds(466, 155, 457, 50);
		textSurname.setEditable(false);
		textSurname.setEnabled(false);
		add(textSurname);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Constantia", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(466, 245, 457, 50);
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		add(textEmail);

		textName = new JTextField();
		textName.setFont(new Font("Constantia", Font.PLAIN, 15));
		textName.setColumns(10);
		textName.setBounds(466, 335, 457, 50);
		textName.setEditable(false);
		textName.setEnabled(false);
		add(textName);

		// --- JButton --- //

		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBackground(new Color(0, 151, 178));
		btnEditProfile.setForeground(new Color(255, 255, 255));
		btnEditProfile.setFont(new Font("Onyx", Font.BOLD, 45));
		btnEditProfile.addActionListener(this);
		btnEditProfile.setBounds(33, 232, 215, 70);
		add(btnEditProfile);

		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(this);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Onyx", Font.BOLD, 45));
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		btnConfirm.setBackground(new Color(0, 151, 178));
		btnConfirm.setBounds(466, 425, 205, 65);
		add(btnConfirm);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Onyx", Font.BOLD, 45));
		btnCancel.setEnabled(false);
		btnCancel.setVisible(false);
		btnCancel.setBackground(new Color(0, 151, 178));
		btnCancel.setBounds(718, 426, 205, 65);
		add(btnCancel);

		// --- JLabel background --- //
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MemberAccountPanel.class.getResource("/media/descarga.jpg")));
		lblFondo.setBounds(0, 0, 984, 718);
		add(lblFondo);

		// --- Method that insert the data of the manager inside the JTextFields --- //
		getManagerData(auxUser);
	}

	private void getManagerData(User auxUser) {

		textaUsername.setText(auxUser.getUserName());
		textSurname.setText(auxUser.getSurname());
		textEmail.setText(auxUser.getMail());
		textName.setText(auxUser.getName());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnEditProfile)) {
			textaUsername.setEditable(true);
			textaUsername.setEnabled(true);
			textSurname.setEditable(true);
			textSurname.setEnabled(true);
			textEmail.setEditable(true);
			textEmail.setEnabled(true);
			textName.setEditable(true);
			textName.setEnabled(true);
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
			btnConfirm.setEnabled(false);
			btnConfirm.setVisible(false);
			btnCancel.setEnabled(false);
			btnCancel.setVisible(false);

			// call the factory

			// make the controllable method that modifies the data of the user

			// pop a message that shows the user that the modification has been completed
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
			btnConfirm.setEnabled(false);
			btnConfirm.setVisible(false);
			btnCancel.setEnabled(false);
			btnCancel.setVisible(false);

			JOptionPane.showMessageDialog(null, "Edition has been canceled", "Modification Canceled",
					JOptionPane.ERROR_MESSAGE);

		}

	}

}
