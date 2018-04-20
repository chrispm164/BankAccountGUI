import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetBalancePanel extends JPanel{
	
	public GetBalancePanel(ArrayList<BankAccount> a) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblAccNum = new JLabel("Account Number: ");
		add(lblAccNum,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		JTextField txtAccNum = new JTextField("");
		txtAccNum.setPreferredSize(new Dimension(70,20));
		add(txtAccNum,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		JButton btnSubmit = new JButton("Enter");
		btnSubmit.setPreferredSize(new Dimension(70,20));
		add(btnSubmit, gbc);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.findBankAccount(a, Integer.parseInt(txtAccNum.getText())).getBalance();
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(btnSubmit, "Uh-oh. Something went wrong.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(btnSubmit, "Uh-oh. An account with that number was not found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
}
