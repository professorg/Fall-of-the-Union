/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Cruz
 */
public class HeightGen {

    private int[][] map;
    private final int size;

    public HeightGen(int s) {

        size = s;
        map = new int[s][s];
    }

    public void generate() {

        double[][] m = new double [size][size];
        shuffle(m);

        for (int i = 0; i < (int) size / 3; i++) {

            smooth(m);
            System.out.println(i);
        }

        double[] ext = extrema(m);
        grain(m, ext);
        ext = extrema(m);
        regulate(m, ext);
        map = toIntMap(m);
    }
    
    private static double[] extrema(double[][] m){
        
        double[] ext = new double[2];
        ext[0] = m[0][0];
        ext[1] = m[0][0];
        int size = m.length;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (m[i][j] < ext[0]) {

                    ext[0] = m[i][j];
                } else if (m[i][j] > ext[1]) {

                    ext[1] = m[i][j];
                }
            }
        }
        
        return ext;
    }
    
    private static void grain(double[][] m, double[] e){
        
        int size = m.length;
        
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                m[i][j] += (Math.random() - 0.5) * 4 * (e[1] - e[0]) / size;
            }
        }
    }

    private static void regulate(double[][] m, double[] e) {

        int size = m.length;

        double dis = 127.0 - ((e[1] - e[0]) / 2.0 + e[0]);
        double mult = 127.0 / Math.abs(e[1] - 127.0 + dis);

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                double scale = m[i][j] + dis - 127.0;
                m[i][j] = scale * mult + 127.0;
            }
        }
    }

    private static void smooth(double[][] m) {

        final int[] warpX = {-1, 0, 1, -1, 1, -1, 0, 1, 0, 2, 0, -2, -1, 1, -2, 2, -1, 1, -2, 2};
        final int[] warpY = {-1, -1, -1, 0, 0, 1, 1, 1, -2, 0, 2, 0, -2, -2, -1, -1, 2, 2, 1, 1};
        double[][] ref = m;
        int size = m.length;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                double sum = ref[i][j];

                for (int k = 0; k < 20; k++) {

                    int indX = (warpX[k] + i + size) % size;
                    int indY = (warpY[k] + j + size) % size;
                    sum += ref[indX][indY];
                }

                m[i][j] = sum / 21.0;
            }
        }
    }

    private static void shuffle(double[][] m) {

        int size = m.length;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                m[i][j] = Math.floor(Math.random() * 256);
            }
        }
    }

    private static int[][] toIntMap(double[][] m) {

        int size = m.length;
        int[][] nMap = new int[size][size];
        
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                nMap[i][j] = (int) m[i][j];

                if (nMap[i][j] < 0) {

                    nMap[i][j] = 0;
                } else if (nMap[i][j] > 255) {

                    nMap[i][j] = 255;
                }
            }
        }
        
        return nMap;
    }
    
    public int[][] getMap(){
        
        return map;
    }
}
