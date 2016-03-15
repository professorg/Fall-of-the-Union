/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 * An enum of different layer colorings.
 * @author Cruz
 */
public enum MapColor {

    /**
     * Grey to White. Layer 4.
     */
    MOUNT(200, 200, 200, 30, 1),
    
    /**
     * Grey to Black. Layer 4.
     */
    VULCANO(150, 150, 150, 50, -1),
    
    /**
     * Green to Light Green. Layer 3.
     */
    FOREST(25, 125, 25, 100, 1),

    /**
     * White to Yellow. Layer 3.
     */
    DESERT(255, 255, 200, 40, -1),
    
    /**
     * White to Yellow. Layer 2.
     */
    BEACH(255, 255, 180, 40, -1),

    /**
     * Light Grey to Grey. Layer 2.
     */
    ROCKS(200, 200, 200, 50, -1),

    /**
     * Light Green to Green. Layer 2.
     */
    VEGI(25, 200, 25, 50, -1),
    
    /**
     * Red to Orange. Layer 1.
     */
    LAVA(255, 150, 100, 25, -1),

    /**
     * Black to Blue. Layer 1.
     */
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
    
    /**
     * Gets the color.
     * @return an array of ints of length 3 from 0-255 representing RGB
     */
    public int[] getColor(){
        
        return color;
    }
    
    /**
     * Gets the difference.
     * @return the amount it changes from each height
     */
    public int getDiff(){
        
        return diff;
    }
    
    /**
     * Gets the multiplier.
     * @return the multiplier for the difference
     */
    public int getMult(){
        
        return mult;
    }
}
