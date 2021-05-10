package it.euris.test.exercise.developerTestEuris.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Operations implements IOperations{

    /**
     * Sum from a external values
     * @param values Ex (5p 17s 8d + 3p 4s 10d)
     * @return result of the operation
     */
    @Override
    public String sum(String values) {
        String[] operandOff = values.split("\\+");
        String[] firstOperand = operandOff[0].split(" ");
        String[] secondOperand = operandOff[1].split(" ");

        int p = Integer.parseInt(firstOperand[0].substring(0, firstOperand[0].length() - 1));
        int s = Integer.parseInt(firstOperand[1].substring(0, firstOperand[1].length() - 1));
        int d = Integer.parseInt(firstOperand[2].substring(0, firstOperand[2].length() - 1));
        int p1 = Integer.parseInt(secondOperand[1].substring(0, secondOperand[1].length() - 1));
        int s1 = Integer.parseInt(secondOperand[2].substring(0, secondOperand[2].length() - 1));
        int d1 = Integer.parseInt(secondOperand[3].substring(0, secondOperand[3].length() - 1));

        int sumD = d + d1;
        int sumS = s + s1;
        int sumP = p + p1;

        int resultD = 0;
        if (sumD >= 12) {
            resultD = sumD % 12;
            sumS += sumD / 12;
        } else {
            resultD = sumD;
        }


        int resultS = 0;
        if (sumS >= 20) {
            resultS = sumS % 20;
            sumP += sumS / 20;
        } else {
            resultS = sumS;
        }



        return values + " = " + sumP + "p " + resultS + "s " + resultD + "d ";
    }

    /**
     * Subtraction from a external values
     * @param values Ex (5p 17s 8d - 3p 4s 10d)
     * @return result of the operation
     */
    @Override
    public String subtraction(String values) {
        String[] operandOff = values.split("\\-");
        String[] firstOperand = operandOff[0].split(" ");
        String[] secondOperand = operandOff[1].split(" ");

        int p = Integer.parseInt(firstOperand[0].substring(0, firstOperand[0].length() - 1));
        int s = Integer.parseInt(firstOperand[1].substring(0, firstOperand[1].length() - 1));
        int d = Integer.parseInt(firstOperand[2].substring(0, firstOperand[2].length() - 1));
        int p1 = Integer.parseInt(secondOperand[1].substring(0, secondOperand[1].length() - 1));
        int s1 = Integer.parseInt(secondOperand[2].substring(0, secondOperand[2].length() - 1));
        int d1 = Integer.parseInt(secondOperand[3].substring(0, secondOperand[3].length() - 1));

        int subtrD = d - d1;
        int subtrS = s - s1;
        int subtrP = p - p1;

        int resultD = 0;
        if (subtrD < 0) {
            resultD = 12 + subtrD;
            s -= 1;
        } else {
            resultD = subtrD;
        }


        int resultS = 0;
        if (subtrS < 0) {
            resultS = 20 + subtrS;
            p -= 1;
        } else {
            resultS = subtrS;
        }



        return values + " = " + subtrP + "p " + resultS + "s " + resultD + "d ";
    }

    /**
     * Moltiplication from a external values
     * @param values Ex (5p 17s 8d * 2)
     * @return result of the operation
     */
    @Override
    public String moltiplication(String values) {
        String[] operandOff = values.split("\\*");
        String[] firstOperand = operandOff[0].split(" ");
        String[] secondOperand = operandOff[1].split(" ");

        int p = Integer.parseInt(firstOperand[0].substring(0, firstOperand[0].length() - 1));
        int s = Integer.parseInt(firstOperand[1].substring(0, firstOperand[1].length() - 1));
        int d = Integer.parseInt(firstOperand[2].substring(0, firstOperand[2].length() - 1));
        int operandM = Integer.parseInt(secondOperand[1]);

        int moltiD = d * operandM;
        int moltiS = s * operandM;
        int moltiP = p * operandM;

        int resultD = 0;
        if (moltiD >= 12) {
            resultD = moltiD % 12;
            moltiS += moltiD / 12;
        } else {
            resultD = moltiD;
        }

        int resultS = 0;
        if (moltiS >= 20) {
            resultS = moltiS % 20;
            moltiP += moltiS / 20;
        } else {
            resultS = moltiS;
        }


        return values + " = " + moltiP + "p " + resultS + "s " + resultD + "d ";
    }

    /**
     * Division from a external values
     * @param operandOne Ex (18p 16s 1d)
     * @param operandTwo Ex (15)
     * @return Result of the operation
     */
    @Override
    public String division(String operandOne, String operandTwo) {

        String[] firstOperand = operandOne.split(" ");

        int p = Integer.parseInt(firstOperand[0].substring(0, firstOperand[0].length() - 1));
        int s = Integer.parseInt(firstOperand[1].substring(0, firstOperand[1].length() - 1));
        int d = Integer.parseInt(firstOperand[2].substring(0, firstOperand[2].length() - 1));
        int operandD = Integer.parseInt(operandTwo);

        int divP = p / operandD;
        int restP = p % operandD;

        s += restP * 20;
        restP = 0;
        int divS = s / operandD;
        int restS = s % operandD;

        d += restS * 12;
        int divD = d / operandD;
        int restD = d % operandD;

        if (restD >= 12) {
            restD = restD % 12;
            restS += restD / 12;
        }

        if (restS >= 20) {
            restS = restS % 20;
            restP += restS / 20;
        }
        String resultValue = "";
        if (restD == 0 && restS == 0 && restP == 0) {
            resultValue = operandOne + " / " + operandTwo + " = " + divP + "p " + divS + "s " + divD + "d ";
        } else {
            resultValue = operandOne + " / " + operandTwo + " = " + divP + "p " + divS + "s " + divD + "d " + "("+ restP + "p " + restS + "s " + restD + "d)";
        }
        return resultValue;
    }
}
