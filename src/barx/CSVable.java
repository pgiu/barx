package barx;

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

import java.util.List;

/**
 *
 * @author pgiudice
 */
public interface CSVable {

    /**
     * Gets the stantdard content of the object as a CSV string.
     *
     * @param separator is the character that separates two fields. It's usually
     * a comma (',')  but tab ('\t') or semicolon (';') are popular too.
     * @return a CSV version of the object
     */
    public String toCSV(char separator);

    /**
     * Gets the content of the object as a CSV string, specifying which fields
     * to export.
     *
     * @param options options for each parameter. Each object that implements
     * this interface must explicitly show the orders of the parameters. It is
     * advisable to expose constants with numbers like: PARAM1 = 1 PARAM2 = 2
     * ... so if the code changes someday, it will be backwards compatible.
     *
     * @return a CSV version of the object, as a string
     */
    public String toCSV(List<Integer> options);
}

