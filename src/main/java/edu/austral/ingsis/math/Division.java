package edu.austral.ingsis.math;

import java.util.Map;

public class Division implements Function {
  public Function numerador;
  public Function denomindaor;

  public Division(Function numerator, Function denominator) {
    this.numerador = numerator;
    this.denomindaor = denominator;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return numerador.evaluate(variables) / denomindaor.evaluate(variables);
  }

  public double evaluate() {
    return numerador.evaluate() / denomindaor.evaluate();
  }

  @Override
  public void accept(Processor process) {
    process.process(this);
  }

  public Function getDen() {
    return denomindaor;
  }

  public Function getNum() {
    return numerador;
  }
}
