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
}
