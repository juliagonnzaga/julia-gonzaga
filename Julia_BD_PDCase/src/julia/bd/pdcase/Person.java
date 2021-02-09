/*
@author Júlia Gonzaga
*/

package julia.bd.pdcase;

import java.time.LocalDate;

public class Person{

    private Long id;
    private String nomePaciente;
    private String sobrenomePaciente;
    private String idPlanoDeSaude;
    private Integer numeroCarteiraPlano;
    private String idEspecialidade;
    private LocalDate birthday;

    public Person() {
        this("", "");
    }

    public Person(String nomePaciente, String sobrenomePaciente) {
        this.nomePaciente = nomePaciente;
        this.sobrenomePaciente = sobrenomePaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getSobrenomePaciente() {
        return sobrenomePaciente;
    }

    public void setSobrenomePaciente(String sobrenomePaciente) {
        this.sobrenomePaciente = sobrenomePaciente;
    }

    public String getIdPlanoDeSaude() {
        return idPlanoDeSaude;
    }

    public void setIdPlanoDeSaude(String idPlanoDeSaude) {
        this.idPlanoDeSaude = idPlanoDeSaude;
    }

    public Integer getNumeroCarteiraPlano() {
        return numeroCarteiraPlano;
    }

    public void setNumeroCarteiraPlano(Integer numeroCarteiraPlano) {
        this.numeroCarteiraPlano = numeroCarteiraPlano;
    }

    public String getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(String idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}