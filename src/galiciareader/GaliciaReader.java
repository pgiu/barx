/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galiciareader;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.ui.RefineryUtilities;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author pgiudice
 */
public class GaliciaReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        try {
            //Abro el origen de los datos
            File input = new File("D:\\Dropbox\\JAVA\\GaliciaReader\\test\\Resumen2015.htm");
            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

            // Parseo los datos
            GaliciaParser gp = new GaliciaParser(doc);
            List<Date> t = new ArrayList();
            List<Double> saldo = new ArrayList();
            gp.getSaldo(t, saldo);
            System.out.println("saldo size=" + saldo.size());

            for (Double d : saldo) {
                System.out.println("saldo:" + d);
            }

            //Visualizo
            GaliciaLineChart chart = new GaliciaLineChart("Saldo A", "Saldo B", t, saldo);

            chart.pack();
            RefineryUtilities.centerFrameOnScreen(chart);
            chart.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(GaliciaReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
