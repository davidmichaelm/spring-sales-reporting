package edu.wctc.reporting.impl;

import edu.wctc.reporting.Sale;
import edu.wctc.reporting.iface.ShippingPolicy;

public class FlatRateDomesticShippingPolicy implements ShippingPolicy {
    @Override
    public double getShippingCost(Sale sale) {
        if (sale.getCountry().equals("United States")) {
            return 10.0;
        } else {
            return 20.0;
        }
    }
}
