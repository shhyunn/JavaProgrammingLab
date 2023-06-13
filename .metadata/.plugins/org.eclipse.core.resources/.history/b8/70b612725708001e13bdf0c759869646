package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class mainPage extends JFrame{
	private JPanel contentPane;
	private JPanel infoPane;
	private JPanel titlePane;
	private JPanel mainPane;
	private JScrollPane scrollPane;
	private int btnCount;
	private JButton requestBtn;
	private JButton myBtn;
	private JButton rankingBtn;
	private GridBagConstraints constraints;
	private JButton editBtn;
	private JButton logoutBtn;
	
	public mainPage() {
		/*initializing the main page*/
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 900, 700);
		setBackground(Color.WHITE);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		titlePane = new JPanel(new GridLayout(2,1));
		infoPane = new JPanel(new GridLayout(1,4));
		JLabel emptyPadding = new JLabel();
		
		mainPane = new JPanel(new GridBagLayout());
		scrollPane = new JScrollPane(mainPane); //adding scroll bar to the main contents
		
		constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        
		JLabel mainTitle = new JLabel("SungKyun's PICK"); //for storing the title
		mainTitle.setForeground(new Color(64, 128, 128));
		mainTitle.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		infoPane.add(mainTitle);//1 button
		
		requestBtn = new JButton("request");
		requestBtn.setForeground(new Color(64, 128, 128));
		requestBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
		infoPane.add(requestBtn); //2 button
		
		myBtn = new JButton("my page");
		myBtn.setForeground(new Color(64, 128, 128));
		myBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
		infoPane.add(myBtn); //3 button
		
		rankingBtn = new JButton("SungKyun's Ranking");
		rankingBtn.setBackground(new Color(64, 128, 128));
		rankingBtn.setForeground(new Color(255, 255, 255));
		rankingBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
		infoPane.add(rankingBtn); //4 button
		titlePane.add(infoPane);
		titlePane.add(emptyPadding);
		
		ButtonHandler handler = new ButtonHandler();
		requestBtn.addActionListener(handler);
		myBtn.addActionListener(handler);
		rankingBtn.addActionListener(handler);
		
		int row = 0;
		int col = 0;
		/*iteration for adding the restaurant information button*/
		for (restaurant res: programData.getInstance().getRestaurantList()) {
			btnCount += 1;
			JButton resBtn = createResBtn(res);
			resBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			resBtn.addActionListener(handler);
			
			resBtn.setPreferredSize(new Dimension(150,200));
			
			constraints.weightx = 1.0;
			constraints.weighty = 1.0;
			constraints.gridx = col; // Column index
	        constraints.gridy = row; // Row index
	        // Add the button to the panel with constraints
	        mainPane.add(resBtn, constraints);
	        col++; //adding the col number if adding the restaurant information button
	        if (col >= 2) { //condition for changing the row number
	        	col = 0;
	        	row++;
	        }
		}
		
		contentPane.add(titlePane, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel bottomPane = new JPanel(new BorderLayout());
		JPanel btnPane = new JPanel(new GridLayout(1,2));
		
		/*condition for adding the edit button if the role of program's user is "manager"*/
		if ("manager".equals(programData.getInstance().getUserStudent().getRole())) {
			editBtn = new JButton("EDIT");
			editBtn.setForeground(new Color(64, 128, 128));
			editBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
			btnPane.add(editBtn);

		} else {
			btnPane.add(new JLabel(""));
		}
		
		//adding the logout button
		logoutBtn = new JButton("logout");
		logoutBtn.setForeground(new Color(64, 128, 128));
		logoutBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
		logoutBtn.addActionListener(handler);
		logoutBtn.addActionListener(handler);
		
		btnPane.add(logoutBtn);
		bottomPane.add(btnPane, BorderLayout.EAST);
		contentPane.add(bottomPane, BorderLayout.SOUTH);
		setContentPane(contentPane);
		
	}
	
	/*function for returning the new button after creating restaurant button*/
	private JButton createResBtn(restaurant res) {
		String imagePath = res.getImagePath();
		ImageIcon picture = new ImageIcon(mainPage.class.getResource(imagePath));
		JButton btn = new JButton(res.getRestaurantName());
		btn.setBackground(Color.WHITE);
		Image image = picture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(image);
	    btn.setIcon(scaledIcon);
		
		return btn;
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == requestBtn) {
				/*condition whether the role of user is student or manager*/
				if ("manager".equals(programData.getInstance().getUserStudent().getRole())) {
					managerPage managerPage = new managerPage();
					managerPage.setVisible(true);
					
				} else {
					requestPage requestPage = new requestPage();
					requestPage.setVisible(true);
				}
				
	        }
			
			else if (e.getSource() == myBtn) {
				myPage myPage = new myPage();
				myPage.setVisible(true);
			}
			
			else if (e.getSource() == rankingBtn) {
				rankingPage rankingPage = new rankingPage();
				rankingPage.setVisible(true);
			}
			
			else if (e.getSource() == logoutBtn) {
				//creating the first page
				mainGUI mainGUI = new mainGUI();
				mainGUI.setVisible(true);
				setVisible(false);
			}
			
			else { //if the other button is selected(restaurant buttons...)
				 for (restaurant res : programData.getInstance().getRestaurantList()) {
					JButton tempBtn = (JButton) e.getSource();
					if (tempBtn.getText().equals(res.getRestaurantName())) {
						detailPage detailPage = new detailPage(res); //giving the page the restaurant object
						detailPage.setVisible(true);
					}
				}		
			}
		}
	}
}

