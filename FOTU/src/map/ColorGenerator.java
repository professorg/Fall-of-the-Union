/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 * Used to color designated height maps.
 * @author Cruz
 */
public class ColorGenerator {

    private static MapColor[] layers;
    private final int[][] hMap;
    private final int size;
    private int[][][] map;

    /**
     * Stores the height map to be colored.
     * @param hm a height map
     */
    public ColorGenerator(int[][] hm) {

        hMap = hm;
        size = hm.length;
        map = new int[size][size][3];
    }

    /**
     * creates a new color map, accessible using getMap()
     */
    public void generate() {

        map = color(hMap);
        toRoundMap(map);
    }

    private static int[][][] color(int[][] m) {

        int size = m.length;
        int[][][] map = new int[size][size][3];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                int code = getCode(m[i][j]);
                map[i][j] = getColor(code, m[i][j]);
            }
        }

        return map;
    }

    private static int[] getColor(int c, int h) {

        int[] map = new int[3];

        switch (c) {

            case 7:
                map = plain(layers[3], h, 190, 255);
                break;

            case 6:
                map = mix(plain(layers[2], h, 110, 210), plain(layers[3], h, 190, 255), h, 190, 210);
                break;

            case 5:
                map = plain(layers[2], h, 110, 210);
                break;

            case 4:
                map = mix(plain(layers[1], h, 60, 130), plain(layers[2], h, 110, 210), h, 110, 130);
                break;

            case 3:
                map = plain(layers[1], h, 60, 130);
                break;

            case 2:
                map = mix(plain(layers[0], h, 0, 80), plain(layers[1], h, 60, 130), h, 60, 80);
                break;

            case 1:
                map = plain(layers[0], h, 0, 80);
                break;
        }

        return map;
    }

    private static int[] mix(int[] c1, int[] c2, int h, int t1, int t2) {

        int[] color = new int[3];
        int scale = t2 - t1;
        int height = h - t1;
        double perC = ((double) height) / scale;

        for (int i = 0; i < 3; i++) {

            color[i] = (int) (c2[i] * perC + c1[i] * (1 - perC));
        }

        return color;
    }

    private static int[] plain(MapColor c, int h, int t1, int t2) {

        int[] color = new int[3];
        double dis = t2 - t1;
        double perC = (h - t1) / dis;

        for (int i = 0; i < 3; i++) {

            color[i] = (int) (c.getColor()[i] + (c.getMult() * perC * c.getDiff()));
        }

        return color;
    }

    private static int getCode(int h) {

        if (210 <= h) {

            return 7;
        } 
        
        if (190 <= h) {

            return 6;
        } 
        
        if (130 <= h) {

            return 5;
        } 
        
        if (110 <= h) {

            return 4;
        } 
        
        if (80 <= h) {

            return 3;
        } 
        
        if (60 <= h) {

            return 2;
        }

        return 1;
    }

    private static void toRoundMap(int[][][] m) {

        int size = m.length;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                for (int k = 0; k < 3; k++) {

                    if (m[i][j][k] < 0) {

                        m[i][j][k] = 0;
                    } else if (m[i][j][k] > 255) {

                        m[i][j][k] = 255;
                    }
                }
            }
        }
    }

    /**
     * Changes the colors of the layers.
     * @param l the new layer colors, an array of length 4
     */
    public static void setLayers(MapColor[] l) {

        layers = l;
    }

    /**
     * Gets the RGB, two dimensional map
     * @return the colored array, the third dimension being the RGB values from 0-255
     */
    public int[][][] getMap() {

        return map;
    }
}
