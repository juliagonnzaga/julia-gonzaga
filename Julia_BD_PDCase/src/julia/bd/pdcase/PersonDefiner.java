/*
@author Júlia Gonzaga
*/

package julia.bd.pdcase;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class PersonDefiner {
    Connection connection;
    public PersonDefiner() {}
    public PersonDefiner(Connection connection) {
        this.connection = connection;
    }
    
    public void define(Person p) throws Exception{
        PersonController personController = new PersonController(connection);
        personController.insert(p);
        
        List<Person> pList = personController.listAll();
            
        for (Person q: pList)
            System.out.println(q.getNomePaciente() + " " + q.getSobrenomePaciente());
        connection.close();
    }
}
