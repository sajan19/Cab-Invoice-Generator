import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//Create class
public class RideRepository {
    //Declare HashMap
    Map<String, ArrayList<Ride>> userRides;
    //Constructor
    public RideRepository() {
        this.userRides = new HashMap<>();
    }
    //Method to add rides
    public void addRides(String userId, Ride[] rides) {
        this.userRides.computeIfAbsent(userId, k -> new ArrayList<>(Arrays.asList(rides)));
    }
    //Getter
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}