package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class mainGUI extends JFrame {
	private static mainGUI frame;
	private JPanel contentPane;
	private JButton loginBtn;
	private JButton signUpBtn;
	private static programData data;
	private JTextArea inputID;
	private JTextArea inputPW;
	private int version;
	private JLabel studentID;
	private JLabel studentPW;
	private JRadioButton studentButton;
	private JRadioButton managerButton;
	
	public static void main(String[] args) {
		data = programData.getInstance(); //for storing total program data
		/*adding the object of students for example*/
		data.addStudent(new student("2021310932", "SoSo","1234","student"));
		data.addStudent(new student("2020202020", "sungg","2345","student"));
		data.addStudent(new student("2222222222","kyunn","1111","student"));
		
		/*adding the object of restaurants for example*/
		restaurant res1 = new restaurant("소친친(sochinchin)","10000~20000",700);
		res1.setImagePath("/img/sochinchin.png");
		res1.setOnStore("11:30~22:00 (break sunday)");
		res1.addMenu(new menu("sochinchin","myeon","9000"));
		res1.addMenu(new menu("sochinchin","rice","8000"));
		res1.addMenu(new menu("sochinchin","soup","7500"));
		data.addRestaurant(res1);
		
		restaurant res2 = new restaurant("포보(pobo)","7000~12000",300);
		res2.setImagePath("/img/pobo.png");
		res2.setOnStore("10:00~21:00");
		res2.addMenu(new menu("pobo","myeon","9000"));
		res2.addMenu(new menu("pobo","rice","8000"));
		res2.addMenu(new menu("pobo","soup","7500"));
		data.addRestaurant(res2);
		
		restaurant res3 = new restaurant("기꾸스시(kiggu-sushi)","10000~25000",400);
		res3.setImagePath("/img/kiggu.png");
		res3.setOnStore("11:30~22:00");
		res3.addMenu(new menu("kiggu","mini sushi","12000"));
		res3.addMenu(new menu("kiggu","group sushi","14000"));
		res3.addMenu(new menu("kiggu","special sushi","20000"));
		data.addRestaurant(res3);
		
		
		restaurant res4 = new restaurant("깔리(kalli)","8000~25000",600);
		res4.setImagePath("/img/kalli.png");
		res4.setOnStore("11:30~21:00 (break monday)");
		res4.addMenu(new menu("kalli","tanduri chicken","10000"));
		res4.addMenu(new menu("kalli","chicken curry","8000"));
		res4.addMenu(new menu("kalli","nan & curry","9000"));
		data.addRestaurant(res4);
		
		restaurant res5 = new restaurant("홍순두부(Hong-sundubu)","6000~10000",400);
		res5.setImagePath("/img/hongsundubu.png");
		res5.setOnStore("10:00~20:00 (break sunday)");
		res5.addMenu(new menu("hongsundubu","meat sundubu","6000"));
		res5.addMenu(new menu("hongsundubu","seashell sundubu","6000"));
		res5.addMenu(new menu("hongsundubu","dumpling sundubu","6000"));
		data.addRestaurant(res5);
		
		restaurant res6 = new restaurant("정돈(Jung-don)","8000~25000",600);
		res6.setImagePath("/img/jungdon.png");
		res6.setOnStore("11:30~21:30");
		res6.addMenu(new menu("jungdon","tenderloin pork cutlet","15000"));
		res6.addMenu(new menu("jungdon","sirloin pork cutlet","14000"));
		res6.addMenu(new menu("jungdon","shrimp cutlet","4000"));
		data.addRestaurant(res6);
		
		restaurant res7 = new restaurant("정통집(Traditional-house)","25000~35000",800);
		res7.setImagePath("/img/traditionalhouse.png");
		res7.setOnStore("15:00~23:00");
		res7.addMenu(new menu("traditionalHouse","Grilled Pork-kimchi(small)","25000"));
		res7.addMenu(new menu("traditionalHouse","Grilled Pork-kimchi(medium)","30000"));
		res7.addMenu(new menu("traditionalHouse","Grilled Pork-kimchi(large)","35000"));
		data.addRestaurant(res7);
		
		restaurant res8 = new restaurant("나누미떡볶이(Nanumi-tteokbokki)","5000~",300);
		res8.setImagePath("/img/nanumitteokbokki.png");
		res8.setOnStore("00:00~24:00");
		res8.addMenu(new menu("nanumitteokbokki","ddeokbokki","5000"));
		data.addRestaurant(res8);
		
		/*start parts of program running*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new mainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainGUI() {
		/*initializing the initial information of first login page*/
		setTitle("SungKyun's PICK");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("SungKyun's PICK");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 40));
		title.setForeground(new Color(64, 128, 128));
		
		contentPane.add(title, BorderLayout.NORTH);//adding first row panel to total panel
		
		/*addint the basic image of the program*/
		String imagePath = "/img/spoon.png";
		ImageIcon picture = new ImageIcon(mainGUI.class.getResource(imagePath));
		Image image = picture.getImage();
		Image changeImage = image.getScaledInstance(450, 450, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture = new ImageIcon(changeImage);
		JLabel spoonImage = new JLabel(changePicture);
		
		contentPane.add(spoonImage, BorderLayout.CENTER);
		
		JPanel padding = new JPanel(new GridLayout(3,1));
		JPanel info = new JPanel(new GridLayout(1,4));
		
		JPanel firstCol = new JPanel(new GridLayout(2,1));
		
		//radio buttons for selecting the role, student or manager
        studentButton = new JRadioButton("student");
        managerButton = new JRadioButton("manager");
        
        //Group the student and manager radio buttons so that only one is selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(studentButton);
        buttonGroup.add(managerButton);
        
        
        JPanel btnPanel = new JPanel(new GridLayout(1,4));
        btnPanel.add(studentButton);
        btnPanel.add(managerButton);
        btnPanel.add(new JLabel(""));
        btnPanel.add(new JLabel(""));
        
        padding.add(btnPanel);
        
        //adding the id&pw label and id*pw input text
		studentID = new JLabel("student ID");
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setForeground(new Color(0, 0, 0));
		studentID.setFont(new Font("굴림", Font.BOLD, 15));
		studentPW = new JLabel("student PW");
		studentPW.setHorizontalAlignment(SwingConstants.CENTER);
		studentPW.setFont(new Font("굴림", Font.BOLD, 15));
		
		firstCol.add(studentID);
		firstCol.add(studentPW);
		
		info.add(firstCol);
		
		/*function for handling the button events*/
		ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//for cases of being selected the student/manager button
                if (studentButton.isSelected()) {
                	//changing the id&pw label to student label
                    studentID.setText("student ID");
                    studentPW.setText("student PW");
                    
                } else if (managerButton.isSelected()) {
                	//changing the id&pw label to manager label
                	studentID.setText("manager ID");
                    studentPW.setText("manager PW");
                }
            }
        };
        
        //adding the event listener
        studentButton.addActionListener(listener);
        managerButton.addActionListener(listener);
        
		JPanel secondCol = new JPanel(new GridLayout(2,1));
		
		inputID = new JTextArea();
		inputPW = new JTextArea();
		
		secondCol.add(inputID);
		secondCol.add(inputPW);
		
		info.add(secondCol);
		
		//adding the login button
		loginBtn = new JButton("log in");
		loginBtn.setBackground(new Color(64, 128, 128));
		loginBtn.setIcon(null);
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		
		info.add(loginBtn);
		
		//adding the signUp button
		signUpBtn = new JButton("sign up");
		signUpBtn.setBackground(new Color(255, 255, 0));
		signUpBtn.setForeground(new Color(0, 0, 0));
		signUpBtn.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		
		info.add(signUpBtn);
		
		JLabel blank = new JLabel("");
		
		padding.add(info);
		padding.add(blank);
		
		contentPane.add(padding, BorderLayout.SOUTH);
		
		ButtonHandler handler = new ButtonHandler(); //creating action listener
		loginBtn.addActionListener(handler);
		signUpBtn.addActionListener(handler);
		
	}
	
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == loginBtn) {//for selecting the login button
				int correctFlag = 0; //for storing the flag of correct information
				
				if (!studentButton.isSelected() && !managerButton.isSelected()) {//If neither radio button is selected
					JOptionPane.showMessageDialog(null, "You select the radio button, student or manager.",
	                    "error", JOptionPane.ERROR_MESSAGE);
					inputID.setText("");
					inputPW.setText("");
					
	            } else {
	            	/*iteration for finding the correct information*/
	            	for (student student : data.getInstance().getStudentList()) {
						if ((""+inputID.getText()).equals(student.getStudentID())) {
							correctFlag = 1;
							if ((""+inputPW.getText()).equals(student.getStudentPW())) { //cases for successing the correct information
								data.setUserStudent(student);
								mainPage mainPage = new mainPage();
								mainPage.setVisible(true);
								frame.setVisible(false);
								
							}
							else { //cases for right id & wrong pw
								JOptionPane.showMessageDialog(null, "You input the wrong password.", "error", JOptionPane.ERROR_MESSAGE);
								inputID.setText("");
								inputPW.setText("");
								correctFlag = 1;
							}
						}
					}
					if (correctFlag == 0) { //cases for wrong id & pw
						JOptionPane.showMessageDialog(null, "There is not correct information.", "error", JOptionPane.ERROR_MESSAGE);
						inputID.setText("");
						inputPW.setText("");
					}   
	            }
			}
			
			else if (e.getSource() == signUpBtn) { //for selecting the sign up button
				signUpPage signUpPage = new signUpPage();
				signUpPage.setVisible(true);
			}
		}
	}
}
