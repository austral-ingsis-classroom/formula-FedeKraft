package edu.austral.ingsis.math;

import java.util.Map;

public class FixedValue implements Function{
    double val;
    public FixedValue(double val){
        this.val = val;
    }
    @Override
    public double evaluate(Map<String, Double> variables) {
        return val;
    }
    public double evaluate() {
        return val;
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public double getVal() {return val;}
}
