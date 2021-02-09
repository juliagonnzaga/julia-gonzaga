package juliapdcase.view;
/**
 *
 * @author Júlia Gonzaga
 */
import juliapdcase.util.AlertFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.control.Alert.AlertType;

import juliapdcase.model.Person;
import juliapdcase.util.DateUtil;

public class PersonEditDialogController implements Controller{

    @FXML
    private TextField nomePacienteField;
    @FXML
    private TextField sobrenomePacienteField;
    @FXML
    private TextField idPlanoDeSaudeField;
    @FXML
    private TextField numeroCarteiraPlanoField;
    @FXML
    private TextField idEspecialidadeField;
    @FXML
    private TextField birthdayField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked;

    @FXML
    private void initialize() {
        okClicked = false;
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;

        nomePacienteField.setText(person.getNomePaciente());
        sobrenomePacienteField.setText(person.getSobrenomePaciente());
        idPlanoDeSaudeField.setText(person.getIdPlanoDeSaude());
        numeroCarteiraPlanoField.setText(Integer.toString(person.getNumeroCarteiraPlano()));
        idEspecialidadeField.setText(person.getIdEspecialidade());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNomePaciente(nomePacienteField.getText());
            person.setSobrenomePaciente(sobrenomePacienteField.getText());
            person.setIdPlanoDeSaude(idPlanoDeSaudeField.getText());
            person.setNumeroCarteiraPlano(Integer.parseInt(numeroCarteiraPlanoField.getText()));
            person.setIdEspecialidade(idEspecialidadeField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = constructErrorMessage();

        if (errorMessage.length() == 0) {
            return true;
        } else {
            String title = "Campos Inválidos";
            String headerText = "Por favor, corrija os campos inválidos";

            AlertFactory.createAlert(AlertType.ERROR, title, headerText, errorMessage);

            return false;
        }
    }

    private String constructErrorMessage() {
        String errorMessage = "";
        
        if (!isFieldValid(nomePacienteField)) {
            errorMessage += "Nome inválido!\n";
        }
        
        if (!isFieldValid(sobrenomePacienteField)) {
            errorMessage += "Sobrenome inválido!\n";
        }
        
        if (!isFieldValid(idPlanoDeSaudeField)) {
            errorMessage += "Plano de Saúde Inválido!\n";
        }
        
        if (!isFieldValid(numeroCarteiraPlanoField)) {
            errorMessage += "Número da Carteira Inválida!\n";
        } else {
            final String postalCodeTypeError = "Número da Carteira Inválida (deve ser um inteiro)!\n";
            errorMessage += constructErrorMessageIfFieldIsInvalid(postalCodeTypeError);
        }
        
        if (!isFieldValid(idEspecialidadeField)) {
            errorMessage += "Esta especialidade já esta´sendo utilizada por outro Plano!\n";
        }
        
        if (!isFieldValid(birthdayField)) {
            errorMessage += "Data Inválida!\n";
        } else {
            final String birthdayFieldInvalidDateMessage = "Data inválida. Use o formato dd.mm.yyyy!\n";
            errorMessage += handleDateFieldErrorMessageIFDateIsInvalid(birthdayFieldInvalidDateMessage);
        }
        
        return errorMessage;
    }

    private boolean isFieldValid(TextField field) {
        String text = field.getText();
        final boolean isFieldNull = (text == null);
        final boolean isFieldEmpty = (field.getText().length() == 0);
        boolean isInvalid = isFieldNull || isFieldEmpty;
        return !isInvalid;
    }

    private String constructErrorMessageIfFieldIsInvalid(String errorMessageIfInvalid) {
        String errorMessage = "";
        try {
            Integer.parseInt(numeroCarteiraPlanoField.getText());
        } catch (NumberFormatException e) {
            errorMessage += errorMessageIfInvalid;
        }
        return errorMessage;
    }

    private String handleDateFieldErrorMessageIFDateIsInvalid(String errorMessageIfInvalid) {
        String errorMessage = "";
        if (!DateUtil.validDate(birthdayField.getText())) {
            errorMessage = errorMessageIfInvalid;
        }
        return errorMessage;
    }
}
