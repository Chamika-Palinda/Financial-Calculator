package CalculationFormulas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AutoLoanCal {

    public static BigDecimal calculateTotalPrice(
            double loanAmount, double termInMonths, double interestRate, double downPayment) {

        interestRate /= 100.0;
        double monthlyRate = interestRate / 12.0;

        if (downPayment >= 0) {
            loanAmount = loanAmount - downPayment;
        }
        double monthlyPayment =
                (loanAmount * monthlyRate) /
                        (1 - Math.pow(1 + monthlyRate, -termInMonths));

        BigDecimal monthlyPaymentWithDecimal = new BigDecimal(monthlyPayment).setScale(2, RoundingMode.HALF_EVEN);

        return monthlyPaymentWithDecimal;
    }


    public static BigDecimal calculateVehiclePrice(
            double paymentValue, double numOfPeriods, double interestRate, double downPayment) {


        double realInterestRate = (interestRate / 100) / numOfPeriods;

        //Calculate
        double packOne = Math.pow(1 + realInterestRate, numOfPeriods);
        double futureValue = paymentValue * ((packOne - 1) / realInterestRate);
        futureValue = futureValue + downPayment;

        BigDecimal vehiclePriceWithDecimal = new BigDecimal(futureValue).setScale(2, RoundingMode.HALF_EVEN);

        return vehiclePriceWithDecimal;

    }
}
