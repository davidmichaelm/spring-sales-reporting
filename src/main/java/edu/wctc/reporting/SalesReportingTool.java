package edu.wctc.reporting;

import edu.wctc.reporting.iface.SalesInput;
import edu.wctc.reporting.iface.SalesReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesReportingTool {

    SalesInput salesInput;
    SalesReport salesReport;

    @Autowired
    public SalesReportingTool(SalesInput salesInput, SalesReport salesReport) {
        this.salesInput = salesInput;
        this.salesReport = salesReport;
    }

    public void showReport() {
        List<Sale> sales = salesInput.getSales();
        salesReport.generateReport(sales);
    }
}
