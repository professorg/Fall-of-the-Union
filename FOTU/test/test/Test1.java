/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import load.LoadException;
import load.types.LoadMap;
import map.HeightGenerator;
import map.Map;
import save.SaveException;
import save.types.SaveMap;

/**
 *
 * @author Cruz
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HeightGenerator hg = new HeightGenerator(10, 10);
        hg.generate();
        Map m = hg.getMap();
        SaveMap sm = new SaveMap();
        LoadMap lm = new LoadMap();
        File fs = new File("game/saves");
        File fl = new File("game/saves/test1.map");
        
        try {
            
            sm.write(fs, "test1", m);
        } catch (SaveException ex) {

            System.out.println("Failed to Save");
        }
        
        try {
            
            Map l = lm.read(fl);
            int[][] iMap = l.getHeightMap();
            System.out.println("");
            
            for (int i = 0; i < l.size(); i++) {
                
                for (int j = 0; j < l.size(); j++) {
                    
                    System.out.print(iMap[i][j] + " ");
                }
                
                System.out.println("");
            }
        } catch (LoadException ex) {

            System.out.println("Failed to load");
        }
    }
}
