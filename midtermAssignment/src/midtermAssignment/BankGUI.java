package midtermAssignment;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class BankGUI extends JFrame {
	private ArrayList<BankAccount> bankAccounts; //for storing user's bank account information
	private int userIdx; //for storing user's index of array list
	private int otherIdx; //for storing receiver(other)'s index of array list
	private JPanel contentPane;
	
	public BankGUI(ArrayList<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JLabel nameLabel = new JLabel(""); //setting the bank name 'woori bank'
		nameLabel.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/woori.png")));
		nameLabel.setForeground(new Color(0, 0, 153));
		nameLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 27));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setPreferredSize(new Dimension(0,100));
		contentPane.add(nameLabel, BorderLayout.NORTH); //adding the name label at the contentPane

		JPanel gridPanel = new JPanel(new GridLayout(2,3)); //for storing name label, option button panel, text field, two language button
		JPanel buttonPanel = new JPanel(new GridLayout(4, 1)); //panel for 4 option button panel
		
		JButton option1 = new JButton("OPTION 1"); //button named 'option1'
		option1.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/arr.png")));
		option1.setBackground(new Color(255, 255, 255));
		option1.setFont(new Font("굴림", Font.BOLD, 9));
		option1.setPreferredSize(new Dimension(100,15));
		JButton option2 = new JButton("OPTION 2"); //button named 'option2'
		option2.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/arr.png")));
		option2.setBackground(new Color(255, 255, 255));
		option2.setFont(new Font("굴림", Font.BOLD, 9));
		option2.setPreferredSize(new Dimension(50, 15));
		JButton option3 = new JButton("OPTION 3"); //button named 'option3'
		option3.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/arr.png")));
		option3.setBackground(new Color(255, 255, 255));
		option3.setFont(new Font("굴림", Font.BOLD, 9));
		option3.setPreferredSize(new Dimension(100,15));
		JButton option4 = new JButton("OPTION 4"); //button named 'option4'
		option4.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/arr.png")));
		option4.setBackground(new Color(255, 255, 255));
		option4.setFont(new Font("굴림", Font.BOLD, 9));
		option4.setPreferredSize(new Dimension(100,15));
		
		//adding option1-4 buttons at button panel
		buttonPanel.add(option1);
		buttonPanel.add(option2);
		buttonPanel.add(option3);
		buttonPanel.add(option4);
		contentPane.add(buttonPanel, BorderLayout.WEST); //adding button panel at contentPane
		
		JTextArea field = new JTextArea("Please, insert your card and press ENTER..."); //initializing first text in text field
		field.setFont(new Font("Monospaced", Font.PLAIN, 10));
		field.setBackground(new Color(255, 255, 255));
		contentPane.add(field, BorderLayout.CENTER);
		
		JPanel languagePanel = new JPanel(new GridLayout(2, 1)); // language panel for two language button
		
		JButton button = new JButton("KOREAN"); //Korean button
		button.setBackground(new Color(255, 255, 255));
		button.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/kor.png")));
		button.setFont(new Font("Arial Black", Font.PLAIN, 11));
		languagePanel.add(button);
		
		JButton button_1 = new JButton("ENGLISH"); //English button
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/eng.png")));
		button_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
		languagePanel.add(button_1);
		contentPane.add(languagePanel, BorderLayout.EAST);
		
		JPanel downPanel = new JPanel(new GridLayout(1,3)); //for setting SKKU images, number button, three buttons(cancel, clear, enter)
		JPanel picturePanel = new JPanel(new GridLayout(2,1));//panel for skku images and text
		
		ImageIcon picture = new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/명륜율전사진.png"));
		Image image = picture.getImage();
		Image changeImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture = new ImageIcon(changeImage);
		JLabel imageLabel = new JLabel(changePicture);
		
		JPanel textPanel = new JPanel(new GridLayout(3,1)); //skku text of three lines
		JLabel subLabel1 = new JLabel("SUNGKYUNKWAN");
		subLabel1.setForeground(new Color(36, 81, 68));
		subLabel1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		subLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel subLabel2 = new JLabel("UNIVERSITY");
		subLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		subLabel2.setForeground(new Color(36, 81, 68));
		subLabel2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		JLabel subLabel3 = new JLabel("1398");
		subLabel3.setForeground(new Color(0, 0, 0));
		subLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		subLabel3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
		
		textPanel.add(subLabel1);
		textPanel.add(subLabel2);
		textPanel.add(subLabel3);
		
		picturePanel.add(imageLabel, BorderLayout.CENTER);
		picturePanel.add(textPanel);
		downPanel.add(picturePanel);
		
		JPanel numberPanel = new JPanel (new GridLayout(4,3)); //panel for 9 number buttons 
		JButton num1 = new JButton("");
		num1.setActionCommand("1");
		num1.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/1.png")));
		num1.setBackground(new Color(255, 255, 255));
		num1.setForeground(new Color(0, 0, 160));
		num1.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num2 = new JButton("");
		num2.setActionCommand("2");
		num2.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/2.png")));
		num2.setBackground(new Color(255, 255, 255));
		num2.setFont(new Font("Arial Black", Font.BOLD, 20));
		num2.setForeground(new Color(0, 0, 160));
		JButton num3 = new JButton("");
		num3.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/3.png")));
		num3.setActionCommand("3");
		num3.setBackground(new Color(255, 255, 255));
		num3.setForeground(new Color(0, 0, 160));
		num3.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num4 = new JButton("");
		num4.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/4.png")));
		num4.setActionCommand("4");
		num4.setBackground(new Color(255, 255, 255));
		num4.setForeground(new Color(0, 0, 160));
		num4.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num5 = new JButton("");
		num5.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/5.png")));
		num5.setActionCommand("5");
		num5.setBackground(new Color(255, 255, 255));
		num5.setForeground(new Color(0, 0, 160));
		num5.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num6 = new JButton("");
		num6.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/6.png")));
		num6.setActionCommand("6");
		num6.setBackground(new Color(255, 255, 255));
		num6.setForeground(new Color(0, 0, 160));
		num6.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num7 = new JButton("");
		num7.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/7.png")));
		num7.setActionCommand("7");
		num7.setBackground(new Color(255, 255, 255));
		num7.setForeground(new Color(0, 0, 160));
		num7.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num8 = new JButton("");
		num8.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/8.png")));
		num8.setActionCommand("8");
		num8.setBackground(new Color(255, 255, 255));
		num8.setFont(new Font("Arial Black", Font.BOLD, 20));
		num8.setForeground(new Color(0, 0, 160));
		JButton num9 = new JButton("");
		num9.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/9.png")));
		num9.setActionCommand("9");
		num9.setBackground(new Color(255, 255, 255));
		num9.setForeground(new Color(0, 0, 160));
		num9.setFont(new Font("Arial Black", Font.BOLD, 20));
		JLabel empty1 = new JLabel("");//define empty button
		JButton num0 = new JButton("");
		num0.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/0.png")));
		num0.setActionCommand("0");
		num0.setBackground(new Color(255, 255, 255));
		num0.setForeground(new Color(0, 0, 160));
		num0.setFont(new Font("Arial Black", Font.BOLD, 20));
		JLabel empty2 = new JLabel("");
		
		//adding number button to number panel
		numberPanel.add(num1);
		numberPanel.add(num2);
		numberPanel.add(num3);
		numberPanel.add(num4);
		numberPanel.add(num5);
		numberPanel.add(num6);
		numberPanel.add(num7);
		numberPanel.add(num8);
		numberPanel.add(num9);
		numberPanel.add(empty1);
		numberPanel.add(num0);
		numberPanel.add(empty2);
		
		downPanel.add(numberPanel);
		
		JPanel enterPanel = new JPanel(new GridLayout(3,1)); //panel for 3 button (cancel, clear, enter)
		JButton cancel = new JButton("CANCEL");
		cancel.setBackground(new Color(255, 255, 255));
		cancel.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/cancel.png")));
		cancel.setForeground(new Color(255, 0, 0));
		cancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		JButton clear = new JButton("CLEAR");
		clear.setBackground(new Color(255, 255, 255));
		clear.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/clear.png")));
		clear.setForeground(new Color(241, 213, 14));
		clear.setFont(new Font("Arial Black", Font.BOLD, 15));
		JButton enter = new JButton("ENTER");
		enter.setBackground(new Color(255, 255, 255));
		enter.setIcon(new ImageIcon(BankGUI.class.getResource("/midtermAssignment/icons/enter.png")));
		enter.setForeground(new Color(64, 128, 128));
		enter.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		enterPanel.add(cancel);
		enterPanel.add(clear);
		enterPanel.add(enter);
		
		downPanel.add(enterPanel);
		downPanel.setPreferredSize(new Dimension(0, 250));
		contentPane.add(downPanel, BorderLayout.SOUTH);
		
		
		ActionListener numberListener = new ActionListener() {
			/*function for processing events of number button*/
			public void actionPerformed(ActionEvent e) {
				String input = e.getActionCommand();
				field.setText(field.getText() + input); //adding the number text of button at text field
			}
		};
		
		//adding action listener at number button
		num1.addActionListener(numberListener);
		num2.addActionListener(numberListener);
		num3.addActionListener(numberListener);
		num4.addActionListener(numberListener);
		num5.addActionListener(numberListener);
		num6.addActionListener(numberListener);
		num7.addActionListener(numberListener);
		num8.addActionListener(numberListener);
		num9.addActionListener(numberListener);
		num0.addActionListener(numberListener);
		
		//action listener of Other buttons except for number buttons
		class ButtonHandler implements ActionListener {
			private int flag = 0; //for storing status of enter button
			private String message; //for storing text message of text field
	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == option1) { 
					flag = 6; //changing to end message after enter button
					message = String.format("User: %s\nBalance: %.2f\nPlease ENTER...", bankAccounts.get(userIdx).getUser().getName(), bankAccounts.get(userIdx).getBalance());
					field.setText(message);
					
				} else if (e.getSource() == option2) {
					flag = 2; //changing to withdrawing message and screen after enter button
					message = "Enter Withdrawal Amount: ";
					field.setText(message);	
					
				} else if (e.getSource() == option3) {
					flag = 3; //changing to deposit message and screen after enter button
					message = "Enter Deposit Amount: ";
					field.setText(message);
					
				} else if (e.getSource() == option4) {
					flag = 4; //changing to transfer message and screen after enter button
					message = "Enter Amount Number(Receiver): ";
					field.setText(message); 
					
				} else if (e.getSource() == cancel) {
					flag = 6; //changing to end message after enter button
					message = "Process is canceled by user!\nPlease press ENTER...";
					field.setText(message);
					
				} else if (e.getSource() == clear) {
					String clearText = field.getText(); //bringing field text
					clearText = clearText.substring(0, clearText.length() - 1); //removing 1 character from the end
					field.setText(clearText);
					
				} else if (e.getSource() == enter) {
					String text = field.getText(); //bringing field text
					
					/*condition the status of flag*/
					if (flag == 0) { //flag for pin
						message = "PIN: ";
						field.setText(message);
						flag = 1; //changing to pin check message and screen after enter button
						
					} else if (flag == 1) { //flag for welcome message
						String pinStr = text.replaceAll("[^\\d]", ""); //changing to "" except for integer
						int findPin; //for iterating index of array list
						int pin = Integer.parseInt(pinStr); //bringing integer and storing to variable
						flag = 1; //maintaining the flag
						
						message = "Wrong pin! Try Again:\nPIN:"; //setting wrong message first
						
						/*iteration for finding the user information of pin*/
						for (findPin = 0; findPin < bankAccounts.size(); findPin++) {
							
							/*condition whether the pin corrects the pin of user in bank array list*/
							if (bankAccounts.get(findPin).getPinCode() == pin) {
								userIdx = findPin; //storing the matching index
								message = String.format(
										"Welcome %s\nPlease choose options:\n"
										+ "OPTION 1: Balance Checking \n"
										+ "OPTION 2: Withdrawing money\n"
										+ "OPTION 3: Deposit \nOPTION 4: Transfer",bankAccounts.get(userIdx).getUser().getName());
							}	
						}
						field.setText(message);	
						
					} else if (flag == 2) {
						flag = 6;
						String withdrawStr = text.replaceAll("[^\\d]", ""); //changing to "" except for integer
						
						double withdrawMoney = Double.parseDouble(withdrawStr); //bringing the double number(withdrawing money)
						/*condition whether withdrawing money is smaller then balance*/
						if (withdrawMoney <= bankAccounts.get(userIdx).getBalance()) {
							bankAccounts.get(userIdx).setBalance(bankAccounts.get(userIdx).getBalance() - withdrawMoney);//setting the balance to the modifying balance
							message = String.format("Success:)\nUser: %s\nWithdrawal Amount: %.2f\n"
									+ "Current Balance: %.2f\nPress ENTER...", bankAccounts.get(userIdx).getUser().getName(),withdrawMoney, bankAccounts.get(userIdx).getBalance());
						} else {
							message = "Not enough money!\nPress ENTER...";
						}
						field.setText(message);
						
					} else if (flag == 3) {
						flag = 6;
						String depositStr = text.replaceAll("[^\\d]",""); //changing to "" except for integer
						double depositMoney = Double.parseDouble(depositStr);//bringing the double number(deposit money)
						bankAccounts.get(userIdx).setBalance(bankAccounts.get(userIdx).getBalance()+depositMoney); //setting the balance to the modifying balance
						message = String.format("Success:) \nUser: %s\nDeposit Amount: %.2f\n"
								+ "Current Balance: %.2f\nPress ENTER...", bankAccounts.get(userIdx).getUser().getName(),depositMoney,bankAccounts.get(userIdx).getBalance());
						field.setText(message);
						
					} else if (flag == 4) {
					    int findAccount; //for storing the index in iteration
					    String accountStr = text.replaceAll("[^\\d]",""); //changing to "" except for integer
					    long account = Long.parseLong(accountStr); //bringing the long number(receiver's account)
					    String longChangeStr = Long.toString(account);//changing account to string format
					    message = "You entered the wrong account number! \nPress ENTER...";
				        flag = 6; //storing flag '6' first
				        
				        /*iteration for finding the receiver using the receiver's account*/
					    for (findAccount = 0; findAccount < bankAccounts.size(); findAccount++) {
					    	/*condition whether the account is same for customer's account of bank array list*/
					        if (bankAccounts.get(findAccount).getBankNumber().equals(longChangeStr)) {
					            otherIdx = findAccount;//storing the matching index 
					            message = String.format("Transfer Account: %s\nEnter Transfer Amount: ",bankAccounts.get(otherIdx).getUser().getName());
					            flag = 5;//flag for transfer messages
					        }
					    }
					    field.setText(message);
					    
					} else if (flag == 5) {
						flag = 6;
						String transferStr = text.replaceAll("[^\\d]","");
						double transferMoney = Double.parseDouble(transferStr); //changing to "" except for integer
						
						/*condition whether the transferred money is smaller than balance*/
						if (transferMoney <= bankAccounts.get(userIdx).getBalance()) {
							bankAccounts.get(userIdx).setBalance(bankAccounts.get(userIdx).getBalance()-transferMoney); //setting the balance of user
							bankAccounts.get(otherIdx).setBalance(bankAccounts.get(otherIdx).getBalance()+transferMoney); //setting the balance of receiver
							message = String.format("Transfer Amount: %.2f\nCurrent Balance: %.2f\nPress ENTER...",transferMoney,bankAccounts.get(userIdx).getBalance());
									
						} else {
							message = String.format("Not enough money!\nPress ENTER...");
						}
						field.setText(message);
						
					} else if (flag == 6) {
						flag = 0; //flag for pin
						message = "Thank you for banking with us!\npress ENTER...";
						field.setText(message);
					}
				}
			}
		}
		
		ButtonHandler handler = new ButtonHandler(); //creating action listener
		
		//adding the action listener at other buttons except for number buttons
		option1.addActionListener(handler);
		option2.addActionListener(handler);
		option3.addActionListener(handler);
		option4.addActionListener(handler);
		cancel.addActionListener(handler);
		clear.addActionListener(handler);
		enter.addActionListener(handler);
	}
}
