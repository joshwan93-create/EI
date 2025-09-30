import java.util.logging.Level;
import java.util.logging.Logger;

public class Bike implements Vehicle {
    private static final Logger logger = Logger.getLogger(Bike.class.getName());

    @Override
    public void manufacture() {
        logger.log(Level.INFO, "Manufacturing a Bike...");
    }
}
