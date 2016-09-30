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
  @Test
  public void save_returnsTrueIfEndangeredAnimalsAretheSame() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    testEndangeredAnimal.save();
    assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
  }
  @Test
  public void save_assignsIdToEndangeredAnimal() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    testEndangeredAnimal.save();
    EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
    assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
  }
  @Test
  public void all_returnsAllInstancesOfEndangeredAnimal_true() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Mountain Beaver", "Healthy", "Youth");
    secondEndangeredAnimal.save();
    assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
    assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
  }
  @Test
  public void delete_removesEndangeredAnimalFromDB_null() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    testEndangeredAnimal.save();
    testEndangeredAnimal.delete();
    assertEquals(null, EndangeredAnimal.findById(testEndangeredAnimal.getId()));
  }
  @Test
  public void findById_returnsEndangeredAnimalWithSameId_secondBook() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Mountain Beaver", "Healthy", "Youth");
    secondEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.findById(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
  }
  @Test
  public void findByName_returnsEndangeredAnimalsWithSameName_EndangeredAnimal() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Mountain Beaver", "Healthy", "Youth");
    secondEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.findByName(secondEndangeredAnimal.getName()).get(0), secondEndangeredAnimal);
  }
  @Test
  public void findByAge_returnsEndangeredAnimalsWithSameAge_EndangeredAnimal() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Mountain Beaver", "Healthy", "Youth");
    secondEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.findByAge(secondEndangeredAnimal.getAge()).get(0), secondEndangeredAnimal);
  }
  @Test
  public void findByHealth_returnsEndangeredAnimalsWithSameHealth_EndangeredAnimal() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Goat", "Ill", "Old");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Mountain Beaver", "Healthy", "Youth");
    secondEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.findByHealth(secondEndangeredAnimal.getHealth()).get(0), secondEndangeredAnimal);
  }
}
