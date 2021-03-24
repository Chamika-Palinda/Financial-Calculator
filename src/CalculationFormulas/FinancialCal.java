package CalculationFormulas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FinancialCal {

    public static BigDecimal calculateFutureValue(
            double timeInYears,
            double presentValue,
            double interestRate,
            double paymentValue) {

        int numOfPeriods = 1;

        double realInterestRate = interestRate/100/numOfPeriods;

        //Calculate
        double packOne = Math.pow(1 + realInterestRate, timeInYears * numOfPeriods);
        double comPrincipleAmount = presentValue * packOne;
        double futureValue = (paymentValue*(packOne-1)/realInterestRate)+comPrincipleAmount;

        BigDecimal futureValueWithDecimal = new BigDecimal(futureValue).setScale(2, RoundingMode.HALF_EVEN);

        return futureValueWithDecimal;
    }

    public static BigDecimal calculatePresentValue(
            double futureValue,
            double timeInYears,
            double interestRate,
            double paymentValue) {

        double realInterestRate = interestRate/100;

        //Calculate
        double packOne = Math.pow(1+realInterestRate,timeInYears);
        double presentValue = futureValue/packOne;

        BigDecimal presentValueWithDecimal = new BigDecimal(presentValue).setScale(2, RoundingMode.HALF_EVEN);

        return presentValueWithDecimal;
    }

    public static void main(String[] args) {
        System.out.println(
                calculatePresentValue(1000000,10,6,0));
    }


    public static BigDecimal calculatePMT(
            double futureValue,
            double timeInYears,
            double presentValue,
            double interestRate) {


        int numOfPeriods = 1;

        double realInterestRate = interestRate/(100*numOfPeriods);

        //Calculate
        double packOne = Math.pow(1 + realInterestRate, timeInYears * numOfPeriods);
        double comPrincipleAmount = presentValue * packOne;
        double paymentValue = (futureValue-comPrincipleAmount) / ((packOne-1)/realInterestRate);

        BigDecimal PMTValueWithDecimal = new BigDecimal(paymentValue).setScale(2, RoundingMode.HALF_EVEN);

        return PMTValueWithDecimal;
    }

    public static BigDecimal calculateInterestRate(
            double futureValue,
            double timeInYears,
            double presentValue,
            double paymentValue) {


        //Calculate
        double packOne = Math.pow(futureValue/presentValue,1/timeInYears);
        double comPrincipleAmount = Math.pow(paymentValue,1/timeInYears);
        double interestRate = (packOne-1)*100-comPrincipleAmount;

        BigDecimal InterestRateValueWithDecimal = new BigDecimal(interestRate).setScale(3, RoundingMode.HALF_EVEN);

        return InterestRateValueWithDecimal;
    }

}
