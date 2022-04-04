package provincialScenes;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Function;

import connectivity.ConnectionClass;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller implements Initializable {
	@FXML
	private Stage primaryStage;
	private Scene scene;
	private Parent root;

	// FIELDS
	@FXML
	private TextField LicenseTextField;
	@FXML
	private TextField RegistrationTextField;
	@FXML
	private TextField DriverFNTextField;
	@FXML
	private TextField DriverLNTextField;
	@FXML
	private CheckBox LicenseSuspendedCB;// driver
	@FXML
	private CheckBox LicenseRevokedCB;// driver
	@FXML
	private CheckBox OutstandingWarrantsCB;// driver
	@FXML
	private CheckBox VRegisteredCB;// vehicle
	@FXML
	private CheckBox VStolenCB;// vehicle
	@FXML
	private CheckBox VWantedCB;// vehicle
	// TABLES
	@FXML
	private TableView<Provincialtables> Provincialtables;
	@FXML
	private TableColumn<Provincialtables, String> Licensefield;
	@FXML
	private TableColumn<Provincialtables, String> MovingVehicleViolationfield;
	@FXML
	private TableColumn<Provincialtables, String> MovingVehicleWarningfield;
	@FXML
	private TableColumn<Provincialtables, String> ArrestWarrantStatusfield;
	@FXML
	private TableColumn<Provincialtables, String> AmountDuefield;
	@FXML
	private TableColumn<Provincialtables, String> dateCreatedfield;
	@FXML
	private TableColumn<Provincialtables, String> Registrationfield;
	@FXML
	private TableColumn<Provincialtables, String> ParkingViolationsfield;
	@FXML
	private TableColumn<Provincialtables, String> FixitTicketStatusfield;
	// for our tableview import
	private ObservableList<Provincialtables> oblist = FXCollections.observableArrayList();
	private String updatequery;

	public void VehicleInfoScreen(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ProvincialVehicleScene.fxml"));
		primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root, 650, 450);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void DriverInfoScreen(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ProvincialDriverScene.fxml"));
		primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public Scene getScene() {
		return scene;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	// File>Exit
	public void Exit(ActionEvent e) {
		Platform.exit();
	}

//Driver License Search
	public void DLicenseSearch(ActionEvent e) { // search button 1

		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		String pullQuery = "SELECT * FROM provincialgovernmenttable WHERE LicenseNumber =?";

		try {
			PreparedStatement pst = connection.prepareStatement(pullQuery);
			pst.setString(1, LicenseTextField.getText());
			ResultSet queryOutput = pst.executeQuery();

			while (queryOutput.next()) {
				LicenseTextField.setText(queryOutput.getString("LicenseNumber"));
				RegistrationTextField.setText(queryOutput.getString("RegistrationNumber"));
				DriverFNTextField.setText(queryOutput.getString("DriverFirstName"));
				DriverLNTextField.setText(queryOutput.getString("DriverLastName"));

				if (queryOutput.getBoolean("DStatusLicenseSuspended") == true) {
					LicenseSuspendedCB.setSelected(true);
				} else if (queryOutput.getBoolean("DStatusLicenseSuspended") == false) {
					LicenseSuspendedCB.setSelected(false);
				}

				if (queryOutput.getBoolean("DStatusLicenseRevoked") == true) {
					LicenseRevokedCB.setSelected(true);
				} else if (queryOutput.getBoolean("DStatusLicenseRevoked") == false) {
					LicenseRevokedCB.setSelected(false);
				}

				if (queryOutput.getBoolean("DStatusLicenseSuspended") == true) {
					LicenseSuspendedCB.setSelected(true);
				} else if (queryOutput.getBoolean("DStatusLicenseSuspended") == false) {
					LicenseSuspendedCB.setSelected(false);
				}
			}

		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	// Vehicle License Search
	public void VLicenseSearch(ActionEvent e) { // search button 1

		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();

		String pullQuery = "SELECT * FROM provincialgovernmenttable WHERE LicenseNumber =?";

		try {
			PreparedStatement pst = connection.prepareStatement(pullQuery);
			pst.setString(1, LicenseTextField.getText());
			ResultSet queryOutput = pst.executeQuery();

			while (queryOutput.next()) {
				LicenseTextField.setText(queryOutput.getString("LicenseNumber"));
				RegistrationTextField.setText(queryOutput.getString("RegistrationNumber"));
				DriverFNTextField.setText(queryOutput.getString("DriverFirstName"));
				DriverLNTextField.setText(queryOutput.getString("DriverLastName"));

				if (queryOutput.getBoolean("VstatusRegistered") == true) {
					VRegisteredCB.setSelected(true);
				} else if (queryOutput.getBoolean("VstatusRegistered") == false) {
					VRegisteredCB.setSelected(false);
				}

				if (queryOutput.getBoolean("VStatusStolen") == true) {
					VStolenCB.setSelected(true);
				} else if (queryOutput.getBoolean("VStatusStolen") == false) {
					VStolenCB.setSelected(false);
				}

				if (queryOutput.getBoolean("VStatusWanted") == true) {
					VWantedCB.setSelected(true);
				} else if (queryOutput.getBoolean("VStatusWanted") == false) {
					VWantedCB.setSelected(false);

				}
			}

		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	// Driver Registration Search
	public void DRegistrationSearch(ActionEvent e) { // search button 2
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();

		String pullQuery = "SELECT * FROM provincialgovernmenttable WHERE RegistrationNumber =?";

		try {
			PreparedStatement pst = connection.prepareStatement(pullQuery);
			pst.setString(1, RegistrationTextField.getText());
			ResultSet queryOutput = pst.executeQuery();

			while (queryOutput.next()) {
				RegistrationTextField.setText(queryOutput.getString("RegistrationNumber"));
				LicenseTextField.setText(queryOutput.getString("LicenseNumber"));
				DriverFNTextField.setText(queryOutput.getString("DriverFirstName"));
				DriverLNTextField.setText(queryOutput.getString("DriverLastName"));

				if (queryOutput.getBoolean("DStatusLicenseSuspended") == true) {
					LicenseSuspendedCB.setSelected(true);
				} else if (queryOutput.getBoolean("DStatusLicenseSuspended") == false) {
					LicenseSuspendedCB.setSelected(false);
				}

				if (queryOutput.getBoolean("DStatusLicenseRevoked") == true) {
					LicenseRevokedCB.setSelected(true);
				} else if (queryOutput.getBoolean("DStatusLicenseRevoked") == false) {
					LicenseRevokedCB.setSelected(false);
				}

				if (queryOutput.getBoolean("DStatusLicenseSuspended") == true) {
					LicenseSuspendedCB.setSelected(true);
				} else if (queryOutput.getBoolean("DStatusLicenseSuspended") == false) {
					LicenseSuspendedCB.setSelected(false);
				}
			}

		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	// Vehicle Registration Search
	public void VRegistrationSearch(ActionEvent e) { // search button 2
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();

		String pullQuery = "SELECT * FROM provincialgovernmenttable WHERE RegistrationNumber =?";

		try {

			PreparedStatement pst = connection.prepareStatement(pullQuery);
			pst.setString(1, RegistrationTextField.getText());
			ResultSet queryOutput = pst.executeQuery();

			while (queryOutput.next()) {
				RegistrationTextField.setText(queryOutput.getString("RegistrationNumber"));
				LicenseTextField.setText(queryOutput.getString("LicenseNumber"));
				DriverFNTextField.setText(queryOutput.getString("DriverFirstName"));
				DriverLNTextField.setText(queryOutput.getString("DriverLastName"));

				if (queryOutput.getBoolean("VstatusRegistered") == true) {
					VRegisteredCB.setSelected(true);
				} else if (queryOutput.getBoolean("VstatusRegistered") == false) {
					VRegisteredCB.setSelected(false);
				}

				if (queryOutput.getBoolean("VStatusStolen") == true) {
					VStolenCB.setSelected(true);
				} else if (queryOutput.getBoolean("VStatusStolen") == false) {
					VStolenCB.setSelected(false);
				}

				if (queryOutput.getBoolean("VStatusWanted") == true) {
					VWantedCB.setSelected(true);
				} else if (queryOutput.getBoolean("VStatusWanted") == false) {
					VWantedCB.setSelected(false);

				}
			}

		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	public void VehicleDiscard(ActionEvent e) {
		// For Vehicle field
		LicenseTextField.setText("");
		RegistrationTextField.setText("");
		DriverFNTextField.setText("");
		DriverLNTextField.setText("");
		VRegisteredCB.setSelected(false);// vehicle
		VStolenCB.setSelected(false);// vehicle
		VWantedCB.setSelected(false);// vehicle

	}

	// for our update/insert
	private void UpdateQuery() {
		updatequery = "INSERT INTO provincialgovernmenttable(LicenseNumber, RegistrationNumber, DriverFirstName, DriverLastName, DStatusLicenseSuspended, DStatusLicenseRevoked, DStatusOutstandingWarrants, VstatusRegistered, VStatusStolen, VStatusWanted) VALUES (?,?,?,?,?,?,?,?,?,?)";

	}

	private void driverinsert() {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection iConnect = connectionClass.getConnection();
		PreparedStatement preparedStatement;

		try {

			preparedStatement = iConnect.prepareStatement(updatequery);
			preparedStatement.setString(1, LicenseTextField.getText());
			preparedStatement.setString(2, RegistrationTextField.getText());
			preparedStatement.setString(3, DriverFNTextField.getText());
			preparedStatement.setString(4, DriverLNTextField.getText());
			preparedStatement.setBoolean(5, LicenseSuspendedCB.isSelected());
			preparedStatement.setBoolean(6, LicenseRevokedCB.isSelected());
			preparedStatement.setBoolean(7, OutstandingWarrantsCB.isSelected());
			preparedStatement.setString(8, "0");
			preparedStatement.setString(9, "0");
			preparedStatement.setString(10, "0");

			// System.out.print("Error before execution");
			preparedStatement.execute();

			// System.out.print("Error after execution");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void vehicleinsert() {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection iConnect = connectionClass.getConnection();
		PreparedStatement preparedStatement;

		try {

			preparedStatement = iConnect.prepareStatement(updatequery);
			preparedStatement.setString(1, LicenseTextField.getText());
			preparedStatement.setString(2, RegistrationTextField.getText());
			preparedStatement.setString(3, DriverFNTextField.getText());
			preparedStatement.setString(4, DriverLNTextField.getText());
			preparedStatement.setString(5, "0");
			preparedStatement.setString(6, "0");
			preparedStatement.setString(7, "0");
			preparedStatement.setBoolean(8, VRegisteredCB.isSelected());
			preparedStatement.setBoolean(9, VStolenCB.isSelected());
			preparedStatement.setBoolean(10, VWantedCB.isSelected());

			// System.out.print("Error before execution");
			preparedStatement.execute();

			// System.out.print("Error after execution");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void VehicleUpdate(ActionEvent e) {

		try {
			UpdateQuery();
			vehicleinsert();
		} catch (Exception ex) {
			System.out.println("update failed");
			ex.printStackTrace();
		}
	}

	public void DriverUpdate(ActionEvent e) {
		try {
			UpdateQuery();
			driverinsert();
		} catch (Exception ex) {
			System.out.println("update failed");
			ex.printStackTrace();
		}

	}

	public void DriverDiscard(ActionEvent e) {
		// For driver field
		LicenseTextField.setText("");
		RegistrationTextField.setText("");
		DriverFNTextField.setText("");
		DriverLNTextField.setText("");
		LicenseSuspendedCB.setSelected(false);// driver
		LicenseRevokedCB.setSelected(false);// driver
		OutstandingWarrantsCB.setSelected(false);// driver
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ConnectionClass connectionClass = new ConnectionClass();
			Connection con = connectionClass.getConnection();
			ResultSet rs = con.createStatement().executeQuery("SELECT * from localgovernmenttable");

			while (rs.next()) {
				oblist.add(new Provincialtables(rs.getString("LicenseNum"), rs.getString("MovingVehicleViolations"),
						rs.getString("MovingVehicleWarnings"), rs.getString("ArrestWarrantStatus"),
						rs.getString("AmountDue"), rs.getString("dateCreated"), rs.getString("RegistrationNum"),
						rs.getString("ParkingViolations"), rs.getString("FixitTicketStatus")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Licensefield.setCellValueFactory(new PropertyValueFactory<>("LicenseNum"));
		MovingVehicleViolationfield.setCellValueFactory(new PropertyValueFactory<>("MovingVehicleViolations"));
		MovingVehicleWarningfield.setCellValueFactory(new PropertyValueFactory<>("MovingVehicleWarnings"));
		ArrestWarrantStatusfield.setCellValueFactory(new PropertyValueFactory<>("ArrestWarrantStatus"));
		AmountDuefield.setCellValueFactory(new PropertyValueFactory<>("AmountDue"));
		dateCreatedfield.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
		Registrationfield.setCellValueFactory(new PropertyValueFactory<>("RegistrationNum"));
		ParkingViolationsfield.setCellValueFactory(new PropertyValueFactory<>("ParkingViolations"));
		FixitTicketStatusfield.setCellValueFactory(new PropertyValueFactory<>("FixitTicketStatus"));

		Provincialtables.setItems(oblist);

	}
}