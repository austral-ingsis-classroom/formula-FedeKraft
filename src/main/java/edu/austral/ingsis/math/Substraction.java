package edu.austral.ingsis.math;

import java.security.PublicKey;
import java.util.Map;

public class Substraction implements Function{
    Function Sub1;
    Function Sub2;

    @Override
    public double evaluate(Map<String, Double> variables) {
        return Sub1.evaluate(variables) - Sub2.evaluate(variables);
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public Function getSub1() {
        return Sub1;
    }

    public Function getSub2() {return Sub2;}
}
