import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/log", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("Sighting", Sighting.class);
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings", Sighting.all());
      model.put("template", "templates/log.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/log/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      // if(Animal.findById(sighting.getAnimalId()) == );
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("sighting", sighting);
      model.put("template", "templates/sighting.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // FILTER LOG
    get("/log/location/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      model.put("filter", "Location");
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("Sighting", Sighting.class);
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings",  Sighting.findByLocation(sighting.getLocation()));
      model.put("template", "templates/log.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/log/ranger/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      model.put("filter", "Ranger");
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("Sighting", Sighting.class);
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings",  Sighting.findByRangerName(sighting.getRangerName()));
      model.put("template", "templates/log.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/log/species/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      List<Sighting> sightings = new ArrayList<Sighting>();
      Animal animal = Animal.findById(sighting.getAnimalId());
      for(Animal currentAnimal : Animal.findByName(animal.getName())){
        sightings.add(Sighting.findByAnimalId(currentAnimal.getId()));
      }
      model.put("filter", "Species");
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("Sighting", Sighting.class);
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings",  sightings);
      model.put("template", "templates/log.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/log/health/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      List<Sighting> sightings = new ArrayList<Sighting>();
      EndangeredAnimal animal = EndangeredAnimal.findById(sighting.getAnimalId());
      for(EndangeredAnimal currentAnimal : EndangeredAnimal.findByHealth(animal.getHealth())){
        sightings.add(Sighting.findByAnimalId(currentAnimal.getId()));
      }
      model.put("filter", "Health");
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("Sighting", Sighting.class);
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings",  sightings);
      model.put("template", "templates/log.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/log/age/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      List<Sighting> sightings = new ArrayList<Sighting>();
      EndangeredAnimal animal = EndangeredAnimal.findById(sighting.getAnimalId());
      for(EndangeredAnimal currentAnimal : EndangeredAnimal.findByAge(animal.getAge())){
        sightings.add(Sighting.findByAnimalId(currentAnimal.getId()));
      }
      model.put("filter", "Age");
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("Sighting", Sighting.class);
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings",  sightings);
      model.put("template", "templates/log.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/log/status/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      List<Sighting> sightings = new ArrayList<Sighting>();
      EndangeredAnimal animal = EndangeredAnimal.findById(sighting.getAnimalId());
      for(EndangeredAnimal currentAnimal : EndangeredAnimal.findByStatus(animal.getStatus())){
        sightings.add(Sighting.findByAnimalId(currentAnimal.getId()));
      }
      model.put("filter", "Status");
      model.put("Animal", Animal.class);
      model.put("EndangeredAnimal", EndangeredAnimal.class);
      model.put("Sighting", Sighting.class);
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings",  sightings);
      model.put("template", "templates/log.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // POST ROUTES
    post("/animal/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String location = request.queryParams("location");
      String ranger_name = request.queryParams("ranger_name");
      try{
        if(name.equals("") || location.equals("") || ranger_name.equals("")){
          throw new UnsupportedOperationException("Empty Text Field");
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

    post("endangeredanimal/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String health = request.queryParams("health");
      String age = request.queryParams("age");
      String location = request.queryParams("location");
      String ranger_name = request.queryParams("ranger_name");
      try{
        if(name.equals("") || location.equals("") || ranger_name.equals("") || health.equals("") || age.equals("")){
          throw new UnsupportedOperationException("Empty Text Field");
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

    post("/update/animal/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      Animal animal = Animal.findById(sighting.getAnimalId());
        try{
          if(request.queryParams("name").equals("") || request.queryParams("location").equals("") || request.queryParams("ranger_name").equals("")){
            throw new UnsupportedOperationException("Empty Text Field");
          }
          model.put("success", "Sucessfully updated");
          animal.updateName(request.queryParams("name"));
          sighting.updateRangerName(request.queryParams("ranger_name"));
          sighting.updateLocation(request.queryParams("location"));
        } catch (java.lang.UnsupportedOperationException e) {
          String error = "Oops! It looks like on of the text fields was empty. Sorry for the inconvenience :(";
          model.put("error", error);
        }
        model.put("Animal", Animal.class);
        model.put("EndangeredAnimal", EndangeredAnimal.class);
        model.put("sighting", sighting);
      model.put("template", "templates/sighting.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/update/endangered-animal/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.findById(Integer.parseInt(request.params(":id")));
      EndangeredAnimal animal = EndangeredAnimal.findById(sighting.getAnimalId());
        try{
          if(request.queryParams("name").equals("") || request.queryParams("location").equals("") || request.queryParams("ranger_name").equals("") || request.queryParams("health").equals("") || request.queryParams("age").equals("")){
              throw new UnsupportedOperationException("Empty Text Field");
              }
          model.put("success", "Sucessfully updated");
          animal.updateName(request.queryParams("name"));
          animal.updateHealth(request.queryParams("health"));
          animal.updateAge(request.queryParams("age"));
          sighting.updateRangerName(request.queryParams("ranger_name"));
          sighting.updateLocation(request.queryParams("location"));
        } catch (java.lang.UnsupportedOperationException e) {
          String error = "Oops! It looks like on of the text fields was empty. Sorry for the inconvenience :(";
          model.put("error", error);
        }
        model.put("Animal", Animal.class);
        model.put("EndangeredAnimal", EndangeredAnimal.class);
        model.put("sighting", sighting);
        model.put("template", "templates/sighting.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  }
}
