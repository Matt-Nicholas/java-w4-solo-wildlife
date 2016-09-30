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
}
