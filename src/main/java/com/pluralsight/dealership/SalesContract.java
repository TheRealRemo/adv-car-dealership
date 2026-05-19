package com.pluralsight.dealership;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String name, String email, Vehicle vehicle, boolean isFinanced) {
        super(date, name, email, vehicle);
        this.salesTax = 0.05;
        this.recordingFee = 100;
        this.processingFee = processingFee;
        this.isFinanced = isFinanced;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        this.isFinanced = financed;
    }

    @Override
    public double getTotalPrice() {
        double taxAmount = getVehicleSold().getPrice() * salesTax;
        if (getVehicleSold().getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        double totalPrice = getVehicleSold().getPrice() + taxAmount +
                processingFee + recordingFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPayment = 0;
        double monthlyRate = 0;
        int numberOfMonths = 0;
        if (isFinanced && (getTotalPrice() >= 10000)) {
            numberOfMonths = 48;
            monthlyRate = 0.0425 / 12;
             monthlyPayment = getTotalPrice() * monthlyRate * Math.pow(1 + monthlyRate, numberOfMonths)
                     / (Math.pow(1 + monthlyRate, numberOfMonths) - 1);
        } else if (isFinanced && (getTotalPrice() <= 10000)) {
            monthlyRate = 0.0525 / 12;
            numberOfMonths = 24;
            monthlyPayment = getTotalPrice() * monthlyRate * Math.pow(1 + monthlyRate, numberOfMonths)
                    / (Math.pow(1 + monthlyRate, numberOfMonths) - 1);
        }
        return monthlyPayment;
    }
}

