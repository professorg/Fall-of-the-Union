/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package save;

/**
 * Thrown incase saving fails.
 * @author Cruz
 */
public class SaveException extends Exception {

    /**
     * Creates a new instance of <code>FailedSaveException</code> without detail
     * message.
     */
    public SaveException() {
        
        super("Failed to save.");
    }

    /**
     * Constructs an instance of <code>FailedSaveException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SaveException(String msg) {
        
        super(msg);
    }
}
