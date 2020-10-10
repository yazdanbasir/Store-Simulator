import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CashiersTest.
 *
 * @author Yazdan
 */
public class CashierTest {
    Cashiers tester;
    
    /**
     * Default constructor for test class CashiersTest
     */
    public CashierTest() {
        tester = new Cashiers(2, 60, 240, 2, 6); 
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        tester = new Cashiers(2, 60, 240, 2, 6); 
    }
    
    @Test
    public void generateRandomProfitTest() {
        float a = tester.generateRandomProfit();
        
        assertEquals((a >= 2 && a <= 6), true);
    }
    
    @Test
    public void generateRandomServingTimeTest() {
        int a = tester.generateRandomServingTime();
        //System.out.println(a);
        
        assertEquals((a>= 60 && a <= 240), true);
    }
    
    @Test
    public void startServingCustomerTest() {
        tester.tracker[0].startServingCustomer(5, 5, 5);
        
        assertEquals(false, tester.tracker[0].status);
    }
    
    @Test
    public void finishServingCustomerTest() {
        tester.tracker[0].startServingCustomer(5, 5, 5);
        tester.tracker[0].finishServingCustomer();
        
        assertEquals(true, tester.tracker[0].status);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}