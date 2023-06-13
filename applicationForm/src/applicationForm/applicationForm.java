package applicationForm;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class applicationForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicationForm frame = new applicationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public applicationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 800, 800);
		setTitle("SKKU New Students Enrollment");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5,1));
		JPanel titlePanel = new JPanel(new GridLayout(1,3)); //panel for title text and picture
		
		String imagePath0 = "logo.png";
		ImageIcon picture0 = new ImageIcon(getClass().getResource(imagePath0));
		Image image0 = picture0.getImage();
		Image changeImage0 = image0.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture0 = new ImageIcon(changeImage0);
		JLabel imageLabel0 = new JLabel(changePicture0);
		
		JLabel title = new JLabel("SKKU Application Form"); //label for title text
		title.setForeground(new Color(64, 128, 128));
		title.setBackground(new Color(255, 255, 255));
		title.setFont(new Font("Segoe UI Black", Font.ITALIC, 29));
		title.setHorizontalAlignment(SwingConstants.LEFT);
		
		titlePanel.add(imageLabel0);
		titlePanel.add(title);
		
		contentPane.add(titlePanel); //adding title panel to total panel
		
		JPanel container1 = new JPanel(new GridLayout(1,3)); //panel for first container that includes basic informations
		
		JPanel labels1 = new JPanel(new GridLayout(5,1)); //panel for 5 label text
		
		JLabel name = new JLabel("Applicant Name:  ");
		name.setForeground(new Color(64, 128, 128));
		name.setBackground(new Color(255, 255, 255));
		name.setFont(new Font("굴림", Font.BOLD, 13));
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel birthDate = new JLabel("Birth Date:  ");
		birthDate.setForeground(new Color(64, 128, 128));
		birthDate.setHorizontalAlignment(SwingConstants.RIGHT);
		birthDate.setFont(new Font("굴림", Font.BOLD, 13));
		JLabel sex = new JLabel("Sex:  ");
		sex.setFont(new Font("굴림", Font.BOLD, 13));
		sex.setForeground(new Color(64, 128, 128));
		sex.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel email = new JLabel("Email:  ");
		email.setForeground(new Color(64, 128, 128));
		email.setHorizontalAlignment(SwingConstants.RIGHT);
		email.setFont(new Font("굴림", Font.BOLD, 13));
		JLabel phone = new JLabel("Phone Number:  ");
		phone.setForeground(new Color(64, 128, 128));
		phone.setFont(new Font("굴림", Font.BOLD, 13));
		phone.setHorizontalAlignment(SwingConstants.RIGHT);
		
		/*adding 5 label text to label container and first container*/
		labels1.add(name);
		labels1.add(birthDate);
		labels1.add(birthDate);
		labels1.add(sex);
		labels1.add(email);
		labels1.add(phone);
		
		container1.add(labels1);
		
		JPanel text1 = new JPanel(new GridLayout(5,1)); //panel for adding 5 text field
		JTextField nameText = new JTextField();
		JTextField birthDateText = new JTextField();
		JTextField sexText = new JTextField();
		JTextField emailText = new JTextField();
		JTextField phoneText = new JTextField();
		
		/*adding 5 text field to text container and first container*/
		text1.add(nameText);
		text1.add(birthDateText);
		text1.add(sexText);
		text1.add(emailText);
		text1.add(phoneText);
		
		container1.add(text1);
		
		String imagePath1 = "basicPicture.png"; //images in first container (meaning for basic information)
		ImageIcon picture1 = new ImageIcon(getClass().getResource(imagePath1));
		Image image1 = picture1.getImage();
		Image changeImage1 = image1.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture1 = new ImageIcon(changeImage1);
		JLabel imageLabel1 = new JLabel(changePicture1);
		
		container1.add(imageLabel1);
		
		contentPane.add(container1);
		
		JPanel container2 = new JPanel(new GridLayout(1,3));
		
		String imagePath2 = "graduatePicture.png"; //images in second container (meaning for graduated applicant's information)
		ImageIcon picture2 = new ImageIcon(getClass().getResource(imagePath2));
		Image image2 = picture2.getImage();
		Image changeImage2 = image2.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture2 = new ImageIcon(changeImage2);
		JLabel imageLabel2 = new JLabel(changePicture2);
		
		container2.add(imageLabel2);
		
		JPanel labels2 = new JPanel(new GridLayout(5,1)); //panel for adding 3 label text
		
		JLabel degree = new JLabel("Degree:  ");
		degree.setForeground(new Color(64, 128, 128));
		degree.setFont(new Font("굴림", Font.BOLD, 13));
		degree.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel eptyLabel1 = new JLabel();
		JLabel univ = new JLabel("Attended university(for Graduates):  ");
		univ.setForeground(new Color(64, 128, 128));
		univ.setHorizontalAlignment(SwingConstants.RIGHT);
		univ.setFont(new Font("굴림", Font.BOLD, 13));
		JLabel eptyLabel2 = new JLabel();
		JLabel gpa = new JLabel("GPA(for Graduates):  ");
		gpa.setForeground(new Color(64, 128, 128));
		gpa.setHorizontalAlignment(SwingConstants.RIGHT);
		gpa.setFont(new Font("굴림", Font.BOLD, 13));
		
		/*adding 3 label text to label container*/
		labels2.add(degree);
		labels2.add(eptyLabel1);
		labels2.add(univ);
		labels2.add(eptyLabel2);
		labels2.add(gpa);
		
		container2.add(labels2);
		
		JPanel text2 = new JPanel(new GridLayout(5,1));
		
		JTextField degreeText = new JTextField();
		JLabel eptyLabel3 = new JLabel();
		JTextField univText = new JTextField();
		JLabel eptyLabel4 = new JLabel();
		JTextField gpaText = new JTextField();
		
		/*adding 3 text field to text container*/
		text2.add(degreeText);
		text2.add(eptyLabel3);
		text2.add(univText);
		text2.add(eptyLabel4);
		text2.add(gpaText);
		
		container2.add(text2);
		
		contentPane.add(container2);//adding second container to total container
		
		JPanel container3 = new JPanel(new GridLayout(3,1));//creating third container
		
		JLabel personalMessage = new JLabel("Personal Statement");
		personalMessage.setForeground(new Color(64, 128, 128));
		personalMessage.setFont(new Font("굴림", Font.BOLD, 14));
		personalMessage.setHorizontalAlignment(SwingConstants.CENTER);
		container3.add(personalMessage);
		
		
		JTextField pmText = new JTextField();
		container3.add(pmText);

		JPanel addrContainer = new JPanel(new GridLayout(2,2)); //panel for address information
		JLabel eptyLbl1 = new JLabel();
		JLabel eptyLbl2 = new JLabel();
		JLabel addr =new JLabel("Home Address:  ");
		addr.setForeground(new Color(64, 128, 128));
		addr.setHorizontalAlignment(SwingConstants.RIGHT);
		addr.setFont(new Font("굴림", Font.BOLD, 13));
		JTextField addrText = new JTextField();
		
		addrContainer.add(eptyLbl1);
		addrContainer.add(eptyLbl2);
		addrContainer.add(addr); //adding address label
		addrContainer.add(addrText); //adding address text field
		container3.add(addrContainer); //adding address container to third container
		
		contentPane.add(container3); //adding third container to total panel
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,3)); //panel for button 
		JLabel emptyLabel1 = new JLabel();
		JLabel emptyLabel2 = new JLabel();
		
		JPanel smallButton = new JPanel(new GridLayout(3,1)); //panel for specific location of button
		JLabel emptyLabel3 = new JLabel();
		JLabel emptyLabel4 = new JLabel();
		JButton submit = new JButton("submit Application"); //creating button for submitting
		submit.setBackground(new Color(64, 128, 128));
		submit.setForeground(new Color(255, 255, 255));
		submit.setFont(new Font("굴림", Font.BOLD, 17));
		
		smallButton.add(emptyLabel3);
		smallButton.add(submit);
		smallButton.add(emptyLabel4);
		
		buttonPanel.add(emptyLabel1);
		buttonPanel.add(smallButton); //adding button to button panel
		buttonPanel.add(emptyLabel2);
		
		contentPane.add(buttonPanel);
		
		/*functions for events after pressing the submit button, */
		class ButtonHandler implements ActionListener {
			
			/*class for processing empty text exception*/
			class EmptyException extends Exception {
			    public EmptyException() {
			    }
			}

			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				int count = 0; //for storing the sequence of error message
				String resultErr = ""; //for storing the error message
				
				String nameMessage = nameText.getText(); //for storing the text of name text field
				try {
					if (nameMessage.isEmpty()) {
						throw new EmptyException(); //throwing the empty exception
					}
					
					String[] words = nameMessage.split(" "); // string array for word count
					
					/*condition whether name includes the first name and last name*/
					if (words.length < 2) { 
						count += 1;
						resultErr += String.format("%d. You forgot to write your name or surname.\n", count); //adding the name error message
					}
					
				} catch (EmptyException exception) {
					count += 1;
					resultErr += String.format("%d. You forgot to fill the name text field, Please fill it.\n", count); //adding the empty field error message
					
				} catch (Exception exception) {
					count += 1;
					resultErr += String.format("%d. You have to enter right format in name text field\n", count); //adding the wrong format error message
				}
				
				
				String birthMessage = birthDateText.getText();
				String birthPattern = "\\d{2}/\\d{2}/\\d{4}"; //formal expression for birth date
				try {
					if (birthMessage.isEmpty()) {
						throw new EmptyException();
					}
					/*condition whether the birth date text is same for the formal expression*/
					if (!birthMessage.matches(birthPattern)) { 
						count += 1;
					    resultErr += String.format("%d. Birth date must be in '06/06/1995' format.\n", count);
					}
					
				} catch (EmptyException exception){
					count += 1;
					resultErr += String.format("%d. You forgot to fill the birth date text field, Please fill it.\n", count);
				}
	
				
				String sexMessage = sexText.getText();
				try {
					if (sexMessage.isEmpty()) {
						throw new EmptyException();
					}
					
					/*condition whether the sex text is 'female' or 'male' */
					if (!((sexMessage.equals("male")) || (sexMessage.equals("female")))) {
						count += 1;
					    resultErr += String.format("%d. Sex format must be 'male' or 'female'\n", count);
					}
					
				} catch (EmptyException exception){
					count += 1;
					resultErr += String.format("%d. You forgot to fill the sex text field, Please fill it.\n", count);
				}
				
				String emailMessage = emailText.getText();
				try {
					if (emailMessage.isEmpty()) {
						throw new EmptyException();
					}
					
					/*condition whether the email message contains "@" and "."*/
					if (!emailMessage.contains("@") || !emailMessage.contains(".")) {
						count += 1;
					    resultErr += String.format("%d. Email must be in 'example@some.com'.\n", count);
					}
					
				} catch (EmptyException exception){
					count += 1;
					resultErr += String.format("%d. You forgot to fill the email text field, Please fill it.\n", count);
				}
				
				String phoneMessage = phoneText.getText();
				String phonePattern = "\\d{3}-\\d{4}-\\d{4}"; //formal expression for phone number
				try {
					if (phoneMessage.isEmpty()) {
						throw new EmptyException();
					}
					
					/*condition whether the phone message is the right formal expression*/
					if (!phoneMessage.matches(phonePattern)) {
						count += 1;
						resultErr += String.format("%d. Phone number format must be in '010-1111-0000'\n", count);
					}
					
				} catch (EmptyException exception) {
					count += 1;
					resultErr += String.format("%d. You forgot to fill the phone number text field, Please fill it.\n", count);
				}
				
				String degreeMessage = degreeText.getText();
				try {
					if (degreeMessage.isEmpty()) {
						throw new EmptyException();
					}
					
					/*condition whether the degree is phD or ms(ma)_*/
					if (degreeMessage.equals("PhD") || degreeMessage.equals("MS") || degreeMessage.equals("MA")) {
						
						/*condition whether the university text and the gpa text is filled*/
						if (univText.getText().isEmpty() || gpaText.getText().isEmpty()) {
							count += 1;
							resultErr += String.format("%d. For graduate, you have to enter previous university and GPA.\n", count);
						}
					}
					
					/*condition whether the degree is undergraduates*/
					else if (degreeMessage.equals("Banchelor")) {
						
						/*condition whether the university text and the gpa text is empty*/
						if (!(univText.getText().isEmpty()) || !(gpaText.getText().isEmpty())) {
							count += 1;
							resultErr += String.format("%d. For undergraduate you shouldn't enter previous university and GPA.\n", count);
						}
					}
					
					/*condition whether applicant enter wrong format text*/
					else { 
						count += 1;
						resultErr += String.format("%d. Degree format must be 'PhD' or 'MS(MA)' or 'Banchelor'\n", count);
					}
					
				} catch (EmptyException exception) {
					count += 1;
					resultErr += String.format("%d. You forgot to fill the degree text field, Please fill it.\n", count);
				}
				
				String gpaMessage = gpaText.getText();
				try {
					if (gpaMessage.isEmpty()) {
						throw new EmptyException();
					}
					Float gpaFloat = Float.parseFloat(gpaMessage); //bringing the only float number
					
					/*condition whether the gpa is less than 4.5, more than 0*/
					if (!(gpaFloat <= 4.5 && gpaFloat >= 0)) {
						count += 1;
						resultErr += String.format("%d. GPA must be between 0 and 4.5\n", count);
					}
					
				} catch (EmptyException exception) {
					count += 1;
					resultErr += String.format("%d. You forgot to fill the GPA text field, Please fill it.\n", count);
					
				}catch (Exception exception) { //exceptions for cases that gpa text not includes the float number
					count += 1;
					resultErr += String.format("%d. GPA must be float type.\n", count);
				}
				
				String pmMessage = pmText.getText();
				try {
					if (pmMessage.isEmpty()) {
						throw new EmptyException();
					}
					
					/*condition whether personal state message length is less than 100*/
					if (pmMessage.length() < 100) {
						count += 1;
						resultErr += String.format("%d. Your Personal Statement must be at least 100 letters.\n", count);
					}
					
				} catch (EmptyException exception){
					count += 1;
					resultErr += String.format("%d. You forgot to fill the personal state text field, Please fill it.\n", count);
				}
				
				String addrMessage = addrText.getText();
				try {
					if (addrMessage.isEmpty()) {
						throw new EmptyException();
					}
					int i = 0;
					String[] addrElements = addrMessage.split(","); // creating string array
					int startIndex = 0; // start index for splitting to ','
					int endIndex = addrMessage.indexOf(","); //index for ',' location
					String number = addrMessage.substring(startIndex, endIndex); //parsing before ','
					int numberInt = Integer.parseInt(number); //changing string type to integer type
					
					startIndex = endIndex + 1; //changing start index after ',' location
					endIndex = addrMessage.indexOf(",", startIndex); //changing end index next ',' location
					String street = addrMessage.substring(startIndex, endIndex);
					
					startIndex = endIndex + 1;
					endIndex = addrMessage.indexOf(",", startIndex);
					String district = addrMessage.substring(startIndex, endIndex);
					
					startIndex = endIndex + 1;
					String city = addrMessage.substring(startIndex);
			        
				} catch (EmptyException exception) {
					count += 1;
					resultErr += String.format("%d. You forgot to fill the home address text field, Please fill it.\n", count);
					
				} catch (Exception exception) {
					count += 1;
					//exceptions for wrong address format 
					resultErr += String.format("%d. Your address must be in 'number, street, district, city' format", count);
				} 
				
				
				if (count == 0) { //No exceptions, submit succeeded
					/*initialization all text field*/
				    nameText.setText("");
				    birthDateText.setText("");
				    sexText.setText("");
				    emailText.setText("");
				    phoneText.setText("");
				    degreeText.setText("");
				    univText.setText("");
				    gpaText.setText("");
				    pmText.setText("");
				    addrText.setText("");
				    
				    JOptionPane optionPane = new JOptionPane("Successfully Submitted."); //creating the success option panel
				    JDialog dialog = optionPane.createDialog("success Meesage");
				    dialog.setTitle("success Message"); //setting the success title
				    dialog.setVisible(true);				    
				}
				
				else if (count >= 1) { //exception generated, error popup created
					//showing the error message
					JOptionPane.showMessageDialog(null, resultErr, "You have following problems:", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		ButtonHandler handler = new ButtonHandler(); //creating action listener
		submit.addActionListener(handler);
		
	}
}
