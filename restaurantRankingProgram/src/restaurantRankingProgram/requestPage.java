package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class requestPage extends JFrame{
	private JPanel contentPane;
	private JPanel infoPane;
	private JPanel mainPane;
	private JTextArea summaryText;
	private JTextArea contentText;
	private JButton sendBtn;
	
	/*request page for asking the manager about editing the restaurant information*/
	public requestPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 800, 600);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("request Page");
		
		infoPane = new JPanel(new GridLayout(4,1));
		JLabel title = new JLabel("Request Page");
		title.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		JLabel explain = new JLabel("Request about editing restaurant information!");
		explain.setFont(new Font("굴림", Font.BOLD, 17));
		JLabel eptyLabel1 = new JLabel();
		JLabel eptyLabel2 = new JLabel();
		
		infoPane.add(title);
		infoPane.add(eptyLabel1);
		infoPane.add(explain);
		infoPane.add(eptyLabel2);
		
		contentPane.add(infoPane, BorderLayout.NORTH);
		
		mainPane = new JPanel(new GridLayout(3,1));
		JPanel firstRow = new JPanel(new GridLayout(2,1));
		JPanel secondRow = new JPanel(new GridLayout(2,1));
		JPanel thirdRow = new JPanel(new GridLayout(3,1));
		
		//adding the label and text for summary in short sentence
		JLabel requestTitle = new JLabel("Summary");
		requestTitle.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));
		summaryText = new JTextArea();
		firstRow.add(requestTitle);
		firstRow.add(summaryText);
		
		//adding the label and text for full contents
		JLabel contentTitle = new JLabel("Contents");
		contentTitle.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));
		contentText = new JTextArea();
		secondRow.add(contentTitle);
		secondRow.add(contentText);
		
		JLabel emptyButton1 = new JLabel();
		JLabel emptyButton2 = new JLabel();
		
		JPanel buttonPane = new JPanel(new GridLayout(1,3));
		JLabel epty1 = new JLabel();
		sendBtn = new JButton("SEND"); //adding the button for storing the request contents
		sendBtn.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
		sendBtn.setBackground(new Color(64, 128, 128));
		sendBtn.setForeground(new Color(255, 255, 255));
		JLabel epty2 = new JLabel();
		
		buttonPane.add(epty1);
		buttonPane.add(sendBtn);
		buttonPane.add(epty2);
		
		thirdRow.add(emptyButton1);
		thirdRow.add(buttonPane);
		thirdRow.add(emptyButton2);
		
		ButtonHandler handler = new ButtonHandler();
		sendBtn.addActionListener(handler);
		mainPane.add(firstRow);
		mainPane.add(secondRow);
		mainPane.add(thirdRow);
		
		contentPane.add(mainPane, BorderLayout.CENTER);
		
		setContentPane(contentPane);
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sendBtn) {
				writeText();
				summaryText.setText("");
				contentText.setText("");
				JOptionPane.showMessageDialog(null, "Your submission is complete.", "Notification", JOptionPane.INFORMATION_MESSAGE);
	        }
		}
	}
	
	public void writeText() {
		try {	
			String summaryValue = summaryText.getText();
            String contentValue = contentText.getText();
            //changing the string format of summary & content text
            String write = String.format("summary : %s \n contents: %s\n", summaryValue, contentValue);
            
            //creating the new request file 
            File file = new File("request.txt");
            FileWriter fileWriter;
            if (file.exists()) {
                fileWriter = new FileWriter(file, true); //overwriting the existing file 
                
            } else {
                fileWriter = new FileWriter(file); //creating the new file
            }

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter writer = new PrintWriter(bufferedWriter);

            writer.println(write);
            writer.close();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
