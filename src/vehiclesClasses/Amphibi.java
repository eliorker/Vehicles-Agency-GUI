package vehiclesClasses;

import Interface.LandVehiclesInterface;
import Interface.VehiclesInterface;
import Interface.WaterVehcilesInterface;
import Vehicles.LandVehicles;
import Vehicles.WaterVehicles;

/// delegator Design Pattern
public class Amphibi  implements LandVehiclesInterface , WaterVehcilesInterface , VehiclesInterface {

	private LandVehicles land ;
	private WaterVehicles water ;
	
	
	
	public Amphibi(int maxPassengers, int maxSpeed, String model, int numberOfWheels, String windDirection, String countryFlag) {
		super();
		this.land = new LandVehicles(maxPassengers,maxSpeed,model,numberOfWheels,"Paved") ;
		this.water = new WaterVehicles(maxPassengers,maxSpeed, model,windDirection,countryFlag);
	}

	@Override
	public String getWindDirection() {
		return water.getWindDirection();
	}

	@Override
	public String getCountryFlag() {
		return water.getCountryFlag();
	}

	@Override
	public void setCountryFlag(String countryFlag) {
		water.setCountryFlag(countryFlag);
	}

	@Override
	public int getNumberOfWheels() {
		return land.getNumberOfWheels();
	}

	@Override
	public String getRoadType() {
		return land.getRoadType();
	}
	
	
	
	@Override
	 public boolean equals(Object other) {
			boolean ans =false;
			if (other instanceof Amphibi) {
				if(((Amphibi) other).land.equals(this.land) && ((Amphibi) other).water.equals(this.water)) ans=true;
			}
			return ans;
		}

	@Override
	public int getKilometraz() {
		return land.getKilometraz();
	}

	@Override
	public void setKilometraz(int moreKilometraz) {
		land.setKilometraz(moreKilometraz);		
	}

	@Override
	public int getMaxPassengers() {
		return land.getMaxPassengers();
	}

	@Override
	public int getMaxSpeed() {
		return land.getMaxSpeed();
	}

	@Override
	public String getModel() {
		return land.getModel();
	}

	@Override
	public void ResetKilometraz() {
		land.ResetKilometraz();
		water.ResetKilometraz();
	}
	@Override
	
	 public String toString() {
		 return "Amphibi: Model: "+land.getModel()+" traveled: "+land.getKilometraz()+" Km, Max speed of :"+land.getMaxSpeed()+" Mph"+" "
	 +"can carry max of : "+land.getMaxPassengers()+" people , Number of wheels:"+land.getNumberOfWheels()+ " ,road type: "+land.getRoadType() +", Wind Direction: "+
				 this.getWindDirection()+ " Country flag: " +water.toString();
	 }
}
