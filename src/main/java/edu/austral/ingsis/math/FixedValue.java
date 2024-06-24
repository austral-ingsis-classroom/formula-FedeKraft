package edu.austral.ingsis.math;

import java.util.Map;

public class FixedValue implements Function{
    Function val;
    public FixedValue(Function val){
        this.val = val;
    }
    @Override
    public double evaluate(Map<String, Double> variables) {
        return val.evaluate(variables);
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
}
