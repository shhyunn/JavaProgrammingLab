import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FiboGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea screen; //for storing the fibonacci series
	private static FiboGUI frame;
	private JProgressBar percentage; //for storing the percentage bar
	private JLabel sumNum; //for storing the total num
	private JButton getSum; //for storing the sum button
	private JTextField input; //for storing the user's input
	private int rowTotal; //for storing the user's row number
	private JButton cancel; //for storing the cancel button
	private boolean isCancel; //for storing the status of cancel button
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiboGUI frame = new FiboGUI();
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
	public FiboGUI() {
		this.isCancel = false;
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout()); //setting total layout to border layout 
		JPanel firstRow = new JPanel(new FlowLayout()); //panel for first row components
		JLabel info = new JLabel("Number of row in Fibonacci:"); //storing label named "number of row"
		info.setFont(new Font("굴림", Font.BOLD, 10));
		input = new JTextField(); //storing for user's input
		input.setColumns(5);
		getSum = new JButton("Get Sum of Fibonacci series"); //storing button for function 'sum'
		getSum.setFont(new Font("굴림", Font.BOLD, 12));
		getSum.setBackground(new Color(243, 227, 27));
		cancel = new JButton("Cancel"); //storing button for function 'cancel'
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setFont(new Font("굴림", Font.BOLD, 12));
		cancel.setBackground(new Color(255, 0, 0));
		
		/*adding 4 components to first row panel*/
		firstRow.add(info);
		firstRow.add(input);
		firstRow.add(getSum);
		firstRow.add(cancel);
		
		contentPane.add(firstRow, BorderLayout.NORTH);//adding first row panel to total panel
		
		screen = new JTextArea(); //text field for indicating fibonacci series
        screen.setEditable(false); // setting for not editing
        
        JScrollPane scrollPane = new JScrollPane(screen,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel thirdRow = new JPanel(new GridLayout(1,2)); //panel for third row components
		percentage = new JProgressBar(); //indicating process percent of fibonacci calculation
		percentage.setValue(0);
		percentage.setStringPainted(true);
		
		sumNum = new JLabel(""); //storing for total sum of fibonacci series
		
		/*adding 2 components to third row panel*/
		thirdRow.add(percentage);
		thirdRow.add(sumNum);
		
		contentPane.add(thirdRow, BorderLayout.SOUTH); //adding third row panel to total panel
		
		
		ButtonHandler handler = new ButtonHandler(); //creating action listener
		getSum.addActionListener(handler);
		cancel.addActionListener(handler);
	}
	
	/*class for action listener after the button performed*/
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*condition whether the event source is*/
			if (e.getSource() == getSum) {
				isCancel = false; //initializing the cancel button is off
				
				/*getting the input text and initializing the initial status of components*/
				String getInput = input.getText();
				screen.setText("");
				percentage.setValue(0);
				sumNum.setText("");
				
				/*condition whether the input text is integer type*/
				if (getInput.matches("\\d+")) {
					rowTotal = Integer.parseInt(getInput);
					Fibo worker = new Fibo(rowTotal, frame); //creating multi-threads
					worker.execute();//executing the thread
					
				} else {
					input.setText(""); //deleting the wrong input text
					JOptionPane.showMessageDialog(null, "Enter valid input!", "Warning", JOptionPane.ERROR_MESSAGE); //showing the error message
				}
				
			} else if (e.getSource() == cancel){
				isCancel = true; //changing the cancel button is on
			}
		}
	}
	
	/*function for updating the screen with fibonacci number*/
	public void setScreen(int sum) {
		screen.setText(screen.getText() + sum + "\n");
	}
	
	/*function for updating the percent gage with fibonacci sequence*/
	public void setPercentage(int sequence) {
		int gage = (int)(((double)(sequence+1) / this.rowTotal) * 100); //calculating the percent gage using the sequence and row number
		gage = Math.min(gage, 100);
	    percentage.setValue(gage); //setting the percentage value with gage
	}
	
	/*function for printing the total sum*/
	public void setSum(long totalSum) {
		sumNum.setText("Sum: " + totalSum);
		
	}
	
	/*function for informing the cancel button on/off*/
	public boolean isCanceled() {
		return isCancel;
	}
	
	/*function for setting the button enablement*/
	public void setCancelBtn(boolean enableFlag) {
		cancel.setEnabled(enableFlag);
	}
	
	/*function for creating files and writing the fibonacci series*/
	public void writeText() {
		try {
			FileOutputStream fileObject = new FileOutputStream("data.txt", true);
			PrintWriter x = new PrintWriter(fileObject);
			String screenValue = screen.getText();
			String[] valueList = screenValue.split("\n");
	        
	        List<String> stringList = new ArrayList<>(Arrays.asList(valueList));
	
			x.println(stringList);
			x.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
