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

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.ui.RefineryUtilities;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author pgiudice
 */
public class Barx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        if (args.length != 2 && args.length != 3) {
            System.out.println("Faltan parámetros\n"
                    + "Para llamar a este programa haga:\n"
                    + ">java barx resumen.html output.csv categorias.csv");
            return;
        }

        try {
            //Abro el origen de los datos
            File input = new File(args[0]);
            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

            GaliciaParser gp;

            if (args.length == 3) {
                Map<String, String> map;
                String splitby = ";";
                CSVReader rcsv = new CSVReader(args[2], splitby);
                map = rcsv.read();
                gp = new GaliciaParser(doc, map);
            } else {
                gp = new GaliciaParser(doc);
            }

            // Parseo los datos
            List<Date> t = new ArrayList();
            List<Double> saldo = new ArrayList();
            gp.getSaldo(t, saldo);
            System.out.println("saldo size=" + saldo.size());

            for (Double d : saldo) {
                System.out.println("saldo:" + d);
            }

            //Visualizo
            GaliciaLineChart chart = new GaliciaLineChart("Galicia Reader", "Saldo", t, saldo);
            chart.pack();
            RefineryUtilities.centerFrameOnScreen(chart);
            chart.setVisible(true);

            //Exporto a formato CSV 
            CSVWriter cw = new CSVWriter(",", new SimpleDateFormat("dd/MM/yyyy"));

            cw.writeCSV(args[1], gp.getConsumos());

            //Exporto a formato QIF (TBD)
        } catch (IOException ex) {
            Logger.getLogger(Barx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
