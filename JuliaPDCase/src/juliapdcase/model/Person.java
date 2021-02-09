package juliapdcase.model;
/**
 *
 * @author Júlia Gonzaga
 */

import juliapdcase.util.LocalDateAdapter;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Person {

    private final StringProperty nomePaciente;
    private final StringProperty sobrenomePaciente;
    private final StringProperty idPlanoDeSaude;
    private final IntegerProperty numeroCarteiraPlano;
    private final StringProperty idEspecialidade;
    private final ObjectProperty<LocalDate> birthday;

    public Person() {
        this(null, null);
    }
    
    public Person(String nomePaciente, String sobrenomePaciente) {
        this.nomePaciente = new SimpleStringProperty(nomePaciente);
        this.sobrenomePaciente = new SimpleStringProperty(sobrenomePaciente);
        
        this.idPlanoDeSaude = new SimpleStringProperty("SUS, IPSM, Unimed...");
        this.numeroCarteiraPlano = new SimpleIntegerProperty(3321);
        this.idEspecialidade = new SimpleStringProperty("Pediatria, Neurologia...");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(1972, 1, 8));
    }
    
    public String getNomePaciente() {
        return nomePaciente.get();
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente.set(nomePaciente);
    }
    
    public StringProperty nomePacienteProperty() {
        return nomePaciente;
    }

    public String getSobrenomePaciente() {
        return sobrenomePaciente.get();
    }

    public void setSobrenomePaciente(String sobrenomePaciente) {
        this.sobrenomePaciente.set(sobrenomePaciente);
    }
    
    public StringProperty sobrenomePacienteProperty() {
        return sobrenomePaciente;
    }

    public String getIdPlanoDeSaude() {
        return idPlanoDeSaude.get();
    }

    public void setIdPlanoDeSaude(String idPlanoDeSaude) {
        this.idPlanoDeSaude.set(idPlanoDeSaude);
    }
    
    public StringProperty idPlanoDeSaudeProperty() {
        return idPlanoDeSaude;
    }

    public int getNumeroCarteiraPlano() {
        return numeroCarteiraPlano.get();
    }

    public void setNumeroCarteiraPlano(int postalCode) {
        this.numeroCarteiraPlano.set(postalCode);
    }
    
    public IntegerProperty numeroCarteiraPlanoProperty() {
        return numeroCarteiraPlano;
    }

    public String getIdEspecialidade() {
        return idEspecialidade.get();
    }

    public void setIdEspecialidade(String idEspecialidade) {
        this.idEspecialidade.set(idEspecialidade);
    }
    
    public StringProperty idEspecialidadeProperty() {
        return idEspecialidade;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
    
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
}
