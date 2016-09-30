import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EndangeredAnimal extends AllAnimals{

  private String health;
  private String age;
  public static final boolean IS_ENDANGERED = true;

  public EndangeredAnimal(String name, String health, String age){

    this.name = name;
    this.health = health;
    this.age = age;
    this.status = IS_ENDANGERED;
  }

  public String getAge(){
    return age;
  }
  public String getHealth(){
    return health;
  }

  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals (name, health, age, status) VALUES (:name, :health, :age, :status)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("status", this.status)
      .addParameter("health", this.health)
      .addParameter("age", this.age)
      .executeUpdate()
      .getKey();
    }
  }
  public static List<EndangeredAnimal> all(){
    try(Connection con= DB.sql2o.open()){
      String sql = "SELECT id, name, health, age, status FROM animals";
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(EndangeredAnimal.class);
    }
  }
  public static EndangeredAnimal findById(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE id=:id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(EndangeredAnimal.class);
    }
  }
  public static List<EndangeredAnimal> findByName(String name){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE name=:name";
      return con.createQuery(sql)
      .addParameter("name", name)
      .throwOnMappingFailure(false)
      .executeAndFetch(EndangeredAnimal.class);
    }
  }
  public static List<EndangeredAnimal> findByAge(String age){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE age=:age";
      return con.createQuery(sql)
      .addParameter("age", age)
      .throwOnMappingFailure(false)
      .executeAndFetch(EndangeredAnimal.class);
    }
  }
  public static List<EndangeredAnimal> findByHealth(String health){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE health=:health";
      return con.createQuery(sql)
      .addParameter("health", health)
      .throwOnMappingFailure(false)
      .executeAndFetch(EndangeredAnimal.class);
    }
  }
  public void updateHealth(String health){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET health=:health WHERE id=:id";
      con.createQuery(sql)
      .addParameter("health", health)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public void updateAge(String age){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET age=:age WHERE id=:id";
      con.createQuery(sql)
      .addParameter("age", age)
      .addParameter("id", id)
      .executeUpdate();
    }
  }


}
