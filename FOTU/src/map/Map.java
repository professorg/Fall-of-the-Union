/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Cruz
 */
public class Map {
    
    private final int size;
    private final int[][] heightMap;
    private int[][][] coloredMap;
    private final ColorGenerator colorGen;
    
    public Map(int[][] hm){
        
        size = hm.length;
        heightMap = hm;
        colorGen = new ColorGenerator(hm);
    }
    
    public void color(){
        
        colorGen.generate();
        coloredMap = colorGen.getMap();
    }
    
    public ColorGenerator getColorGenerator(){
        
        return colorGen;
    }
    
    public int[][] getHeightMap(){
        
        int[][] map = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            
            System.arraycopy(heightMap[i], 0, map[i], 0, size);
        }
        
        return map;
    }
    
    public int[][][] getColoredMap(){
        
        int[][][] map = new int[size][size][3];
        
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                System.arraycopy(coloredMap[i][j], 0, map[i][j], 0, 3);
            }
        }
        
        return map;
    }
    
    public int size(){
        
        return size;
    }
}
