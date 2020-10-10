import java.util.*;

/**
 * Holds methods to run the shop simulation 100 times for a different number of cashiers
 * Returns the average for each metric measured
 *
 * @author Yazdan Basir
 */
public class ExperimentController {
    private static Simulation one;
    private static Simulation two;
    private static Simulation three;
    private static Simulation four;
    private static Simulation five;
    private static Simulation six;
    private static Simulation seven;
    private static Simulation eight;
    private static Simulation nine;
    private static Simulation ten;
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number of cashiers for the simulation: ");
        
        int s = scan.nextInt();
        
        System.out.println();
        
        Simulation sim = new Simulation(s);
        System.out.println(sim.run());
        
        // Print out the average data for every number of cashiers to the output window
        
        // averageDataFor1Cashier();
        // averageDataFor2Cashiers();
        // averageDataFor3Cashiers();
        // averageDataFor4Cashiers();
        // averageDataFor5Cashiers();
        // averageDataFor6Cashiers();
        // averageDataFor7Cashiers();
        // averageDataFor8Cashiers();
        // averageDataFor9Cashiers();
        // averageDataFor10Cashiers();
    }
    
    private static void averageDataFor1Cashier() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        one = new Simulation(1); // Simulation instance created with 1 cashier
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            one.run();
            
            customers = customers + one.served;
            overflow = overflow + one.overflow;
            profit = profit + one.c.totalProfit;
            netprofit = netprofit + ((one.c.totalProfit) - (one.totalCost));
            maxWaitTime = maxWaitTime + one.maxWaitTime;
            avgWaitTime = avgWaitTime + one.avgWaitTime;
        }
        
        System.out.println("Average Data for 1 Cashier:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor2Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        two = new Simulation(2); // Simulation instance created with 2 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            two.run();
            
            customers = customers + two.served;
            overflow = overflow + two.overflow;
            profit = profit + two.c.totalProfit;
            netprofit = netprofit + ((two.c.totalProfit) - (two.totalCost));
            maxWaitTime = maxWaitTime + two.maxWaitTime;
            avgWaitTime = avgWaitTime + two.avgWaitTime;
        }
        
        System.out.println("Average Data for 2 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor3Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        three = new Simulation(3); // Simulation instance created with 3 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            three.run();
            
            customers = customers + three.served;
            overflow = overflow + three.overflow;
            profit = profit + three.c.totalProfit;
            netprofit = netprofit + ((three.c.totalProfit) - (three.totalCost));
            maxWaitTime = maxWaitTime + three.maxWaitTime;
            avgWaitTime = avgWaitTime + three.avgWaitTime;
        }
        
        System.out.println("Average Data for 3 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor4Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        four = new Simulation(4); // Simulation instance created with 4 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            four.run();
            
            customers = customers + four.served;
            overflow = overflow + four.overflow;
            profit = profit + four.c.totalProfit;
            netprofit = netprofit + ((four.c.totalProfit) - (four.totalCost));
            maxWaitTime = maxWaitTime + four.maxWaitTime;
            avgWaitTime = avgWaitTime + four.avgWaitTime;
        }
        
        System.out.println("Average Data for 4 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor5Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        five = new Simulation(5); // Simulation instance created with 5 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            five.run();
            
            customers = customers + five.served;
            overflow = overflow + five.overflow;
            profit = profit + five.c.totalProfit;
            netprofit = netprofit + ((five.c.totalProfit) - (five.totalCost));
            maxWaitTime = maxWaitTime + five.maxWaitTime;
            avgWaitTime = avgWaitTime + five.avgWaitTime;
        }
        
        System.out.println("Average Data for 5 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor6Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        six = new Simulation(6); // Simulation instance created with 6 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            six.run();
            
            customers = customers + six.served;
            overflow = overflow + six.overflow;
            profit = profit + six.c.totalProfit;
            netprofit = netprofit + ((six.c.totalProfit) - (six.totalCost));
            maxWaitTime = maxWaitTime + six.maxWaitTime;
            avgWaitTime = avgWaitTime + six.avgWaitTime;
        }
        
        System.out.println("Average Data for 6 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor7Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        seven = new Simulation(7); // Simulation instance created with 6 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            seven.run();
            
            customers = customers + seven.served;
            overflow = overflow + seven.overflow;
            profit = profit + seven.c.totalProfit;
            netprofit = netprofit + ((seven.c.totalProfit) - (seven.totalCost));
            maxWaitTime = maxWaitTime + seven.maxWaitTime;
            avgWaitTime = avgWaitTime + seven.avgWaitTime;
        }
        
        System.out.println("Average Data for 7 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor8Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        eight = new Simulation(8); // Simulation instance created with 8 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            eight.run();
            
            customers = customers + eight.served;
            overflow = overflow + eight.overflow;
            profit = profit + eight.c.totalProfit;
            netprofit = netprofit + ((eight.c.totalProfit) - (eight.totalCost));
            maxWaitTime = maxWaitTime + eight.maxWaitTime;
            avgWaitTime = avgWaitTime + eight.avgWaitTime;
        }
        
        System.out.println("Average Data for 8 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor9Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        nine = new Simulation(9); // Simulation instance created with 9 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            nine.run();
            
            customers = customers + nine.served;
            overflow = overflow + nine.overflow;
            profit = profit + nine.c.totalProfit;
            netprofit = netprofit + ((nine.c.totalProfit) - (nine.totalCost));
            maxWaitTime = maxWaitTime + nine.maxWaitTime;
            avgWaitTime = avgWaitTime + nine.avgWaitTime;
        }
        
        System.out.println("Average Data for 9 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
    
    private static void averageDataFor10Cashiers() {
        // Variables to hold total data and used to calculate averages
        int customers = 0;
        int overflow = 0;
        
        float profit = 0;
        float netprofit = 0;
        float maxWaitTime = 0;
        float avgWaitTime = 0;
        float extraTime = 0;
        
        ten = new Simulation(10); // Simulation instance created with 10 cashiers
        
        // Runs the run() method 100 times and adds up all the metrics
        for (int i = 0; i < 100; i++) {
            ten.run();
            
            customers = customers + ten.served;
            overflow = overflow + ten.overflow;
            profit = profit + ten.c.totalProfit;
            netprofit = netprofit + ((ten.c.totalProfit) - (ten.totalCost));
            maxWaitTime = maxWaitTime + ten.maxWaitTime;
            avgWaitTime = avgWaitTime + ten.avgWaitTime;
        }
        
        System.out.println("Average Data for 10 Cashiers:");
        System.out.println("Average number of customers served per day: " + (customers/100));
        System.out.println("Average maximum time a customer waited per day: " + (maxWaitTime/100));
        System.out.println("Average time each customer waited per day: " + (avgWaitTime/100));
        System.out.println("Average number of customers lost due to overflow per day: " + (overflow/100));
        System.out.println("Average total profit made per day: " + (profit/100));
        System.out.println("Average net profit made per day: " + (netprofit/100));
        System.out.println();
        System.out.println();
    }
}