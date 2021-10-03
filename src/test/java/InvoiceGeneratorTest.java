import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    //Test Case-1 Calculate Total Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        //Create an Object
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
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
        //Create an Object
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
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
    public void givenMultipleRides_ShouldReturnTotalFare() {
        //Create an Object
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        //Create an Array to get different values
        Ride[] rides = { new Ride(2.0,5),
                        new Ride(0.1,1)
        };
        //Calling of Method Calculate Fare
        double fare = invoiceGenerator.calculateFare(rides);
        //Assertions to check Expected and Actual Value
        Assertions.assertEquals(30, fare,0.0);
    }
}