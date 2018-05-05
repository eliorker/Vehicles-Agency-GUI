package vehiclesClasses;
import Vehicles.WaterVehicles;
import Interface.CommercialUse;
import Interface.MotorizedVehicle;
public class CruiseShip extends WaterVehicles implements CommercialUse,MotorizedVehicle {

	private float AverageFuelConsumption;
	private final String LicenseType = "Unlimited";
	private int EngineLife ;
	
	/**
	 * @param maxPassengers
	 * @param maxSpeed
	 * @param model
	 * @param windDirection
	 * @param countryFlag
	 * @param averageFuelConsumption
	 * @param engineLife
	 */
	public CruiseShip(int maxPassengers, int maxSpeed, String model ,  String countryFlag,
			float averageFuelConsumption, int engineLife) {
		super(maxPassengers, maxSpeed, model, "with the wind", countryFlag);
		AverageFuelConsumption = averageFuelConsumption;
		EngineLife = engineLife;
	}

	/**
	 * @return the size of the engine Life expected in years
	 */
	public int getEngineLife() {
		return EngineLife;
	}

	/**
	 * @return the size of the average Fuel Consumption by Liters
	 */
	public float getAverageFuelConsumption() {
		return AverageFuelConsumption;
	}

	@Override 
	public String GetAverageFuelConsumption() {
		return " Engine: " + AverageFuelConsumption + "L ";
	}

	@Override
	public String GetExpectedEngineLife() {
		return " lifetime of " + EngineLife + " year ";
	}

	@Override
	public String LicenseType() {
		return LicenseType;
	}
	
	@Override
	 public String toString() {
		 return "Cruise Ship: Model: "+this.getModel()+" traveled: "+this.getKilometraz()+" Km, Max speed of :"+this.getMaxSpeed()+" Mph"+" "
	 +"can carry max of : "+this.getMaxPassengers()+" people . Under *"+this.getCountryFlag()+"* flag, "+this.getWindDirection()+", "+this.GetAverageFuelConsumption()+", "+this.GetExpectedEngineLife()+"License Type : "+this.LicenseType();
	 }
	 
	@Override
	public boolean equals(Object other) {
			boolean ans =false;
			if (other instanceof CruiseShip) {
				ans = super.equals(other) && this.EngineLife== ((CruiseShip)other).getEngineLife() && this.AverageFuelConsumption ==((CruiseShip)other).getAverageFuelConsumption() ; 
			}
			return ans;
		}
	
}