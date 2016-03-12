/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load;

import java.io.File;

/**
 * A file reading template.
 * @author Cruz
 * @param <D> data type to receive from the file
 */
public interface Read <D>{
    
    /**
     * Reads the file and produces the data from the function to be defined.
     * @param f the file to read
     * @return data from the specified file
     * @throws load.LoadException when file is invalid
     */
    public abstract D read(File f) throws LoadException;
}
