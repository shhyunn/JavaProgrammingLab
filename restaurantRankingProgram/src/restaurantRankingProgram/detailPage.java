package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class detailPage extends JFrame{
	private JPanel contentPane;
	private JPanel resPane;
	private JPanel menuPane;
	private restaurant res;
	private ArrayList<menu> menuList;
	private JPanel totalPane;
	
	public detailPage(restaurant res) {
		this.res = res; //storing the restaurant object
		this.menuList = res.getMenuList(); //storing the menu list
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel(new GridLayout(1,2));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("detail page of restaurant");
		
		resPane = new JPanel(new GridLayout(2,1));
		String imagePath = res.getImagePath();
		ImageIcon picture = new ImageIcon(detailPage.class.getResource(imagePath));
		Image image = picture.getImage();
		Image changeImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture = new ImageIcon(changeImage);
		JLabel pictureLabel = new JLabel(changePicture);
		resPane.add(pictureLabel);
		
		JPanel textPanel = new JPanel(new GridLayout(4,1));
		JLabel resName = new JLabel("restaurant name:"+res.getRestaurantName());
		resName.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		JLabel onStore = new JLabel("Operational Information:"+res.getOnStore());
		onStore.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		JLabel distance = new JLabel("distance from university:"+res.getDistance()+"m");
		distance.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		JLabel price = new JLabel("price: "+res.getPrice());
		price.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
		
		textPanel.add(resName);
		textPanel.add(onStore);
		textPanel.add(distance);
		textPanel.add(price);
		
		resPane.add(textPanel);
		
		//menuPane
		totalPane = new JPanel(new BorderLayout());
		JLabel titleLabel = new JLabel("MENU");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("HY헤드라인M", Font.BOLD, 22));
		menuPane = new JPanel(new GridLayout(5,1));
		
		/*iteration for adding the menu of restaurant*/
		for (menu tempMenu : menuList) {
			JPanel tempPane = new JPanel(new GridLayout(1,4));
			tempPane.setBackground(Color.WHITE);
			JLabel imageLabel = new JLabel("(No Image)");
			JLabel menuName = new JLabel(tempMenu.getMenuName());
			JLabel menuPrice = new JLabel(tempMenu.getMenuPrice());
			JLabel star = new JLabel(""+tempMenu.getStar());
			
			tempPane.add(imageLabel);
			tempPane.add(menuName);
			tempPane.add(menuPrice);
			tempPane.add(star);
			menuPane.add(tempPane);
		}
		
		totalPane.add(titleLabel, BorderLayout.NORTH);
		totalPane.add(menuPane, BorderLayout.CENTER);
		contentPane.add(resPane);
		contentPane.add(totalPane);
		
		//adding the edit button if the role of user is manager;
		if ("manager".equals(programData.getInstance().getUserStudent().getRole())) {
			JPanel editPane = new JPanel(new BorderLayout());
			JButton editBtn = new JButton("EDIT");
			editBtn.setForeground(new Color(64, 128, 128));
			editBtn.setFont(new Font("Bodoni MT", Font.BOLD, 15));
			editPane.add(editBtn, BorderLayout.EAST);
			totalPane.add(editPane, BorderLayout.SOUTH);
		}
		
		setContentPane(contentPane);
	}
}

