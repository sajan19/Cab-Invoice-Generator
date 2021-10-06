import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    //Create an Object
    public static InvoiceGenerator invoiceGenerator = null;

    @BeforeAll
    static void beforeAll() {
        invoiceGenerator = new InvoiceGenerator();
    }
    //Test Case-1 Calculate Total Fare
    @Test
    void givenDistanceAndTimeShouldReturnTheTotalFare() {
        //Declare Local Variables
        double distance = 2.0;
        int time = 5;
        //Calling of Method Calculate Fare
        double fare = invoiceGenerator.calculateFare(distance, time);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(25, fare, 0.0);
    }
    //Test Case to Calculate Minimum Fare
    @Test
    void givenLessDistanceAndTimeShouldReturnTheMinimumFare() {
        //Declare Local Variables
        double distance = 0.1;
        int time = 1;
        //Calling of Method Calculate Fare
        double fare = invoiceGenerator.calculateFare(distance, time);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(5, fare, 0.0);
    }
    //Test Case  to Calculate Multiple Rides Fare
    @Test
    void givenMultipleRidesShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        //Calling of Method Calculate Multiple Ride Fare
        double fare = invoiceGenerator.calculateFare(rides);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(30, fare, 0.0);
    }
    //Test Case to Calculate Invoice Summary
    @Test
    void givenMultipleRidesShouldReturnInvoiceSummary() {
        //Define an Array
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        //Call an Object
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
    //Test Case to Calculate Invoice Summary according to User ID
    @Test
    void givenUserIDAndRideListShouldReturnInvoiceSummary() {
        //Define an Array
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        String userId = "LUCA 501";
        //Call Add Method
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}