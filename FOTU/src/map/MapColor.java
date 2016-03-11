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
public enum MapColor {

    MOUNT(200, 200, 200, 30, 1),
    
    FOREST(25, 125, 25, 100, 1),
    DESERT(255, 255, 200, 40, -1),
    
    BEACH(255, 255, 180, 40, -1),
    ROCKS(200, 200, 200, 50, -1),
    VEGI(25, 200, 25, 50, -1),
    
    LAVA(255, 150, 100, 25, -1),
    OCEAN(0, 0, 100, 100, 1);

    private final int[] color;
    private final int diff;
    private final int mult;

    private MapColor(int r, int g, int b, int d, int m) {

        color = new int[3];
        color[0] = r;
        color[1] = g;
        color[2] = b;
        
        diff = d;
        mult = m;
    }
    
    public int[] getColor(){
        
        return color;
    }
    
    public int getDiff(){
        
        return diff;
    }
    
    public int getMult(){
        
        return mult;
    }
}
