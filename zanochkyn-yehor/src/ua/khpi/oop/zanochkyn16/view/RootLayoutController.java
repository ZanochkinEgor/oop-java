package ua.khpi.oop.zanochkyn16.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import ua.khpi.oop.zanochkyn16.MainApp;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 */
public class RootLayoutController
{
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp)
    {
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew()
    {
        mainApp.getClientList().clear();
    }
    
    @FXML
    private void handleSaveXMLFile()
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (file != null)
        {
            if (!file.getPath().endsWith(".xml"))
                file = new File(file.getPath() + ".xml");
            mainApp.saveClientsToXMLFile(file);
        }
    }

    @FXML
    private void handleOpenXMLFile()
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (file != null)
            mainApp.loadClientsFromXMLFile(file);
    }

    @FXML
    private void handleAbout()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About window");
        alert.setHeaderText("About");
        alert.setContentText("Author: Zanochkyn Yehor\nGroup: KIT-119a");
        alert.showAndWait();
    }
}