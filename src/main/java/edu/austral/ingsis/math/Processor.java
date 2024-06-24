package edu.austral.ingsis.math;

public interface Processor {
    void process(Addition Sum);
    void process(Substraction Sub);
    void process(Division Div);

    void process(Multiplication Mult);
    void process(VarValue var);
    void process(Pwr exp);
    void process(FixedValue fixV);
    void process(SqrRoot sqrt);
    void process(AbsValue abs);



}
