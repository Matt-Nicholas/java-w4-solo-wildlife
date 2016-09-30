import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Animal extends AllAnimals{
  public static final boolean IS_ENDANGERED = false;


  public Animal(String name){
    this.name = name;
    this.status = IS_ENDANGERED;

  }
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals (name, status) VALUES (:name, :status)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("status", this.status)
      .executeUpdate()
      .getKey();
    }
  }
  public static List<Animal> all(){
    try(Connection con= DB.sql2o.open()){
      String sql = "SELECT id, name, status FROM animals";
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(Animal.class);
    }
  }
  public static Animal findById(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE id=:id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(Animal.class);
    }
  }
  public static List<Animal> findByName(String name){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE name=:name";
      return con.createQuery(sql)
      .addParameter("name", name)
      .throwOnMappingFailure(false)
      .executeAndFetch(Animal.class);
    }
  }
  
}
