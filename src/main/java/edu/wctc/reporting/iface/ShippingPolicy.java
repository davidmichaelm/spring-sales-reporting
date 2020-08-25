package edu.wctc.reporting.iface;

import edu.wctc.reporting.Sale;

public interface ShippingPolicy {
    double getShippingCost(Sale sale);
}
