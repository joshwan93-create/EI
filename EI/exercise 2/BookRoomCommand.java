import java.util.logging.Level;
import java.util.logging.Logger;

public class BookRoomCommand implements Command {
    private Room room;

    public BookRoomCommand(Room room) { this.room = room; }

    @Override
    public void execute() {
        if (!room.isBooked()) {
            room.bookRoom();
            Logger.getLogger(BookRoomCommand.class.getName()).log(Level.INFO,
                    "Room {0} booked successfully.", room.getRoomId());
        } else {
            Logger.getLogger(BookRoomCommand.class.getName()).log(Level.WARNING,
                    "Room {0} is already booked.", room.getRoomId());
        }
    }
}
