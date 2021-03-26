package ua.khpi.oop.zanochkyn16.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ua.khpi.oop.zanochkyn16.MainApp;
import ua.khpi.oop.zanochkyn16.model.Client;
import ua.khpi.oop.zanochkyn16.util.DateUtil;

public class ClientOverviewController
{
	@FXML private TableView<Client> clientListTable;
	@FXML private TableColumn<Client, String> genderColumn;
	@FXML private TableColumn<Client, Integer> ageColumn;
	@FXML private Label clientGenderLabel;
    @FXML private Label idLabel;
    @FXML private Label registrationDateLabel;
    @FXML private Label clientNameLabel;
    @FXML private Label clientAgeLabel;
    @FXML private Label clientHeightLabel;
    @FXML private Label clientEyeColourLabel;
    @FXML private Label clientHobbiesLabel;
    @FXML private Label partnerGenderLabel;
    @FXML private Label partnerMinAgeLabel;
    @FXML private Label partnerMaxAgeLabel;
    @FXML private Label partnerHobbiesLabel;
    
    private MainApp mainApp;
    
    public ClientOverviewController() {}
    
    @FXML
    private void initialize()
    {
    	genderColumn.setCellValueFactory(cellData -> cellData.getValue().clientGenderProperty());
    	ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
    	
    	// Clear client details.
        showClientDetails(null);

        // Listen for selection changes and show the client details when changed.
        clientListTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClientDetails(newValue));
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp)
    {
        this.mainApp = mainApp;
        clientListTable.setItems(mainApp.getClientList());
    }
    
    /**
     * Fills all text fields to show details about the client.
     * If the specified client is null, all text fields are cleared.
     * 
     * @param client the client or null
     */
    private void showClientDetails(Client client)
    {
        if (client != null)
        {
            // Fill the labels with info from the person object.
        	clientGenderLabel.setText(client.getClientGender());
        	idLabel.setText(Integer.toString(client.getId()));
        	registrationDateLabel.setText(DateUtil.format(client.getRegistrationDate()));
        	clientNameLabel.setText(client.getName());
        	clientAgeLabel.setText(Integer.toString(client.getAge()));
        	clientHeightLabel.setText(Integer.toString(client.getHeight()));
        	clientEyeColourLabel.setText(client.getEyeColour());
        	clientHobbiesLabel.setText(client.getClientHobbies());
        	partnerGenderLabel.setText(client.getPartnerGender());
            partnerMinAgeLabel.setText(Integer.toString(client.getMinAge()));
            partnerMaxAgeLabel.setText(Integer.toString(client.getMaxAge()));
            partnerHobbiesLabel.setText(client.getPartnerHobbies());
        }
        else
        {
            // Person is null, remove all the text.
        	clientGenderLabel.setText("");
        	idLabel.setText("");
        	registrationDateLabel.setText("");
        	clientNameLabel.setText("");
        	clientAgeLabel.setText("");
        	clientHeightLabel.setText("");
        	clientEyeColourLabel.setText("");
        	clientHobbiesLabel.setText("");
        	partnerGenderLabel.setText("");
            partnerMinAgeLabel.setText("");
            partnerMaxAgeLabel.setText("");
            partnerHobbiesLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteClient()
    {
        int selectedIndex = clientListTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0)
        	clientListTable.getItems().remove(selectedIndex);
        else
        {
        	// Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Client Selected");
            alert.setContentText("Please select a client in the table.");
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new client.
     */
    @FXML
    private void handleNewClient()
    {
        Client tempPerson = new Client();
        boolean result = false;
        boolean okClicked = mainApp.showClientEditDialog(tempPerson);
        if (okClicked)
        {
        	for (Client element : mainApp.getClientList())
        	{
        		result = tempPerson.equals(element);
        		if (result)
        			break;
        	}
        	if (!result)
        		mainApp.getClientList().add(tempPerson);
            else
            {
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Result of search");
                alert.setHeaderText("This element is in the list");
                alert.showAndWait();
            }
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected client.
     */
    @FXML
    private void handleEditClient()
    {
        Client selectedPerson = clientListTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null)
        {
            boolean okClicked = mainApp.showClientEditDialog(selectedPerson);
            if (okClicked)
                showClientDetails(selectedPerson);
        }
        else
        {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Client Selected");
            alert.setContentText("Please select a client in the table.");
            alert.showAndWait();
        }
    }
}