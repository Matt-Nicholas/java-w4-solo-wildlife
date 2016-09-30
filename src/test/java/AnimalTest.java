import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Date;


public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Goat");
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void equals_returnsTrueIfNameAndIdAreSame_true() {
    Animal testAnimal = new Animal("Goat");
    Animal anotherAnimal = new Animal("Goat");
    assertTrue(testAnimal.equals(anotherAnimal));
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Animal testAnimal = new Animal("Goat");
    testAnimal.save();
    assertTrue(Animal.all().get(0).equals(testAnimal));
  }
  

}
