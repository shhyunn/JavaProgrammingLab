package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class rankingPage extends JFrame{
	private JPanel contentPane;
	
	private JLabel rankingTitle;
	private JPanel titlePane;
	private JPanel northPane;
	private JPanel mainPane;
	private JButton ptBtn;
	private JButton exBtn;
	/*ranking page for showing the restaurant ranking*/
	public rankingPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 800, 700);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("ranking Page");
		
		rankingTitle = new JLabel("SungKyun's Ranking");
		rankingTitle.setForeground(new Color(64, 128, 128));
		rankingTitle.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 30));
		JLabel week = new JLabel("This WEEK");
		week.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		ptBtn = new JButton("PARTICIPATE"); //adding the participate button
		ptBtn.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
		ptBtn.setForeground(new Color(255, 255, 255));
		ptBtn.setBackground(new Color(64, 128, 128));
		exBtn = new JButton("EXPLAIN"); //adding the explain button
		exBtn.setForeground(new Color(255, 255, 255));
		exBtn.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
		exBtn.setBackground(new Color(64, 128, 128));
		
		ButtonHandler handler = new ButtonHandler();
		ptBtn.addActionListener(handler);
		exBtn.addActionListener(handler);
		
		titlePane = new JPanel(new GridLayout(1,4));
		JLabel padd = new JLabel();
		titlePane.add(week);
		titlePane.add(padd);
		titlePane.add(ptBtn);
		titlePane.add(exBtn);
		
		northPane = new JPanel(new GridLayout(3,1));
		JLabel emptyPadd = new JLabel();
		northPane.add(rankingTitle);
		northPane.add(titlePane);
		northPane.add(emptyPadd);
		contentPane.add(northPane, BorderLayout.NORTH);
		
		mainPane = new JPanel(new GridLayout(5,1));
		int cnt = 1; //for storing the store count number
		
		/*iteration for showing the restaurant ranking*/
		for (restaurant res : programData.getInstance().getRestaurantList()) {
			JPanel tempPane = new JPanel(new GridLayout(1,3));
			String placeText = String.format("%d place", cnt);
			JLabel place = new JLabel(placeText);
			place.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
			place.setHorizontalAlignment(SwingConstants.CENTER);
			String imagePath = res.getImagePath();
			ImageIcon picture = new ImageIcon(getClass().getResource(imagePath));
			Image image = picture.getImage();
			Image changeImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); //adjusting size of image
			ImageIcon changePicture = new ImageIcon(changeImage);
			JLabel Image = new JLabel(changePicture);
			JLabel name = new JLabel(res.getRestaurantName());
			name.setFont(new Font("굴림", Font.BOLD, 15));
			tempPane.add(place);
			tempPane.add(Image);
			tempPane.add(name);
			mainPane.add(tempPane);
			cnt += 1;	
		}
		
		contentPane.add(mainPane, BorderLayout.CENTER);
		setContentPane(contentPane);
		
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ptBtn) {
				participatePage participatePage = new participatePage();
				participatePage.setVisible(true);
	        }
			else if (e.getSource() == exBtn) {
				explainPage explainPage = new explainPage();
				explainPage.setVisible(true);
			}
			
		}
	}
	

}