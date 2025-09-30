import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoryCard {
    private static final Logger logger = Logger.getLogger(MemoryCard.class.getName());

    public void insert() {
        logger.log(Level.INFO, "Memory Card inserted.");
    }

    public void readData() {
        logger.log(Level.INFO, "Reading data from Memory Card...");
    }
}
