import java.util.logging.Level;
import java.util.logging.Logger;

public class Car implements Vehicle {
    private static final Logger logger = Logger.getLogger(Car.class.getName());

    @Override
    public void manufacture() {
        logger.log(Level.INFO, "Manufacturing a Car...");
    }
}
