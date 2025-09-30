import java.util.logging.Level;
import java.util.logging.Logger;

public class Truck implements Vehicle {
    private static final Logger logger = Logger.getLogger(Truck.class.getName());

    @Override
    public void manufacture() {
        logger.log(Level.INFO, "Manufacturing a Truck...");
    }
}
