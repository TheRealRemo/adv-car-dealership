package com.pluralsight.dealership;

public class SalesContract extends Contract{
    public SalesContract(String date, String name, String email, String vehicle) {
        super(date, name, email, vehicle);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
