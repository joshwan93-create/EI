import java.util.logging.Level;
import java.util.logging.Logger;

public class CancelBookingCommand implements Command {
    private Room room;

    public CancelBookingCommand(Room room) { this.room = room; }

    @Override
    public void execute() {
        if (room.isBooked()) {
            room.cancelBooking();
            Logger.getLogger(CancelBookingCommand.class.getName()).log(Level.INFO,
                    "Booking cancelled for Room {0}", room.getRoomId());
        } else {
            Logger.getLogger(CancelBookingCommand.class.getName()).log(Level.WARNING,
                    "Room {0} is not booked.", room.getRoomId());
        }
    }
}
