import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Date;


public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    Sighting testSighting = new Sighting(1, "Over there", "Walker");
    assertEquals(true, testSighting instanceof Sighting);
  }
  @Test
  public void equals_returnsTrueIfLocationAndIdAreSame_true() {
    Sighting testSighting = new Sighting(1, "Over there", "Walker");
    Sighting anotherSighting = new Sighting(1, "Over there", "Walker");
    assertTrue(testSighting.equals(anotherSighting));
  }
  @Test
  public void save_returnsTrueIfSightingsAretheSame() {
    Sighting testSighting = new Sighting(1, "Over there", "Walker");
    testSighting.save();
    assertTrue(Sighting.all().get(0).equals(testSighting));
  }
  @Test
  public void save_assignsIdToSighting() {
    Sighting testSighting = new Sighting(1, "Over there", "Walker");
    testSighting.save();
    Sighting savedSighting = Sighting.all().get(0);
    assertEquals(savedSighting.getId(), testSighting.getId());
  }
  @Test
  public void all_returnsAllInstancesOfSighting_true() {
    Sighting firstSighting = new Sighting(1, "Over there", "Walker");
    firstSighting.save();
    Sighting secondSighting = new Sighting(2, "Over here", "Rick");
    secondSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(firstSighting));
    assertEquals(true, Sighting.all().get(1).equals(secondSighting));
  }
  @Test
  public void delete_removesSightingFromDB_null() {
    Sighting testSighting = new Sighting(1, "Over there", "Walker");
    testSighting.save();
    testSighting.delete();
    assertEquals(null, Sighting.findById(testSighting.getId()));
  }
}
