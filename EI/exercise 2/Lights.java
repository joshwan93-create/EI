import java.util.logging.Level;
import java.util.logging.Logger;

public class Lights implements Observer {
    private static final Logger logger = Logger.getLogger(Lights.class.getName());

    @Override
    public void update(Room room) {
        if (room.isOccupied())
            logger.log(Level.INFO, "Lights ON for Room {0}", room.getRoomId());
        else
            logger.log(Level.INFO, "Lights OFF for Room {0}", room.getRoomId());
    }
}
