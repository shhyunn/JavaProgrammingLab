package restaurantRankingProgram;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.SwingConstants;

public class signUpPage  extends JFrame{
	private JPanel contentPane;
	private JPanel firstRow;
	private JPanel secondRow;
	private JPanel thirdRow;
	private JTextArea inputID;
	private JTextArea inputNick;
	private JTextArea inputPW;
	private JTextArea inputRePW;
	private JTextArea freeInfo;
	private JRadioButton studentBtn;
	private JRadioButton managerBtn;
	
	private JButton submitBtn;
	
	private JLabel studentID;
	private JLabel studentPW;
	private JLabel infoExplain;
	
	public signUpPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("sign up page");
		setContentPane(contentPane);
		
		firstRow = new JPanel();
		secondRow = new JPanel();
		thirdRow = new JPanel();
		contentPane.setLayout(new GridLayout(3,1));
		firstRow.setLayout(new GridLayout(1,3));
		String imagePath = "/img/사람.png";
		ImageIcon picture = new ImageIcon(signUpPage.class.getResource(imagePath));
		Image image = picture.getImage();
		Image changeImage = image.getScaledInstance(200, 300, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture = new ImageIcon(changeImage);
		JLabel humanImage = new JLabel(changePicture);
		firstRow.add(humanImage);
		
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JPanel infoLabel = new JPanel(new GridLayout(5,1));
		
		//adding the radio button for role of user
		studentBtn = new JRadioButton("student");
		managerBtn = new JRadioButton("manager");
		
		ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(studentBtn);
        buttonGroup.add(managerBtn);
        
        btnPanel.add(studentBtn);
        btnPanel.add(managerBtn);
        
		ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentBtn.isSelected()) {
                	//changing the id&pw to student text
                    studentID.setText("student ID");
                    studentPW.setText("student PW");
                    infoExplain.setText("explain about you(belong to, your best restaurant, farovite food...)");
                
                } else if (managerBtn.isSelected()) {
                	//changing the id&pw to manager text
                	studentID.setText("manager ID");
                    studentPW.setText("manager PW");
                    infoExplain.setText("introduce yourself about your career, advantages...");
                }
            }
        };

        studentBtn.addActionListener(listener);
        managerBtn.addActionListener(listener);
        
        //adding the label& text area for storing new information of new uwer
        JLabel roleLabel = new JLabel("role");
        roleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        roleLabel.setFont(new Font("굴림", Font.BOLD, 13));
		studentID = new JLabel("student ID");
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setFont(new Font("굴림", Font.BOLD, 13));
		JLabel nickName = new JLabel("nick name:");
		nickName.setFont(new Font("굴림", Font.BOLD, 12));
		nickName.setHorizontalAlignment(SwingConstants.CENTER);
		studentPW = new JLabel("student PW:");
		studentPW.setFont(new Font("굴림", Font.BOLD, 12));
		studentPW.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel checkPW = new JLabel("check PW:");
		checkPW.setHorizontalAlignment(SwingConstants.CENTER);
		checkPW.setFont(new Font("굴림", Font.BOLD, 12));
		
		infoLabel.add(roleLabel);
		infoLabel.add(studentID);
		infoLabel.add(nickName);
		infoLabel.add(studentPW);
		infoLabel.add(checkPW);
		firstRow.add(infoLabel);
		
		JPanel infoInput = new JPanel(new GridLayout(5,1));
		inputID = new JTextArea();
		inputNick = new JTextArea();
		inputPW = new JTextArea();
		inputRePW = new JTextArea();
		
		infoInput.add(btnPanel);
		infoInput.add(inputID);
		infoInput.add(inputNick);
		infoInput.add(inputPW);
		infoInput.add(inputRePW);
		firstRow.add(infoInput);
		
		contentPane.add(firstRow);
		
		secondRow.setLayout(new GridLayout(2,1));
		infoExplain = new JLabel("explain about you(belong to, your best restaurant, farovite food...)");
		infoExplain.setFont(new Font("굴림", Font.BOLD, 15));
		freeInfo = new JTextArea();
		
		secondRow.add(infoExplain);
		secondRow.add(freeInfo);
		
		contentPane.add(secondRow);
		
		thirdRow.setLayout(new GridLayout(3,1));
		JPanel emptyPanel1 = new JPanel();
		JPanel emptyPanel2 = new JPanel();
		
		JPanel btnPanel2 = new JPanel(new GridLayout(1,3));
		JLabel emptyLabel1 = new JLabel("");
		JLabel emptyLabel2 = new JLabel("");
		submitBtn = new JButton("SUBMIT"); //addint the submit button
		submitBtn.setForeground(new Color(255, 0, 0));
		submitBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
		
		ButtonHandler handler = new ButtonHandler();
		submitBtn.addActionListener(handler);
		
		btnPanel2.add(emptyLabel1);
		btnPanel2.add(submitBtn);
		btnPanel2.add(emptyLabel2);
		
		thirdRow.add(emptyPanel1);
		thirdRow.add(btnPanel2);
		thirdRow.add(emptyPanel2);
		
		contentPane.add(thirdRow);
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//creating the exception class 1
			class EmptyException extends Exception {
			    public EmptyException() {
			    }
			}
			
			//creating the exception class 2
			class NoCorrectException extends Exception {
			    public NoCorrectException() {
			    }
			}
			
			if (e.getSource() == submitBtn) { //cases for submit button
				String resultErr = ""; //for storing the result error message
				int count = 0; //for storing the error number
				int error = 0; //flag for generating the error
				student newStudent = new student(); //creating the new student object
				
				try {
					if (!studentBtn.isSelected() && !managerBtn.isSelected()) { //case for not selecting the role radio button
						throw new EmptyException();
						
					} else if (studentBtn.isSelected()){
						newStudent.setRole("student");
						
					} else if (managerBtn.isSelected()){
						newStudent.setRole("manager");
					}
					
				} catch (EmptyException exception){
					error = 1;
					count += 1;
					resultErr += String.format("%d. You forgot to check the radio button, Please check student or manager.\n", count);
				}
				
				String id = inputID.getText();
				try {
					if (id.isEmpty()) { //case for empty ID input text
						throw new EmptyException();
					}
					newStudent.setStudentID(id);
				}
				catch (EmptyException exception){
					error = 1;
					count += 1;
					resultErr += String.format("%d. You forgot to fill the id text field, Please fill it.\n", count);
					
				}
				
				String nickName = inputNick.getText();
				try {
					if (nickName.isEmpty()) {
						throw new EmptyException();
					}
					newStudent.setNickName(nickName);
				}
				catch (EmptyException exception) {
					error = 1;
					count += 1;
					resultErr += String.format("%d. You forgot to fill the nick name text field, Please fill it.\n", count);
				}
				
				String password = inputPW.getText(); //for storing the text of name text field
				String rePassword = inputRePW.getText();
				
				try {
					if (password.isEmpty() || rePassword.isEmpty()) { //case for either text is empty
						throw new EmptyException(); //throwing the empty exception
					}
					
					/*condition whether name includes the first name and last name*/
					if (password.length() < 4 || rePassword.length() < 4) {
						throw new Exception();
					}
					if (!password.equals(rePassword)) { //case for not matching the password 
						throw new NoCorrectException();
					}
					newStudent.setStudentPW(inputPW.getText());

					
				} catch (EmptyException exception) {
					error = 1;
					count += 1;
					resultErr += String.format("%d. You forgot to fill the password text field, Please fill it.\n", count); //adding the empty field error message
					
				} catch (NoCorrectException exception) {
					error = 1;
					count += 1;
					resultErr += String.format("%d. Password didn't correct the check password.\n", count); //adding the name error message
					
				} catch (Exception exception) {
					error = 1;
					count += 1;
					resultErr += String.format("%d. Password must be longer than 4.\n", count); //adding the name error message
					
				} 
				
				newStudent.setFreeInfo(freeInfo.getText());
				
				if (error == 0) { //case for not generating errors
					programData.getInstance().addStudent(newStudent); //adding the new student object
					
					inputID.setText("");
					inputNick.setText("");
					inputPW.setText("");
					inputRePW.setText("");
					freeInfo.setText("");
					
					JOptionPane.showMessageDialog(null, "You submitted finally.", "Notification", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, resultErr, "Error", JOptionPane.ERROR_MESSAGE); //showing the total error message
				}
				
	        }
		}
	}
}
