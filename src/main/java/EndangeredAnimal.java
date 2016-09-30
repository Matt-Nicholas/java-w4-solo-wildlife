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
}
