package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.varHandle.VarManager;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new Addition(new FixedValue(1), new FixedValue(6));
    VarManager varManager = new VarManager(function);
    final List<String> result = varManager.getVarNames();
    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new Division(new FixedValue(12), new VarValue("div"));
    VarManager varManager = new VarManager(function);
    final List<String> result = varManager.getVarNames();
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function =
        new Multiplication(new Division(new FixedValue(9), new VarValue("x")), new VarValue("y"));
    VarManager varManager = new VarManager(function);
    final List<String> result = varManager.getVarNames();
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function =
        new Pwr(new Division(new FixedValue(27), new VarValue("a")), new VarValue("b"));
    VarManager varManager = new VarManager(function);
    final List<String> result = varManager.getVarNames();
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function =
        new Pwr(new VarValue("z"), new Division(new FixedValue(1), new FixedValue(2)));
    VarManager varManager = new VarManager(function);
    final List<String> result = varManager.getVarNames();
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new Substraction(new AbsValue(new VarValue("value")), new FixedValue(8));
    VarManager variableManager = new VarManager(function);
    final List<String> result = variableManager.getVarNames();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function function = new Substraction(new AbsValue(new VarValue("value")), new FixedValue(8));
    VarManager variableManager = new VarManager(function);
    final List<String> result = variableManager.getVarNames();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function =
        new Multiplication(
            new Substraction(new FixedValue(5), new VarValue("i")), new FixedValue(8));
    VarManager variableManager = new VarManager(function);
    final List<String> result = variableManager.getVarNames();
    assertThat(result, containsInAnyOrder("i"));
  }
}
