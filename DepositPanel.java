import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DepositPanel extends JPanel{
	
	public DepositPanel(ArrayList<BankAccount> a) {
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
		JLabel lblAmt = new JLabel("Amount: ");
		add(lblAmt,gbc);
		
		gbc.gridx = 1;
		JTextField txtAmt = new JTextField("");
		txtAmt.setPreferredSize(new Dimension(70,20));
		add(txtAmt,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblAccType = new JLabel("Deposit/Withdrawal: ");
		add(lblAccType, gbc);
		
		gbc.gridx = 1;
		String[] options = {"Deposit", "Withdrawal"};
		JComboBox<String> scrOptions = new JComboBox<String>(options);
		add(scrOptions, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		JButton btnSubmit = new JButton("Enter");
		btnSubmit.setPreferredSize(new Dimension(70,20));
		add(btnSubmit, gbc);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				try {
					if (scrOptions.getSelectedItem() == null || scrOptions.getSelectedItem().toString().equals("Deposit")) {
						Main.findBankAccount(a, Integer.parseInt(txtAccNum.getText())).deposit(Integer.parseInt(txtAmt.getText()));
						JOptionPane.showMessageDialog(btnSubmit, "Checking Account Created.", "Created.", JOptionPane.PLAIN_MESSAGE);
					}
					else if (scrOptions.getSelectedItem().toString().equals("Withdrawal")) {
						Main.findBankAccount(a, Integer.parseInt(txtAccNum.getText())).withdraw(Integer.parseInt(txtAmt.getText()));
						JOptionPane.showMessageDialog(btnSubmit, "Savings Account Created.", "Created.", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(btnSubmit, "Uh-oh. Something went wrong.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(btnSubmit, "Uh-oh. An account with that number was not found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
}
