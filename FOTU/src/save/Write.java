/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package save;

import java.io.File;

/**
 * A file writing template.
 * @author Cruz
 * @param <D> Data type to write into a file.
 */
public interface Write <D>{
    
    /**
     * Writes the data to the file using the function to be defined.
     * @param f File to write to, only directory.
     * @param n File name.
     * @param d Data to write into file.
     * @throws save.SaveException When file is invalid.
     */
    public abstract void write(File f, String n, D d) throws SaveException;
}
