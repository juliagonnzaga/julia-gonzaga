package juliapdcase.view;
/**
 *
 * @author Júlia Gonzaga
 */
import juliapdcase.util.AlertFactory;
import juliapdcase.MainApp;
import juliapdcase.model.Person;
import java.io.File;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class RootLayoutController implements Controller{
    private MainApp mainApp;
    //private FileHandler<Person> fileHandler;
    private ObservableList<Person> personData;
    
    public void setMainAppAndFileHandler(MainApp mainApp){
        this.mainApp = mainApp;
        personData = mainApp.getPersonData();
        
    }
    
    @FXML
    private void handleAbout() {
        String title = "PD Case";
        String headerText = "Sobre: Esse é um Exercício Técnico Solicitado pela PD Case Informática LTDA!";
        String contentText = "Autor: Júlia Gonzaga";

        AlertFactory.createAlert(AlertType.INFORMATION, title, headerText, contentText);
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
}
