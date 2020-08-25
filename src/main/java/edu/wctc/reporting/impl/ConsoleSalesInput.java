package edu.wctc.reporting.impl;

import edu.wctc.reporting.Sale;
import edu.wctc.reporting.iface.SalesInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleSalesInput implements SalesInput {

    Scanner keyboard;

    public ConsoleSalesInput() {
        keyboard = new Scanner(System.in);
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();

        do {
            String name = getName();
            String country = getCountry();
            double amount = getAmount();
            double tax = getTax();

            Sale sale = new Sale(name, country, amount, tax);
            sales.add(sale);

        } while (getAddMore());

        return sales;
    }

    private String getName() {
        System.out.println("Enter the name:");
        return getString();
    }

    private String getCountry() {
        System.out.println("Enter the country:");
        return getString();
    }

    private double getAmount() {
        System.out.println("Enter the amount of the sale:");
        return getDouble();
    }

    private double getTax() {
        System.out.println("Enter the tax:");
        return getDouble();
    }

    private String getString() {
        String input = keyboard.nextLine();
        while (input.isEmpty()) {
            System.out.println("Input must be at least one character. Try again:");
            input = keyboard.nextLine();
        }

        return input;
    }

    private double getDouble() {
        double parsedDouble = 0.0;
        boolean parsed = false;
        do {
            try {
                String amount = keyboard.nextLine();
                parsedDouble = Double.parseDouble(amount);

                if (parsedDouble >= 0) {
                    parsed = true;
                } else {
                    System.out.println("Input cannot be negative. Try again:");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input must be a double. Try again:");
            } catch (NullPointerException e) {
                System.out.println("Input must not be null. Try again:");
            }
        } while (!parsed);

        return parsedDouble;
    }

    private boolean getAddMore() {
        System.out.println("Add another sale? y\\n");
        String input = getString().toUpperCase();

        while (!input.equals("Y") && !input.equals("N")) {
            System.out.println("Enter 'y' or 'n':");
            input = getString().toUpperCase();
        }

        return input.equals("Y");
    }
}
