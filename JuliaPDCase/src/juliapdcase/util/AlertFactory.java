package juliapdcase.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Júlia Gonzaga
 */
public abstract class AlertFactory {
    public static void createAlert(AlertType alertType, String title, String headerText, String contentText){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        
        alert.showAndWait();
    }
}
