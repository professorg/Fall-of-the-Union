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
public abstract class HeightMap <A, B, C>{
    
    protected final int size;
    protected final A heightMap;
    protected B colorMap;
    protected C colorGen;
    
    public HeightMap(A hm){
        
        heightMap = hm;
        size = size(hm);
        colorGen = initColorGen();
    }
    
    public abstract void color();
    
    protected abstract int size(A hm);
    
    protected abstract C initColorGen();
    
    public C getColorGen(){
        
        return colorGen;
    }
    
    public int getSize(){
        
        return size;
    }
    
    public abstract A getHeightMap();
    
    public abstract B getColorMap();
}
