package vehiclesClasses;
import Vehicles.LandVehicles;
import Interface.NonMotorizedVehicle;


/**
 * this class represents a non motorized Bike
 *
 */
public class Bike extends LandVehicles implements NonMotorizedVehicle  {
	
	private String PowerSourceType;
	private String EnergyType;
	
	/**
	 * @param maxPassengers the max passenger that the bike can carry
	 * @param maxSpeed max speed of the bike
	 * @param model bike model
	 * @param EnergyType The Energy type of the Bike : (can be A, B or C)
	 * @param PowerSourceType The Bike power source type ( manual,automatic, semi-automatic..) 
	 */
	public Bike(int maxPassengers, int maxSpeed, String model ) {
		super(maxPassengers, maxSpeed, model, 2, "Paved");
		PowerSourceType="A";
		EnergyType="manual";
		
	}


	@Override
	public String PowerSource() {
		return " Power Source : "+this.PowerSourceType+ " ";
		
	}
	@Override
	public String EnergeticScore() {
		return " Energetic Score: "+this.EnergyType+ " ";
	}
	
	@Override
	public String toString() {
		 return "Bike: Model: "+this.getModel()+" traveled: "+this.getKilometraz()+" Km, Max speed of :"+this.getMaxSpeed()+" Mph"+" "
	 +"can carry max of : "+this.getMaxPassengers()+" people " +this.PowerSource()+this.EnergeticScore();
	 }
	
	@Override
	public boolean equals(Object other) {
		boolean ans =false;
		if (other instanceof Bike) {
			ans = super.equals(other) && this.EnergyType.equals(((Bike)other).getEnergyType()) && this.PowerSourceType.equals(((Bike)other).getPowerSourceType()) ; 
		}
		return ans;
	}

	/**
	 * @return the energy Type (can be A, B or C)
	 */
	public String getEnergyType() {
		return EnergyType;
	}

	/**
	 * @return the what type of power Source the Spy Glider uses ( manual,automatic, semiautomatic..)
	 */
	public String getPowerSourceType() {
		return PowerSourceType;
	}
}