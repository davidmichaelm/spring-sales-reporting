package edu.wctc.reporting;

public class Sale {

    String name;
    String country;
    double amount;
    double tax;

    public Sale(String name, String country, double amount, double tax) {
        this.name = name;
        this.country = country;
        this.amount = amount;
        this.tax = tax;
    }
}
