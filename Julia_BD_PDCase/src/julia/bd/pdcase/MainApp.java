/*
@author Júlia Gonzaga
*/

package julia.bd.pdcase;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        Connection connection = null;
        try{
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            connection = connectionManager.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Person p = new Person();
        p.setNomePaciente(scr.nextLine());
        p.setSobrenomePaciente(scr.nextLine());
        p.setIdPlanoDeSaude(scr.nextLine());
        p.setNumeroCarteiraPlano(scr.nextInt());
        scr.nextLine();
        p.setIdEspecialidade(scr.nextLine());
        p.setBirthday(LocalDate.of(2010, Month.JANUARY, 27));
        PersonDefiner personDefiner = new PersonDefiner(connection);
        personDefiner.define(p);
    }
}