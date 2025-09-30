import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoryCardReader implements USB {
    private MemoryCard memoryCard;
    private static final Logger logger = Logger.getLogger(MemoryCardReader.class.getName());

    public MemoryCardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        memoryCard.insert();
        memoryCard.readData();
        logger.log(Level.INFO, "Memory Card is now accessible via USB port.");
    }
}
