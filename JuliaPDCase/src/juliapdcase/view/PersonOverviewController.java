package juliapdcase.view;
/**
 *
 * @author Júlia Gonzaga
 */
import juliapdcase.util.AlertFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import juliapdcase.MainApp;
import juliapdcase.model.Person;
import juliapdcase.util.DateUtil;
import javafx.scene.control.Alert.AlertType;

public class PersonOverviewController implements Controller{
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nomePacienteColumn;
    @FXML
    private TableColumn<Person, String> sobrenomePacienteColumn;

    @FXML
    private Label nomePacienteLabel;
    @FXML
    private Label sobrenomePacienteLabel;
    @FXML
    private Label idPlanoDeSaudeLabel;
    @FXML
    private Label numeroCarteiraPlanoLabel;
    @FXML
    private Label idEspecialidadeLabel;
    @FXML
    private Label birthdayLabel;

    private MainApp mainApp;

    public PersonOverviewController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(mainApp.getPersonData());
    }

    @FXML
    private void initialize() {
        nomePacienteColumn.setCellValueFactory(cellData -> cellData.getValue().nomePacienteProperty());
        sobrenomePacienteColumn.setCellValueFactory(cellData -> cellData.getValue().sobrenomePacienteProperty());
        
        showPersonDetails(null);
        
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue)
        );
    }
    
    @FXML
    private void handleDeletePerson(){
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        try{
            personTable.getItems().remove(selectedIndex);
        }catch(ArrayIndexOutOfBoundsException e){
            String title = "Nenhuma seleção";
            String headerText = "Nenhuma Pessoa Selecionada";
            String contentText = "Por favor, selecione uma pessoa na tabela.";
            AlertFactory.createAlert(AlertType.WARNING, title, headerText, contentText);
        }
    }
    
   @FXML
   private void handleNewPerson() {
       Person tempPerson = new Person();
       boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
       if (okClicked) {
           mainApp.getPersonData().add(tempPerson);
       }
   }

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            String title = "Nenhuma seleção";
            String headerText = "Nenhuma Pessoa Selecionada";
            String contentText = "Por favor, selecione uma pessoa na tabela.";
            
            AlertFactory.createAlert(AlertType.WARNING, title, headerText, contentText);
        }
    }
    
    private void showPersonDetails(Person person) {
        if(person != null) {
            nomePacienteLabel.setText(person.getNomePaciente());
            sobrenomePacienteLabel.setText(person.getSobrenomePaciente());
            idPlanoDeSaudeLabel.setText(person.getIdPlanoDeSaude());
            numeroCarteiraPlanoLabel.setText(Integer.toString(person.getNumeroCarteiraPlano()));
            idEspecialidadeLabel.setText(person.getIdEspecialidade());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            nomePacienteLabel.setText("");
            sobrenomePacienteLabel.setText("");
            idPlanoDeSaudeLabel.setText("");
            numeroCarteiraPlanoLabel.setText("");
            idEspecialidadeLabel.setText("");
            birthdayLabel.setText("");
        }
    }
}
