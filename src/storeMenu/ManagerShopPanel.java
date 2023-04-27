package storeMenu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

public class ManagerShopPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField textFieldProductId;
	private JButton btnSearch;
	private JButton btnShow;
	private JScrollPane scrollPaneProductList;
	

	/**
	 * Create the panel.
	 */
	public ManagerShopPanel() {
		setLayout(null);
		setBounds(0, 0, 1860, 910);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblProductId.setBounds(160, 50, 193, 52);
		add(lblProductId);
		
		textFieldProductId = new JTextField();
		textFieldProductId.setBounds(360, 50, 1090, 52);
		add(textFieldProductId);
		textFieldProductId.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnSearch.setBounds(1460, 50, 270, 52);
		add(btnSearch);
		
		scrollPaneProductList = new JScrollPane();
		scrollPaneProductList.setBounds(120, 125, 1640, 695);
		add(scrollPaneProductList);
		
		btnShow = new JButton("Show");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnShow.setBounds(1460, 844, 270, 52);
		add(btnShow);
		btnShow.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
