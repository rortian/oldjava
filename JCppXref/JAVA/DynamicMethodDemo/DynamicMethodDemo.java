/*
 * Frederick F. Chew, The Java/C++ Cross Reference Handbook (Book/CD-ROM)
 * Published By HP Press/Prentice-Hall
 * Copyright (C) 1997 Hewlett-Packard Company
 * All Rights Reserved. ISBN 0-13-848318-3
 *
 * Permission to use, copy, modify, and distribute this
 * software and its documentation for NON-COMMERCIAL purposes
 * and without fee is hereby granted provided that this
 * copyright notice appears in all copies.
 *
 * THE AUTHOR AND PUBLISHER MAKE NO REPRESENTATIONS OR
 * WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. THE AUTHOR
 * AND PUBLISHER SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED
 * BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */

/**
 * @version 1.00 01 May 1997
 * @author Frederick F. Chew
 */

/**
 * Note:  This program was built from the JDK version 1.02
 *        and has not been customized to work on version 1.1
 *
 *        There is an equivalent version of this program
 *        created from the JDK version 1.1 on the media.
 */

import java.awt.*;
import java.io.IOException;

class Food {

    Food(String nm, double cost, double gain) {
    name = new String(nm);
    unit_cost = cost;
    percent_profit = gain;
    }

	String getName() {
	return name;
	}

    private protected double calculateSalesPrice() {
    return unit_cost + unit_cost * percent_profit;
    }

    double calculatePayment() {
    return calculateSalesPrice();
    }

	private String name;
    private double unit_cost;
	private double percent_profit;
}

class Candy extends Food {

    Candy(String nm, double cost, double gain, double ltax) {
    super(nm, cost, gain);
    local_tax = ltax;
    }

    double calculatePayment() {
    double sales_price = calculateSalesPrice();
    return sales_price + sales_price * local_tax;
    }

	private protected double getLocalTax() {
	return local_tax;
	}

	private double local_tax;
}

class ForeignCandy extends Candy {

    ForeignCandy(String nm, double cost, double gain,
                 double ltax, double itax) {
    super(nm, cost, gain, ltax);
    import_tax = itax;
    }

    double calculatePayment() {
    double sales_price = calculateSalesPrice();
    return sales_price + sales_price * getLocalTax() + sales_price * import_tax;
    }

	private double import_tax;
}


public class DynamicMethodDemo {

    public static void main(String args[]) {
        ForeignCandy biscotti = new ForeignCandy("Mocha au Lait", 3.00, 0.25, 0.10, 0.05);
        System.out.println(biscotti.getName()+" will cost the consumer $"+biscotti.calculatePayment());
        Food edible = biscotti;
        System.out.println(edible.getName()+" will cost the consumer $"+edible.calculatePayment());

        System.out.println("\n(press Enter to exit)");
        try {
            System.in.read();
        }
        catch (IOException e) {
            return;
        }
    }
}
