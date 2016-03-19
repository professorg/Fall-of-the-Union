/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.generators;

/**
 *
 * @author Cruz
 */
public class ChunkGenerator {

    private static int chunkSize = 16;

    public static void setChunkSize(int cs) {

        if (chunkSize > 0) {
            
            chunkSize = cs;
        }
    }

    public static int[][] convertHeight(int[][][][] chm) {

        if (chm != null && chm[0] != null) {

            int y = chm.length;
            int x = chm[0].length;
            int c = chm[0][0].length;
            int[][] map = new int[c * y][c * x];
            
            for (int i = 0; i < y; i++) {
                
                for (int j = 0; j < x; j++) {
                    
                    for (int k = 0; k < c; k++) {
                        
                        System.arraycopy(chm[i][j][k], 0, map[i * c + k], j * c, c);
                    }
                }
            }
            
            return map;
        }

        return null;
    }
    
    public static int[][][] convertColor(int[][][][][] ccm){
        
        if (ccm != null && ccm[0] != null) {

            int y = ccm.length;
            int x = ccm[0].length;
            int c = ccm[0][0].length;
            int[][][] map = new int[c * y][c * x][3];
            
            for (int i = 0; i < y; i++) {
                
                for (int j = 0; j < x; j++) {
                    
                    for (int k = 0; k < c; k++) {
                        
                        for (int l = 0; l < 10; l++) {
                            
                            System.arraycopy(ccm[i][j][k][l], 0, map[i * c + k][j * c + l], 0, 3);
                        }
                    }
                }
            }
            
            return map;
        }

        return null;
    }

    public static int[][][][] generateHeight(int[][] hm) {

        if (hm != null && hm[0] != null) {

            int y = hm.length;
            int x = hm[0].length;
            int[][][][] cMap;

            if (y % chunkSize == 0 && x % chunkSize == 0) {

                cMap = new int[y / chunkSize][x / chunkSize][chunkSize][chunkSize];

                for (int i = 0; i < y / chunkSize; i++) {

                    for (int j = 0; j < x / chunkSize; j++) {

                        for (int k = 0; k < chunkSize; k++) {

                            for (int l = 0; l < chunkSize; l++) {

                                cMap[i][j][k][l] = hm[i * chunkSize + k][j * chunkSize + l];
                            }
                        }
                    }
                }

                return cMap;
            }
        }

        return null;
    }

    public static int[][][][][] generateColor(int[][][] cm) {

        if (cm != null && cm[0] != null) {

            int y = cm.length;
            int x = cm[0].length;
            int[][][][][] cMap;

            if (y % chunkSize == 0 && x % chunkSize == 0) {

                cMap = new int[y / chunkSize][x / chunkSize][chunkSize][chunkSize][3];

                for (int i = 0; i < y / chunkSize; i++) {

                    for (int j = 0; j < x / chunkSize; j++) {

                        for (int k = 0; k < chunkSize; k++) {

                            for (int l = 0; l < chunkSize; l++) {

                                System.arraycopy(cm[i * chunkSize + k][j * chunkSize + l], 0, cMap[i][j][k][l], 0, 3);
                            }
                        }
                    }
                }

                return cMap;
            }
        }

        return null;
    }
}
