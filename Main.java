import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	public ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public Main() {
		JFrame frame = new JFrame("Bank Account");
		
		JMenuBar menuBar = new JMenuBar();
		JMenu mainMenu = new JMenu("Main Menu");
		
		JMenuItem main = new JMenuItem("Main Menu");
		mainMenu.add(main);
		
		JMenu accountsMenu = new JMenu("Accounts");
		
		JMenuItem createAcc = new JMenuItem("Create an Account");
		accountsMenu.add(createAcc);
		
		JMenuItem removeAcc = new JMenuItem("Remove an Account");
		accountsMenu.add(removeAcc);
		
		JMenuItem findAcc = new JMenuItem("Find an Account");
		accountsMenu.add(findAcc);
		
		JMenu transactions = new JMenu("Transactions");
		
		JMenuItem depositWithdrawal = new JMenuItem("Deposit/Withdrawal");
		transactions.add(depositWithdrawal);
		
		JMenuItem transfer = new JMenuItem("Transfer");
		transactions.add(transfer);
		
		JMenuItem getBalance = new JMenuItem("Find Balance");
		transactions.add(getBalance);

		CardLayout cards = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cards);
		overall.add(new MainPanel(), "Main Panel");
		overall.add(new CreateAccPanel(accounts), "Create Acc Panel");
		overall.add(new RemoveAccPanel(accounts), "Remove Acc Panel");
		overall.add(new GetAccPanel(accounts), "Find Acc Panel");
		overall.add(new DepositPanel(accounts), "Deposit/Withdrawal Panel");
		overall.add(new TransferPanel(accounts), "Transfer Panel");
		overall.add(new GetBalancePanel(accounts), "Get Balance Panel");
		cards.show(overall, "Main Panel");
		
		menuBar.add(mainMenu);
		menuBar.add(accountsMenu);
		menuBar.add(transactions);
		frame.setJMenuBar(menuBar);
		frame.setBounds(400, 100, 400, 400);
		frame.setVisible(true);
		frame.add(overall);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(overall, "Main Panel");
			}
		});
		removeAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(overall, "Remove Acc Panel");
			}
		});
		createAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(overall, "Create Acc Panel");
			}
		});
		findAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(overall, "Find Acc Panel");
			}
		});
		depositWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(overall, "Deposit/Withdrawal Panel");
			}
		});
		transfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(overall, "Transfer Panel");
			}
		});
		getBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(overall, "Get Balance Panel");
			}
		});
	}
	
	public static BankAccount findBankAccount(ArrayList<BankAccount> acc, int accNum) {
		for(BankAccount a : acc) {
			if(a.getAccountNumber() == accNum) {
				return a;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
