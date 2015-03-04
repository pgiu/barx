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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pgiudice
 */
public class Consumo {

    //As seen on Banco Galicia Balance
    public Date fecha;
    //public String movimiento;
    public double debito;
    public double credito;
    public double saldoParcial;
    public String detalle; // == detalles en MoneyManagerEx

    //As seen on MoneyManager
    public String movimiento;
    public String categoria;
    public String subcategoria;
    public int numero;
    public String toFrom;
    public String cuenta; // De donde se saca/pone el dinero
    
    public Consumo() {
        this.fecha = new Date();
        //this.movimiento = "";
        this.debito = 0;
        this.credito = 0;
        this.saldoParcial = 0;
        this.detalle = "";
        this.movimiento = "";
        this.categoria = "";
        this.subcategoria = "";
        this.numero = 0;
        this.toFrom = "";
    }

    public Consumo(Date fecha, String movimiento, double debito, double credito, double saldoParcial, String detalle) {
        this.fecha = fecha;
        //this.movimiento = movimiento;
        this.debito = debito;
        this.credito = credito;
        this.saldoParcial = saldoParcial;
        this.detalle = detalle;
        this.movimiento = movimiento;
        this.categoria = "";
        this.subcategoria = "";
        this.numero = 0;
        this.toFrom = "";

    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
}
