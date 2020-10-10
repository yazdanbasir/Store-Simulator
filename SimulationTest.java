import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SimulationTest.
 *
 * @author Yazdan Basir
 */
public class SimulationTest {
    Simulation tester;
    
    /**
     * Default constructor for test class SimulationTest
     */
    public SimulationTest() {
        tester = new Simulation(3);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        tester = new Simulation(3);
    }
    
    @Test
    public void nextAvailableServeTimeTest() {
        tester.c.times.add(5);
        tester.c.times.add(10);
        tester.c.times.add(7);
        
        assertEquals(5, tester.nextAvailableServeTime()); // Should return the minimum value of the Linked List
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}
