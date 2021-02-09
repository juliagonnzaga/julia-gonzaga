/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliapdcase.percistency;

import java.util.List;

/**
 *
 * @author Júlia Gonzaga
 */
public interface DAO<T> {
    public List<T> getAll();
    public T getById(Integer id);
    public boolean save();
    public boolean delete();
}
