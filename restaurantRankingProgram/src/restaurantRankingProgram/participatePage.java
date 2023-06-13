package restaurantRankingProgram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class participatePage extends JFrame {
	private JPanel contentPane;
	private ArrayList<restaurant> initList;
	private ArrayList<restaurant> resList;
	private ArrayList<restaurant> currResList;
	private restaurant winner;

	private JPanel titlePane;
	private JPanel mainPane;
	
	private JButton resBtn1;
	private JButton resBtn2;
	private int round;
	
	private JLabel vsLabel;
	private JLabel roundLabel;
	
	private JLabel resLabel1;
	private JLabel resLabel2;
	
	/*participate page for implementing restaurant game*/
    public participatePage() {
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(50, 50, 700, 600);
		setTitle("Sungkyun's Ranking");
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel title = new JLabel("SungKyun's Ranking");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(64, 128, 128));
		title.setFont(new Font("Arial Black", Font.BOLD, 30));
		JLabel epty = new JLabel();
		JLabel comment = new JLabel("----------- Select yout Pick! -----------");
		comment.setHorizontalAlignment(SwingConstants.CENTER);
		comment.setFont(new Font("Arial Black", Font.BOLD, 28));
		titlePane = new JPanel(new GridLayout(3,1));
		titlePane.add(title);
		titlePane.add(epty);
		titlePane.add(comment);
		contentPane.add(titlePane, BorderLayout.NORTH);
		
		mainPane = new JPanel(new GridLayout(1,3));
		JPanel resPane1 = new JPanel(new BorderLayout());
		JPanel resPane2 = new JPanel(new BorderLayout());
		resBtn1 = new JButton(""); //adding the restaurant button1
		resLabel1 = new JLabel("");
		resLabel1.setFont(new Font("휴먼엑스포", Font.BOLD, 15));
		resLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		resBtn2 = new JButton(""); //adding the restaurant button2
		resLabel2 = new JLabel("");
		resLabel2.setFont(new Font("휴먼엑스포", Font.BOLD, 15));
		resLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		resPane1.add(resLabel1, BorderLayout.NORTH);
		resPane1.add(resBtn1, BorderLayout.CENTER);
		
		resPane2.add(resLabel2, BorderLayout.NORTH);
		
		resPane2.add(resBtn2, BorderLayout.CENTER);
		mainPane.add(resPane1);
		
		JPanel vsPane = new JPanel(new GridLayout(4,1));
		vsLabel = new JLabel("vs");
		vsLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		vsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vsPane.add(new JLabel(""));
		roundLabel = new JLabel("Quater-final"); //for showing the quater final or semi final or final
		roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roundLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		roundLabel.setForeground(new Color(255, 0, 0));
		vsPane.add(roundLabel);
		vsPane.add(vsLabel);
		vsPane.add(new JLabel(""));
		mainPane.add(vsPane);
		mainPane.add(resPane2);
		
		contentPane.add(mainPane, BorderLayout.CENTER);
		JPanel bottomPane = new JPanel(new BorderLayout());
		JButton blankButton = new JButton("------------------------------");
		blankButton.setForeground(new Color(64, 128, 128));
		blankButton.setBackground(new Color(64, 128, 128));

		String imagePath = "/img/sungkyunkwan.png";
		ImageIcon picture = new ImageIcon(participatePage.class.getResource(imagePath));
		Image image = picture.getImage();
		Image changeImage = image.getScaledInstance(700,150, Image.SCALE_SMOOTH); //adjusting size of image
		ImageIcon changePicture = new ImageIcon(changeImage);
		JLabel imageLabel = new JLabel(changePicture);
		bottomPane.add(blankButton, BorderLayout.NORTH);
		bottomPane.add(imageLabel, BorderLayout.CENTER);
		
		contentPane.add(bottomPane, BorderLayout.SOUTH);
		
		setContentPane(contentPane);
		
		//initializing and storing the 3 list
    	initList = programData.getInstance().getRestaurantList();
    	resList = new ArrayList<restaurant>(initList);
    	currResList = new ArrayList<restaurant>();
    	round = 0;
    	startGame(); //game start
    }

    public void startGame() {

        selectRandomRestaurants();
        
        resBtn1.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				GameThread gameThread = new GameThread();
		        gameThread.start(); //delaying the game for a moments
				handleButtonClick(resLabel1);	
			}
        });
        
        resBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameThread gameThread = new GameThread();
		        gameThread.start(); //delaying the game for a moments
				handleButtonClick(resLabel2);
			}
        });      
    }

    private int selectRandomRestaurants() {
    	if (resList.isEmpty()) { //cases for changing the round (quater -> semi, semi -> final)
    	    resList = new ArrayList<restaurant>(); //creating new restaurant list
    	    resList.addAll(currResList); //copying the currResList to resList
    	    currResList.clear(); //deleting the object in currResList
    	    
    	    if (resList.size() == 4) { //previous round : quater round
    	    	roundLabel.setText("Semi-final"); //changing round to semi final
    	    }
    	    else if (resList.size() == 2) { //previous round : semi final
    	    	roundLabel.setText("Final"); //changing round to final
    	    }
    	}
    	
    	if (resList.size() <=1) { //if the restaurant object is just one
    		winner = resList.get(0); //the object is the winner object
   		 	JOptionPane.showMessageDialog(this, "Winner: " + winner.getRestaurantName(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
   		 	setVisible(false); //game ended
   		 	return 0;
    	}
    			
    	Random random = new Random();
    	//selecting the random index
    	int idx1 = random.nextInt(resList.size());
    	int idx2 = random.nextInt(resList.size());
    	
    	while (idx2 == idx1) { //cases for the same index
    		idx2 = random.nextInt(resList.size());
    	}
    	
    	//get the restaurant object for index
    	restaurant res1 = resList.get(idx1);
    	restaurant res2 = resList.get(idx2);
    	
    	//deleting the restaurant object from existing the restaurant list
    	resList.remove(res1);
    	resList.remove(res2);

		ImageIcon picture1 = new ImageIcon(participatePage.class.getResource(res1.getImagePath()));
		Image image1 = picture1.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(image1);

		ImageIcon picture2 = new ImageIcon(participatePage.class.getResource(res2.getImagePath()));
		Image image2 = picture2.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(image2);
		
		resBtn1.setIcon(scaledIcon1); //setting the image of restaurant
    	resLabel1.setText(res1.getRestaurantName()); //setting the label of restaurant
    	
    	resBtn2.setIcon(scaledIcon2);
    	resLabel2.setText(res2.getRestaurantName());
    	return 0;
    }
    
    private void handleButtonClick(JLabel resLabel) {
    	String selectName = resLabel.getText();
    	restaurant selectRestaurant = null;
    	
    	/*iteration for finding the correct restaurant*/
    	for (restaurant res : initList) {
    		if (res.getRestaurantName().equals(selectName)) {
    			selectRestaurant = res; //storing the correct restaurant
    			break;
    		}
    	}
    	currResList.add(selectRestaurant); //adding the correct restaurant to currReslist
    	selectRandomRestaurants(); //call the select random restaurant funcion
  
    }

    private class GameThread extends Thread {
        @Override
        public void run() {
            // delaying the select the restaurant
            try {
                Thread.sleep(2000);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }  
}
