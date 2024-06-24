package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double expected = 7d;
    Function function = new Addition(new FixedValue(1), new FixedValue(6));
    Double result = function.evaluate(null);
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = 6d;
    Function function = new Division(new FixedValue(12), new FixedValue(2));
    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double expected = 13.5;
    Function division = new Division(new FixedValue(9), new FixedValue(2));
    Function function = new Multiplication(division, new FixedValue(3));
    Double result = function.evaluate(null);
    assertThat(result, equalTo(expected));
  }
  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result = 20.25;
    Function division = new Division(new FixedValue(27), new FixedValue(6));
    Function function = new Pwr(division, new FixedValue(2));
    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = 6d;
    Function pwr = new Pwr(new FixedValue(36), new Division(new FixedValue(1), new FixedValue(2)));
    assertThat(result, equalTo(pwr.evaluate()));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = 136d;
    Function function = new AbsValue(new FixedValue(136));
    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = 136d;
    Function function = new AbsValue(new FixedValue(-136));
    assertThat(result, equalTo(function.evaluate()));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double expected = 0d;
    Function substraction = new Substraction(new FixedValue(5), new FixedValue(5));
    Function function = new Multiplication(substraction, new FixedValue(8));
    Double result = function.evaluate(null);
    assertThat(result, equalTo(expected));
  }
}
