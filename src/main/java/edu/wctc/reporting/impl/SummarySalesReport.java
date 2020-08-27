package edu.wctc.reporting.impl;

import edu.wctc.reporting.Sale;
import edu.wctc.reporting.iface.SalesReport;
import edu.wctc.reporting.iface.ShippingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummarySalesReport implements SalesReport {

    private ShippingPolicy shippingPolicy;

    @Autowired
    public void setShippingPolicy(ShippingPolicy shippingPolicy) {
        this.shippingPolicy = shippingPolicy;
    }

    @Override
    public void generateReport(List<Sale> salesList) {
        System.out.println("SALES SUMMARY REPORT");
        System.out.printf("%-20s%-10s%-10s%-10s\n", "Country", "Amount", "Tax", "Shipping");

        HashMap<String, List<Sale>> salesByCountry = getSalesByCountry(salesList);

        for (Map.Entry<String, List<Sale>> countrySaleMap : salesByCountry.entrySet()) {
            List<Sale> countrySaleList = countrySaleMap.getValue();
            System.out.printf("%-20s%-10.2f%-10.2f%-10.2f\n", countrySaleMap.getKey(), getCountryAmountTotal(countrySaleList), getCountryTaxTotal(countrySaleList), getCountryShippingTotal(countrySaleList));
        }
    }

    private HashMap<String, List<Sale>> getSalesByCountry(List<Sale> salesList) {
        HashMap<String, List<Sale>> salesByCountry = new HashMap<String, List<Sale>>();

        for (Sale sale : salesList) {
            String country = sale.getCountry();
            if (!salesByCountry.containsKey(country)) {
                salesByCountry.put(country, new ArrayList<>());
            }
            salesByCountry.get(country).add(sale);
        }

        return salesByCountry;
    }

    private double getCountryAmountTotal(List<Sale> countrySaleList) {
        double total = 0;

        for (Sale sale : countrySaleList) {
            total += sale.getAmount();
        }

        return total;
    }

    private double getCountryTaxTotal(List<Sale> countrySaleList) {
        double total = 0;

        for (Sale sale : countrySaleList) {
            total += sale.getTax();
        }

        return total;
    }

    private double getCountryShippingTotal(List<Sale> countrySaleList) {
        double total = 0;

        for (Sale sale : countrySaleList) {
            total += shippingPolicy.getShippingCost(sale);
        }

        return total;
    }
}
