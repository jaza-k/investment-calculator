package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SetupController {
	
	static InvestmentApp app;

	public void linkWithApplication(InvestmentApp app) {
		SetupController.app = app;
	}
	
    @FXML
    private TextField ageTextfield;

    @FXML
    private Button continueButton;

    @FXML
    private TextField nameTextfield;

    @FXML
    private Label title;

    @FXML
    void loadInputView(ActionEvent event) {
    	app.inputView();
    }

}
