package CalculationFormulas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MortgageCal {
    public static void main(String[] args) {

    }

    public static BigDecimal calculateMonthlyPayment(
            double loanAmount, double termInYears, double interestRate, double downPayment) {

        interestRate /= 100.0;
        double monthlyRate = interestRate / 12.0;
        double termInMonths = termInYears * 12;

        if(downPayment>=0){
            double realDownpayment = loanAmount*(downPayment/100);
            loanAmount = loanAmount - realDownpayment;
        }
        double monthlyPayment =
                (loanAmount*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonths));

        BigDecimal monthlyPaymentWithDecimal =new BigDecimal(monthlyPayment).setScale(2, RoundingMode.HALF_EVEN);

        return monthlyPaymentWithDecimal;
    }

}
