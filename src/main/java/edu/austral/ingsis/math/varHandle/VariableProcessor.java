package edu.austral.ingsis.math.varHandle;

import edu.austral.ingsis.math.*;

import java.util.HashSet;
import java.util.Set;

public class VariableProcessor implements Processor {
    private final Set<String> hashSet = new HashSet<>();

    @Override
    public void process(Addition sum) {
        sum.getSum1().accept(this);
        sum.getSum2().accept(this);
    }

    @Override
    public void process(Substraction subtraction) {
        subtraction.getSub1().accept(this);
        subtraction.getSub2().accept(this);
    }

    @Override
    public void process(Multiplication multiplication) {
        multiplication.getMult1().accept(this);
        multiplication.getMult2().accept(this);
    }

    @Override
    public void process(Division division) {
        division.denomindaor.accept(this);
        division.numerador.accept(this);
    }

    @Override
    public void process(SqrRoot root) {
        root.getEval().accept(this);
    }

    @Override
    public void process(Pwr exponentiation) {
        exponentiation.getNum().accept(this);
        exponentiation.getPow().accept(this);
    }

    @Override
    public void process(AbsValue absolute) {
        absolute.getAbs().accept(this);
    }

    @Override
    public void process(FixedValue number) {
        // Numbers don't have variable names
    }

    @Override
    public void process(VarValue variable) {
        hashSet.add(variable.getVar());
    }

    public Set<String> getHashSet() {
        return hashSet;
    }
}