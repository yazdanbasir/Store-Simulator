import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerQueueTest.
 *
 * @author Yazdan Basir
 */
public class CustomerQueueTest {
    CustomerQueue tester;
    
    /**
     * Default constructor for test class CustomerQueueTest
     */
    public CustomerQueueTest() {
        tester = new CustomerQueue();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        tester = new CustomerQueue();
        //tester.
    }
    
    @Test
    public void addTest1() {
        //Should return because the queue is empty
        assertEquals(true, tester.add(new Customer(1, 2, 3)));
    }
    
    @Test
    public void addTest2() {
        tester.add(new Customer(1, 2, 3));
        tester.add(new Customer(2, 2, 3));
        tester.add(new Customer(3, 2, 3));
        tester.add(new Customer(4, 2, 3));
        tester.add(new Customer(5, 2, 3));
        tester.add(new Customer(6, 2, 3));
        tester.add(new Customer(7, 2, 3));
        tester.add(new Customer(8, 2, 3));
        
        assertEquals(true, tester.add(new Customer (5, 10, 15)));
    }
    
    @Test
    public void peekTest1() {
        tester.add(new Customer(5, 10, 15));
        
        //Should return 5 because that's the arrivalTime value of the Customer at the top of the queue 
        assertEquals(5, tester.peek().arrivalTime);
    }
    
    @Test
    public void peekTest2() {
        tester.add(new Customer(10, 15, 20));
        tester.add(new Customer(5, 10, 15));
        
        //Should return 5 because that's the arrivalTime value of the Customer at the top of the queue 
        assertEquals(10, tester.peek().arrivalTime);
    }
    
    @Test
    public void pollTest1() {
        tester.add(new Customer(10, 15, 20));
        tester.add(new Customer(5, 10, 15));
        
        tester.pop(); // Removes the Customer at the top of the queue
        
        // Should return 10 because that's the arrivalTime value of the Customer at the top of the queue 
        assertEquals(5, tester.peek().arrivalTime);
    }
    
    @Test
    public void getLowPBoundTest() {
        tester.getDataFromFile();
        assertEquals(2.0, (tester.getLowPBound()), 0.0001);
    }
    
    @Test
    public void getHighPBoundTest() {
        tester.getDataFromFile();
        assertEquals(6.0, tester.getHighPBound(), 0.0001);
    }
    
    @Test
    public void getLowSBoundTest() {
        tester.getDataFromFile();
        assertEquals(60, tester.getLowSBound());
    }
    
    @Test
    public void getHighSBoundTest() {
        tester.getDataFromFile();
        assertEquals(240, tester.getHighSBound());
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}