package edu.austral.ingsis.math;

import java.util.Map;

public class VarValue implements Function {
    private final String var;

    public VarValue(String name) {
        this.var = name;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        Double value = variables.get(var);
        if (value == null) {
            throw new IllegalStateException("Variable not initialized: " + var);
        }
        return value;
    }


    @Override
    public void accept(Processor process) {
        process.process(this);
    }

    public String getVar() {
        return var;
    }
}