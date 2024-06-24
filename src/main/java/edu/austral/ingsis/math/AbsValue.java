package edu.austral.ingsis.math;

import java.util.Map;

public class AbsValue implements Function{
    Function abs;
    public AbsValue(Function abs){
        this.abs = abs;
    }
    @Override
    public double evaluate(Map<String, Double> variables) {
        return Math.abs(abs.evaluate(variables));
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public Function getAbs() {return abs;}
}
