package week7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;

public class firstGUI {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(300, 300);
		window.setTitle("First GUI");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton button = new JButton();
		button.setText("Click");
		button.setBackground(Color.CYAN);
		
		JButton button2 = new JButton();
		button2.setText("Next");
		button2.setBackground(Color.RED);
		
		//FlowLayout layout = new FlowLayout();
		//GridLayout layout = new GridLayout(2,1);
		BorderLayout layout = new BorderLayout();
		window.setLayout(layout);
		
		window.add(button, BorderLayout.WEST);
		window.add(button2, BorderLayout.EAST);
		
		//changeColor listener = new changeColor();
		//listener.setControl(button);
		//button.addActionListener(listener);
		button.addActionListener(new firstGUI().new changeColor());
		window.setVisible(true);
		
	}	



class changeColor implements ActionListener{
	JButton controledButton;
	
	void setControl(JButton object) {
		controledButton = object;
	}
	
	void change() {
		controledButton.setBackground(Color.YELLOW);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// code to do when you click a button
		System.out.println("Cliked");
		change();
	}
	
}

}