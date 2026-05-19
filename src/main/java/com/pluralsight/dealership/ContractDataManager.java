package com.pluralsight.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ContractDataManager {

    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {

            if (contract instanceof SalesContract) {
                String financeOption = "";
                if (((SalesContract) contract).isFinanceOption()) {
                    financeOption = "YES";
                } else {
                    financeOption = "NO";
                }
                bw.write("SALE|" + LocalDate.now() + "|" + contract.getName()
                        + "|" + contract.getEmail() + "|" + contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear()
                        + "|" + contract.getVehicleSold().getMake() + "|" + contract.getVehicleSold().getModel()
                        + "|" + contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor() + "|"
                        + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice()
                        + "|" + ((SalesContract) contract).getSalesTaxAmount() + "|" + ((SalesContract) contract).getRecordingFee() + "|"
                        + ((SalesContract) contract).getProcessingFee() + "|" +  contract.getTotalPrice() + "|" +
                        financeOption + "|" + contract.getMonthlyPayment());
                bw.newLine();
            }
            else {
                bw.write("LEASE|" + LocalDate.now() + "|" + contract.getName()
                        + "|" + contract.getEmail() + "|" + contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear()
                        + "|" + contract.getVehicleSold().getMake() + "|" + contract.getVehicleSold().getModel()
                        + "|" + contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor() + "|"
                        + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice()
                        + "|" + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee()
                        + "|" +  contract.getTotalPrice() +  "|" + contract.getMonthlyPayment());

                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
