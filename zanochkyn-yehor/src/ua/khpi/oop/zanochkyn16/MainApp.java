package ua.khpi.oop.zanochkyn16;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ua.khpi.oop.zanochkyn16.model.Client;
import ua.khpi.oop.zanochkyn16.model.ClientListWrapper;
import ua.khpi.oop.zanochkyn16.view.ClientEditDialogController;
import ua.khpi.oop.zanochkyn16.view.ClientOverviewController;
import ua.khpi.oop.zanochkyn16.view.RootLayoutController;

public class MainApp extends Application
{
	private ObservableList<Client> clientList = FXCollections.observableArrayList();
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dating Office");
        this.primaryStage.getIcons().add(new Image("file:D:\\Eclipse_Workspace\\zanochkyn-yehor\\src\\ua\\khpi\\oop\\zanochkyn16\\thumbnail.jpg"));
        initRootLayout();
        showClientOverview();
    }
    
    public MainApp()
    {
    	clientList.add(new Client("Male", 1, LocalDate.now(), "Yehor", 19, 185, "Blue", "Video games, Music", "Female", 18, 25, "None"));
    	clientList.add(new Client("Female", 2, LocalDate.now(), "Kate", 18, 170, "Green", "Art", "Male", 18, 25, "Music"));
    }
   
 	/**
 	 * Returns the data as an observable list of client's. 
 	 * @return
 	 */
 	public ObservableList<Client> getClientList()
 	{
 		return clientList;
 	}
 	
    /**
     * Initializes the root layout.
     */
    public void initRootLayout()
    {
        try
        {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
 	        primaryStage.setScene(scene);
 	        RootLayoutController controller = loader.getController();
 	        controller.setMainApp(this);
 	        primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Shows the client overview inside the root layout.
     */
    public void showClientOverview()
    {
        try
        {
            // Load client overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ClientOverview.fxml"));
            AnchorPane clientListOverview = (AnchorPane) loader.load();

            // Set client overview into the center of root layout.
            rootLayout.setCenter(clientListOverview);
            
            ClientOverviewController controller = loader.getController();
            controller.setMainApp(this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified client. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param client the client object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showClientEditDialog(Client client)
    {
        try
        {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ClientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Client");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the client into the controller.
            ClientEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setClient(client);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.isOkClicked();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    /**
     * Saves the current client data to the specified file.
     * 
     * @param file
     */
    public void saveClientsToXMLFile(File file)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(ClientListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Wrapping our person data.
            ClientListWrapper wrapper = new ClientListWrapper();
            wrapper.setClients(clientList);
            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);
        }
        catch (Exception e)
        { 	// catches ANY exception
        	e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());
            alert.showAndWait();
        }
    }
    
    /**
     * Loads client data from the specified file. The current client data will
     * be replaced.
     */
    public void loadClientsFromXMLFile(File file)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(ClientListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            ClientListWrapper wrapper = (ClientListWrapper) um.unmarshal(file);
            clientList.clear();
            clientList.addAll(wrapper.getClients());
        }
        catch (Exception e)
        { 	// catches ANY exception
        	e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            alert.showAndWait();
        }
    }
}