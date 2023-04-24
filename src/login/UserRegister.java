package login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class UserRegister extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public UserRegister() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrese");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		lblNewLabel.setBounds(91, 78, 716, 169);
		add(lblNewLabel);

	}

}
