import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoryPattern {
    private static final Logger logger = Logger.getLogger(FactoryPattern.class.getName());

    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.createVehicle("car");
        v1.manufacture();

        Vehicle v2 = VehicleFactory.createVehicle("bike");
        v2.manufacture();

        Vehicle v3 = VehicleFactory.createVehicle("truck");
        v3.manufacture();

        logger.log(Level.INFO, "All vehicles manufactured successfully.");
    }
}
