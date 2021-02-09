/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliapdcase.util.xml;
/**
 *
 * @author Júlia Gonzaga
 */
public class MarshalException extends Exception {

    /**
     * Creates a new instance of <code>MarshallException</code> without detail
     * message.
     */
    public MarshalException() {
    }

    /**
     * Constructs an instance of <code>MarshallException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MarshalException(String msg) {
        super(msg);
    }
}
