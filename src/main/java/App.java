import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Object;
import java.lang.String;
import spark.ModelAndView;
import static java.lang.System.out;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;


public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      int inputSide1 = Integer.parseInt(request.queryParams("side1"));
      int inputSide2 = Integer.parseInt(request.queryParams("side2"));
      int inputSide3 = Integer.parseInt(request.queryParams("side3"));

      Triangle tri = new Triangle(inputSide1, inputSide2, inputSide3);
      int triangle = tri.checkTriangle();

      model.put("triangle", triangle);
      model.put("inputSide1", inputSide1);
      model.put("inputSide2", inputSide2);
      model.put("inputSide3", inputSide3);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
