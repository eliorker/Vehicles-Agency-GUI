/**
 * @author Elior Kertsman
 * @ID : 313565095
 * @Campus : Ashdod
 *
 */
package menuFrames;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import Interface.VehiclesInterface;
import Interface.WaterVehcilesInterface;

import java.awt.Image;
import java.util.*;
import Vehicles.*;

public class mainApp {
	private static ArrayList<VehiclesInterface> Vehicles = new ArrayList<VehiclesInterface>();
	private static ArrayList<WaterVehcilesInterface> waterVehicles = new ArrayList<WaterVehcilesInterface>(); // for not breaking the polymorphisem
	private static ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();

	public static void main(String[] args) { // main method
		// ----------------------------------------------------------
		// Vehicle Agency Program
		// ----------------------------------------------------------
		AddVehiclesMenu menuGui = new AddVehiclesMenu();
		menuGui.setVisible(true);
	}
	public static ArrayList<ImageIcon> getImages() {
		return images;
	}

	public static void addImages(ImageIcon images) {
		mainApp.images.add(images);
	}
	public static void deleteImages(ImageIcon image) {
		mainApp.images.remove(image);
	}
	
	////
	public static ArrayList<VehiclesInterface> getVehicles() {
		return mainApp.Vehicles;
	}

	public static void addVehicle(VehiclesInterface Vehicle) {
		mainApp.Vehicles.add(Vehicle);
	}
	public static void deleteVehicle(VehiclesInterface Vehicle) {
		mainApp.Vehicles.remove(Vehicle);
	}
	
	///
	public static ArrayList<WaterVehcilesInterface> getWaterVehicles() {
		return mainApp.waterVehicles;
	}

	public static void addWaterVehcile(WaterVehicles Vehicle) {
		mainApp.waterVehicles.add(Vehicle);
	}
	public static void deleteWaterVehcile(WaterVehicles Vehicle) {
		mainApp.waterVehicles.remove(Vehicle);
	}

}
