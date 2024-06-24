package edu.austral.ingsis.math;

import java.util.Map;

public class SqrRoot implements Function{
    Function eval;

    public SqrRoot(Function eval){
        this.eval = eval;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return Math.sqrt(eval.evaluate(variables));
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public Function getEval() {return eval;}
}
