package Vehicles;
import Interface.LandVehiclesInterface;

public class LandVehicles extends Vehicles implements LandVehiclesInterface {
	private int NumberOfWheels;
	private String RoadType; // Paved or dirt
	
	/**
	 * This constructor a Land Vehicles with a specified
	 * maxPassengers,maxSpeed,model,numberOfWheels,roadType  
	 * parameters will be explained explicitly in the Derived classes
	 */
	public LandVehicles( int maxPassengers, int maxSpeed, String model,
			int numberOfWheels, String roadType) {
		super( maxPassengers, maxSpeed, model);
		NumberOfWheels = numberOfWheels;
		RoadType = roadType;
	}
	/**
	 * @return Numerical representation for the number of wheels in the Vehicle 
	 */
	public int getNumberOfWheels() {
		return NumberOfWheels;
	}
	/**
	 * @return String representation for the Road Type 
	 */
	public String getRoadType() {
		return RoadType;
	}
	public boolean equals(Object other) {
		boolean ans =false;
		if (other instanceof LandVehicles) {
			ans = super.equals(other) && this.NumberOfWheels== ((LandVehicles)other).getNumberOfWheels() &&
					this.RoadType.equals(((LandVehicles)other).getRoadType()) ;
		}
		return ans;
	}
	public  String toString() {
		return RoadType;
	}
	public void ResetKilometraz() {this.Kilometraz=0;}
}
