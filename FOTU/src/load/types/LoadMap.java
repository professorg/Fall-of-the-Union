/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load.types;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import load.LoadException;
import load.Read;
import map.Map;

/**
 * Loads .map files as a Map object
 * @author Cruz
 */
public class LoadMap implements Read<Map> {

    @Override
    public Map read(File f) throws LoadException {

        if(!(f.exists() || f.getPath().endsWith("map"))){
            
            throw new LoadException();
        }
        
        int[][] map = null;
        
        try {
            
            Scanner reader = new Scanner(f);
            int l = Integer.parseInt(reader.next());
            map = new int[l][l];
            
            for (int i = 0; i < l; i++) {
                
                for (int j = 0; j < l; j++) {
                    
                    map[i][j] = Integer.parseInt(reader.next());
                }
            }
            
            reader.close();
        } catch (FileNotFoundException ex) {

            throw new LoadException();
        }
        
        return new Map(map);
    }
}
