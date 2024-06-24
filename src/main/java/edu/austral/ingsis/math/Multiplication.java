package edu.austral.ingsis.math;

import java.util.Map;

public class Multiplication implements Function{

    Function mult1;
    Function mult2;
    public Multiplication(Function mult1, Function mult2){
        this.mult1 = mult1;
        this.mult2 = mult2;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return mult1.evaluate(variables) * mult2.evaluate(variables);
    }

    @Override
    public void accept(Processor process) {
        process.process(this);
    }
    public Function getMult1() {return mult1;}

    public Function getMult2() {return mult2;}
}

