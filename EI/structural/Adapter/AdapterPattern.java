import java.util.logging.Level;
import java.util.logging.Logger;

public class AdapterPattern {
    private static final Logger logger = Logger.getLogger(AdapterPattern.class.getName());

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        MemoryCard memoryCard = new MemoryCard();
        USB cardReader = new MemoryCardReader(memoryCard);

        logger.log(Level.INFO, "Connecting Memory Card to Laptop using Card Reader...");
        laptop.connectDevice(cardReader);
    }
}
