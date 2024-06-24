package edu.austral.ingsis.math;

import java.util.Map;

public class Division implements Function{
    Function denominator;
    Function numerator;

    public Division(Function numerator, Function denominator) {
        this.denominator = denominator;
        this.numerator = numerator;
    }
    @Override
    public double evaluate(Map<String, Double> variables) {
        return denominator.evaluate(variables) / numerator.evaluate(variables);
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public Function getDen() {return denominator;}

    public Function getNum() {return numerator;}
}
