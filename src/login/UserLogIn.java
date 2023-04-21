package login;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserLogIn extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserLogIn() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicie sesion");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		lblNewLabel.setBounds(91, 78, 716, 169);
		add(lblNewLabel);
	}

}
