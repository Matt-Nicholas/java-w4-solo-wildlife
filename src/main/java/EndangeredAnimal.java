import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EndangeredAnimal extends Animals{

  private String health;
  private String age;
  public static final boolean IS_ENDANGERED = true;

  public EndangeredAnimal(String name, String health, String age){

    this.name = name;
    this.health = health;
    this.age = age;
    this.status = IS_ENDANGERED;

  }
}
