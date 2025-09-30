import java.util.logging.Level;
import java.util.logging.Logger;

public class AC implements Observer {
    private static final Logger logger = Logger.getLogger(AC.class.getName());

    @Override
    public void update(Room room) {
        if (room.isOccupied())
            logger.log(Level.INFO, "AC ON for Room {0}", room.getRoomId());
        else
            logger.log(Level.INFO, "AC OFF for Room {0}", room.getRoomId());
    }
}
