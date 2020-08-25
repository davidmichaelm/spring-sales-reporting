package edu.wctc.reporting.iface;

import edu.wctc.reporting.Sale;

import java.util.List;

public interface SalesReport {
    void generateReport(List<Sale> salesList);
}
