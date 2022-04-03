package provincialScenes;

public class VehicleTables {
	String VAmountDuefield, VdateCreatedfield, Registrationfield, ParkingViolationsfield, FixitTicketStatusfield;

	public VehicleTables(String vAmountDuefield, String vdateCreatedfield, String registrationfield,
			String parkingViolationsfield, String fixitTicketStatusfield) {
		super();
		VAmountDuefield = vAmountDuefield;
		VdateCreatedfield = vdateCreatedfield;
		Registrationfield = registrationfield;
		ParkingViolationsfield = parkingViolationsfield;
		FixitTicketStatusfield = fixitTicketStatusfield;
	}

	public String getVAmountDuefield() {
		return VAmountDuefield;
	}

	public void setVAmountDuefield(String vAmountDuefield) {
		VAmountDuefield = vAmountDuefield;
	}

	public String getVdateCreatedfield() {
		return VdateCreatedfield;
	}

	public void setVdateCreatedfield(String vdateCreatedfield) {
		VdateCreatedfield = vdateCreatedfield;
	}

	public String getRegistrationfield() {
		return Registrationfield;
	}

	public void setRegistrationfield(String registrationfield) {
		Registrationfield = registrationfield;
	}

	public String getParkingViolationsfield() {
		return ParkingViolationsfield;
	}

	public void setParkingViolationsfield(String parkingViolationsfield) {
		ParkingViolationsfield = parkingViolationsfield;
	}

	public String getFixitTicketStatusfield() {
		return FixitTicketStatusfield;
	}

	public void setFixitTicketStatusfield(String fixitTicketStatusfield) {
		FixitTicketStatusfield = fixitTicketStatusfield;
	}

		
	
}
