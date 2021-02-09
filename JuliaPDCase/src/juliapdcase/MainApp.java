package juliapdcase;
/**
 *
 * @author Júlia Gonzaga
 */

import juliapdcase.model.Person;
import juliapdcase.view.PersonEditDialogController;
import juliapdcase.view.PersonOverviewController;
import juliapdcase.view.RootLayoutController;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<Person> personData;

    public MainApp() {
        personData = FXCollections.observableArrayList();
        personData.add(new Person("Ana", "Silva"));
        personData.add(new Person("Marina", "Moreira"));
        personData.add(new Person("Luiz", "Braga"));
        personData.add(new Person("Matheus", "Viana"));
        personData.add(new Person("Felipe", "Gonzaga"));
        personData.add(new Person("Daiana", "Melo"));
        personData.add(new Person("Naiara", "Avelar"));
        personData.add(new Person("Márcio", "Pacheco"));
        personData.add(new Person("Sofia", "Lana"));
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PD Case");

        Preferences preferences = Preferences.userNodeForPackage(MainApp.class);
        
        this.primaryStage.getIcons()
                .add(new Image("file:resources/images/address_book_32.png"));

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            RootLayoutController controller = loader.getController();
            

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
 
    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
