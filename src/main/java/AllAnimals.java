import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AllAnimals{

  protected int id;
  protected String name;
  protected boolean status;

  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public boolean status(){
    return status;
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
  
}
