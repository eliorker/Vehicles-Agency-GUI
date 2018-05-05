package createVehiclesFrames;
import menuFrames.*;
import vehiclesClasses.SpyGlider;

import java.awt.Color;
import java.awt.Dimension; // help to store heights and widths
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit; // ask different questions of the operating system
import javax.swing.*;
import javax.swing.border.Border;

import Interface.VehiclesInterface;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class SpyGliderFrame extends JFrame {
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	BufferedImage imageLink ;
	private ImageIcon image1;
	
	private JRadioButton Rbutton1;
	private JRadioButton Rbutton2;
	private JRadioButton Rbutton3;
	private JRadioButton Rbutton4;
	
	private JTextArea text1;
	private JTextArea text2;
	private JTextArea text3;
	private JTextArea text4;
	
	private JButton button1;
	
	public SpyGliderFrame() {
		image1 =new ImageIcon(getClass().getResource("spy1.jpg")); // defaulty
		this.setSize(500,400); //frame size
		this.setTitle("Vehicle Management Menu");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPosition = (dim.width / 2) - (this.getWidth()/2); // position everything in the center
		int yPosition = (dim.height / 2) - (this.getHeight()/2);
		this.setLocation(xPosition, yPosition);
		//this.setLocationRelativeTo(null); //position everything center based off what the screen is
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // real exit when clicking the X button
		
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel container = new JPanel();
		middlePanel.setLayout(new GridLayout(5, 1 ,14 ,14));
		topPanel.add(label1 = new JLabel("Enter The Spy Glider Details"));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		middlePanel.add(label2 = new JLabel("Power Source :                   "));
		middlePanel.add(text1 = new JTextArea("Power Source"));
		text1.setBorder(border);
		
		ListenForRadioButton lForRadioButton = new ListenForRadioButton();
		
		ButtonGroup bg = new ButtonGroup();
		
		// group all the Radio Buttons together
		bg.add(Rbutton1 = new JRadioButton("Image 1")) ;
		Rbutton1.addActionListener(lForRadioButton);
		bg.add(Rbutton2 = new JRadioButton("Image 2")) ;
		Rbutton2.addActionListener(lForRadioButton);
		bg.add(Rbutton3 = new JRadioButton("Image 3")) ;
		Rbutton3.addActionListener(lForRadioButton);
		bg.add(Rbutton4 = new JRadioButton("Add Image")) ;
		
		Rbutton4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		        JFileChooser fc = new JFileChooser();
		        int result = fc.showOpenDialog(null);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            String sname = file.getAbsolutePath();
		            middlePanel.remove(label3);
		            middlePanel.remove(button1);
		            label3 = new JLabel("",image1= new ImageIcon(sname), JLabel.CENTER);
		            label3.setPreferredSize(new Dimension(30, 30));
		            middlePanel.add(label3);
		            middlePanel.add(button1);
		            middlePanel.revalidate(); 
		            middlePanel.repaint();  
		        }
		       
		    }
		});
		
		ListenForButton lForButton = new ListenForButton();
		button1=new JButton("Add");
		button1.addActionListener(lForButton);
		middlePanel.add(Rbutton1);
		middlePanel.add(Rbutton2);
		middlePanel.add(Rbutton3);
		middlePanel.add(Rbutton4);
		label3 = new JLabel("");
		label3.setPreferredSize(new Dimension(30, 30));
		middlePanel.add(label3);
		middlePanel.add(button1);
		
		container.add(topPanel);
		container.add(middlePanel);
		this.add(container);
		this.setVisible(true);
	}
	
	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) { // add button
				if(text1.getText().equals("")) {
					JFrame SuccedOrNot = CreateFrame("Please try again please - All fields must be filled") ;	
				}
				else {
					try {
						boolean flag=false;
						String powerSource = text1.getText();
						flag = true;
						if(flag) {
							JFrame SuccedOrNot = CreateFrame("Vehicle Added successfully ") ;
						}
						SpyGlider spyG = new SpyGlider(powerSource);
						mainApp.addImages(image1);
						mainApp.getVehicles().add(spyG);
						AddVehiclesMenu a = new AddVehiclesMenu();
						setVisible(false);
						a.setVisible(true);
					}catch(NumberFormatException ex) {JFrame SuccedOrNot = CreateFrame("Please try again please - All fields must be filled correctlly");}

				}
			}
			
		}
		
		public JFrame CreateFrame(String message) {
			JFrame frame = new JFrame();
			
			JPanel panel = new JPanel();
			frame.setSize(400,200);
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dim = tk.getScreenSize();
			int xPosition = (dim.width / 2) - (frame.getWidth()/2); // position everything in the center
			int yPosition = (dim.height / 2) - (frame.getHeight()/2);
			frame.setLocation(xPosition, yPosition);
			JLabel temp = new JLabel(message);
			panel.add(temp);
			frame.add(panel);	
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.setVisible(true);
			return frame;
		}
		
	}
	
	private class ListenForRadioButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Rbutton1) {
				image1 =new ImageIcon(getClass().getResource("spy1.jpg"));
				label3.setIcon(image1);
				//Rbutton1.setSelected(false);
				}
			else if (e.getSource() == Rbutton2) {
				image1 =new ImageIcon(getClass().getResource("spy2.jpg"));
				label3.setIcon(image1);
				}
			else // (e.getSource() == Rbutton3) 
				{
				image1 =new ImageIcon(getClass().getResource("spy3.jpg"));
				label3.setIcon(image1);
				}
			
		}
		
	}
	
}