import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void checkTriangle_Equilateral_1() {
    Triangle testTri = new Triangle(2, 2, 2);
    int expected = 1;
    assertEquals(expected, testTri.checkTriangle());
  }
  @Test
  public void checkTriangle_Iso_2() {
    Triangle testTri = new Triangle(2, 3, 2);
    int expected = 2;
    assertEquals(expected, testTri.checkTriangle());
  }
  @Test
  public void checkTriangle_Scalene_3() {
    Triangle testTri = new Triangle(2, 3, 4);
    int expected = 3;
    assertEquals(expected, testTri.checkTriangle());
  }
  @Test
  public void checkTriangle_NotATri_4() {
    Triangle testTri = new Triangle(2, 3, 5);
    int expected = 4;
    assertEquals(expected, testTri.checkTriangle());
  }

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Triangle");
  }

  @Test
  public void equilateralTest() {
    goTo("http://localhost:4567/");
    fill("#side1").with("2");
    fill("#side2").with("2");
    fill("#side3").with("2");
    submit(".btn");
    assertThat(pageSource()).contains("Equilateral");
  }

  @Test
  public void isoscelesTest() {
    goTo("http://localhost:4567/");
    fill("#side1").with("2");
    fill("#side2").with("3");
    fill("#side3").with("2");
    submit(".btn");
    assertThat(pageSource()).contains("Isosceles");
  }

  @Test
  public void scaleneTest() {
    goTo("http://localhost:4567/");
    fill("#side1").with("2");
    fill("#side2").with("3");
    fill("#side3").with("4");
    submit(".btn");
    assertThat(pageSource()).contains("Scalene");
  }

  @Test
  public void notTriTest() {
    goTo("http://localhost:4567/");
    fill("#side1").with("2");
    fill("#side2").with("3");
    fill("#side3").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("not a Triangle");
  }


  // @Test
  // public void letterReplace_testForA() {
  //   App yourApp = new App();
  //   String expected = "-s";
  //   assertEquals(expected, yourApp.letterReplace("as"));
  // }

}
