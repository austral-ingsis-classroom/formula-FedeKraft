package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double expected = 4d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3d);
    Function function = new Addition(new FixedValue(1), new VarValue("x"));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double expected = 3d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("div", 4d);
    Function function = new Division(new FixedValue(12), new VarValue("div"));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double expected = 12d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3d);
    variables.put("y", 4d);
    Function division = new Division(new FixedValue(9), new VarValue("x"));
    Function function = new Multiplication(division, new VarValue("y"));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double expected = 27d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("a", 9d);
    variables.put("b", 3d);
    Function division = new Division(new FixedValue(27), new VarValue("a"));
    Function function = new Pwr(division, new VarValue("b"));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double expected = 6d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("z", 36d);
    Function function = new Pwr(new VarValue("z"), new FixedValue(0.5));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double expected = 0d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8d);
    Function function = new Substraction(new AbsValue(new VarValue("value")), new FixedValue(8));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 where value = -8 */
  @Test
  public void shouldResolveFunction7() {
    final Double expected = 0d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", -8d);
    Function function = new Substraction(new AbsValue(new VarValue("value")), new FixedValue(8));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double expected = 24d;
    Map<String, Double> variables = new HashMap<>();
    variables.put("i", 2d);
    Function subtraction = new Substraction(new FixedValue(5), new VarValue("i"));
    Function function = new Multiplication(subtraction, new FixedValue(8));
    Double result = function.evaluate(variables);
    assertThat(result, equalTo(expected));
  }
}
