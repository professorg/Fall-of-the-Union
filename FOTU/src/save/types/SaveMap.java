/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package save.types;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import map.Map;
import save.SaveException;
import save.Write;

/**
 * Saves height maps as .map files
 *
 * @author Cruz
 */
public class SaveMap implements Write<Map> {

    @Override
    public void write(File f, String n, Map d) throws SaveException {

        if (!(f.exists() || f.getPath().endsWith(""))) {

            throw new SaveException();
        }

        try {

            f = new File(f.toString() + "/" + n + ".map");
            int l = d.size();
            int[][] map = d.getHeightMap();
            FileWriter writer = new FileWriter(f);
            writer.write("" + l + "\n");

            for (int i = 0; i < l; i++) {

                for (int j = 0; j < l; j++) {

                    writer.write(map[i][j] + " ");
                }

                writer.write("\n");
            }

            writer.close();
        } catch (FileNotFoundException ex) {

            throw new SaveException();
        } catch (IOException ex) {

            throw new SaveException();
        }
    }
}
