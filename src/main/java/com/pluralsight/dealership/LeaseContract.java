package com.pluralsight.dealership;

public class LeaseContract extends Contract {
    private double endingValue;
    private double leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicleSold) {
        super(date, name, email, vehicleSold);
    }


    @Override
    public double getTotalPrice() {
        endingValue = getVehicleSold().getPrice() * 0.50;
        leaseFee = getVehicleSold().getPrice() * 0.07;
        double totalPrice = endingValue + leaseFee;

        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPayment = 0;
        double monthlyRate = 0;
        int numberOfMonths = 0;
        numberOfMonths = 36;
        monthlyRate = 0.04 / 12;
        monthlyPayment = getTotalPrice() * monthlyRate * Math.pow(1 + monthlyRate, numberOfMonths)
                / (Math.pow(1 + monthlyRate, numberOfMonths) - 1);
        return monthlyPayment;

    }
}
