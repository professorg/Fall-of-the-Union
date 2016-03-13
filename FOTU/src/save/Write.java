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
 * @param <D> data type to write into a file
 */
public interface Write <D>{
    
    /**
     * Writes the data to the file using the function to be defined.
     * @param f file to write to, only directory
     * @param n file name
     * @param d data to write into file
     * @throws save.SaveException when file is invalid
     */
    public abstract void write(File f, String n, D d) throws SaveException;
}
