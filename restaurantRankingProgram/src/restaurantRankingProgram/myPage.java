package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import restaurantRankingProgram.signUpPage.ButtonHandler;


public class myPage extends JFrame{
	private JPanel contentPane;
	private JPanel firstRow;
	private JPanel secondRow;
	private JPanel thirdRow;
	private JTextArea inputID;
	private JTextArea inputNick;
	private JTextArea inputPW;
	private JTextArea freeInfo;
	private student user;
	private JTextArea inputRole;
	private JButton editBtn;
	private JButton logoutBtn;
	
	/*my page for checking the private information of users*/
	public myPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 800, 600);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("my Page");
		
		setContentPane(contentPane);
		
		user = programData.getInstance().getUserStudent();
		
		firstRow = new JPanel();
		secondRow = new JPanel();
		thirdRow = new JPanel();
		contentPane.setLayout(new GridLayout(3,1));
		firstRow.setLayout(new GridLayout(1,3));
		String imagePath = "/img/사람.png";
		ImageIcon picture = new ImageIcon(myPage.class.getResource(imagePath));
		Image image = picture.getImage();
		Image changeImage = image.getScaledInstance(200, 300, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture = new ImageIcon(changeImage);
		JLabel humanImage = new JLabel(changePicture);
		firstRow.add(humanImage);
		
		//creating the label and text area for the existing information of user
		JPanel infoLabel = new JPanel(new GridLayout(4,1));
		JLabel roleLabel = new JLabel("role");
		roleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roleLabel.setFont(new Font("굴림", Font.BOLD, 13));
		JLabel studentID = new JLabel("student ID:");
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setFont(new Font("굴림", Font.BOLD, 13));
		JLabel nickName = new JLabel("nick name:");
		nickName.setFont(new Font("굴림", Font.BOLD, 12));
		nickName.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel studentPW = new JLabel("student PW:");
		studentPW.setFont(new Font("굴림", Font.BOLD, 12));
		studentPW.setHorizontalAlignment(SwingConstants.CENTER);
		
		infoLabel.add(roleLabel);
		infoLabel.add(studentID);
		infoLabel.add(nickName);
		infoLabel.add(studentPW);
		firstRow.add(infoLabel);
		
		JPanel infoInput = new JPanel(new GridLayout(4,1));
		inputRole = new JTextArea();
		inputRole.setText(user.getRole());
		inputID = new JTextArea();
		inputID.setText(user.getStudentID());
		inputNick = new JTextArea();
		inputNick.setText(user.getNickName());
		inputPW = new JTextArea();
		inputPW.setText(user.getStudentPW());
		
		//prohibiting the edit functions
		inputRole.setEditable(false);
		inputID.setEditable(false);
		inputNick.setEditable(false);
		inputPW.setEditable(false);
		
		infoInput.add(inputRole);
		infoInput.add(inputID);
		infoInput.add(inputNick);
		infoInput.add(inputPW);
		firstRow.add(infoInput);
		
		contentPane.add(firstRow);
		
		secondRow.setLayout(new GridLayout(2,1));
		JLabel infoExplain = new JLabel("details");
		infoExplain.setFont(new Font("굴림", Font.BOLD, 15));
		freeInfo = new JTextArea();
		freeInfo.setText(user.getFreeInfo());
		freeInfo.setEditable(false);
		
		secondRow.add(infoExplain);
		secondRow.add(freeInfo);
		
		contentPane.add(secondRow);
		
		thirdRow.setLayout(new GridLayout(3,1));
		JPanel emptyPanel1 = new JPanel();
		JPanel emptyPanel2 = new JPanel();
		
		JPanel btnPanel = new JPanel(new GridLayout(1,3));
		JLabel emptyLabel1 = new JLabel("");
		JLabel emptyLabel2 = new JLabel("");
		editBtn = new JButton("EDIT"); //adding the edit button
		editBtn.setForeground(new Color(255, 0, 0));
		editBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
		
		ButtonHandler handler = new ButtonHandler();
		editBtn.addActionListener(handler);
		
		btnPanel.add(emptyLabel1);
		btnPanel.add(editBtn);
		btnPanel.add(emptyLabel2);
		
		thirdRow.add(emptyPanel1);
		thirdRow.add(btnPanel);
		thirdRow.add(emptyPanel2);
		contentPane.add(thirdRow);
	}
	
	class ButtonHandler implements ActionListener {
		private int flag = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == editBtn && flag == 0) { //pressed the edit button & previous status : prohibit edit
				editBtn.setText("COMPLETE"); //changing the button text to "complete"
				//Edit functionality changed to enable
				inputRole.setEditable(true);
				inputID.setEditable(true);
				inputNick.setEditable(true);
				inputPW.setEditable(true);
				freeInfo.setEditable(true);
				flag = 1; //changing the edit flag
	        }
			else if (e.getSource() == editBtn && flag == 1) {//pressed the edit button & previous status : enable to edit
				editBtn.setText("EDIT"); //changing the button text to "edit"
				//storing the changing information to the user data
				programData.getInstance().getUserStudent().setRole(inputRole.getText());
				programData.getInstance().getUserStudent().setStudentID(inputID.getText());
				programData.getInstance().getUserStudent().setNickName(inputNick.getText());
				programData.getInstance().getUserStudent().setStudentPW(inputPW.getText());
				programData.getInstance().getUserStudent().setFreeInfo(freeInfo.getText());
				
				//prohibits the edit function
				inputRole.setEditable(false);
				inputID.setEditable(false);
				inputNick.setEditable(false);
				inputPW.setEditable(false);
				freeInfo.setEditable(false);
				
				JOptionPane.showMessageDialog(null, "The modification has been completed.", "Notification", JOptionPane.INFORMATION_MESSAGE);
				flag = 0;
			}
		}
	}
}
