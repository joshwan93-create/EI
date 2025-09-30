import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleFactory {
    private static final Logger logger = Logger.getLogger(VehicleFactory.class.getName());

    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                logger.log(Level.INFO, "Creating a Car object.");
                return new Car();
            case "bike":
                logger.log(Level.INFO, "Creating a Bike object.");
                return new Bike();
            case "truck":
                logger.log(Level.INFO, "Creating a Truck object.");
                return new Truck();
            default:
                logger.log(Level.SEVERE, "Unknown vehicle type: {0}", type);
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
