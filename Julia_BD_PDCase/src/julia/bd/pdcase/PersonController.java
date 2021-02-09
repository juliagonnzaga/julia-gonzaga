/*
@author Júlia Gonzaga
*/

package julia.bd.pdcase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonController {
    Connection connection;
    public PersonController() {}
    public PersonController(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Person person) throws Exception {

        try {
            if (person == null) {
                throw new Exception("Entidade não pode ser nula.");
            }

            String sql = "INSERT INTO person (nomepaciente, sobrenomepaciente, idplanodesaude, numerocarteiraplano, idespecialidade, birthday) VALUES(?,?,?,?,?,?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, person.getNomePaciente());
            pstmt.setString(2, person.getSobrenomePaciente());
            pstmt.setString(3, person.getIdPlanoDeSaude());
            pstmt.setInt(4, person.getNumeroCarteiraPlano());
            pstmt.setString(5, person.getIdEspecialidade());
            pstmt.setDate(6, java.sql.Date.valueOf(person.getBirthday()));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Long id = rs.getLong("id");
                person.setId(id);
            }

            rs.close();
            pstmt.close();
    

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }
    }
    public void update(Person person) throws Exception {
        
        String sql = "UPDATE person "
                + "   SET nomepaciente = ?, "
                + "       sobrenomepaciente = ?, "
                + "       idplanodesaude = ?, "
                + "       numerocarteiraplano = ?, "
                + "       idespecialidade = ?, "
                + "       birthday = ? "
                + " WHERE id = ?;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, person.getNomePaciente());
        pstmt.setString(2, person.getSobrenomePaciente());
        pstmt.setString(3, person.getIdPlanoDeSaude());
        pstmt.setInt(4, person.getNumeroCarteiraPlano());
        pstmt.setString(5, person.getIdEspecialidade());
        pstmt.setDate(6, java.sql.Date.valueOf(person.getBirthday()));
        pstmt.setLong(7, person.getId());
        pstmt.executeUpdate();
        pstmt.close();

    }
    public Person getPersonById(Long personId) throws Exception {
        String sql = "SELECT * FROM person WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, personId);
        ResultSet rs = pstmt.executeQuery();
        Person person = null;
        if (rs.next()) {
            person = new Person();
            person.setId(rs.getLong("id"));
            person.setNomePaciente(rs.getString("Nome Paciente"));
            person.setSobrenomePaciente(rs.getString("Sobrenome Paciente"));
            person.setIdPlanoDeSaude(rs.getString("Id Plano de Saúde"));
            person.setNumeroCarteiraPlano(rs.getInt("Número Carteira Plano"));
            person.setIdEspecialidade(rs.getString("Id Especialidade"));
            person.setBirthday(rs.getDate("birthday").toLocalDate());
        }
        rs.close();
        pstmt.close();

        return person;
    }
    public Person delete(Long personId) throws Exception {

        try {
            Person person = this.getPersonById(personId);

            String sql = "DELETE FROM person WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, personId);
            pstmt.executeUpdate();

            pstmt.close();
    

            return person;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }
    }
    public List<Person> listAll() throws Exception {
        String sql = "SELECT * FROM person ORDER BY firstname, lastname;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Person> listAll = new ArrayList<>();
        if (rs.next()) {
            do {
                Person person = new Person();
                person.setId(rs.getLong("id"));
                person.setNomePaciente(rs.getString("Nome Paciente"));
                person.setSobrenomePaciente(rs.getString("Sobrenome Paciente"));
                person.setIdPlanoDeSaude(rs.getString("Id Plano de Saude"));
                person.setNumeroCarteiraPlano(rs.getInt("numero Carteira Plano"));
                person.setIdEspecialidade(rs.getString("Id Especialidade"));
                person.setBirthday(rs.getDate("birthday").toLocalDate());
                listAll.add(person);
            } while (rs.next());
        }
        rs.close();
        pstmt.close();

        return listAll;
    }
}
