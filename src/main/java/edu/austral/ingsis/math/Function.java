package edu.austral.ingsis.math;

import java.util.Map;

public interface Function {
  double evaluate(Map<String, Double> variables);

  double evaluate();

  void accept(Processor process);
}
