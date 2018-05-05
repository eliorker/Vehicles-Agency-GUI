/**
 * @author Elior Kertsman
 * @ID : 313565095
 * @Campus : Ashdod
 *
 */
package menuFrames;

import createVehiclesFrames.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; // help to store heights and widths
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit; // ask different questions of the operating system
import javax.swing.*;
import javax.swing.border.Border;

import Interface.VehiclesInterface;

import java.awt.event.*;
import java.util.ArrayList;

public class MenuFrame  extends JFrame {
	private JRadioButton[] RbuttonArray ;
	private JButton [] buttons= new JButton [6]; 
	private int chooseVehicle;
	static int flagChoose;
	static boolean flag;
	
	public MenuFrame(){
		JPanel Toppanel = new JPanel();
		JPanel MiddelPanel = new JPanel();
		String [] options = {"Add new Vehcile" , "Buy a Vehicle" , "Test Drive" , "Reset Vehicles km" , "Change Vehicles flag" , "Exit"};
		ListenForButton lForButton = new ListenForButton();
		for(int i=0 ; i <6 ; i++) {
			buttons[i] = new JButton(options[i]);
			buttons[i].addActionListener(lForButton);
		}
		RbuttonArray = new JRadioButton[mainApp.getVehicles().size()];
		ListenForRadioButton lForRadioButton = new ListenForRadioButton();
		for(int i=0 ; i<mainApp.getVehicles().size() ; i++) {
			Toppanel.add(RbuttonArray[i] = new JRadioButton(mainApp.getImages().get(i)));
			RbuttonArray[i].setToolTipText(mainApp.getVehicles().get(i).toString());
		}
		ButtonGroup bg = new ButtonGroup();
		
		// group all the Radio Buttons together
		for(int i =0 ; i<mainApp.getImages().size(); i++) {
			bg.add(RbuttonArray[i]) ;
			RbuttonArray[i].addActionListener(lForRadioButton);
		}	
		
		this.setSize(700,700); //frame size
		this.setTitle("Vehicle Management Menu");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPosition = (dim.width / 2) - (this.getWidth()/2); // position everything in the center
		int yPosition = (dim.height / 2) - (this.getHeight()/2);
		this.setLocation(xPosition, yPosition);
		Toppanel.setLayout(new FlowLayout());
		MiddelPanel.setLayout(new GridLayout(2,4,10,10));
		
		for(int i=0;i<6; i++) {
			buttons[i].setPreferredSize(new Dimension(80, 57));
			MiddelPanel.add(buttons[i]);
		}
		this.setLayout(new GridLayout(2, 4));
		this.add(Toppanel);
		this.add(MiddelPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // real exit when clicking the X button
		
		
		
		
		
		this.setVisible(true);
	}
	
	public int getchooseVehicle() {return chooseVehicle;}
	public void setchooseVehicle(int newchoose) {chooseVehicle = newchoose;}
	
	private class ListenForButton implements ActionListener{

		@SuppressWarnings("unlikely-arg-type")
		@Override
		public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == buttons[0]) // add vehicle 
			{
			 AddVehiclesMenu a = new AddVehiclesMenu() ;
				a.setVisible(true);
				setVisible(false);
				
			}
		else if (e.getSource() == buttons[1]) // ***buy a vehicle***
		{ 
				if (mainApp.getWaterVehicles().contains(mainApp.getVehicles().get(getchooseVehicle())))
					mainApp.getWaterVehicles().remove(mainApp.getVehicles().get(getchooseVehicle()));
				mainApp.getVehicles().remove(getchooseVehicle());
				mainApp.getImages().remove(getchooseVehicle());
				JFrame frame = CreateFrame("Thank for bought a Vehcile - Enjoy");
				MenuFrame temp = new MenuFrame();
				setVisible(false);
				temp.setVisible(true);
				 
		}
		else if (e.getSource() == buttons[2]) //take for a test drive 
		{
			JFrame frame =CreateFrame("How much did you drive?");
			JButton tbutton = new JButton("OK");
			
			JPanel tempPanel = new JPanel();
			JTextArea tmpText = new JTextArea();
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			tmpText.setBorder(border);
			tmpText.setPreferredSize(new Dimension(40, 40));
			tempPanel.add(tmpText);
			tempPanel.add(tbutton);
			frame.add(tempPanel);
			frame.setLayout(new GridLayout(2,1));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.setVisible(true);
		 	tbutton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent ae) {
							mainApp.getVehicles().get(getchooseVehicle()).setKilometraz(Integer.parseInt(tmpText.getText()));
							MenuFrame temp = new MenuFrame(); 
							frame.dispose();
							setVisible(false);
							temp.setVisible(true);
						}
			});
			
			}
		 
		 
		else if (e.getSource() == buttons[3]) // reset vehicles km
		{
			for(int i=0 ; i<mainApp.getVehicles().size() ; i++) 
				mainApp.getVehicles().get(i).ResetKilometraz();
			JFrame frame =CreateFrame("All Vehicles km have been reset");
			MenuFrame temp = new MenuFrame();
			setVisible(false);
			temp.setVisible(true);
		}
		else if (e.getSource() == buttons[4]) // change vehicles flags
		{
				String [] flagsimageswithoutPNG = {"israel" , "usa" , "sumalia" , "italy" , "german" , "pirate" , "greec"};
				JFrame a =FlagFrame();
				JPanel panel = new JPanel();
				String [] flagsimages = {"israel.jpg" , "usa.jpg" , "sumalia.jpg" , "italy.png" , "german.jpg" , "pirate.png" , "greec.jpg"};
				panel.setLayout(new GridLayout(3, 4));
				ImageIcon pic1 = new ImageIcon(getClass().getResource(flagsimages[0]));
				ImageIcon pic2 = new ImageIcon(getClass().getResource(flagsimages[1]));
				ImageIcon pic3 = new ImageIcon(getClass().getResource(flagsimages[2]));
				ImageIcon pic4 = new ImageIcon(getClass().getResource(flagsimages[3]));
				ImageIcon pic5 = new ImageIcon(getClass().getResource(flagsimages[4]));
				ImageIcon pic6 = new ImageIcon(getClass().getResource(flagsimages[5]));
				ImageIcon pic7 = new ImageIcon(getClass().getResource(flagsimages[6]));

				JButton but1 = new JButton(pic1);
				JButton but2 = new JButton(pic2);
				JButton but3 = new JButton(pic3);
				JButton but4 = new JButton(pic4);
				JButton but5 = new JButton(pic5);
				JButton but6 = new JButton(pic6);
				JButton but7 = new JButton(pic7);
				VehiclesInterface vehicle= mainApp.getVehicles().get(chooseVehicle);

				panel.add(but1);
				panel.add(but2);
				panel.add(but3);
				panel.add(but4);
				panel.add(but5);
				panel.add(but6);
				panel.add(but7);
				a.add(panel);
				a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				a.setVisible(true);
				
				but1.addActionListener(new ActionListener() { // 
				    public void actionPerformed(ActionEvent ae) {
				    	MenuFrame.flagChoose = 0;
				    	for(int i=0;i<mainApp.getWaterVehicles().size() ; i++) 
							if(mainApp.getWaterVehicles().get(i).equals(vehicle))
								mainApp.getWaterVehicles().get(i).setCountryFlag(flagsimageswithoutPNG[MenuFrame.flagChoose]);
				    	MenuFrame temp= new MenuFrame();
				    	setVisible(false);
				    	temp.setVisible(true);
				    	a.dispose();
				    	}
				    });
				but2.addActionListener(new ActionListener() { // 
				    public void actionPerformed(ActionEvent ae) {
				    	MenuFrame.flagChoose = 1;
				    	for(int i=0;i<mainApp.getWaterVehicles().size() ; i++) 
							if(mainApp.getWaterVehicles().get(i).equals(vehicle))
								mainApp.getWaterVehicles().get(i).setCountryFlag(flagsimageswithoutPNG[MenuFrame.flagChoose]);
				    	MenuFrame temp= new MenuFrame();
				    	setVisible(false);
				    	temp.setVisible(true);
				    	a.dispose();
				    }
				    });
				but3.addActionListener(new ActionListener() { // 
				    public void actionPerformed(ActionEvent ae) {
				    	MenuFrame.flagChoose = 2;
				    	for(int i=0;i<mainApp.getWaterVehicles().size() ; i++) 
							if(mainApp.getWaterVehicles().get(i).equals(vehicle))
								mainApp.getWaterVehicles().get(i).setCountryFlag(flagsimageswithoutPNG[MenuFrame.flagChoose]);
				    	MenuFrame temp= new MenuFrame();
				    	setVisible(false);
				    	temp.setVisible(true);
				    	a.dispose();
				    }
				    });
				but4.addActionListener(new ActionListener() { // 
				    public void actionPerformed(ActionEvent ae) {
				    	MenuFrame.flagChoose = 3;
				    	for(int i=0;i<mainApp.getWaterVehicles().size() ; i++) 
							if(mainApp.getWaterVehicles().get(i).equals(vehicle))
								mainApp.getWaterVehicles().get(i).setCountryFlag(flagsimageswithoutPNG[MenuFrame.flagChoose]);
				    	MenuFrame temp= new MenuFrame();
				    	setVisible(false);
				    	temp.setVisible(true);
				    	a.dispose();
				    }
				    });
				but5.addActionListener(new ActionListener() { // 
				    public void actionPerformed(ActionEvent ae) {
				    	MenuFrame.flagChoose = 4;
				    	for(int i=0;i<mainApp.getWaterVehicles().size() ; i++) 
							if(mainApp.getWaterVehicles().get(i).equals(vehicle))
								mainApp.getWaterVehicles().get(i).setCountryFlag(flagsimageswithoutPNG[MenuFrame.flagChoose]);
				    	MenuFrame temp= new MenuFrame();
				    	setVisible(false);
				    	temp.setVisible(true);
				    	a.dispose();
				    }
				    });
				but6.addActionListener(new ActionListener() { // 
				    public void actionPerformed(ActionEvent ae) {
				    	MenuFrame.flagChoose = 5;
				    	for(int i=0;i<mainApp.getWaterVehicles().size() ; i++) 
							if(mainApp.getWaterVehicles().get(i).equals(vehicle))
								mainApp.getWaterVehicles().get(i).setCountryFlag(flagsimageswithoutPNG[MenuFrame.flagChoose]);
				    	MenuFrame temp= new MenuFrame();
				    	setVisible(false);
				    	temp.setVisible(true);
				    	a.dispose();
				    }
				    });
				but7.addActionListener(new ActionListener() { // 
				    public void actionPerformed(ActionEvent ae) {
				    	MenuFrame.flagChoose = 6;
				    	for(int i=0;i<mainApp.getWaterVehicles().size() ; i++) 
							if(mainApp.getWaterVehicles().get(i).equals(vehicle))
								mainApp.getWaterVehicles().get(i).setCountryFlag(flagsimageswithoutPNG[MenuFrame.flagChoose]);
				    	MenuFrame temp= new MenuFrame();
				    	setVisible(false);
				    	temp.setVisible(true);
				    	a.dispose();
				    }
				    });
		
		}
		
		else if (e.getSource() == buttons[5]) // exit
		{
			JFrame frame =CreateFrame("Have a good day :)") ;
			setVisible(false);
			return;
			
		}	 
		}
		public JFrame CreateFrame(String message) {
			JFrame frame = new JFrame();
			
			JPanel panel = new JPanel();
			frame.setSize(400,120);
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dim = tk.getScreenSize();
			int xPosition = (dim.width / 2) - (frame.getWidth()/2); // position everything in the center
			int yPosition = (dim.height / 2) - (frame.getHeight()/2);
			frame.setLocation(xPosition, yPosition);
			JLabel temp = new JLabel(message);
			panel.add(temp);
			frame.add(panel);	
			frame.setVisible(true);
			return frame;
		}
		
	}
	
	private class ListenForRadioButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i=0;i<mainApp.getImages().size(); i++)
				if(RbuttonArray[i].isSelected())
					setchooseVehicle(i);
		}
		
	}
	
	public JFrame FlagFrame() {
		JFrame frame = new JFrame();
		frame.setSize(400,250);
		frame.setTitle("Click on the chosen Flag");
		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPosition = (dim.width / 2) - (frame.getWidth()/2); // position everything in the center
		int yPosition = (dim.height / 2) - (frame.getHeight()/2);
		frame.setLocation(xPosition, yPosition);
		//frame.add(panel);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		return frame;
		
	}
}
	




