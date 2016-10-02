import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AllAnimals{
  // ????Getters will not work unless declared here and in sub class????
  protected String health;
  protected String age;
  protected int id;
  protected String name;
  protected boolean status;

  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public boolean getStatus(){
    return status;
  }
  public String getAge(){
    return age;
  }
  public String getHealth(){
    return health;
  }
  @Override
  public boolean equals(Object otherAllAnimals){
    if(!(otherAllAnimals instanceof AllAnimals)){
      return false;
    } else {
      AllAnimals newAllAnimals = (AllAnimals) otherAllAnimals;
      return this.getName().equals(newAllAnimals.getName()) && this.getId() == newAllAnimals.getId();
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM animals WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public void updateName(String name){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET name=:name WHERE id=:id";
      con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("id", id)
      .executeUpdate();
    }
  }




}
