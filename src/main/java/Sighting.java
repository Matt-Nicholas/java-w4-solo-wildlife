import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Sighting{

  private int id;
  private int animal_id;
  private String location;
  private String ranger_name;
  private long time;

  public Sighting(int animal_id, String location, String ranger_name){

    this.animal_id = animal_id;
    this.location = location;
    this.ranger_name = ranger_name;
    time = new Date().getTime();

  }
}
