package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class explainPage extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JPanel mainPane;
	private JPanel buttonPane;
	private JPanel whatPane;
	private JPanel whenPane;
	private JPanel howToPane;
	private JTextArea whatText;
	private JTextArea whenText;
	private JTextArea howToText;
	private JButton okBtn;
	
	/*explain page of sungkyun's ranking*/
	public explainPage() {
		setTitle("Explain Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 500, 600);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		title = new JLabel("SungKyun's RANKING");
		title.setForeground(new Color(0, 0, 0));
		title.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		contentPane.add(title, BorderLayout.NORTH);
		
		mainPane = new JPanel(new GridLayout(3,1));
		
		//first information
		JLabel what = new JLabel("What");
		what.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 12));
		whatText = new JTextArea();
		whatText.setText("This is Sungkyun's ranking");
		whatText.setEditable(false);
		
		whatPane = new JPanel(new GridLayout(2,1));
		whatPane.add(what);
		whatPane.add(whatText);
		
		mainPane.add(whatPane);
		
		//second information
		JLabel when = new JLabel("When");
		when.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 12));
		whenText = new JTextArea();
		whenText.setText("This can be participated for every week.");
		whenText.setEditable(false);
		
		whenPane = new JPanel(new GridLayout(2,1));
		whenPane.add(when);
		whenPane.add(whenText);
		
		mainPane.add(whenPane);
		
		//third information
		JLabel howTo = new JLabel("How To");
		howTo.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 12));
		howToText = new JTextArea();
		howToText.setText("click the participate button and choose your best restaurant of SungKyun!");
		howToText.setEditable(false);
		
		howToPane = new JPanel(new GridLayout(2,1));
		howToPane.add(howTo);
		howToPane.add(howToText);
		
		mainPane.add(howToPane);
		
		contentPane.add(mainPane, BorderLayout.CENTER);
		
		buttonPane = new JPanel(new GridLayout(3,1));
		JLabel epty1 = new JLabel();
		JPanel btnRow = new JPanel(new GridLayout(1,3));
		JLabel miniEpty1 = new JLabel();
		JLabel miniEpty2 = new JLabel();
		okBtn = new JButton("OK");
		okBtn.setBackground(new Color(64, 128, 128));
		okBtn.setForeground(new Color(255, 255, 255));
		okBtn.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
		
		ButtonHandler handler = new ButtonHandler();
		okBtn.addActionListener(handler);
		
		btnRow.add(miniEpty1);
		btnRow.add(okBtn);
		btnRow.add(miniEpty2);
		
		JLabel epty2 = new JLabel();
		
		buttonPane.add(epty1);
		buttonPane.add(btnRow);
		buttonPane.add(epty2);
		
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		setContentPane(contentPane);
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okBtn) { // if the okBtn is pressed, this page is closed
				setVisible(false);
	        }
		}
	}
}
