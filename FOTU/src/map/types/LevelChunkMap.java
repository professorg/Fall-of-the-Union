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
public class LevelChunkMap extends HeightMap<int[][][][], int[][][][][], ColorGenerator> {

    private final LevelMap simMap;
    private final int chunkSize;
    private final int numChunks;

    public LevelChunkMap(LevelMap lm) {

        super(lm.generateChunkMap());
        simMap = lm;
        chunkSize = heightMap[0][0].length;
        numChunks = heightMap.length;
    }

    public int getNumChunks() {

        return numChunks;
    }

    public int getChunkSize() {

        return chunkSize;
    }

    @Override
    public void color() {

        simMap.color();
        colorMap = ChunkGenerator.generateColor(simMap.getColorMap());
    }

    @Override
    protected int size(int[][][][] hm) {

        return hm.length * hm[0][0].length;
    }

    @Override
    public int[][][][] getHeightMap() {

        int[][][][] map = new int[numChunks][numChunks][chunkSize][chunkSize];

        for (int i = 0; i < numChunks; i++) {

            for (int j = 0; j < numChunks; j++) {

                for (int k = 0; k < chunkSize; k++) {

                    System.arraycopy(heightMap[i][j][k], 0, map[i][j][k], 0, chunkSize);
                }
            }
        }

        return map;
    }

    @Override
    public int[][][][][] getColorMap() {

        int[][][][][] map = new int[numChunks][numChunks][chunkSize][chunkSize][3];

        for (int i = 0; i < numChunks; i++) {

            for (int j = 0; j < numChunks; j++) {

                for (int k = 0; k < chunkSize; k++) {

                    for (int l = 0; l < chunkSize; l++) {

                        System.arraycopy(colorMap[i][j][k][l], 0, map[i][j][k][l], 0, 3);
                    }
                }
            }
        }

        return map;
    }

    @Override
    protected ColorGenerator initColorGen() {

        if (simMap != null) {
            
            return simMap.getColorGen();
        }
        
        return null;
    }
}
