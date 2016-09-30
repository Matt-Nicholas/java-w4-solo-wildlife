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

  // @Test
  // public void getCheckoutDate_returnsCheckoutDate_True(){
  //   Book testBook = new Book("Tilte", "Author");
  //   testBook.save();
  //   Date temp = new Date();
  //   assertTrue(Math.abs(testBook.getCheckoutDate() - temp.getTime()) <= 100);
  // }
  //
  // @Test
  // public void getDueDate_returnDueDate_Date(){
  //   Book testBook = new Book("Bubbles", "Author");
  //   testBook.save();
  //   Date temp = new Date();
  //   assertTrue(Math.abs(testBook.getDueDate() - (temp.getTime() + Book.CHECKOUT_PERIOD)) <= 100);
  // }
  //
  // @Test
  // public void checkOut_updatesBookStatus_String(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   Patron testPatron = new Patron("Blossom");
  //   testBook.save();
  //   testPatron.save();
  //   testBook.checkOut(testPatron.getId());
  //   assertEquals("checked-out", testBook.getStatus());
  // }
  // @Test
  // public void checkOut_updatesBookPatronId_int(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   Patron testPatron = new Patron("Blossom");
  //   testBook.save();
  //   testPatron.save();
  //   testBook.checkOut(testPatron.getId());
  //   assertEquals(testPatron.getId(), testBook.getPatronId());
  // }
  // @Test
  // public void checkStatus_returnsAvailableAppropriately_String(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   testBook.save();
  //   assertEquals("available", testBook.checkStatus());
  // }
  // @Test
  // public void checkStatus_returnsCheckedOutAppropriately_String(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   Patron testPatron = new Patron("Blossom");
  //   testBook.save();
  //   testPatron.save();
  //   testBook.checkOut(testPatron.getId());
  //   assertEquals("checked-out", testBook.checkStatus());
  // }
  // @Test
  // public void checkStatus_returnsOverdueAppropriately_String(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   Patron testPatron = new Patron("Blossom");
  //   testBook.save();
  //   testPatron.save();
  //   testBook.checkOut(testPatron.getId());
  //   testBook.DEV_setOverdue();
  //   assertEquals("overdue", testBook.checkStatus());
  // }
  // @Test
  // public void tryRenew_returnsTrueFirstTry_true(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   Patron testPatron = new Patron("Blossom");
  //   testBook.save();
  //   testPatron.save();
  //   testBook.checkOut(testPatron.getId());
  //   assertEquals(true, testBook.tryRenew());
  // }
  // @Test
  // public void tryRenew_returnsTrueSecondTry_true(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   Patron testPatron = new Patron("Blossom");
  //   testBook.save();
  //   testPatron.save();
  //   testBook.checkOut(testPatron.getId());
  //   testBook.tryRenew();
  //   assertEquals(true, testBook.tryRenew());
  // }
  // @Test
  // public void tryRenew_returnsFalseThirdTry_true(){
  //   Book testBook = new Book("Bubbles", "Buttercup");
  //   Patron testPatron = new Patron("Blossom");
  //   testBook.save();
  //   testPatron.save();
  //   testBook.checkOut(testPatron.getId());
  //   testBook.tryRenew();
  //   testBook.tryRenew();
  //   assertEquals(false, testBook.tryRenew());
  // }

}
