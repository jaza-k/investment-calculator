package application;

/**
 * SetupController class which loads the first scene of the application
 * 
 * @author Jaza Khan
 * @author Richi Patel
 *
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Creator;

public class SetupController {
	
	/** InvestmentApp instance variable to link files */
	private static InvestmentApp app;
	
	/** instance variables for all elements with IDs*/
    @FXML
    private TextField ageTextfield;

    @FXML
    private Button continueButton;

    @FXML
    private TextField nameTextfield;

    @FXML
    private Label title;
    
    /** 
     * linkWithApplication() method
     * Method which links the controller file to application class
     * 
     * @param an instance of InvestmentApp class
     */
	void linkWithApplication(InvestmentApp app) {
		SetupController.app = app;
	}

	/** 
	 * loadInputView() method
	 * Saves the user input received so far in Factory instance variables
	 * and then calls inputView() in InvestmentApp class to get the next view
	 * 
	 * @param Button click event for the <code>continueButton</code> button
	 * 
	 */
    @FXML
    void loadInputView(ActionEvent event) {
    	Creator.getInstance().setCurrentAge(Integer.parseInt(ageTextfield.getText()));
    	Creator.getInstance().setName(nameTextfield.getText());
    	app.inputView();
    }

}
