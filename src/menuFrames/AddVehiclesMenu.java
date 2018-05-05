/**
 * @author Elior Kertsman
 * @ID : 313565095
 * @Campus : Ashdod
 *
 */
package menuFrames;
import createVehiclesFrames.*;
import java.awt.Dimension; // help to store heights and widths
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit; // ask different questions of the operating system
import javax.swing.*;

import Interface.VehiclesInterface;
import createVehiclesFrames.AmphibiFrame;
import createVehiclesFrames.BikeFrame;
import createVehiclesFrames.CruiseShipFrame;
import createVehiclesFrames.FrigateFrame;
import createVehiclesFrames.GameGliderFrame;
import createVehiclesFrames.JeepFrame;
import createVehiclesFrames.SpyGliderFrame;

import java.awt.event.*;
import java.util.ArrayList;


public class AddVehiclesMenu extends JFrame {
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	
	private ImageIcon amphibiImg;
	private ImageIcon jeepImg;
	private ImageIcon bikeImg;
	private ImageIcon frigateImg;
	private ImageIcon spyGliderImg;
	private ImageIcon gameGliderImg;
	private ImageIcon cruiseShipImg;
	private ImageIcon menuImg;
	
	private JButton amphibiButton;
	private JButton jeepButton;
	private JButton bikeButton;
	private JButton frigateButton;
	private JButton spyGliderButton;
	private JButton gameGliderButton;
	private JButton cruiseShipButton;
	private JButton menuButton;
	
	
	
	public AddVehiclesMenu() { // creating a frame
		this.setSize(500,400); //frame size
		this.setTitle("Vehicle Management Agency");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPosition = (dim.width / 2) - (this.getWidth()/2); // position everything in the center
		int yPosition = (dim.height / 2) - (this.getHeight()/2);
		this.setLocation(xPosition, yPosition);
		//this.setLocationRelativeTo(null); //position everything center based off what the screen is
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // real exit when clicking the X button
		
		JPanel mainPanel = new JPanel(); //combine all panels together
		JPanel TopPanel = new JPanel(); // for the title
		TopPanel.add(label1 = new JLabel("Welcome To My Vehicle Agency"));
		TopPanel.add(label2 = new JLabel("Add a vehicle to the agency , select one of the following:"));
		
		JPanel panel = new JPanel(); 
		label1.setFont(new Font("Serif", Font.PLAIN, 24)); // change the label1 font
		
		//ADD PICTURES TO THE BUTTONS
		
		amphibiImg =new ImageIcon(getClass().getResource("amphibi.png"));
		jeepImg =new ImageIcon(getClass().getResource("jeep.png"));
		bikeImg =new ImageIcon(getClass().getResource("bike.png"));
		frigateImg =new ImageIcon(getClass().getResource("frigate.png"));
		spyGliderImg =new ImageIcon(getClass().getResource("spyglider.png"));
		gameGliderImg =new ImageIcon(getClass().getResource("gameglider.png"));
		cruiseShipImg =new ImageIcon(getClass().getResource("cruise.png"));
		menuImg=new ImageIcon(getClass().getResource("menu.png"));
	
	
		panel.add(label3 = new JLabel("Amphibi:"));
		panel.add(amphibiButton = new JButton(amphibiImg));
		
		panel.add(label8 = new JLabel("        Jeep:"));
		panel.add(jeepButton = new JButton(jeepImg));
		
		panel.add(label4 = new JLabel("Bike:"));
		panel.add(bikeButton = new JButton(bikeImg));
		
		panel.add(	label6 = new JLabel("        Frigate:"));
		panel.add(frigateButton = new JButton(frigateImg));
		
		panel.add(label9 = new JLabel("Spy Glider:"));
		panel.add(spyGliderButton = new JButton(spyGliderImg));
		
		panel.add(label7 = new JLabel("        Game Glider:"));
		panel.add(gameGliderButton = new JButton(gameGliderImg));
		
		
		panel.add(label5 = new JLabel("Cruise:"));
		panel.add(cruiseShipButton = new JButton(cruiseShipImg));
		
		panel.add(label10 = new JLabel("        Menu:"));
		
		panel.add(menuButton = new JButton(menuImg));
		
		gameGliderButton.setPreferredSize(new Dimension(80, 57));
		amphibiButton.setPreferredSize(new Dimension(80, 57));
		
		
		ListenForButton lForButton = new ListenForButton();
		amphibiButton.addActionListener(lForButton);
		bikeButton.addActionListener(lForButton);
		jeepButton.addActionListener(lForButton);
		cruiseShipButton.addActionListener(lForButton);
		menuButton.addActionListener(lForButton);
		gameGliderButton.addActionListener(lForButton);
		spyGliderButton.addActionListener(lForButton);
		frigateButton.addActionListener(lForButton);
		
		//add picture
		panel.setLayout(new GridLayout(5, 2));
		TopPanel.setLayout(new GridLayout(2, 1));
		mainPanel.add(TopPanel);
		mainPanel.add(panel);
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == amphibiButton)
			{
			 AmphibiFrame a = new AmphibiFrame() ;
				a.setVisible(true);
				setVisible(false);
				
			}
		else if (e.getSource() == bikeButton)
		{
			BikeFrame a = new BikeFrame() ;
			a.setVisible(true);
			setVisible(false);
			
		}
		else if (e.getSource() == cruiseShipButton)
		{
			CruiseShipFrame a = new CruiseShipFrame() ;
			a.setVisible(true);
			setVisible(false);
			
		}
		else if (e.getSource() == frigateButton)
		{
			FrigateFrame a = new FrigateFrame() ;
			a.setVisible(true);
			setVisible(false);
			
		}
		else if (e.getSource() == gameGliderButton)
		{
			GameGliderFrame a = new GameGliderFrame() ;
			a.setVisible(true);
			setVisible(false);
			
		}
		else if (e.getSource() == jeepButton)
		{
			JeepFrame a = new JeepFrame() ;
			a.setVisible(true);
			setVisible(false);
			
		}
		else if (e.getSource() == spyGliderButton)
		{
			SpyGliderFrame a = new SpyGliderFrame() ;
			a.setVisible(true);
			setVisible(false);
			
		}
		else if (e.getSource() == menuButton)
		{
			MenuFrame a= new MenuFrame() ;
			a.setVisible(true);
			setVisible(false);
			
		}
		 
		 
		}
	}
	
	
}

