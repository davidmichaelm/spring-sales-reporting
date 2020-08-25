package edu.wctc.reporting.impl;

import edu.wctc.reporting.Sale;
import edu.wctc.reporting.iface.ShippingPolicy;

public class FlatRateDomesticShippingPolicy implements ShippingPolicy {
    @Override
    public double getShippingCost(Sale sale) {
        return 0;
    }
}
