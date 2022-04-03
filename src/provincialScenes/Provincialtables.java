package provincialScenes;

public class Provincialtables {
	

	String LicenseNum, MovingVehicleViolations, MovingVehicleWarnings, ArrestWarrantStatus,
	AmountDue, dateCreated, RegistrationNum, ParkingViolations, FixitTicketStatus;

	public Provincialtables(String licenseNum, String movingVehicleViolations, String movingVehicleWarnings,
			String arrestWarrantStatus, String amountDue, String dateCreated, String registrationNum,
			String parkingViolations, String fixitTicketStatus) {
		super();
		LicenseNum = licenseNum;
		MovingVehicleViolations = movingVehicleViolations;
		MovingVehicleWarnings = movingVehicleWarnings;
		ArrestWarrantStatus = arrestWarrantStatus;
		AmountDue = amountDue;
		this.dateCreated = dateCreated;
		RegistrationNum = registrationNum;
		ParkingViolations = parkingViolations;
		FixitTicketStatus = fixitTicketStatus;
	}

	public String getLicenseNum() {
		return LicenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		LicenseNum = licenseNum;
	}

	public String getMovingVehicleViolations() {
		return MovingVehicleViolations;
	}

	public void setMovingVehicleViolations(String movingVehicleViolations) {
		MovingVehicleViolations = movingVehicleViolations;
	}

	public String getMovingVehicleWarnings() {
		return MovingVehicleWarnings;
	}

	public void setMovingVehicleWarnings(String movingVehicleWarnings) {
		MovingVehicleWarnings = movingVehicleWarnings;
	}

	public String getArrestWarrantStatus() {
		return ArrestWarrantStatus;
	}

	public void setArrestWarrantStatus(String arrestWarrantStatus) {
		ArrestWarrantStatus = arrestWarrantStatus;
	}

	public String getAmountDue() {
		return AmountDue;
	}

	public void setAmountDue(String amountDue) {
		AmountDue = amountDue;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getRegistrationNum() {
		return RegistrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		RegistrationNum = registrationNum;
	}

	public String getParkingViolations() {
		return ParkingViolations;
	}

	public void setParkingViolations(String parkingViolations) {
		ParkingViolations = parkingViolations;
	}

	public String getFixitTicketStatus() {
		return FixitTicketStatus;
	}

	public void setFixitTicketStatus(String fixitTicketStatus) {
		FixitTicketStatus = fixitTicketStatus;
	}

	

	
}
