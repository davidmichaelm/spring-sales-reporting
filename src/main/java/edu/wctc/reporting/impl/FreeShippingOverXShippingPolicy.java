package edu.wctc.reporting.impl;

import edu.wctc.reporting.Sale;
import edu.wctc.reporting.iface.ShippingPolicy;

public class FreeShippingOverXShippingPolicy implements ShippingPolicy {

    private double amountForFreeShipping;

    public FreeShippingOverXShippingPolicy(double amountForFreeShipping) {
        this.amountForFreeShipping = amountForFreeShipping;
    }

    @Override
    public double getShippingCost(Sale sale) {
        if (sale.getAmount() >= amountForFreeShipping) {
            return 0.0;
        } else {
            return 10.0;
        }
    }
}
