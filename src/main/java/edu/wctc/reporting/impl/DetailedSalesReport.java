package edu.wctc.reporting.impl;

import edu.wctc.reporting.Sale;
import edu.wctc.reporting.iface.SalesReport;
import edu.wctc.reporting.iface.ShippingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DetailedSalesReport implements SalesReport {

    ShippingPolicy shippingPolicy;

    @Autowired
    public void setShippingPolicy(ShippingPolicy shippingPolicy) {
        this.shippingPolicy = shippingPolicy;
    }

    @Override
    public void generateReport(List<Sale> salesList) {
        System.out.println("SALES DETAIL REPORT");
        System.out.printf("%-25s%-20s%-10s%-10s%-10s\n", "Customer", "Country", "Amount", "Tax", "Shipping");

        for (Sale sale : salesList) {
            System.out.printf("%-25s%-20s%-10.2f%-10.2f%-10.2f\n", sale.getName(), sale.getCountry(), sale.getAmount(), sale.getTax(), shippingPolicy.getShippingCost(sale));
        }
    }
}
