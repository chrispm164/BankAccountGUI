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

public class CreateAccPanel extends JPanel{
	
	public CreateAccPanel(ArrayList<BankAccount> a) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName,gbc);
		
		gbc.gridx = 1;
		JTextField txtName = new JTextField("");
		txtName.setPreferredSize(new Dimension(70,20));
		add(txtName,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblInitDeposit = new JLabel("Initial Deposit: ");
		add(lblInitDeposit, gbc);
		
		gbc.gridx = 1;
		JTextField txtInitDeposit = new JTextField("");
		txtInitDeposit.setPreferredSize(new Dimension(70,20));
		add(txtInitDeposit,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblAccType = new JLabel("Account Type: ");
		add(lblAccType, gbc);
		
		gbc.gridx = 1;
		String[] arr = {"Checking", "Savings"};
		JComboBox<String> scrOptions = new JComboBox<String>(arr);
		scrOptions.setPreferredSize(new Dimension(90,21));
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
				if (scrOptions.getSelectedItem() == null || scrOptions.getSelectedItem().toString().equals("Checking")) {
					a.add(new CheckingAccount(txtName.getText(), Integer.parseInt(txtInitDeposit.getText()), 15, 2, 30));
					JOptionPane.showMessageDialog(btnSubmit, "Checking Account Created.", "Created.", JOptionPane.PLAIN_MESSAGE);
				}
				else if (scrOptions.getSelectedItem().toString().equals("Savings")) {
					a.add(new SavingsAccount(txtName.getText(), Integer.parseInt(txtInitDeposit.getText()), 0.03, 300, 10));
					JOptionPane.showMessageDialog(btnSubmit, "Savings Account Created.", "Created.", JOptionPane.PLAIN_MESSAGE);
				}
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(btnSubmit, "Uh-oh. Something went wrong.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
	}

}