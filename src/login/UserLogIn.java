package login;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;

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





	