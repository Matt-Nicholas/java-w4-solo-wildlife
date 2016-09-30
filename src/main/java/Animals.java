import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Animals{

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
  public boolean equals(Object otherAnimals){
    if(!(otherAnimals instanceof Animals)){
      return false;
    } else {
      Animals newAnimals = (Animals) otherAnimals;
      return this.getName().equals(newAnimals.getName()) && this.getId() == newAnimals.getId();
    }
  }
}
