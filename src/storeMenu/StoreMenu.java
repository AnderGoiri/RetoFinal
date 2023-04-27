package storeMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class StoreMenu extends JDialog {
	
	private JPanel contentPanel;
	private JPanel menuPanel;
	
	private MemberMenu memberPanel;
	private CardLayout cardLayout;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StoreMenu dialog = new StoreMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StoreMenu() {
		setBounds(100, 100, 1900, 1000);
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 1900, 1000);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane (contentPanel);
		contentPanel.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 1860, 950);
		cardLayout = new CardLayout();
		menuPanel.setLayout (cardLayout);
		contentPanel.add(menuPanel);
		
		memberPanel = new MemberMenu();
		menuPanel.add( "Member", memberPanel);
		
		showMenu();
		
	}

	private void showMenu() {
		// TODO Auto-generated method stub
		cardLayout.show(menuPanel, "Member");
		
	}

}
