/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load;

/**
 * Thrown incase loading fails.
 * @author Cruz
 */
public class LoadException extends Exception {

    /**
     * Creates a new instance of <code>LoadException</code> without detail
     * message.
     */
    public LoadException() {
        
        super("Failed to load.");
    }

    /**
     * Constructs an instance of <code>LoadException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LoadException(String msg) {
        
        super(msg);
    }
}
