import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author Yazdan Basir
 */
public class CustomerTest {
    Customer tester;
    
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest() {
        tester = new Customer (10, 20, 0); 
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        tester = new Customer (10, 20, 0); // Arrival time is 10 for testing purposes
    }
    
    @Test
    public void customerCompareToTest() {
        Customer tester2 = new Customer (5, 20, 0); // Arrival time is less than tester, so compareTo should order this one before
        assertEquals(-1, tester2.compareTo(tester));
    }
    
    @Test
    public void customerCompareToTest2() {
        Customer tester2 = new Customer (15, 20, 0); // Arrival time is more than tester, so compareTo should order this one after
        assertEquals(1, tester2.compareTo(tester));
    }
    
    @Test
    public void customerCompareToTest3() {
        Customer tester2 = new Customer (10, 20, 0); // Arrival time is the as tester, so compareTo should order them the same
        assertEquals(0, tester2.compareTo(tester));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}
