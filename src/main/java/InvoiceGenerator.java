/*
*
@author : Sajan Mhatre
*
 */
public class InvoiceGenerator {
    //Declare Constants
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5.0;
    private final RideRepository rideRepository;

    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }
    //Create a Method to calculate Fare
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }


    //Method to calculate total fare for multiple rides
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    // Method To calculate total fare for multiple rides
    public InvoiceSummary calculateFareSummary(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
    //Method to get invoice Summary
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFareSummary(rideRepository.getRides(userId));
    }
    //Method to Add rides
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}