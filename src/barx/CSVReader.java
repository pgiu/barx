/*
 * Copyright (C) 2015 pgiudice
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package barx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

    String csvSplitBy;
    String filename;

    CSVReader(String filename, String csvSplitBy) {
        this.csvSplitBy = csvSplitBy;
        this.filename = filename;
    }

    public static void main(String[] args) {
        String csvFile = "samples/categorias_gastos.csv";
        CSVReader obj = new CSVReader(csvFile, ";");
        obj.read();
    }

    public Map<String, String> read() {

        Map<String, String> output = new HashMap();

        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] tokens = line.split(csvSplitBy);

                output.put(tokens[0], tokens[1]);
                //System.out.println("key:" + tokens[0] + ", value:" + tokens[1]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return output;
    }
}
