package edu.austral.ingsis.math;

import java.security.PublicKey;
import java.util.Map;

public class Substraction implements Function{
    Function Sub1;
    Function Sub2;
    public Substraction(Function Sub1, Function Sub2){
        this.Sub1 = Sub1;
        this.Sub2 = Sub2;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return Sub1.evaluate(variables) - Sub2.evaluate(variables);
    }
    public double evaluate() {
        return Sub1.evaluate() - Sub2.evaluate();
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
