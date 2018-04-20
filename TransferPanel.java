import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransferPanel extends JPanel{
	
	public TransferPanel(ArrayList<BankAccount> a) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblFromAccNum = new JLabel("Account Number Transferring from: ");
		add(lblFromAccNum,gbc);
		
		gbc.gridx = 1;
		JTextField txtFromAccNum = new JTextField("");
		txtFromAccNum.setPreferredSize(new Dimension(70,20));
		add(txtFromAccNum,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblToAccNum = new JLabel("Account Number Transferring to: ");
		add(lblToAccNum,gbc);
		
		gbc.gridx = 1;
		JTextField txtToAccNum = new JTextField("");
		txtToAccNum.setPreferredSize(new Dimension(70,20));
		add(txtToAccNum,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblDepAmt = new JLabel("Amount: ");
		add(lblDepAmt,gbc);
		
		gbc.gridx = 1;
		JTextField txtDepAmt = new JTextField("");
		txtDepAmt.setPreferredSize(new Dimension(70,20));
		add(txtDepAmt,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		JButton btnSubmit = new JButton("Enter");
		btnSubmit.setPreferredSize(new Dimension(70,20));
		add(btnSubmit, gbc);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				try {
					Main.findBankAccount(a, Integer.parseInt(txtFromAccNum.getText())).transfer(Main.findBankAccount(a, Integer.parseInt(txtToAccNum.getText())), Integer.parseInt(txtDepAmt.getText()));
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(btnSubmit, "Uh-oh. Something went wrong.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(btnSubmit, "Uh-oh. An account with that number was not found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
}
