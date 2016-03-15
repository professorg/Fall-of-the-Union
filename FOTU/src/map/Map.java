/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 * An object to consolidate all of the necessary map information.
 * @author Cruz
 */
public class Map {
    
    private final int size;
    private final int[][] heightMap;
    private int[][][] coloredMap;
    private final ColorGenerator colorGen;
    
    /**
     * Initializing a new map from an existing height map.
     * @param hm The height map.
     */
    public Map(int[][] hm){
        
        size = hm.length;
        heightMap = hm;
        colorGen = new ColorGenerator(hm);
    }
    
    /**
     * Colors the height map.
     */
    public void color(){
        
        colorGen.generate();
        coloredMap = colorGen.getMap();
    }
    
    /**
     * Gets the color generator for the height map to allow for changes.
     * @return The color generator.
     */
    public ColorGenerator getColorGenerator(){
        
        return colorGen;
    }
    
    /**
     * Gets a copy of the height map.
     * @return A copy of the height map.
     */
    public int[][] getHeightMap(){
        
        int[][] map = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            
            System.arraycopy(heightMap[i], 0, map[i], 0, size);
        }
        
        return map;
    }
    
    /**
     * Gets a copy of the map with a third RGB dimension of length 3.
     * @return A copy of coloredMap.
     */
    public int[][][] getColoredMap(){
        
        int[][][] map = new int[size][size][3];
        
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                System.arraycopy(coloredMap[i][j], 0, map[i][j], 0, 3);
            }
        }
        
        return map;
    }
    
    /**
     * Gets the size of the map.
     * @return The size.
     */
    public int size(){
        
        return size;
    }
}
