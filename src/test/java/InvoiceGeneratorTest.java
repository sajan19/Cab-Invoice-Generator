import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    //Test Case-1 Calculate correct Fare
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
}