import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    //Create an Object
    InvoiceGenerator invoiceGenerator =null;

    @BeforeEach
    public void setUp() throws Exception {
         invoiceGenerator = new InvoiceGenerator();
    }

    //Test Case-1 Calculate Total Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        //Declare Local Variables
        double distance = 2.0;
        int time =  5;
        //Calling of Method Calculate Fare
        double fare = invoiceGenerator.calculateFare(distance, time);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(25, fare,0.0);
    }
    //Test Case to Calculate Minimum Fare
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare(){
        //Declare Local Variables
        double distance = 0.1;
        int time = 1;
        //Calling of Method Calculate Fare
        double fare = invoiceGenerator.calculateFare(distance, time);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(5, fare,0.0);
    }
    //Test Case 2 to Calculate Multiple Rides Fare
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        //Create an Array to get different values
        Ride[] rides = { new Ride(2.0,5),
                        new Ride(0.1,1)
        };
        //Calling of Method Calculate Multiple Ride Fare
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary =  new InvoiceSummary(2,30.0);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
}