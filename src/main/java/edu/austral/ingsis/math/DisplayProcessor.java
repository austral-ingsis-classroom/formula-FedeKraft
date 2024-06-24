package edu.austral.ingsis.math;

public class DisplayProcessor implements Processor{
    private final StringBuilder stringBuild = new StringBuilder();

    @Override
    public void process(Addition Sum) {
        stringBuild.append("(");
        Sum.getSum1().accept(this);
        stringBuild.append(" + ");
        Sum.getSum2().accept(this);
        stringBuild.append(")");
    }

    @Override
    public void process(Substraction Sub) {
        stringBuild.append("(");
        Sub.getSub1().accept(this);
        stringBuild.append(" - ");
        Sub.getSub2().accept(this);
        stringBuild.append(")");
    }

    @Override
    public void process(Division Div) {
        stringBuild.append("(");
        Div.denomindaor.accept(this);
        stringBuild.append(" / ");
        Div.numerador.accept(this);
        stringBuild.append(")");
    }

    @Override
    public void process(Multiplication Mult) {
        stringBuild.append("(");
        Mult.getMult1().accept(this);
        stringBuild.append(" * ");
        Mult.getMult2().accept(this);
        stringBuild.append(")");
    }

    @Override
    public void process(VarValue var) {
        stringBuild.append(var.getVar());
    }

    @Override
    public void process(Pwr exp) {
        stringBuild.append("(");
        exp.getNum().accept(this);
        stringBuild.append(" ^ ");
        exp.getPow().accept(this);
        stringBuild.append(")");
    }

    @Override
    public void process(FixedValue fixV) {
        stringBuild.append(String.valueOf(fixV.getVal()));
    }

    @Override
    public void process(SqrRoot sqrt) {
        stringBuild.append("sqrt(");
        sqrt.getEval().accept(this);
        stringBuild.append(")");
    }

    @Override
    public void process(AbsValue abs) {
        stringBuild.append("|");
        abs.getAbs().accept(this);
        stringBuild.append("|");
    }
}