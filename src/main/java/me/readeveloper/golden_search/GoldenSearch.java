package me.readeveloper.golden_search;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class GoldenSearch {
    public static double GOLDEN_NUMBER = 0.618;

    public static void main(String[] args) {
        String function = "2 * sin(x) - ((x ^ 2) / 10)";
        Expression expression = new ExpressionBuilder(function).variable("x").build();
        double error = 0.1;
        double xMin = 0;
        double xMax = 4;
        double x1, x2, fx1, fx2, diff;
        int i = 1;

        do {
            System.out.println("Iteración: " + i);
            x1 = xMax - GOLDEN_NUMBER * (xMax - xMin);
            x2 = xMin + GOLDEN_NUMBER * (xMax - xMin);

            fx1 = expression.setVariable("x", x1).evaluate();
            fx2 = expression.setVariable("x", x2).evaluate();

            System.out.println("xMin: " + xMin);
            System.out.println("xMax: " + xMax);
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
            System.out.println("fx1: " + fx1);
            System.out.println("fx2: " + fx2);

            if (fx1 > fx2) {
                xMax = x2;
            } else if (fx2 > fx1) {
                xMin = x1;
            }

            diff = Math.abs(x1 - x2);
            i++;
            System.out.println("---------------------------------------");
        } while (diff > error);

        System.out.println("x1 final: " + x1);
        System.out.println("x2 final: " + x2);
    }
}
