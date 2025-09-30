import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartOffice {
    private static final Logger logger = Logger.getLogger(SmartOffice.class.getName());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Office office = Office.getInstance();

        logger.log(Level.INFO, "Enter number of rooms: ");
        int numRooms = sc.nextInt(); sc.nextLine();
        office.configureOffice(numRooms);

        for (Room room : office.getRooms()) {
            room.addObserver(new Lights());
            room.addObserver(new AC());
        }

        BookingManager manager = new BookingManager();
        boolean exit = false;

        while (!exit) {
            logger.log(Level.INFO,
                    "\n1. Book Room\n2. Cancel Booking\n3. Enter Room\n4. Leave Room\n5. Exit\nChoose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> { office.displayRooms();
                    logger.log(Level.INFO, "Enter Room ID to book: ");
                    int bid = sc.nextInt(); sc.nextLine();
                    Room roomToBook = office.getRoomById(bid);
                    if (roomToBook != null) manager.executeCommand(new BookRoomCommand(roomToBook));
                    else logger.log(Level.WARNING, "Room ID not found.");
                }
                case 2 -> { office.displayRooms();
                    logger.log(Level.INFO, "Enter Room ID to cancel booking: ");
                    int cid = sc.nextInt(); sc.nextLine();
                    Room roomToCancel = office.getRoomById(cid);
                    if (roomToCancel != null) manager.executeCommand(new CancelBookingCommand(roomToCancel));
                    else logger.log(Level.WARNING, "Room ID not found.");
                }
                case 3 -> { office.displayRooms();
                    logger.log(Level.INFO, "Enter Room ID to enter: ");
                    int eid = sc.nextInt(); sc.nextLine();
                    Room roomToEnter = office.getRoomById(eid);
                    if (roomToEnter != null) {
                        logger.log(Level.INFO, "Enter number of people: ");
                        int people = sc.nextInt(); sc.nextLine();
                        roomToEnter.enterRoom(people);
                    } else logger.log(Level.WARNING, "Room ID not found.");
                }
                case 4 -> { office.displayRooms();
                    logger.log(Level.INFO, "Enter Room ID to leave: ");
                    int lid = sc.nextInt(); sc.nextLine();
                    Room roomToLeave = office.getRoomById(lid);
                    if (roomToLeave != null) {
                        logger.log(Level.INFO, "Enter number of people leaving: ");
                        int leaving = sc.nextInt(); sc.nextLine();
                        roomToLeave.leaveRoom(leaving);
                    } else logger.log(Level.WARNING, "Room ID not found.");
                }
                case 5 -> { exit = true;
                    logger.log(Level.INFO, "Exiting Smart Office Application...");
                }
                default -> logger.log(Level.WARNING, "Invalid option!");
            }
        }

        sc.close();
    }
}
