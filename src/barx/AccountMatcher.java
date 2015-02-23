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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pgiudice
 */
public class AccountMatcher {

    public Map<String, String> matchMap;

    AccountMatcher(Map<String, String> map) {

        this.matchMap = map;
    }

    public String findMatch(String input) {

        String aMatch = "";

        Set<String> keys = matchMap.keySet();

        Boolean match = false;
        Iterator<String> patternList = keys.iterator();

        while (match == false && patternList.hasNext()) {

            String pat = patternList.next();
            Pattern pattern = Pattern.compile(pat);

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                aMatch = matchMap.get(pat);
            }

        }

        return aMatch;

    }

    public static void main(String[] args) {
        Map<String, String> m = new HashMap();
        m.put("(?i)starbucks", "Expenses:Dining");
        m.put("(?i)atalaya", "Expenses:Dining");
        m.put("(?i)interes", "Income:Interes");
        m.put("(?i)COMPRA DE DOLARES", "Assets:USD-Casa");

        AccountMatcher am = new AccountMatcher(m);

        List<String> input = new ArrayList();
        input.add("COMPRA CON TARJETA GALICIA 24 A470 GOETHE INSTITUT EV");
        input.add("INTERES CAPITALIZADO Febrero 2015");
        input.add("COMPRA CON TARJETA GALICIA 24 A005 ATALAYA");
        input.add("COMPRA CON TARJETA GALICIA 24 A386 HIPER CHASCOMUS SRL");
        input.add("COMPRA CON TARJETA GALICIA 24 A005 ATALAYA");
        input.add("SUBSIDIO VACACIONAL");
        input.add("COMPRA CON TARJETA GALICIA 24 A342 ATALAYA");
        input.add("PAGO TARJETA VISA");
        input.add("COMPRA CON TARJETA GALICIA 24 A496 DEPORTES JUAN MANUEL");
        input.add("COMPRA CON TARJETA GALICIA 24 A005 ATALAYA");
        input.add("COMPRA CON TARJETA GALICIA 24 A002 YPF SEGUI COMB 063");
        input.add("EXTRACCION POR CAJEROS AUTOMATICOS A589 S1BFN589");
        input.add("DEVOL.IVA 4.13%-COMPRA GALICIA 24 LIQUIDAC.100254860");
        input.add("EXTRACCION POR CAJEROS AUTOMATICOS A955 S1DGL955");
        input.add("TRANSFERENCIA ELECTRONICA A054 CUENTA ORIGENCAJA AHORRO PESOS 1362601989");
        input.add("COMPRA DE DOLARES OPERACION 0300043");
        input.add("ACREDITAMIENTO DE HABERES");
        input.add("COMPRA CON TARJETA GALICIA 24 A902 DIA % TIENDA NRO 389");
        input.add("COMPRA CON TARJETA GALICIA 24 A422 GEZATEK COMPUTACION");
        input.add("EXTRACCION POR CAJEROS AUTOMATICOS A483 S1FSP483");
        input.add("COMPRA CON TARJETA GALICIA 24 A001 FARMACITY");
        input.add("COMPRA CON TARJETA GALICIA 24 A203 SBUX CABILDO");
        input.add("COMPRA CON TARJETA GALICIA 24 A404 TIENDA DIA NL224 - FLORES");
        input.add("COMPRA CON TARJETA GALICIA 24 A841 ORTOPEDIA SIMONYAN");

        for (String s : input) {
            String match = am.findMatch(s);
            if (match.isEmpty())
                match = "NO MATCH";

            System.out.println("Entrada:" + s + "\t\tSalida: " + match);

        }
    }
}
