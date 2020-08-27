package edu.wctc.reporting;

import edu.wctc.reporting.iface.SalesInput;
import edu.wctc.reporting.iface.SalesReport;
import edu.wctc.reporting.iface.ShippingPolicy;
import edu.wctc.reporting.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc.reporting")
public class AppConfig {

    @Bean
    SalesInput salesInput() {
        return new ConsoleSalesInput();
//        return new FileSalesInput("sales.txt");
    }

    @Bean
    SalesReport salesReport() {
        return new SummarySalesReport();
//        return new DetailedSalesReport();
    }

    @Bean
    ShippingPolicy shippingPolicy() {
        return new FreeShippingPolicy();
//        return new FlatRateDomesticShippingPolicy();
//        return new FreeShippingOverXShippingPolicy(50.0);
    }
}
