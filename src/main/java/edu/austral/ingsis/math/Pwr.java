package edu.austral.ingsis.math;

import java.util.Map;

public class Pwr implements Function{
    Function num;
    Function pow;
    public Pwr(Function num, Function pow){
        this.num = num;
        this.pow = pow;
    }
    @Override
    public double evaluate(Map<String, Double> variables) {
        return Math.pow(num.evaluate(variables), pow.evaluate(variables));
    }
    public double evaluate() {
        return Math.pow(num.evaluate(), pow.evaluate());
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public Function getNum() {return num;}
    public Function getPow() {return pow;}
}
