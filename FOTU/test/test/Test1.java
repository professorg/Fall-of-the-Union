/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import load.LoadException;
import load.types.LoadLevelMap;
import map.generators.HeightGenerator;
import map.types.LevelChunkMap;
import map.types.LevelMap;
import save.SaveException;
import save.types.SaveLevelMap;

/**
 *
 * @author Cruz
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HeightGenerator hg = new HeightGenerator(32, 32);
        hg.generate();
        LevelMap m = hg.getMap();
        SaveLevelMap sm = new SaveLevelMap();
        LoadLevelMap lm = new LoadLevelMap();
        File fs = new File("game/saves");
        File fl = new File("game/saves/test1.map");
        
        try {
            
            sm.write(fs, "test1", m);
        } catch (SaveException ex) {

            System.out.println("Failed to Save");
        }
        
        try {
            
            LevelMap l = lm.read(fl);
            int[][] iMap = l.getHeightMap();
            System.out.println("");
            
            for (int i = 0; i < l.getSize(); i++) {
                
                for (int j = 0; j < l.getSize(); j++) {
                    
                    System.out.print(iMap[i][j] + " ");
                }
                
                System.out.println("");
            }
            
            System.out.println("");
            
            LevelChunkMap lcm = l.intoChunkMap();
            int[][][][] dhm = lcm.getHeightMap();
            
            for (int i = 0; i < lcm.getNumChunks(); i++) {
                
                for (int j = 0; j < lcm.getNumChunks(); j++) {
                    
                    for (int k = 0; k < lcm.getChunkSize(); k++) {
                        
                        for (int n = 0; n < lcm.getChunkSize(); n++) {
                            
                            System.out.print(dhm[i][j][k][n] + " ");
                        }
                        
                        System.out.println("");
                    }
                    
                    System.out.println("");
                }
                
                System.out.println("");
            }
        } catch (LoadException ex) {

            System.out.println("Failed to load");
        } 
    }
}
