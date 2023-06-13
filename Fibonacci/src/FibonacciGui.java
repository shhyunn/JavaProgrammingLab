import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class FibonacciGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea screen;
	private static FibonacciGui frame;
	private int fibonacciSum;
	private JProgressBar percentage;
	private List<Fibonacci> fibonacciThread;
	private JLabel sumNum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FibonacciGui();
					frame.setVisible(true);
					frame.setTitle("Finding Fibonacci series sum");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FibonacciGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		JPanel firstRow = new JPanel(new FlowLayout());
		JLabel info = new JLabel("Number of row in Fibonacci:");
		info.setFont(new Font("굴림", Font.BOLD, 10));
		JTextField input = new JTextField();
		input.setColumns(5);
		JButton getSum = new JButton("Get Sum of Fibonacci series");
		getSum.setFont(new Font("굴림", Font.BOLD, 12));
		getSum.setBackground(new Color(243, 227, 27));
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setFont(new Font("굴림", Font.BOLD, 12));
		cancel.setBackground(new Color(255, 0, 0));
		
		
		
		firstRow.add(info);
		firstRow.add(input);
		firstRow.add(getSum);
		firstRow.add(cancel);
		
		
		contentPane.add(firstRow, BorderLayout.NORTH);
		
		screen = new JTextArea();
        screen.setEditable(false); // 사용자가 편집하지 못하도록 설정
        
        JScrollPane scrollPane = new JScrollPane(screen,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel thirdRow = new JPanel(new GridLayout(1,2));
		//JLabel percentage = new JLabel("percentage");
		percentage = new JProgressBar();
		percentage.setValue(0);
		percentage.setStringPainted(true);
		
		sumNum = new JLabel("");
		
		thirdRow.add(percentage);
		thirdRow.add(sumNum);
		
		contentPane.add(thirdRow, BorderLayout.SOUTH);
		
		

		class ButtonHandler implements ActionListener {
			
			private long fibonacci(int n) {
				if (n <= 1) {
			       return n;
			    } else {
			       return fibonacci(n - 1) + fibonacci(n - 2);
			    }
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fibonacciThread = new ArrayList<>();
				
				if (e.getSource() == getSum) {
					String getInput = input.getText();
					if (getInput.matches("\\d+")) {
						int intRow = Integer.parseInt(getInput);
						long rowResult;
						for (int num = 0; num < intRow; num++) {
//							rowResult = fibonacci(num);
//							screen.setText(screen.getText() + rowResult + "\n");
//							ProgressBar worker = new ProgressBar(num, intRow, rowResult, fibonacciSum);
//							worker.execute();
							Fibonacci worker = new Fibonacci(num, intRow, frame);
							fibonacciThread.add(worker);
							worker.execute();
						}
						
					} else {
						input.setText("");
						screen.setText("");
						percentage.setValue(0);
						fibonacciSum = 0;
						sumNum.setText("");
						JOptionPane.showMessageDialog(null, "Enter valid input!", "Warning", JOptionPane.ERROR_MESSAGE);
					}
					
				} else if(e.getSource() == cancel) {
					stopAllThreads();
				}
			}
			
			private void stopAllThreads() {
				for (Fibonacci thread: fibonacciThread) {
				if (!thread.isDone()) {
						thread.cancel(true);
						
					}
				}
				sumNum.setText("Sum=" + fibonacciSum);
			}
			
					
		}
		
		ButtonHandler handler = new ButtonHandler(); //creating action listener
		getSum.addActionListener(handler);
		cancel.addActionListener(handler);
       	
	}
	
	public void updateScreen(long result) {
		fibonacciSum += result;
		screen.setText(screen.getText() +  result + "\n");
		
	}
	
	
	public void setPercentage(int per) {
		this.percentage.setValue(per);
		
	}
	
	public boolean areAllThreadsDone() {
	    for (SwingWorker<?, ?> worker : fibonacciThread) {
	        if (!worker.isDone()) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public void setSum() {
		sumNum.setText("Sum:" + fibonacciSum);
	}
		

}
