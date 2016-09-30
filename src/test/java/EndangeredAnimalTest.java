import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Date;


public class EndangeredAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void equals_returnsTrueIfNameAndIdAreSame_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
  }

}
