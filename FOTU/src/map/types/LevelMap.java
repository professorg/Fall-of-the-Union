/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.types;

import map.HeightMap;
import map.generators.ChunkGenerator;
import map.generators.ColorGenerator;

/**
 *
 * @author Cruz
 */
public class LevelMap extends HeightMap<int[][], int[][][], ColorGenerator> {

    public static int defChunk = 16;
    
    private int chunk;
    
    public LevelMap(int[][] hm) {
        
        super(hm);
        chunk = defChunk;
    }
    
    public LevelChunkMap intoChunkMap(){
        
        return new LevelChunkMap(this);
    }
    
    public int[][][][] generateChunkMap(){
        
        return ChunkGenerator.generateHeight(heightMap);
    }
    
    public void setChunkSize(int cs){
        
        chunk = cs;
    }
    
    public int getChunkSize(){
        
        return chunk;
    }

    @Override
    protected int size(int[][] hm) {

        return hm.length;
    }

    @Override
    protected ColorGenerator initColorGen() {

        return new ColorGenerator(heightMap);
    }

    @Override
    public int[][] getHeightMap() {

        int[][] map = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            
            System.arraycopy(heightMap[i], 0, map[i], 0, size);
        }
        
        return map;
    }

    @Override
    public int[][][] getColorMap() {

        int[][][] map = new int[size][size][3];
        
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                System.arraycopy(colorMap[i][j], 0, map[i][j], 0, 3);
            }
        }
        
        return map;
    }

    @Override
    public void color() {

        colorGen.generate();
        colorMap = colorGen.getMap();
    }
    
}
