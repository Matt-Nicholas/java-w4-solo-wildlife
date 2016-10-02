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
  public void save_returnsTrueIfAnimalsAretheSame() {
    Animal testAnimal = new Animal("Goat");
    testAnimal.save();
    assertTrue(Animal.all().get(0).equals(testAnimal));
  }
  @Test
  public void save_assignsIdToAnimal() {
    Animal testAnimal = new Animal("Goat");
    testAnimal.save();
    Animal savedAnimal = Animal.all().get(0);
    assertEquals(savedAnimal.getId(), testAnimal.getId());
  }
  @Test
  public void all_returnsAllInstancesOfAnimal_true() {
    Animal firstAnimal = new Animal("Goat");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Mountain Beaver");
    secondAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }
  @Test
  public void delete_removesAnimalFromDB_null() {
    Animal testAnimal = new Animal("Goat");
    testAnimal.save();
    testAnimal.delete();
    assertEquals(null, Animal.findById(testAnimal.getId()));
  }
  @Test
  public void findById_returnsAnimalWithSameId_secondBook() {
    Animal firstAnimal = new Animal("Goat");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Mountain Beaver");
    secondAnimal.save();
    assertEquals(Animal.findById(secondAnimal.getId()), secondAnimal);
  }
  @Test
  public void findByName_returnsAnimalsWithSameName_Animal() {
    Animal firstAnimal = new Animal("Goat");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Mountain Beaver");
    secondAnimal.save();
    assertEquals(Animal.findByName(secondAnimal.getName()).get(0), secondAnimal);
  }
  @Test
  public void updateName_updatesName_Couger(){
    Animal testAnimal = new Animal("Goat");
    testAnimal.save();
    testAnimal.updateName("Couger");
    assertEquals("Couger", Animal.findById(testAnimal.getId()).getName());
  }
}
