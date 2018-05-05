package createVehiclesFrames;
import menuFrames.*;
import java.awt.Color;
import java.awt.Dimension; // help to store heights and widths
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit; // ask different questions of the operating system

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Interface.VehiclesInterface;
import vehiclesClasses.Amphibi;
import vehiclesClasses.Jeep;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AmphibiFrame extends JFrame {
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	
	BufferedImage imageLink ;
	private ImageIcon image1;
	
	private JTextArea text1;
	private JTextArea text2;
	private JTextArea text3;
	private JTextArea text4;
	private JTextArea text5;
	private JTextArea text6;
	
	private JButton button1;
	
	private JRadioButton Rbutton1;
	private JRadioButton Rbutton2;
	private JRadioButton Rbutton3;

	
	public AmphibiFrame() {
		image1 =new ImageIcon(getClass().getResource("amphi1.jpg")); // defaulty
		this.setSize(500,550); //frame size
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
		
		middlePanel.setLayout(new GridLayout(9, 2 ,14 ,14));
		//downPanel.setLayout(new GridLayout(6, 1,0,0));
		topPanel.add(label1 = new JLabel("Enter The Amphibi vehicle Details"));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		middlePanel.add(label2 = new JLabel("Max speed"));
		middlePanel.add(text1 = new JTextArea("Max speed"));
		text1.setBorder(border);
		middlePanel.add(label3 = new JLabel("Model:"));
		middlePanel.add(text2 = new JTextArea("Model"));
		text2.setBorder(border);
		middlePanel.add(label4 = new JLabel("Number of wheels:"));
		middlePanel.add(text3 = new JTextArea("Number of wheels"));
		text3.setBorder(border);
		middlePanel.add(label5 = new JLabel("Max passengers:"));
		middlePanel.add(text4 = new JTextArea("Max passengers"));
		text4.setBorder(border);
		middlePanel.add(label6 = new JLabel("Wind direction:"));
		middlePanel.add(text5 = new JTextArea("with the wind/against the wind"));
		text5.setBorder(border);
		middlePanel.add(label7 = new JLabel("Country flag:"));
		middlePanel.add(text6 = new JTextArea("Country flag"));
		text6.setBorder(border);
		
		ListenForRadioButton lForRadioButton = new ListenForRadioButton();
		
		ButtonGroup bg = new ButtonGroup();
		
		// group all the Radio Buttons together
		bg.add(Rbutton1 = new JRadioButton("Image 1")) ;
		Rbutton1.addActionListener(lForRadioButton);
		bg.add(Rbutton2 = new JRadioButton("Image 2")) ;
		Rbutton2.addActionListener(lForRadioButton);
		bg.add(Rbutton3 = new JRadioButton("Add Image")) ;
		
		Rbutton3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		        JFileChooser fc = new JFileChooser();
		        int result = fc.showOpenDialog(null);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            String sname = file.getAbsolutePath();
		            middlePanel.remove(label8);
		            middlePanel.remove(button1);
		            label8 = new JLabel("",image1= new ImageIcon(sname), JLabel.CENTER);
		            label8.setPreferredSize(new Dimension(40, 40));
		            middlePanel.add(label8);
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
		label8 = new JLabel("");
		label8.setPreferredSize(new Dimension(40, 40));
		middlePanel.add(label8);

		middlePanel.add(button1);
		
	
		container.add(topPanel);
		container.add(middlePanel);
		container.add(middlePanel);
		this.add(container);
		this.setVisible(true);
	}
	
	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == button1) {// add button
				if(text1.getText().equals("") || text2.getText().equals("")|| text3.getText().equals("")|| text4.getText().equals("")|| text5.getText().equals("")
						|| text6.getText().equals("")) {
					JFrame SuccedOrNot = CreateFrame("Please try again please - All fields must be filled ") ;	
				}
				else {
				
					try {
						boolean flag=false;
						int maxSpeed =Integer.parseInt(text1.getText())  , maxPassenger=Integer.parseInt(text4.getText()) , numberOfWheels = Integer.parseInt(text3.getText());
						String model=text2.getText() , windDirection = text5.getText() , countryFlag = text6.getText();
						flag = true;
						if(flag) {
							JFrame SuccedOrNot = CreateFrame("Vehicle Added successfully ") ;
						}
						Amphibi amphibi = new Amphibi(maxPassenger, maxSpeed, model, numberOfWheels, windDirection ,countryFlag );
						mainApp.addImages(image1);
						mainApp.getVehicles().add(amphibi);
						mainApp.getWaterVehicles().add(amphibi);
						AddVehiclesMenu a = new AddVehiclesMenu();
						setVisible(false);
						a.setVisible(true);
						} catch(NumberFormatException ex) {JFrame SuccedOrNot = CreateFrame("Please try again please - All fields must be filled correctlly");}
				
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
				image1 =new ImageIcon(getClass().getResource("amphi1.jpg"));
				label8.setIcon(image1);
				//Rbutton1.setSelected(false);
				}
			else  {
				image1 =new ImageIcon(getClass().getResource("amphi2.jpg"));
				label8.setIcon(image1);
				}	
		}
		
	}
	
}
