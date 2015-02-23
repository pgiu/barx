/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galiciareader;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author pgiudice
 */
public class GaliciaParser {

    Document doc;

    GaliciaParser(Document aDoc) {
        doc = aDoc;
    }

    void getSaldo(List<Date> t, List<Double> saldo) throws IOException, ParseException {

        //

        //Element table = doc.select("table class=\"noBorderTop\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\"").first();
        Element table = doc.select("table.noBorderTop[width=590]").first();

        Iterator<Element> row = table.select("tr").iterator();

        SimpleDateFormat standardDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        //row.next(); // first one is header, skip
        while (row.hasNext()) {

            Iterator<Element> td = row.next().select("td").iterator();
            String fecha = td.next().text();//fecha
            String lugar = td.next().text();//debito
            String debito = td.next().text();//debito
            String credito = td.next().text();//credito
            String saldoAsText = td.next().text();//saldo

            System.out.println("Fecha:" + fecha + "Lugar:\t" + lugar + "\tSaldo:" + saldoAsText); //

            try {
                //Parseo la fecha 
                t.add(standardDateFormat.parse(fecha));
                //Parseo el saldo
                NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
                Number number = format.parse(saldoAsText);
                double d = number.doubleValue();
                saldo.add(d);
                
            } catch (ParseException ex) {
                Logger.getLogger(GaliciaParser.class.getName()).log(Level.SEVERE, null, ex);
                //throw new ParseException("a",1);
            }

            
        }

    }
}
