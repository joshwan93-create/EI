import java.util.*;

public class Office {
    private static Office instance;
    private List<Room> rooms = new ArrayList<>();

    private Office() {}

    public static synchronized Office getInstance() {
        if (instance == null) instance = new Office();
        return instance;
    }

    public void configureOffice(int numRooms) {
        for (int i = 0; i < numRooms; i++) rooms.add(new Room()); // Automatically assigns unique IDs
    }

    public List<Room> getRooms() { return rooms; }

    public Room getRoomById(int id) {
        return rooms.stream().filter(r -> r.getRoomId() == id).findFirst().orElse(null);
    }

    // Display room IDs with their status
    public void displayRooms() {
        System.out.println("\nRoom Status:");
        for (Room room : rooms) {
            System.out.println("Room ID: " + room.getRoomId() +
                               " | Booked: " + room.isBooked() +
                               " | Occupied: " + room.isOccupied());
        }
        System.out.println();
    }
}
