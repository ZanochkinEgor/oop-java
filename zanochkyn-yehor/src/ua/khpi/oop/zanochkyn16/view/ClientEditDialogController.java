package ua.khpi.oop.zanochkyn16.view;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ua.khpi.oop.zanochkyn16.model.Client;
import ua.khpi.oop.zanochkyn16.util.DateUtil;

/**
 * Dialog to edit details of a client.
 */
public class ClientEditDialogController
{
    @FXML private TextField idField;
    @FXML private TextField registrationDateField;
    @FXML private TextField clientNameField;
    @FXML private TextField clientAgeField;
    @FXML private TextField clientHeightField;
    @FXML private TextField clientEyeColourField;
    @FXML private TextField clientHobbiesField;
    @FXML private TextField partnerMinAgeField;
    @FXML private TextField partnerMaxAgeField;
    @FXML private TextField partnerHobbiesField;
    @FXML private ComboBox<String> clientGenderComboBox;
    @FXML private ComboBox<String> partnerGenderComboBox;

    private Stage dialogStage;
    private Client client;
    private boolean okClicked = false;
    private static int ID = 3;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize()
    {
    	ObservableList<String> langs = FXCollections.observableArrayList("Male", "Female");
        clientGenderComboBox.setItems(langs);
        partnerGenderComboBox.setItems(langs);
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) { this.dialogStage = dialogStage; }

    /**
     * Sets the client to be edited in the dialog.
     * 
     * @param client
     */
    public void setClient(Client client)
    {
        this.client = client;
        if(client.getClientGender() != null)
        {
	    	idField.setText(Integer.toString(client.getId()));
	    	registrationDateField.setText(DateUtil.format(client.getRegistrationDate()));
	    	registrationDateField.setPromptText("dd.mm.yyyy");
	    	clientGenderComboBox.getSelectionModel().select(client.getClientGender());
	    	clientNameField.setText(client.getName());
	    	clientAgeField.setText(Integer.toString(client.getAge()));
	    	clientHeightField.setText(Integer.toString(client.getHeight()));
	    	clientEyeColourField.setText(client.getEyeColour());
	    	clientHobbiesField.setText(client.getClientHobbies());
	    	partnerGenderComboBox.getSelectionModel().select(client.getPartnerGender());
	        partnerMinAgeField.setText(Integer.toString(client.getMinAge()));
	        partnerMaxAgeField.setText(Integer.toString(client.getMaxAge()));
	        partnerHobbiesField.setText(client.getPartnerHobbies());
        }
        else
        {
        	idField.setText(Integer.toString(ID++));
	    	registrationDateField.setText(DateUtil.format(LocalDate.now()));
	    	clientGenderComboBox.setValue("");
	    	clientNameField.setText("");
	    	clientAgeField.setText("");
	    	clientHeightField.setText("");
	    	clientEyeColourField.setText("");
	    	clientHobbiesField.setText("");
	    	partnerGenderComboBox.setValue("");
	        partnerMinAgeField.setText("");
	        partnerMaxAgeField.setText("");
	        partnerHobbiesField.setText("");
        }
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() { return okClicked; }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk()
    {
        if (isInputValid())
        {
        	client.setId(Integer.parseInt(idField.getText()));
        	client.setRegistrationDate(DateUtil.parse(registrationDateField.getText()));
        	client.setClientGender(clientGenderComboBox.getValue());
        	client.setName(clientNameField.getText());
        	client.setAge(Integer.parseInt(clientAgeField.getText()));
        	client.setHeight(Integer.parseInt(clientHeightField.getText()));
        	client.setEyeColour(clientEyeColourField.getText());
        	client.setClientHobbies(clientHobbiesField.getText());
        	client.setPartnerGender(partnerGenderComboBox.getValue());
        	client.setMinAge(Integer.parseInt(partnerMinAgeField.getText()));
        	client.setMaxAge(Integer.parseInt(partnerMaxAgeField.getText()));
        	client.setPartnerHobbies(partnerHobbiesField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() { dialogStage.close(); }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid()
    {
        String errorMessage = "";
        Pattern patternId = Pattern.compile("\\d+");
        Pattern patternRegistrationDay = Pattern.compile("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(19|20)\\d{2}");
        Pattern patternName = Pattern.compile("^([a-zA-Z]+)");
		Pattern patternAge = Pattern.compile("^(([1-9])|([1-9][0-9]))");
		Pattern patternHeight = Pattern.compile("^(([1-9])|([1-9][0-9])|([1-2][0-9][0-9]))");
		Pattern patternEyeColour = Pattern.compile("^([a-zA-Z]+)");
		Pattern patternHobby = Pattern.compile("^(([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)(,\\s([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+))*)");
		
		Matcher matcher = patternId.matcher(idField.getText());
        if (!matcher.matches())
            errorMessage += "No valid ID!\n";
        
        matcher = patternRegistrationDay.matcher(registrationDateField.getText());
        if (!matcher.matches())
            errorMessage += "No valid registration date!\n";
        
        matcher = patternName.matcher(clientNameField.getText());
        if (!matcher.matches())
            errorMessage += "No valid name!\n";
        
        matcher = patternAge.matcher(clientAgeField.getText());
        if (!matcher.matches())
            errorMessage += "No valid age!\n";
        
        matcher = patternHeight.matcher(clientHeightField.getText());
        if (!matcher.matches())
            errorMessage += "No valid height!\n";
        
        matcher = patternEyeColour.matcher(clientEyeColourField.getText());
        if (!matcher.matches())
            errorMessage += "No valid eye colour!\n";
        
        matcher = patternHobby.matcher(clientHobbiesField.getText());
        if (!matcher.matches())
            errorMessage += "No valid client hobbies!\n";
        
        matcher = patternAge.matcher(partnerMinAgeField.getText());
        if (!matcher.matches())
            errorMessage += "No valid min age!\n";
        
        matcher = patternAge.matcher(partnerMaxAgeField.getText());
        if (!matcher.matches())
            errorMessage += "No valid max age!\n";
        
        matcher = patternHobby.matcher(partnerHobbiesField.getText());
        if (!matcher.matches())
            errorMessage += "No valid partner hobbies!\n";

        if (errorMessage.length() == 0)
            return true;
        else
        {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}