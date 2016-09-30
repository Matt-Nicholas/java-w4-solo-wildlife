import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/animal/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String location = request.queryParams("location");
      String ranger_name = request.queryParams("ranger_name");
      try{
        if(name.equals("") || location.equals("") || ranger_name.equals("")){
          throw new UnsupportedOperationException("All feilds must be filled out.");
        }
        Animal animal = new Animal(name);
        animal.save();
        Sighting sighting = new Sighting(animal.getId(), location, ranger_name);
        sighting.save();
        sighting.join();
        String newAnimal = animal.getName();
        model.put("rangerName", sighting.getRangerName());
        model.put("newAnimal", newAnimal);
      } catch (java.lang.UnsupportedOperationException e) {
        String error = "Oops! All feilds must be completed. Sorry for the inconvenience :(";
        model.put("error", error);
      }
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/endangeredanimal/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String health = request.queryParams("health");
      String age = request.queryParams("age");

      String location = request.queryParams("location");
      String ranger_name = request.queryParams("ranger_name");

      try{
        if(name.equals("") || location.equals("") || ranger_name.equals("") || health.equals("") || age.equals("")){
          throw new UnsupportedOperationException("All feilds must be filled out.");
        }
        EndangeredAnimal animal = new EndangeredAnimal(name, health, age);
        animal.save();
        Sighting sighting = new Sighting(animal.getId(), location, ranger_name);
        sighting.save();
        sighting.join();
        String newAnimal = animal.getName();
        model.put("rangerName", sighting.getRangerName());
        model.put("newAnimal", newAnimal);
      } catch (java.lang.UnsupportedOperationException e) {
        String error = "Oops! All feilds must be completed. Sorry for the inconvenience :(";
        model.put("error", error);
      }
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
