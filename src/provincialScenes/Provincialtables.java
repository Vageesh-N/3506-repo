package provincialScenes;

public class Provincialtables {
	String Licensefield, MovingVehicleViolationfield, MovingVehicleWarningfield, ArrestWarrantStatusfield,
			AmountDuefield, dateCreatedfield;

	public Provincialtables(String licensefield, String movingVehicleViolationfield, String movingVehicleWarningfield,
			String arrestWarrantStatusfield, String amountDuefield, String dateCreatedfield) {
		super();
		Licensefield = licensefield;
		MovingVehicleViolationfield = movingVehicleViolationfield;
		MovingVehicleWarningfield = movingVehicleWarningfield;
		ArrestWarrantStatusfield = arrestWarrantStatusfield;
		AmountDuefield = amountDuefield;
		this.dateCreatedfield = dateCreatedfield;
	}

	public String getLicensefield() {
		return Licensefield;
	}

	public void setLicensefield(String licensefield) {
		Licensefield = licensefield;
	}

	public String getMovingVehicleViolationfield() {
		return MovingVehicleViolationfield;
	}

	public void setMovingVehicleViolationfield(String movingVehicleViolationfield) {
		MovingVehicleViolationfield = movingVehicleViolationfield;
	}

	public String getMovingVehicleWarningfield() {
		return MovingVehicleWarningfield;
	}

	public void setMovingVehicleWarningfield(String movingVehicleWarningfield) {
		MovingVehicleWarningfield = movingVehicleWarningfield;
	}

	public String getArrestWarrantStatusfield() {
		return ArrestWarrantStatusfield;
	}

	public void setArrestWarrantStatusfield(String arrestWarrantStatusfield) {
		ArrestWarrantStatusfield = arrestWarrantStatusfield;
	}

	public String getAmountDuefield() {
		return AmountDuefield;
	}

	public void setAmountDuefield(String amountDuefield) {
		AmountDuefield = amountDuefield;
	}

	public String getDateCreatedfield() {
		return dateCreatedfield;
	}

	public void setDateCreatedfield(String dateCreatedfield) {
		this.dateCreatedfield = dateCreatedfield;
	}

}
