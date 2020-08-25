package edu.wctc.reporting.impl;

import edu.wctc.reporting.Sale;
import edu.wctc.reporting.iface.SalesInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSalesInput implements SalesInput {

    private String fileName;

    public FileSalesInput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();
        int failedSales = 0;

        File file = new File(fileName);
        Scanner scanner = null;
        try {

            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        while (scanner != null && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(",");

            Sale sale = null;

            try {
                sale = new Sale(lineArray[0], lineArray[1], Double.parseDouble(lineArray[2]), Double.parseDouble(lineArray[3]));
            } catch (Exception e) {
                failedSales++;
            }

            if (sale != null) {
                sales.add(sale);
            }
        }

        if (failedSales > 0) {
            System.out.println("Failed to create " + failedSales + " sales");
        }

        return sales;
    }
}
