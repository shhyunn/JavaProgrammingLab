package bankProgram;

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
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class bankGUI extends JFrame {
	private ArrayList<BankAccount> bankAccounts;
	private int userIdx;
	private int otherIdx;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<BankAccount> bankAccounts = new ArrayList<>();
					bankGUI frame = new bankGUI(bankAccounts);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public bankGUI(ArrayList<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		//JPanel upPanel = new JPanel(new BorderLayout());

		JLabel lblNewLabel = new JLabel("WOORI BANK");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setPreferredSize(new Dimension(0,100));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel gridPanel = new JPanel(new GridLayout(2,3));
		JPanel buttonPanel = new JPanel(new GridLayout(4, 1)); // 4개의 버튼을 가진 패널
		// 버튼 컴포넌트 추가
		JButton option1 = new JButton("OPTION 1");
		option1.setFont(new Font("굴림", Font.BOLD, 11));
		option1.setPreferredSize(new Dimension(100,15));
		JButton option2 = new JButton("OPTION 2");
		option2.setFont(new Font("굴림", Font.BOLD, 11));
		option2.setPreferredSize(new Dimension(50, 15));
		JButton option3 = new JButton("OPTION 3");
		option3.setFont(new Font("굴림", Font.BOLD, 11));
		option3.setPreferredSize(new Dimension(100,15));
		JButton option4 = new JButton("OPTION 4");
		option4.setFont(new Font("굴림", Font.BOLD, 11));
		option4.setPreferredSize(new Dimension(100,15));
		
		buttonPanel.add(option1);
		buttonPanel.add(option2);
		buttonPanel.add(option3);
		buttonPanel.add(option4);
		contentPane.add(buttonPanel, BorderLayout.WEST);
		
		JTextArea field = new JTextArea("Please, insert your card and press ENTER...");
		field.setFont(new Font("Monospaced", Font.PLAIN, 11));
		field.setBackground(new Color(255, 255, 255));
		contentPane.add(field, BorderLayout.CENTER);
		
		JPanel languagePanel = new JPanel(new GridLayout(2, 1)); // 2개의 언어 버튼을 가진 패널
		// 언어 버튼 컴포넌트 추가
		JButton button = new JButton("KOREAN");
		button.setFont(new Font("Arial Black", Font.PLAIN, 11));
		languagePanel.add(button);
		JButton button_1 = new JButton("ENGLISH");
		button_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		languagePanel.add(button_1);
		contentPane.add(languagePanel, BorderLayout.EAST);
		
		/*
		 * 명륜이 율전이 사진 넣고 성균관대학교 라벨 추가하기
		 */
		
		JPanel downPanel = new JPanel(new GridLayout(1,3));
		JPanel picturePanel = new JPanel(new GridLayout(2,1));
		
		String imagePath = "/src/resources/명륜율전사진.png";
		ImageIcon picture = new ImageIcon(imagePath);
		Image image = picture.getImage();
		Image changeImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon changePicture = new ImageIcon(changeImage);
		JLabel imageLabel = new JLabel(changePicture);
		imageLabel.setFont(new Font("Bell MT", Font.PLAIN, 15));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel textPanel = new JPanel(new GridLayout(3,1));
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
		
		JPanel numberPanel = new JPanel (new GridLayout(4,3));
		JButton num1 = new JButton("1");
		num1.setForeground(new Color(0, 0, 160));
		num1.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num2 = new JButton("2");
		num2.setFont(new Font("Arial Black", Font.BOLD, 20));
		num2.setForeground(new Color(0, 0, 160));
		JButton num3 = new JButton("3");
		num3.setForeground(new Color(0, 0, 160));
		num3.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num4 = new JButton("4");
		num4.setForeground(new Color(0, 0, 160));
		num4.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num5 = new JButton("5");
		num5.setForeground(new Color(0, 0, 160));
		num5.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num6 = new JButton("6");
		num6.setForeground(new Color(0, 0, 160));
		num6.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num7 = new JButton("7");
		num7.setForeground(new Color(0, 0, 160));
		num7.setFont(new Font("Arial Black", Font.BOLD, 20));
		JButton num8 = new JButton("8");
		num8.setFont(new Font("Arial Black", Font.BOLD, 20));
		num8.setForeground(new Color(0, 0, 160));
		JButton num9 = new JButton("9");
		num9.setForeground(new Color(0, 0, 160));
		num9.setFont(new Font("Arial Black", Font.BOLD, 20));
		JLabel empty1 = new JLabel("");
		JButton num0 = new JButton("0");
		num0.setForeground(new Color(0, 0, 160));
		num0.setFont(new Font("Arial Black", Font.BOLD, 20));
		JLabel empty2 = new JLabel("");
		
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
		
		JPanel enterPanel = new JPanel(new GridLayout(3,1));
		JButton cancel = new JButton("CANCEL");
		cancel.setForeground(new Color(255, 0, 0));
		cancel.setFont(new Font("Arial Black", Font.BOLD, 15));
		JButton clear = new JButton("CLEAR");
		clear.setForeground(new Color(241, 213, 14));
		clear.setFont(new Font("Arial Black", Font.BOLD, 15));
		JButton enter = new JButton("ENTER");
		enter.setForeground(new Color(64, 128, 128));
		enter.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		enterPanel.add(cancel);
		enterPanel.add(clear);
		enterPanel.add(enter);
		
		downPanel.add(enterPanel);
		downPanel.setPreferredSize(new Dimension(0, 250));
		contentPane.add(downPanel, BorderLayout.SOUTH);
		
		/*
		ButtonHandler handler = new ButtonHandler();
		
		option1.addActionListener(handler);
		option2.addActionListener(handler);
		option3.addActionListener(handler);
		option4.addActionListener(handler);
		cancel.addActionListener(handler);
		clear.addActionListener(handler);
		enter.addActionListener(handler);
		*/
		
		ActionListener numberListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = e.getActionCommand();
				field.setText(field.getText() + input);
			}
		};
		
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
		
		
		
		class ButtonHandler implements ActionListener {
			private int flag = 0;
			private String message;
			//TODO flag 사용 다시 코드 수정
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == option1) {
					flag = 6; //pin 화면으로
					message = String.format("User: %s\nBalance: %.2f\nPlease ENTER...", bankAccounts.get(userIdx).getUser().getName(), bankAccounts.get(userIdx).getBalance());
					field.setText(message); //그 다음 pin 화면으로 넘어가기
					
				} else if (e.getSource() == option2) {
					flag = 2; //옵션 2번 화면으로
					message = "Enter Withdrawal Amount: ";
					field.setText(message); //숫자 눌러서 enter 화면으로 넘어가기	
					
				} else if (e.getSource() == option3) {
					flag = 3; //옵션 3번 화면으로
					message = "Enter Deposit Amount: ";
					field.setText(message); //숫자 눌러서 enter 화면으로 넘어가기
					
				} else if (e.getSource() == option4) {
					flag = 4; //옵션 4번 화면으로
					message = "Enter Amount Number(Receiver): ";
					field.setText(message); //숫자 눌러서 enter 화면으로 넘어가기
					
				} else if (e.getSource() == cancel) {
					flag = 6;
					message = "Process is canceled by user!\nPlease press ENTER..."; //중간에 처음 화면으로 넘어가기
					field.setText(message);
					
				} else if (e.getSource() == clear) {
					String clearText = field.getText();
					clearText = clearText.substring(0, clearText.length() - 1); //하나씩 지우기
					field.setText(clearText);
					
				} else if (e.getSource() == enter) {
					String text = field.getText();
					if (flag == 0) {
						message = "PIN: ";
						field.setText(message);
						flag = 1;
						
					} else if (flag == 1) {
						String pinStr = text.replaceAll("[^\\d]", "");
						int findPin;
						int pin = Integer.parseInt(pinStr);
						flag = 1;
						message = "Wrong pin! Try Again:\nPIN:";
						for (findPin = 0; findPin < bankAccounts.size(); findPin++) {
							if (bankAccounts.get(findPin).getPinCode() == pin) {
								userIdx = findPin;
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
						String withdrawStr = text.replaceAll("[^\\d]", "");
						double withdrawMoney = Double.parseDouble(withdrawStr);
						if (withdrawMoney <= bankAccounts.get(userIdx).getBalance()) {
							bankAccounts.get(userIdx).setBalance(bankAccounts.get(userIdx).getBalance() - withdrawMoney);
							message = String.format("Success:)\nUser: %s\nWithdrawal Amount: %.2f\n"
									+ "Current Balance: %.2f\nPress ENTER...", bankAccounts.get(userIdx).getUser().getName(),withdrawMoney, bankAccounts.get(userIdx).getBalance());
						} else {
							message = "Not enough money!\nPress ENTER...";
						}
						field.setText(message);
						
					} else if (flag == 3) {
						flag = 6;
						String depositStr = text.replaceAll("[^\\d]","");
						double depositMoney = Double.parseDouble(depositStr);
						bankAccounts.get(userIdx).setBalance(bankAccounts.get(userIdx).getBalance()+depositMoney);
						message = String.format("Success:) \nUser: %s\nDeposit Amount: %.2f\n"
								+ "Current Balance: %.2f\nPress ENTER...", bankAccounts.get(userIdx).getUser().getName(),depositMoney,bankAccounts.get(userIdx).getBalance());
						field.setText(message);
						
					} else if (flag == 4) {
					    int findAccount;
					    String accountStr = text.replaceAll("[^\\d]","");
					    long account = Long.parseLong(accountStr);
					    String longChangeStr = Long.toString(account);
					    message = "You entered the wrong account number! \nPress ENTER...";
				        flag = 6;
					    for (findAccount = 0; findAccount < bankAccounts.size(); findAccount++) {
					        if (bankAccounts.get(findAccount).getBankNumber().equals(longChangeStr)) {
					            otherIdx = findAccount;
					            message = String.format("Transfer Account: %s\nEnter Transfer Amount: ",bankAccounts.get(otherIdx).getUser().getName());
					            flag = 5;
					        }
					    }
					    field.setText(message);
					} else if (flag == 5) {
						flag = 6;
						String transferStr = text.replaceAll("[^\\d]","");
						double transferMoney = Double.parseDouble(transferStr);
						if (transferMoney <= bankAccounts.get(userIdx).getBalance()) {
							bankAccounts.get(userIdx).setBalance(bankAccounts.get(userIdx).getBalance()-transferMoney);
							bankAccounts.get(otherIdx).setBalance(bankAccounts.get(otherIdx).getBalance()+transferMoney);
							message = String.format("Transfer Amount: %.2f\nCurrent Balance: %.2f\nPress ENTER...",transferMoney,bankAccounts.get(userIdx).getBalance());
									
						} else {
							message = String.format("Not enough money!\nPress ENTER...");
						}
						field.setText(message);
						
					} else if (flag == 6) {
						flag = 0;
						message = "Thank you for banking with us!\npress ENTER...";
						field.setText(message);
					}
				}//else if enter end
			}//activation 끝
		}//class 끝
		
		ButtonHandler handler = new ButtonHandler();
		
		option1.addActionListener(handler);
		option2.addActionListener(handler);
		option3.addActionListener(handler);
		option4.addActionListener(handler);
		cancel.addActionListener(handler);
		clear.addActionListener(handler);
		enter.addActionListener(handler);
		
	}
}
