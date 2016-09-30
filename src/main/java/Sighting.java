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

  public int getId(){
    return id;
  }
  public int getAnimalId(){
    return animal_id;
  }
  public String getLocation(){
    return location;
  }
  public String getRangerName(){
    return ranger_name;
  }
  public long getTime(){
    return time;
  }


  @Override
  public boolean equals(Object otherSighting){
    if(!(otherSighting instanceof Sighting)){
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation()) && this.getId() == newSighting.getId();
    }
  }


  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO sightings (animal_id, location, ranger_name, time) VALUES (:animal_id, :location, :ranger_name, :time)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("animal_id", this.animal_id)
      .addParameter("location", this.location)
      .addParameter("ranger_name", this.ranger_name)
      .addParameter("time", this.time)
      .executeUpdate()
      .getKey();
    }
  }
  public static List<Sighting> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT id, animal_id, location, ranger_name, time FROM sightings";
      return con.createQuery(sql)
      .executeAndFetch(Sighting.class);
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sightings WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public static Sighting findById(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE id=:id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Sighting.class);
    }
  }
  public static List<Sighting> findByLocation(String location){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE location=:location";
      return con.createQuery(sql)
      .addParameter("location", location)
      .executeAndFetch(Sighting.class);
    }
  }
  public static List<Sighting> findByAnimalId(int animal_id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE animal_id=:animal_id";
      return con.createQuery(sql)
      .addParameter("animal_id", animal_id)
      .executeAndFetch(Sighting.class);
    }
  }
  public static List<Sighting> findByRangerName(String ranger_name){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE ranger_name=:ranger_name";
      return con.createQuery(sql)
      .addParameter("ranger_name", ranger_name)
      .executeAndFetch(Sighting.class);
    }
  }
  public static List<Sighting> findByTime(long time){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE time=:time";
      return con.createQuery(sql)
      .addParameter("time", time)
      .executeAndFetch(Sighting.class);
    }
  }
}
