package provincialScenes;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import connectivity.ConnectionClass;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable {
	@FXML
	private Stage primaryStage;
	private Scene scene;
	private Parent root;
	
	// Text fields for DriverScene
	@FXML
	private TextField LicenseTextField;
	@FXML
	private TextField RegistrationTextField;
	@FXML
	private TextField DriverFNTextField;
	@FXML
	private TextField DriverLNTextField;
	@FXML
	private CheckBox LicenseSuspendedCB;//driver
	@FXML
	private CheckBox LicenseRevokedCB;//driver
	@FXML
	private CheckBox OutstandingWarrantsCB;//driver
	@FXML
	private CheckBox VRegisteredCB;//vehicle
	@FXML
	private CheckBox VStolenCB;//vehicle
	@FXML
	private CheckBox VWantedCB;//vehicle

	public void VehicleInfoScreen(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ProvincialVehicleScene.fxml"));
		primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root, 900, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public void DriverInfoScreen(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ProvincialDriverScene.fxml"));
		primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root, 900, 600);
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

	public void LicenseSearch(ActionEvent e) { // search button 1
		
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();

		String pullQuery = "SELECT * FROM provincialgovernmenttable";

		try {
			Statement statement = connection.createStatement();
			ResultSet queryOutput = statement.executeQuery(pullQuery);
			
			while(queryOutput.next()) {
				LicenseTextField.setText(queryOutput.getString("LicenseNumber"));
				RegistrationTextField.setText(queryOutput.getString("RegistrationNumber"));
				DriverFNTextField.setText(queryOutput.getString("DriverFirstName"));
				DriverLNTextField.setText(queryOutput.getString("DriverLastName"));
				
//				if (queryOutput.getInt("DStatusLicenseSuspended") == 1) {
//					LicenseSuspendedCB.setSelected(true);
//				}else if(queryOutput.getInt("DStatusLicenseSuspended") == 0) {
//					LicenseSuspendedCB.setSelected(false);
//				}
			}
				
			
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void RegistrationSearch(ActionEvent e) { // search button 2
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		
		String pullQuery = "SELECT * FROM provincialgovernmenttable";

		try {
			Statement statement = connection.createStatement();
			ResultSet queryOutput = statement.executeQuery(pullQuery);
			
			while(queryOutput.next()) {
				RegistrationTextField.setText(queryOutput.getString("RegistrationNumber"));
				LicenseTextField.setText(queryOutput.getString("LicenseNumber")); 
				DriverFNTextField.setText(queryOutput.getString("DriverFirstName"));
				DriverLNTextField.setText(queryOutput.getString("DriverLastName"));
			}
				
			
		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	public void VehicleUpdate(ActionEvent e) {

	}

	public void VehicleDiscard(ActionEvent e) {
		//For Vehicle field 
		LicenseTextField.setText("");
		RegistrationTextField.setText("");
		DriverFNTextField.setText("");
		DriverLNTextField.setText("");
		VRegisteredCB.setSelected(false);//vehicle
		VStolenCB.setSelected(false);//vehicle
		VWantedCB.setSelected(false);//vehicle
		
	}

	public void DriverUpdate(ActionEvent e) {


//		 LicenseTextField.getText();
//		 RegistrationTextField.getText();
//		 DriverFNTextField.getText();
//		 DriverLNTextField.getText();
	}

	public void DriverDiscard(ActionEvent e) {
		//For driver field 
		LicenseTextField.setText("");
		RegistrationTextField.setText("");
		DriverFNTextField.setText("");
		DriverLNTextField.setText("");
		LicenseSuspendedCB.setSelected(false);//driver
		LicenseRevokedCB.setSelected(false);//driver
		OutstandingWarrantsCB.setSelected(false);//driver
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}