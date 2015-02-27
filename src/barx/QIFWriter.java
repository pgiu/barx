package barx;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

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
/**
 *
 * @author pgiudice
 */
public class QIFWriter {

    private String outputFileName;
    private SimpleDateFormat dateFormat;
    QIFWriter(String outputFileName, SimpleDateFormat dateFormat) {
        this.outputFileName = outputFileName;
    }

    public void writeQIF(List<Consumo> consumos ) throws IOException {
        String content = "";
        
        for (Consumo c : consumos) {
            String date = dateFormat.format(c.fecha);

            /*content += date + sep
             + c.beneficiario + sep
             + (c.credito - c.debito) + sep
             + c.categoria + sep
             + c.subcategoria + sep
             + c.numero + sep
             + c.detalle + sep
             + c.toFrom + "\n";*/
            
            /*content += date + sep
                    + c.numero + sep
                    + c.beneficiario + sep
                    + c.credito + sep
                    + c.debito + sep
                    + c.categoria + sep
                    + c.subcategoria + sep
                    + c.detalle + sep
                    + c.cuenta + "\n";*/

        }

        FileWriter writer = new FileWriter(outputFileName);
        writer.append(content);
        writer.flush();
        writer.close();
    }
}
