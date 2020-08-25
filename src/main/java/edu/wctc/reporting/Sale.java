package edu.wctc.reporting;

public class Sale {

    private String name;
    private String country;
    private double amount;
    private double tax;

    public Sale(String name, String country, double amount, double tax) {
        this.name = name;
        this.country = country;
        this.amount = amount;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getAmount() {
        return amount;
    }

    public double getTax() {
        return tax;
    }
}
