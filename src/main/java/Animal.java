import java.util.List;
import org.sql2o.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Animal extends Animals{
  public static final boolean IS_ENDANGERED = false;



  public Animal(String name){
    this.name = name;
    this.status = IS_ENDANGERED;

  }


}
