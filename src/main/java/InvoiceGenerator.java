/*
@author - Sajan
 */
//Class Invoice Generator
public class InvoiceGenerator {
    //Declare Constant Variables
    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_TIME = 1 ;
    //Method to Calculate Fare
    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME ;
    }
}
