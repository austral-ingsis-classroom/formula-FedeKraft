package edu.austral.ingsis.math;

import java.util.Map;

public class Addition implements Function{
    Function sum1;
    Function sum2;

    public Addition(Function sum1, Function sum2) {
        this.sum1 = sum1;
        this.sum2 = sum2;
    }
    @Override
    public double evaluate(Map<String, Double> variables) {
        return sum1.evaluate(variables) + sum2.evaluate(variables);
    }
    public double evaluate() {
        return sum1.evaluate() + sum2.evaluate();
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public Function getSum1() {return sum1;}

    public Function getSum2() {return sum2;}
}
